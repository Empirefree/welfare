package com.ctgu.ssm.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ctgu.ssm.entity.Actinfo;
import com.ctgu.ssm.entity.Apply;
import com.ctgu.ssm.entity.Interactive;
import com.ctgu.ssm.entity.Item;
import com.ctgu.ssm.entity.Offinfo;
import com.ctgu.ssm.entity.Support;
import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.ActinfoService;
import com.ctgu.ssm.service.AdminService;
import com.ctgu.ssm.service.ApplyService;
import com.ctgu.ssm.service.InteractiveService;
import com.ctgu.ssm.service.ItemService;
import com.ctgu.ssm.service.ItemTypeService;
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.SupportService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.HttpUtil;
import com.ctgu.ssm.utils.ImageUtil;


@Controller
@RequestMapping("/user")
public class donateController{
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("supportService")
	private SupportService supportService;
	
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
	@Qualifier("applyService")
	private ApplyService applyService;
	
	@Autowired
	@Qualifier("interactiveService")
	private InteractiveService interactiveService;
	
	@Autowired
	private HttpSession session;
	
	// 测试接口
	@ResponseBody
	@RequestMapping("/testdonate")
	public String gettest() {
		
		System.out.println( "testUser" );
		
		return "hello";
	}
	
	/** 活动列表
	 * @return
	 */
	@RequestMapping(value = "activity")
	public String Activity(Model model) {
		System.out.println("activiy");
		
		List<Offinfo> list = offinfoService.findAllOffinfo();
		
		System.out.println(list);
		
		model.addAttribute("list", list);
		return "user/activity";
	}
	
	/** 求助详情
	 * @return
	 */
	@RequestMapping(value = "actinfoDetail")
	public String actinfoDetail(Model model, @RequestParam("id") Integer id) {
		System.out.println("actinfoDetail");
		
		// 找到指定的求助活动
		Offinfo offinfo =  offinfoService.findById(id);
		
		// 找到该活动的相关评论
		List<Interactive> list = new ArrayList<Interactive>();
		Interactive inter = new Interactive();
		inter.setDistin(1);
		inter.setItemid(id);
		list = interactiveService.findInteractiveBySome(inter);
		
		// 找到评论者
		List<User> userList = new ArrayList<User>();
		for(Interactive temp : list) {
			userList.add(userService.findById(temp.getDonorid()));
		}
		
//		System.out.println(offinfo);
		
		model.addAttribute("offinfo", offinfo);
		model.addAttribute("list", list);
		model.addAttribute("userList", userList);
		return "user/actinfoDetail";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "activitypl")
	public String activitypl(Model model, 
			@RequestParam("content") String content,
			@RequestParam("itemid") Integer itemid,
			HttpServletResponse response) {
		System.out.println("activiypl");
		
		
		User user = (User) session.getAttribute("user");
		if(user == null) {
			System.out.println("您尚未登入！");
			HttpUtil.sendStrToResp(response, "您尚未登入");
			return "您尚未登入！";
//			return "forward:/user/actinfoDetail?id="+itemid;
		}
		// 评论
		Interactive intec = new Interactive();
		intec.setItemid(itemid);
		intec.setDonorid(user.getId());
		intec.setReceiveid(offinfoService.findById(itemid).getUserid());
		intec.setContent(content);
		intec.setDistin(1);
		interactiveService.addInteractive(intec);
		
		System.out.println("评论成功！");
		return "1";
//		return "forward:/user/actinfoDetail?id="+itemid;
	}
	
	
	/** 求助列表
	 * @return
	 */
	@RequestMapping(value = "helps")
	public String helpAct(Model model) {
		System.out.println("helps");
		
		List<Actinfo> list =  actinfoService.findAllActinfo();
		
		System.out.println(list);
		
		model.addAttribute("list", list);
		return "user/helps";
	}
	
	/** 求助发表界面
	 * @return
	 */
	@RequestMapping(value = "userPublishActinfo")
	public String userPublishActinfo(Model model) {
		User user = (User) session.getAttribute("user");
		
		// 捐赠总数：
//		List<Support> supList1 = supportService.findAllByDonorid(user.getId());
		Item item = new Item();
		item.setUserid(user.getId());
		List<Item> itmeList1 = itemService.findItemBySome(item);
		
		// 领取总数： 
		List<Support> supList2 = supportService.findAllByReceiveid(user.getId());


		model.addAttribute("user", user);
//		System.out.println(user);
//		model.addAttribute("num1", supList1.size());
		model.addAttribute("num1", itmeList1.size());
		model.addAttribute("num2", supList2.size());
		return "user/userPublishActinfo";
	}
	
	/** 求助发表界面
	 * @return
	 */
	@RequestMapping(value = "userPubAct")
	public String userPubAct(Model model,
			MultipartFile file,
			@ModelAttribute Actinfo actinfo) {
		System.out.println(actinfo);
		if(file == null) {
			System.out.println("文件为空！！！");
			return "user/userPublishActinfo";
		}
		System.out.println(file);
		//上传图像：
		String imgpath = ImageUtil.generateNormalImg("", file);
		System.out.println("图片路径：" + imgpath);
		//添加到对象：
		if(imgpath != null && !imgpath.equals("")) {
			User user = (User) session.getAttribute("user");
			actinfo.setActid(1);
			actinfo.setUserid(user.getId());
			actinfo.setAuditid(1);
			actinfo.setActimg(imgpath);
			actinfo.setActtypeid("3");
			actinfoService.addActinfo(actinfo);
			System.out.println(actinfo);
		}
		else {
			System.out.println("获取图片路径失败！");
		}
		
		//----
		User user = (User) session.getAttribute("user");
		// 捐赠总数：
//		List<Support> supList1 = supportService.findAllByDonorid(user.getId());
		Item item = new Item();
		item.setUserid(user.getId());
		List<Item> itmeList1 = itemService.findItemBySome(item);
		
		// 领取总数： 
		List<Support> supList2 = supportService.findAllByReceiveid(user.getId());


		model.addAttribute("user", user);
//		System.out.println(user);
//		model.addAttribute("num1", supList1.size());
		model.addAttribute("num1", itmeList1.size());
		model.addAttribute("num2", supList2.size());
		return "user/userPublishActinfo";
	}
	
	
	/** 求助详情
	 * @return
	 */
	@RequestMapping(value = "helpDetial")
	public String helpDetial(Model model, @RequestParam("id") Integer id) {
		System.out.println("helpDetial");
		
		// 找到指定的求助活动
		Actinfo help =  actinfoService.findById(id);
		// 找到该活动的相关评论
		List<Interactive> list = new ArrayList<Interactive>();
		Interactive inter = new Interactive();
		inter.setDistin(2);
		inter.setItemid(id);
		list = interactiveService.findInteractiveBySome(inter);
		
		// 找到评论者
		List<User> userList = new ArrayList<User>();
		for(Interactive temp : list) {
			userList.add(userService.findById(temp.getDonorid()));
		}
		System.out.println("用户：" + userList);
		System.out.println(help);
		
		model.addAttribute("help", help);
		model.addAttribute("list", list);
		model.addAttribute("userList", userList);
		return "user/helpDetial";
	}
	
	@ResponseBody
	@RequestMapping(value = "helppl")
	public String helppl(Model model, 
			@RequestParam("content") String content,
			@RequestParam("itemid") Integer itemid) {
		System.out.println("helpDetial");
		User user = (User) session.getAttribute("user");
		if(user == null) {
//			System.out.println("您尚未登入！");
//			return "forward:/user/actinfoDetail?id="+itemid;
			return "您尚未登入！";
		}
		// 评论
		Interactive intec = new Interactive();
		intec.setItemid(itemid);
		intec.setDonorid(user.getId());
		intec.setReceiveid(actinfoService.findById(itemid).getUserid());
		intec.setContent(content);
		intec.setDistin(2);
		interactiveService.addInteractive(intec);
		
		System.out.println("评论成功！");
		
//		return "评论成功";
//		return "forward:/user/helpDetial?id="+itemid;
		return "1";
	}
	
	/** 捐赠物品发表界面
	 * @return
	 */
	@RequestMapping(value = "userPublishItem")
	public String userPublishItem(Model model) {
		User user = (User) session.getAttribute("user");
		System.out.println( "userPublishItem====" );
		
		// 捐赠总数：
//		List<Support> supList1 = supportService.findAllByDonorid(user.getId());
		Item item = new Item();
		item.setUserid(user.getId());
		List<Item> itmeList1 = itemService.findItemBySome(item);
		
		// 领取总数： 
		List<Support> supList2 = supportService.findAllByReceiveid(user.getId());

		

		model.addAttribute("user", user);
//		System.out.println(user);
//		model.addAttribute("num1", supList1.size());
		model.addAttribute("num1", itmeList1.size());
		model.addAttribute("num2", supList2.size());
		model.addAttribute("itemTypes", itemTypeService.findAllItemType());
		return "user/userPublishItem";
	}
	
	/** 
	 * 捐赠物品处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "userPubItem")
	public String userPubItem(Model model,
			MultipartFile file,
			@ModelAttribute Item item) {
		
		if(file == null) {
			System.out.println("文件为空！！！");
			return "redirect:/userPublishItem";
		}
		//上传图像：第一个参数为子文件路径，第二个为文件对象
		String imgpath = ImageUtil.generateNormalImg("",file);
		System.out.println("图片路径：" + imgpath);
		//添加到对象：
		if(imgpath != null && !imgpath.equals("")) {
			User user = (User) session.getAttribute("user");
			System.out.println("用户：" + user);
			item.setUserid(user.getId());
			item.setAuditid(1);
			item.setItemimg(imgpath);
			itemService.addItem(item);
		}
		else {
			System.out.println("获取图片路径失败！");
		}
		return "forward:/user/userPublishItem";
	}
	
	
	/**
	 * 互动界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "userItemDetail")
	public String userItemDetail(Model model, 
			@RequestParam("id") Integer id) {
		
		User user = (User) session.getAttribute("user");
		User user1 = null;
		User user2 = null;
		int userid1 = 0;
		int userid2 = 0;

		// 物品
		Item item = itemService.findById(id);
		// 标记为0为左边
		List<Integer> tyList = new ArrayList<Integer>();
		// 所有的评论
		Interactive tt = new Interactive();
		tt.setItemid(id);
		tt.setDistin(0); 
		List<Interactive> intList = interactiveService.findInteractiveBySome(tt) ;
		
		//帮扶记录
		Support sup = new Support();
		sup.setItemid(id);
		if(item.getUserid() == user.getId()) {
			sup.setDonorid(user.getId());
		}
		else {
			sup.setReceiveid(user.getId());
		}
		System.out.println("记录：" + sup.toString());
		List<Support> tsup = supportService.findSupportBySome(sup);
		if(tsup.size()>0) {
			sup = tsup.get(0);
			if(item.getUserid() == user.getId()) {
				// 捐赠者
				user1 = user; 
				user2 = userService.findById(sup.getReceiveid());
				for(Interactive in : intList) {
					if(in.getDonorid() == user.getId()) {
						tyList.add(1);
					}
					else {
						tyList.add(0);
					}
				}
			}
			else {
				// 接收者
				userid2 = user.getId();
				user1 = user;
				user2 = userService.findById(sup.getDonorid());
				System.out.println("用户11： " + user1.toString());
				System.out.println("用户22： " + user2.toString());
				System.out.println("捐赠者id: " + sup.getDonorid());
				for(Interactive in : intList) {
					if(in.getDonorid() == user.getId()) {
						tyList.add(1);
					}
					else {
						tyList.add(0);
					}
				}
			}
		}
		int flag = 1;
		if(user1 == null || user2 == null) {
			flag = 0;
		}
//		System.out.println("用户1： " + user1.toString());
//		System.out.println("用户2： " + user2.toString());
		// 得到物品的领取状态
		int st = item.getAuditid();
		System.out.println("得到物品的领取状态====" + st);
//		if(st == 3) {
//			st = 4;
//		}
//		else if(st == 2) {
//			Apply apply = applyService.findByItemid(item.getId());
//			if(apply != null) {
//				st = 3;
//			}
//		}
		if(st == 2) {  // 物品捐赠成功, 看是否被领取
			Apply apply = new Apply();
			if(userid2 != 0) { // 如果是接收者
				apply.setUserid(user.getId());
				apply.setItemid(id);
				List<Apply> listapply = applyService.findApplyBySome(apply);
				if(listapply.size() > 0) { // 被申请
					st = 3;
					Apply apply2 = listapply.get(0);
					if(apply2.getAuditid() == 2) { // 领取成功
						st = 4;
					}
				}
			}
			else {   // 捐赠者
//				apply.setUserid(user.getId());
				apply.setItemid(id);
				List<Apply> listapply = applyService.findApplyBySome(apply);
				if(listapply.size() > 0) {
					st = 3;
				}
				for(Apply app : listapply) {
					if(app.getAuditid() == 2) {
						st = 4;
						break;
					}
				}
			}
			
		}
		model.addAttribute("st", st);
		model.addAttribute("flag", flag);
		model.addAttribute("tyList", tyList);
		model.addAttribute("intList", intList);
		model.addAttribute("item", item);
		model.addAttribute("user1", user1); // 右边
		model.addAttribute("user2", user2); // 左边
//		System.out.println(tyList.toString() + "觉得JFK的JFK大家即可");
		
		// 捐赠总数：
//		List<Support> supList1 = supportService.findAllByDonorid(user.getId());
		Item item2 = new Item();
		item2.setUserid(user.getId());
		List<Item> itmeList1 = itemService.findItemBySome(item2);
		
		// 领取总数： 
		List<Support> supList2 = supportService.findAllByReceiveid(user.getId());

		model.addAttribute("user", user);
//		System.out.println(user);
		
		model.addAttribute("num1", itmeList1.size());
		model.addAttribute("num2", supList2.size());
		
		return "user/userItemDetail";
	}
	
	/**
	 * 互动留言
	 * 
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "hudong")
	public String hudong(Model model, 
			@RequestParam("id") Integer id, 
			@RequestParam("content") String content) {
		
		User user = (User) session.getAttribute("user");
		Item item = itemService.findById(id);
		// 上传评论：
		Interactive inter = new Interactive();
		inter.setItemid(id);
		inter.setDonorid(user.getId());
		
		Support sup = supportService.findByItemid(id);
		if(sup.getReceiveid() != null) {
			if(sup.getDonorid() == user.getId()) {
				inter.setReceiveid(sup.getReceiveid());
			}
			else {
				inter.setReceiveid(sup.getDonorid());
			}
		}
		inter.setContent(content);
		inter.setDistin(0);
		interactiveService.addInteractive(inter);
		System.out.println("添加的评论为1：" + inter);
		return "1";
	}
	
}
