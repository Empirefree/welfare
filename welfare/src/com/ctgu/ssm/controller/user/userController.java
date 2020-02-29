package com.ctgu.ssm.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.ctgu.ssm.entity.Actinfo;
import com.ctgu.ssm.entity.Apply;
import com.ctgu.ssm.entity.Interactive;
import com.ctgu.ssm.entity.Item;
import com.ctgu.ssm.entity.Leaveidea;
import com.ctgu.ssm.entity.Offinfo;
import com.ctgu.ssm.entity.Support;
import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.ActinfoService;
import com.ctgu.ssm.service.AdminService;
import com.ctgu.ssm.service.ApplyService;
import com.ctgu.ssm.service.InteractiveService;
import com.ctgu.ssm.service.ItemService;
import com.ctgu.ssm.service.ItemTypeService;
import com.ctgu.ssm.service.LeaveideaService;
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.SupportService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.MD5Util;


@Controller
@RequestMapping("/user")
public class userController{
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;
	
	@Autowired
	@Qualifier("interactiveService")
	private InteractiveService interactiveService;

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
	@Qualifier("supportService")
	private SupportService supportService;
	
	@Autowired
	@Qualifier("applyService")
	private ApplyService applyService;
	
	@Autowired
	@Qualifier("leaveideaService")
	private LeaveideaService leaveideaService;

	@Autowired
	private HttpSession session;

	/**
	 * 
	 * 个人消息
	 * 
	 * @return
	 */
	@RequestMapping("/userMsg")
	public String userMsg(Model model) {

		User user = (User) session.getAttribute("user");
		System.out.println( "userMsg" );
		
		// 提取物品相关的消息：
		   // 有人领取了你的物品
		
		
		
		
		
		
		// 得到所有关于他的互动消息
		List<Interactive> interList = new ArrayList<Interactive>();
		Interactive te = new Interactive();
		te.setReceiveid(user.getId());
		interList = interactiveService.findInteractiveBySome(te);
		
		// 得到消息的发出者
		List<User> userList = new ArrayList<User>();
		for(Interactive tm : interList) {
			userList.add(userService.findById(tm.getDonorid()));
		}
		
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
		
		/*******************************消息管理***************************/
		System.out.println("欢迎来到消息管理界面~~~");
		System.out.println(user);
		//捐赠物品成功与失败
		Item itemsupport1 = new Item();
		Item itemsupport2 = new Item();
		//领取物品成功与失败
		Apply apply1 = new Apply();
		Apply apply2 = new Apply();
		//发起参与活动的成功与失败
		Support support1 = new Support();
		Support support2 = new Support();
		//留言管理
		Leaveidea leaveidea = new Leaveidea();
		
		//捐赠
		itemsupport1.setAuditid(2);
		itemsupport1.setUserid(user.getId());
		itemsupport2.setAuditid(3);
		itemsupport2.setUserid(user.getId());
		//领取
		apply1.setAuditid(2);
		apply1.setUserid(user.getId());
		apply2.setAuditid(3);
		apply2.setUserid(user.getId());
		//活动
		support1.setDistin(1);
		support1.setDonorid(user.getId());
		support2.setDistin(3);
		support2.setDonorid(user.getId());
		//留言表
		leaveidea.setUser1id(user.getId());
		

		//获取捐赠者的名字----成功与失败
		List<Item> itemsupports1 = itemService.findItemBySome(itemsupport1);
		List<Item> itemsupports2 = itemService.findItemBySome(itemsupport2);
		//获取领取者的名字----成功与失败
		List<Apply> applysupports1 = applyService.findApplyBySome(apply1);
		List<User> applyusername1 = new ArrayList<User>();
		for(int i = 0; i < applysupports1.size(); i++){
			Apply supporttemp = applysupports1.get(i);
			applyusername1.add(userService.findById(supporttemp.getUserid()));
		}
		List<Item> itemname1 = new ArrayList<Item>();
		for(int i = 0; i < applysupports1.size(); i++){
			Apply supporttemp = applysupports1.get(i);
			itemname1.add(itemService.findById(supporttemp.getItemid()));
		}
		List<Apply> applysupports2 = applyService.findApplyBySome(apply2);
		List<User> applyusername2 = new ArrayList<User>();
		for(int i = 0; i < applysupports2.size(); i++){
			Apply supporttemp = applysupports2.get(i);
			applyusername2.add(userService.findById(supporttemp.getUserid()));
		}
		List<Item> itemname2 = new ArrayList<Item>();
		for(int i = 0; i < applysupports2.size(); i++){
			Apply supporttemp = applysupports2.get(i);
			itemname2.add(itemService.findById(supporttemp.getItemid()));
		}
		//活动
		List<Support> supports1 = supportService.findSupportBySome(support1);
		List<Actinfo> actinfos1 = new ArrayList<Actinfo>();
		for(int i = 0; i < supports1.size(); i++){
			Support supporttemp = supports1.get(i);
			actinfos1.add(actinfoService.findById(supporttemp.getItemid()));
		}
		List<Support> supports2 = supportService.findSupportBySome(support2);
		List<Actinfo> actinfos2 = new ArrayList<Actinfo>();
		for(int i = 0; i < supports2.size(); i++){
			Support supporttemp = supports2.get(i);
			actinfos2.add(actinfoService.findById(supporttemp.getItemid()));
		}
		
		//留言表
		List<Leaveidea> leaveideas = leaveideaService.findLeaveideaBySome(leaveidea);
		List<Leaveidea> adminLeaves = new ArrayList<Leaveidea>();
		for(Leaveidea leaveidea2:leaveideas) {
			Leaveidea leaveidea3 = new Leaveidea();
			leaveidea3.setIdeaid(leaveidea2.getId());
			List<Leaveidea> tLeaveideas = leaveideaService.findLeaveideaBySome(leaveidea3);
			if(!tLeaveideas.isEmpty()) {
				adminLeaves.add(tLeaveideas.get(0));
			}else {
				adminLeaves.add(null);
			}
		}

		//捐赠物品成功与失败
		model.addAttribute("itemsupports1", itemsupports1);
		model.addAttribute("itemsupports2", itemsupports2);
		//领取物品成功与失败
		model.addAttribute("applyusername1", applyusername1);
		model.addAttribute("itemname1", itemname1);
		model.addAttribute("applysupports1", applysupports1);
		model.addAttribute("applyusername2", applyusername2);
		model.addAttribute("itemname2", itemname2);
		model.addAttribute("applysupports2", applysupports2);
		//发起参与活动的成功与失败
		model.addAttribute("actinfos1", actinfos1);
		model.addAttribute("supports1", supports1);
		model.addAttribute("actinfos2", actinfos2);
		model.addAttribute("supports2", supports2);
		
		//留言的所有信息
		model.addAttribute("leaveideas", leaveideas);
		model.addAttribute("adminLeaves", adminLeaves);
		
		return "user/userMsg";
	}

	/**
	 * 个人信息
	 * 
	 * @return
	 */
	@RequestMapping("/userInfo")
	public String userInfo(Model model) {

		User user = (User) session.getAttribute("user");

		model.addAttribute("user", user);
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
		return "user/userInfo";
	}

	/**
	 * 个人主页面
	 * 
	 * @return
	 */
	@RequestMapping("/userMain")
	public String userMain(Model model) {
		User user = (User) session.getAttribute("user");

		System.out.println("用户：" + user);
		System.out.println( "userMain====" );

		// 捐赠总数：
//		List<Support> supList1 = supportService.findAllByDonorid(user.getId());
		Item item = new Item();
		item.setUserid(user.getId());
		List<Item> itmeList1 = itemService.findItemBySome(item);
		
		System.out.println("我捐赠的东西：\n" + itmeList1);
		
		// 领取总数： 
		List<Support> supList2 = supportService.findAllByReceiveid(user.getId());


		model.addAttribute("user", user);
//		System.out.println(user);
//		model.addAttribute("num1", supList1.size());
		model.addAttribute("num1", itmeList1.size());
		model.addAttribute("num2", supList2.size());
		return "user/userMain";
	}


	/**
	 * 个人领取的所有信息
	 * 
	 * @return
	 */
	@RequestMapping("/userReceived")
	public String userReceived(Model model) {
		User user = (User) session.getAttribute("user");

		//得到个人的领取信息
		List<Support> supList = supportService.findAllByReceiveid(user.getId());
		List<Item> itemList = new ArrayList<Item>();
		List<Integer> cntList = new ArrayList<Integer>();
		for(Support sup : supList) {
			Item it = itemService.findById(sup.getItemid());
			itemList.add(it);
			Interactive in = new Interactive();
			in.setItemid(it.getId());
			in.setDistin(0);
			List<Interactive> ly = interactiveService.findInteractiveBySome(in);
			cntList.add(ly.size());
		}
		System.out.println("评论总数：" + cntList.toString());

		System.out.println( "itemList===个人领取的所有信息=" );

		model.addAttribute("itemList", itemList);
		// 捐赠总数：
//		List<Support> supList1 = supportService.findAllByDonorid(user.getId());
		Item item = new Item();
		item.setUserid(user.getId());
		List<Item> itmeList1 = itemService.findItemBySome(item);
		
		// 领取总数： 
		List<Support> supList2 = supportService.findAllByReceiveid(user.getId());
		
		model.addAttribute("user", user);
//		System.out.println(user);
		model.addAttribute("cntList", cntList);
		model.addAttribute("num1", itmeList1.size());
		model.addAttribute("num2", supList2.size());
		return "user/userReceived";
	}

	/**
	 * 个人捐赠的所有信息
	 * 
	 * @return
	 */
	@RequestMapping("/userDonation")
	public String userDonation(Model model) {
		User user = (User) session.getAttribute("user");

//		//得到个人的捐赠信息
//		List<Support> supList = supportService.findAllByDonorid(user.getId());
//		List<Item> itemList = new ArrayList<Item>();
//		for(Support sup : supList) { 
//			itemList.add(itemService.findById(sup.getItemid()));
//		}
//
//		System.out.println( "itemList===个人捐赠的所有信息=" );

		

		// 捐赠总数：
//		List<Support> supList1 = supportService.findAllByDonorid(user.getId());
		Item item = new Item();
		item.setUserid(user.getId());
		List<Item> itmeList1 = itemService.findItemBySome(item);
		List<Integer> cntList = new ArrayList<Integer>();
		for(Item it : itmeList1) {
			Interactive in = new Interactive();
			in.setItemid(it.getId());
			in.setDistin(0);
			List<Interactive> ly = interactiveService.findInteractiveBySome(in);
			cntList.add(ly.size());
		}
		
		// 领取总数： 
		List<Support> supList2 = supportService.findAllByReceiveid(user.getId());


		model.addAttribute("user", user);
//		System.out.println(user);
		model.addAttribute("cntList", cntList);
		model.addAttribute("num1", itmeList1.size());
		model.addAttribute("num2", supList2.size());
		model.addAttribute("itemList", itmeList1);
		return "user/userDonation";
	}

	/**
	 * 主页
	 * @param request
	 * @return
	 */
	@RequestMapping("/main")
	public String toIndex(Model model) {

		System.out.println("main");
		
		// 搜索活动信息
		List<Offinfo> offinfos = offinfoService.findAllOffinfo();
//		System.out.println(offinfos);
		// 获取第一个条活动
		Offinfo topOff = null;
		if(offinfos.size() > 0) {
			topOff = offinfos.get(0);
		}
		int len1 = topOff.getIntroduce().length();
		if(len1 > 30) {
			topOff.setIntroduce(topOff.getIntroduce().substring(0,30));
		}
		// 只返回前4条
		List<Offinfo> listOffinfo = new ArrayList<Offinfo>();
		int offlen = 4;
		for(int i = 0; i < offinfos.size() && offlen > 0; i++) {
			Offinfo temp = offinfos.get(i);
			temp.setStarttime(temp.getStarttime().substring(0, 10));
			listOffinfo.add(temp);
			offlen--;
		}
		
		// 搜索求助信息
		List<Actinfo> actinfos = actinfoService.findAllActinfo();
//		System.out.println(actinfos);
		// 获取第一个条活动
		Actinfo topAct = null;
		if(actinfos.size() > 0) {
			topAct = actinfos.get(0);
		}
		int len2 = topAct.getIntroduce().length();
		if(len2 > 30) {
			topAct.setIntroduce(topAct.getIntroduce().substring(0,30));
		}
		// 只返回前4条
		List<Actinfo> listActinfo = new ArrayList<Actinfo>();
		int actlen = 4;
		for(int i = 0; i < actinfos.size() && actlen > 0; i++) {
			Actinfo temp = actinfos.get(i);
			if(temp.getAuditid() == 2) {
				temp.setStarttime(temp.getStarttime().substring(0, 10));
				listActinfo.add(temp);
				actlen--;
			}
		}
		
		//搜索可以领取的物品：
		List<Item> items = itemService.findAllItem();
		// 可以领取的物品
		List<Item> listItems = new ArrayList<Item>();
		int len = items.size();
		int all = 20; // 最多而是条轮播
		for(int i = 0; i < len && all > 0; i++) {
			Item temp = items.get(i);
			if(temp.getItemcount() > 0 && temp.getAuditid() == 2) {
				listItems.add(temp);
				all--;
			}
		}

		// 捐赠的物品, 捐赠者
		List<User> userList = new ArrayList<User>();
		for(int i = 0; i < len; i++) {
			Item temp = items.get(i);
			userList.add(userService.findById(temp.getUserid()));
		}

		model.addAttribute("topOff", topOff);
		model.addAttribute("topAct", topAct);
		model.addAttribute("listOffinfo", listOffinfo);
		model.addAttribute("offinfos", offinfos);
		model.addAttribute("listActinfo", listActinfo);
		model.addAttribute("listItems", listItems);
		model.addAttribute("items", items); 
		model.addAttribute("userList", userList);
		
		return "user/main";
	}

	/**
	 * 关于我们
	 * @param request
	 * @return
	 */
	@RequestMapping("/aboutUs")
	public String AboutUs(HttpServletRequest request) {
		return "user/aboutUs";
	}
	/**
	 *  返回修个密码界面
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/updatPassword")
	public String updatPassword(HttpServletRequest request,
			@RequestParam("password") String password, 
			@RequestParam("newpassword") String newpassword, 
			@RequestParam("renewpassword") String renewpassword) throws Exception {

		User user = (User) session.getAttribute("user");
		if(!password.equals(user.getPassword())) {
			System.out.println(password);
			System.out.println(user.getPassword());
			return URLEncoder.encode("原密码错误", "utf-8");
		}
		else if(password.equals(newpassword)) {
			return URLEncoder.encode("与原密码一致！", "utf-8");
		}
		else if("".equals(newpassword)) {
			return URLEncoder.encode("密码不能为空！", "utf-8");
		}
		else if(!newpassword.equals(renewpassword)){
			return URLEncoder.encode("两次密码不同！", "utf-8");
		}
		else {
			MD5Util md5 = new MD5Util();
			String pw = MD5Util.getPw(renewpassword, user.getUsername()).toString();
			user.setPassword(pw);
			userService.updateUser(user);
			session.setAttribute("user", user);
		}

		return URLEncoder.encode("修改成功！", "utf-8");
	}


	/** 请求登入页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String Login(HttpServletRequest request) {
		return "user/login";
	}

	/**
	 * 登入验证
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "logininfo")
	public ModelAndView LoginInfo(@RequestParam("username") String username, @RequestParam("password") String password,ModelAndView mav) throws Exception {
		// 根据用户名找到用户
		User user = userService.findByUsername(username); 
//		System.out.println("LoginInfo run");
		MD5Util md5 = new MD5Util();
		String pw = null;
		if(user != null) {
			pw = MD5Util.getPw(password, user.getUsername()).toString();
		}
		if (password != null && user != null && pw.equals(user.getPassword())) {
			session.setAttribute("user", user);
			System.out.println("=========登入成功！----------");
			mav.setViewName("redirect:/user/main");
			return mav; //redirect:/
		} 
		else {
			//登入失败
			System.out.println("=========登入失败！----------");
			mav.setViewName("user/login");
			mav.addObject("userLoginErrMsg","非法信息");
			return mav;
		}
	}


	/**用户请求注册
	 * @return
	 */
	@RequestMapping(value = "register")
	public String Register() {
		return "user/register";
	}

	/**用户信息修改
	 * @return
	 */
	@RequestMapping(value = "updataInfo")
	public String updataInfo(User user) {

		System.out.println("====" + user);
		User user1 = (User) session.getAttribute("user");
		user.setId(user1.getId());
		userService.updateUser(user);
		session.setAttribute("user", user);
		return "forward:/user/userInfo";
	}

	/**注册提交信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/registerInfo")
	public String RegisterInfo(User user) {
		System.out.println("user" + user);
		if(userService.findByUsername(user.getUsername()) != null) {
			//该用户名已经被注册了
			System.out.println("==========已经被注册=====注册失败=============");
			return "forward:/user/register";
		}

		// 插入新用户
		userService.addUser(user);
		if(session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}
//		session.setAttribute("user", user);
		System.out.println("====================注册成功=============");
		return "user/login";
	}

	/**用户退出
	 * @return
	 */
	@RequestMapping("/logout")
	public String Logout() {
		if(session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}
		return "forward:/user/main";
	}

	/**Aboult
	 * @return
	 */
	@RequestMapping("/about")
	public String About() {
		return "user/about";
	}
	
	@RequestMapping(value="/leaveidea/addLeaveidea")
	 public ModelAndView addLeaveidea(
			 @ModelAttribute Leaveidea leaveidea,
			 ModelAndView mv,
			 HttpSession session){
			User user = (User) session.getAttribute("user");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			System.out.println("添加留言成功~~~");
			leaveidea.setUser1id(user.getId());
			leaveidea.setCreatetime(df.format(new Date()));

			leaveideaService.addLeaveidea(leaveidea);
			mv.setViewName("redirect:/user/userMain");
		// 返回
		return mv;
	}
}
