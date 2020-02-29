package com.ctgu.ssm.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ctgu.ssm.entity.ActType;
import com.ctgu.ssm.entity.Actinfo;
import com.ctgu.ssm.entity.Admin;
import com.ctgu.ssm.entity.Apply;
import com.ctgu.ssm.entity.AuditType;
import com.ctgu.ssm.entity.Item;
import com.ctgu.ssm.entity.ItemType;
import com.ctgu.ssm.entity.Leaveidea;
import com.ctgu.ssm.entity.Offinfo;
import com.ctgu.ssm.entity.Support;
import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.ActTypeService;
import com.ctgu.ssm.service.ActinfoService;
import com.ctgu.ssm.service.AdminService;
import com.ctgu.ssm.service.ApplyService;
import com.ctgu.ssm.service.AuditTypeService;
import com.ctgu.ssm.service.ItemService;
import com.ctgu.ssm.service.ItemTypeService;
import com.ctgu.ssm.service.LeaveideaService;
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.SupportService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.SerachBase;


@Controller
@RequestMapping("/admin")
public class adminItemController{
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired  
	@Qualifier("adminService")
	private AdminService adminService;
	
	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;
	
	@Autowired
	@Qualifier("itemTypeService")
	private ItemTypeService itemTypeService;
	
	@Autowired
	@Qualifier("actinfoService")
	private ActinfoService actinfoService;
	
	@Autowired
	@Qualifier("actTypeService")
	private ActTypeService actTypeService;
	
	@Autowired
	@Qualifier("applyService")
	private ApplyService applyService;
	
	@Autowired
	@Qualifier("leaveideaService")
	private LeaveideaService leaveideaService;
	
	@Autowired
	@Qualifier("offinfoService")
	private OffinfoService offinfoService;
	
	@Autowired
	@Qualifier("supportService")
	private SupportService supportService;
	
	
	@Autowired
	@Qualifier("auditTypeService")
	private AuditTypeService auditTypeService;
	@Autowired
	private HttpSession session;
	
	
	/***************************************************操作物品***************************************************/
	/**
	 * 处理添加物品请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Item Item  要添加的物品对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/Item/addItem")
	 public ModelAndView addItem(
			 String flag,
			 @ModelAttribute Item Item,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("/admin/Item/showAddItem");
		}else{
			System.out.println("操作物品成功~~~");
			itemService.addItem(Item);
			mv.setViewName("redirect:/admin/Item/selectItem");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Item Item  要添加的物品对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/Item/updateItem")
	 public ModelAndView updateItemInfo(
			 String flag,
			 @ModelAttribute Item Item,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			Item target = itemService.findById((Item.getId()));
			System.out.println(target + "----");
			mv.addObject("Item",target);
			mv.setViewName("/admin/Item/showUpdateItem");
		}else{
			itemService.updateItem(Item);
			mv.setViewName("redirect:/admin/Item/selectItem");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理删除物品请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@ResponseBody
	@RequestMapping(value="/Item/removeItem")
	 public String removeItem(Integer id,ModelAndView mv){
		itemService.deleteById(id);
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/admin/Item/selectItem");
		// 返回ModelAndView
		return "1";
	}
	
	/**
	 *  
	 * */
	@RequestMapping(value="/Item/selectItem")
	public ModelAndView selectItem(ModelAndView mav, Model model){
		/** 查询物品信息     */
		List<Item> items = itemService.findAllItem();
		System.out.println("欢迎来到物品界面~~~");
		mav.addObject("items",items);
		mav.setViewName("/admin/Item/Item");
		
		
		/*查询数字名称*/
		//用户类型名称
		List<User> temp_users = new ArrayList<User>();
		for(int i = 0; i < items.size(); i++){
			Item temp = items.get(i);
			temp_users.add(userService.findById(temp.getUserid()));
		}
		model.addAttribute("temp_users", temp_users);
//		//活动类型名称
//		List<ActType> temp_actTypes = new ArrayList<ActType>();
//		for(int i = 0; i < items.size(); i++){
//			Item temp = items.get(i);
//			temp_actTypes.add(actTypeService.findById(Integer.parseInt(temp.getTypeid() ())));
//		}
//		model.addAttribute("temp_actTypes", temp_actTypes);
		//审核类型名称
		List<AuditType> temp_audittypes = new ArrayList<AuditType>();
		for(int i = 0; i < items.size(); i++){
			Item temp = items.get(i);
			temp_audittypes.add(auditTypeService.findById(temp.getAuditid()));
		}
		model.addAttribute("temp_audittypes", temp_audittypes);
		//物品类型名称
		List<ItemType> temp_itemtypes = new ArrayList<ItemType>();
		for(int i = 0; i < items.size(); i++){
			Item temp = items.get(i);
			temp_itemtypes.add(itemTypeService.findById(temp.getTypeid()));
		}
		model.addAttribute("temp_itemtypes", temp_itemtypes);
		
		
		
		
		return mav;
		
	}
	/***************************************************操作完成***************************************************/
	

	/***************************************************操作物品类型***************************************************/
	/**
	 * 处理添加物品类型请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param ItemType ItemType  要添加的物品类型对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/ItemType/addItemType")
	 public ModelAndView addItemType(
			 String flag,
			 @ModelAttribute ItemType ItemType,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("/admin/ItemType/showAddItemType");
		}else{
			System.out.println("操作物品类型成功~~~");
			itemTypeService.addItemType(ItemType);
			mv.setViewName("redirect:/admin/ItemType/selectItemType");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param ItemType ItemType  要添加的物品类型对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/ItemType/updateItemType")
	 public ModelAndView updateItemTypeInfo(
			 String flag,
			 @ModelAttribute ItemType ItemType,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			ItemType target = itemTypeService.findById((ItemType.getId()));
			System.out.println(target + "----");
			mv.addObject("ItemType",target);
			mv.setViewName("/admin/ItemType/showUpdateItemType");
		}else{
			itemTypeService.updateItemType(ItemType);
			mv.setViewName("redirect:/admin/ItemType/selectItemType");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理删除物品类型请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@ResponseBody
	@RequestMapping(value="/ItemType/removeItemType")
	 public String removeItemType(Integer id,ModelAndView mv){
		itemTypeService.deleteById(id);
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/admin/ItemType/selectItemType");
		// 返回ModelAndView
		return "1";
	}
	
	/**
	 * 
	 * */
	@RequestMapping(value="/ItemType/selectItemType")
	public ModelAndView selectItemType(ModelAndView mav){
		/** 查询物品类型信息     */
		List<ItemType> itemTypes = itemTypeService.findAllItemType();
		System.out.println("欢迎来到物品类型界面~~~");
		mav.addObject("itemTypes",itemTypes);
		mav.setViewName("/admin/ItemType/ItemType");
		return mav;
		
	}
	/***************************************************操作完成***************************************************/
	
	
	/**
	 * 
	 * */
	@RequestMapping(value="/Item/findItem")
	public ModelAndView findItem(ModelAndView mav, String name){
		/** 查询物品类型信息     */
		List<Item> items = getItem(name);
		System.out.println("欢迎来到物品类型界面~~~");
		
		mav.addObject("items",items);
		mav.setViewName("/admin/Item/Item");
		
		return mav;
	}
	
	
	/**
	 * 封装搜索的函数
	 * 
	 * @param name
	 * @return
	 */
	public  List<Item> getItem(String name){

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
				String[] temp = top.getItemname().replace(" ", "").split(","); 
				for(String tt : temp)
					searchBase.add(i + "",	tt, tt); //这里用链表的序号可以方便下面取出对应的节点
			}
			//查询
			String ids = searchBase.getIds(name);  //返回包含查询商品的名字的商品的id并按出现频率排序，已逗号隔开   
//			System.out.println(ids + "-------------------查询结果=============================");
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
