package com.ctgu.ssm.controller.admin;

import java.sql.DriverManager;
import java.sql.SQLException;
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

import com.ctgu.ssm.entity.Admin;
import com.ctgu.ssm.entity.Apply;
import com.ctgu.ssm.entity.Item;
import com.ctgu.ssm.entity.Leaveidea;
import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.ActTypeService;
import com.ctgu.ssm.service.ActinfoService;
import com.ctgu.ssm.service.AdminService;
import com.ctgu.ssm.service.ApplyService;
import com.ctgu.ssm.service.ItemService;
import com.ctgu.ssm.service.ItemTypeService;
import com.ctgu.ssm.service.LeaveideaService;
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.SupportService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.MD5Util;
import com.ctgu.ssm.utils.SerachBase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;


@Controller
@RequestMapping("/admin")
public class adminUserController{
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
	private HttpSession session;
	
	//数据库的相关配置
	 private final String DRIVER = "com.mysql.jdbc.Driver";
	 private final String URL = "jdbc:mysql://localhost:3306/campus_system?useUnicode=true&characterEncoding=utf8";
	 private final String USERNAME = "root";
	 private final String PASSWORD = "root";
	
	
	/**
	 * 主页
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String toIndex(Model model) {

		System.out.println("欢迎来到后台管理界面~~~");

		return "admin/index";
	}
	@RequestMapping("/main")
	public String main(Model model) throws ClassNotFoundException, SQLException {
		//添加首页信息
		List<User> users = userService.findAllUser();
		model.addAttribute("userCount",users.size());
		List<Item> items = itemService.findAllItem();
		model.addAttribute("itemCount",items.size());
		List<Apply> applys = applyService.findAllApply();
		model.addAttribute("applyCount",applys.size());
		List<Admin> admins = adminService.findAllAdmin();
		model.addAttribute("adminCount",admins.size());
		String str = System.getProperty("user.dir");
		model.addAttribute("mulu", str);
		
		Class.forName(DRIVER);
        Connection con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
        DatabaseMetaData metaData = (DatabaseMetaData) con.getMetaData();
		model.addAttribute("mydb", metaData.getDatabaseProductName() + metaData.getDatabaseProductVersion());

		System.out.println("欢迎来到后台管理界面~~~");
		return "/admin/main";
	}
	/**
	 * 登录界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminlogin")
	public String tologin(Model model) {

		System.out.println("欢迎来到登录界面~~~");

		return "admin/adminlogin";
	}
	/**
	 * 登录界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/test")
	public String totest(Model model) {
		return "admin/tab";
	}
	
	
	/**
	 *  返回修个密码界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatPassword")
	public String updatPassword(HttpServletRequest request) {

		System.out.println("updatPassword---------");
 
		return "app/updatPassword";
	}
	
	/**
	 * 登入验证
	 * @param adminname
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/logininfo")
	public String LoginInfo(@RequestParam("adminname") String adminname, @RequestParam("password") String password, Model model) throws Exception {
		// 根据用户名找到用户
		Admin admin = adminService.findByUsername(adminname); 
		MD5Util md5 = new MD5Util();
		String pw = null;
		if(admin != null) {
			pw = MD5Util.getPw(password, admin.getUsername()).toString();
		}
		if (password != null && admin != null && pw.equals(admin.getPassword())) {
			session.setAttribute("admin", admin);
			System.out.println("=========登入成功！----------");
			return "admin/index"; //redirect:/
//			return "success";
		} else {
			//登入失败
			System.out.println("=========登入失败！----------");
			return "admin/adminlogin";
		}
	}
	
	/**管理员退出
	 * @return
	 */
	@RequestMapping("/logout")
	public String Logout() {
		if(session.getAttribute("admin") != null) {
			session.removeAttribute("admin");
		}
		return "admin/adminlogin";
	}
	
	
	/**关于我们
	 * @return
	 */
	@RequestMapping("/about")
	public String About() {
		return "admin/about";
	}
	
	/***************************************************操作用户***************************************************/
	/**
	 * 处理添加用户请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param User user  要添加的用户对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/user/addUser")
	 public ModelAndView addUser(
			 String flag,
			 @ModelAttribute User user,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("admin/user/showAddUser");
		}else{
			System.out.println("操作用户成功~~~");
			userService.addUser(user);
			mv.setViewName("redirect:admin/user/selectUser");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param User user  要添加的用户对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/user/updateUser")
	 public ModelAndView updateUser(
			 String flag,
			 @ModelAttribute User user,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			User target = userService.findById((user.getId()));
			mv.addObject("user",target);
			mv.setViewName("/admin/user/showUpdateUser");
		}else{
			userService.updateUser(user);
			mv.setViewName("redirect:/admin/user/selectUser");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理删除用户请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@ResponseBody
	@RequestMapping(value="/user/removeUser")
	 public String removeUser(Integer id,ModelAndView mv){
		// 根据id删除用户
		userService.deleteById(id);
		// 设置客户端跳转到查询请求
		System.out.println("删除用户成功~~~");
		mv.setViewName("redirect:/admin/user/selectUser");
		return "1";
	}
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/user/selectUser")
	 public String selectUser(Model model){
		/** 查询用户信息     */
		System.out.println("欢迎来到用户提取界面~~~");
		List<User> users = userService.findAllUser();
		model.addAttribute("users", users);
		return "/admin/user/user";
	
	}
	/**
	 * 处理/findUser请求
	 * */
	@RequestMapping(value="/user/findUser")
	 public String findUser(Model model, @RequestParam("name") String name){
		/** 查询用户     */
		List<User> users = getUser(name);
		model.addAttribute("users", users);
		return "/admin/user/user";
	}
	/***************************************************操作完成***************************************************/
	
	/**
	 * 封装搜索的函数
	 * 
	 * @param name
	 * @return
	 */
	public  List<User> getUser(String name){

		List<User>  users = userService.findAllUser(); 
		List<User> ret = new ArrayList<User>();
		//先从数据库获取可查内容
		int total = 0; //查到结果数量
		if(users == null) {
			System.out.println("数据库内暂无内容");
		}
		else {
			//建立词库
			SerachBase searchBase = SerachBase.getSerachBase();  
			for(int i = 0; i < users.size(); i++) {
				User top = users.get(i);
				String[] temp = top.getUsername().replace(" ", "").split(","); 
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
					ret.add(users.get(Integer.valueOf(id)));  
					ct++;
				}
			}
		}
		return ret;
	}
	
}
