package com.ctgu.ssm.controller.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.ssm.entity.Apply;
import com.ctgu.ssm.entity.Item;
import com.ctgu.ssm.entity.ItemType;
import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.ActinfoService;
import com.ctgu.ssm.service.AdminService;
import com.ctgu.ssm.service.ApplyService;
import com.ctgu.ssm.service.ItemService;
import com.ctgu.ssm.service.ItemTypeService;
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.SerachBase;


@Controller
@RequestMapping("/user")
public class ItemController{
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("applyService")
	private ApplyService applyService;
	
	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;

	@Autowired
	@Qualifier("itemTypeService")
	private ItemTypeService itemTypeService;

	@Autowired
	@Qualifier("offinfoService")
	private OffinfoService offinfoService;

	@Autowired
	@Qualifier("actinfoService")
	private ActinfoService actinfoService;

	@Autowired
	private HttpSession session;

	// 测试接口
	@ResponseBody
	@RequestMapping("/testgoods")
	public String gettest() {

		System.out.println( "testUser333" );

		return "hello";
	}
	
	/**
	 * 物品申请
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/apply")
	public String apply(@RequestParam("id")Integer id,
			@RequestParam("auditid")Integer auditid) {
		User user = (User) session.getAttribute("user");
//		System.out.println( "testUser333" ); 
		if(itemService.findById(id).getItemcount() <= 0) {
			return "0";
		}
		// 添加申请表
		Apply apply = new Apply();
		apply.setItemid(id);
		apply.setAuditid(auditid);
		apply.setUserid(user.getId());
		apply.setAuditid(1);
		applyService.addApply(apply);

		return "1";
	}
	
	/**
	 * 商品详情
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/goodsDetial")
	public String goodsDetial(Model model, @RequestParam("id") Integer id) {
		Item item = itemService.findById(id);
		System.out.println( "goodsDetial========" );
		
		model.addAttribute("item", item);
		return "user/goodsDetial";
	}


	/**
	 * 显示所有的可以领取的物品
	 * @param request
	 * @return
	 */
	@RequestMapping("/showGoods")
	public String showGoods(Model model) {

		System.out.println("======showGoods");
		
		List<Item> itemList = itemService.findAllItem();
		List<Item> list = new ArrayList<Item>();
		List<ItemType> typeList = itemTypeService.findAllItemType();
		
		for(Item item : itemList) {
			if(item.getItemcount() > 0 && item.getAuditid() == 2) {
				item.setIntroduce(itemTypeService.findById(item.getTypeid()).getItemname());
				list.add(item);
			}
		}
		
		model.addAttribute("listItems", list);
		model.addAttribute("typeList", typeList);
		System.out.println(typeList);

		return "user/showGoods";
	}

	
	/**
	 * 搜索物品
	 * 
	 * @param model
	 * @param name
	 * @return
	 */
	@RequestMapping("/itemsearch")
	public String itemsearch(Model model, @RequestParam("name") String name) {

		// 查找物品：
		List<Item> itemList = getItem(name);
		List<Item> list = new ArrayList<Item>();
		List<ItemType> typeList = itemTypeService.findAllItemType();
		int len = name.length();
		for(Item item : itemList) {
			System.out.println(item.toString());
			if(item.getItemcount() > 0 && item.getAuditid() == 2) {
				item.setIntroduce(itemTypeService.findById(item.getTypeid()).getItemname());
				// 将搜索出来的标题标红：
				String temp = item.getItemname();
		    	HashSet<String> set = new HashSet<String>();
		    	String old = "";
		    	for(int i = 0; i < len; i++) {
		    		old = String.valueOf(name.charAt(i));
		    		if(!set.contains(old)) {
		    			set.add(old);
		    			temp = temp.replace(old, "<font color=\"red\">"+
		    			name.charAt(i) + "</font>");
		    		}
		    	}
				item.setItemname(temp);
				list.add(item);
			}
		}
		
		model.addAttribute("listItems", list);
		model.addAttribute("typeList", typeList);

		return "user/showGoods";
	}
	
	public  List<Item> getItem(String kind){
		
		List<Item>  items = itemService.findAllItem(); 
		List<Item> ret = new ArrayList<Item>();
		//先从数据库获取可查内容
		int total = 0; //查到结果数量
		if(items == null) {
			System.out.println("数据库内暂无内容");
		}
		else {
			//建立词库
			SerachBase searchBase = SerachBase.getSerachBase();  
			for(int i = 0; i < items.size(); i++) {
				Item top = items.get(i);
				if(top.getItemcount() <= 0) {
					continue;
				}
				String[] temp = top.getItemname().replace(" ", "").split(","); 
				for(String tt : temp)
					searchBase.add(i + "",	tt, tt); //这里用链表的序号可以方便下面取出对应的节点
			}
			//查询
			String ids = searchBase.getIds(kind);  //返回包含查询商品的名字的商品的id并按出现频率排序，已逗号隔开   
			System.out.println(ids + "-------------------查询结果=============================");
			if(ids != null && !"".equals(ids)) {
				String num[] = ids.split(",");  //用,分割取出id
				int ct = 0;
				for (String id : num) {  
					ret.add(items.get(Integer.valueOf(id)));  
					ct++;
				}
			}
		}
		return ret;
	}
	
}
