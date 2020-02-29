package com.ctgu.ssm.controller.admin;

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

import com.ctgu.ssm.entity.ActType;
import com.ctgu.ssm.entity.Actinfo;
import com.ctgu.ssm.entity.Admin;
import com.ctgu.ssm.entity.Apply;
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
import com.ctgu.ssm.service.ItemService;
import com.ctgu.ssm.service.ItemTypeService;
import com.ctgu.ssm.service.LeaveideaService;
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.SupportService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.SerachBase;


@Controller
@RequestMapping("/admin")
public class adminLeaveController{
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

	/***************************************************操作留言***************************************************/
	/**
	 * 处理添加留言请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Leaveidea leaveidea  要添加的留言对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/leaveidea/addLeaveidea")
	 public ModelAndView addLeaveidea(
			 String flag,
			 @ModelAttribute Leaveidea leaveidea,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("admin/leaveidea/showAddLeaveidea");
		}else{
			System.out.println("操作留言成功~~~");
			leaveideaService.addLeaveidea(leaveidea);
			mv.setViewName("redirect:admin/leaveidea/selectLeaveidea");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Leaveidea leaveidea  要添加的留言对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/leaveidea/updateLeaveidea")
	 public ModelAndView updateLeaveidea(
			 String flag,
			 @RequestParam("id")Integer id,
			 @ModelAttribute Leaveidea leaveidea,
			 String comment1,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			Leaveidea target = leaveideaService.findById((leaveidea.getId()));
			mv.addObject("leaveidea",target);
			mv.setViewName("/admin/leaveidea/showUpdateLeaveidea");
		}else{
			Admin admin = (Admin) session.getAttribute("admin");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Leaveidea temp = null;
			Integer tempid = leaveidea.getUser1id();
			
			//增加新的留言表
			leaveidea.setId(null);
			leaveidea.setIdeaid(id);
			leaveidea.setUser1id(admin.getId());
			leaveidea.setComment(comment1);
			leaveidea.setIsSolve(1);
			leaveidea.setCreatetime(df.format(new Date()));
			leaveideaService.addLeaveidea(leaveidea);
			
			//更新原本的留言表
			Leaveidea leaveidea2 = leaveideaService.findById(id);
			leaveidea2.setIsSolve(1);
			leaveideaService.updateLeaveidea(leaveidea2);
			
			mv.setViewName("redirect:/admin/leaveidea/selectLeaveidea");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理删除留言请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@ResponseBody
	@RequestMapping(value="/leaveidea/removeLeaveidea")
	 public String removeLeaveidea(Integer id,ModelAndView mv){
		// 根据id删除留言
		leaveideaService.deleteById(id);
		// 设置客户端跳转到查询请求
		System.out.println("删除留言成功~~~");
		mv.setViewName("redirect:/admin/leaveidea/selectLeaveidea");
		return "1";
	}
	
	/**
	 * 处理/selectLeaveidea请求
	 * */
	@RequestMapping(value="/leaveidea/selectLeaveidea")
	 public String selectLeaveidea(Model model){
		/** 查询留言信息     */
		System.out.println("欢迎来到留言提取界面~~~");
		List<Leaveidea> leaveideas = leaveideaService.findAllLeaveidea();
		model.addAttribute("leaveideas", leaveideas);
		
		/*查询数字名称*/
		//用户类型名称
		List<User> temp_users = new ArrayList<User>();
		for(int i = 0; i < leaveideas.size(); i++){
			Leaveidea temp = leaveideas.get(i);
			temp_users.add(userService.findById(temp.getUser1id()));
		}
		model.addAttribute("temp_users", temp_users);
//		//活动类型名称
//		List<ActType> temp_actTypes = new ArrayList<ActType>();
//		for(int i = 0; i < actinfos.size(); i++){
//			Actinfo temp = actinfos.get(i);
//			temp_actTypes.add(actTypeService.findById(Integer.parseInt(temp.getActtypeid())));
//		}
//		model.addAttribute("temp_actTypes", temp_actTypes);
//		//审核类型名称
//		List<AuditType> temp_audittypes = new ArrayList<AuditType>();
//		for(int i = 0; i < actinfos.size(); i++){
//			Actinfo temp = actinfos.get(i);
//			temp_audittypes.add(auditTypeService.findById(temp.getAuditid()));
//		}
//		model.addAttribute("temp_audittypes", temp_audittypes);
//		//物品类型名称
//		List<Item_type> temp_itemtypes = new ArrayList<Item_type>();
//		for(int i = 0; i < actinfos.size(); i++){
//			Actinfo temp = actinfos.get(i);
//			temp_itemtypes.add(itemTypeService.findById(temp.getid()));
//		}
//		model.addAttribute("temp_itemtypes", temp_itemtypes);
		
		
		return "/admin/leaveidea/leaveidea";
	
	}
	/***************************************************操作完成***************************************************/
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/leaveidea/findLeaveidea")
	 public String findLeaveidea(Model model,
			 Integer id
			 ){
		/** 查询留言信息     */
		System.out.println("欢迎来到留言提取界面~~~");
		Leaveidea lea = new Leaveidea();
		lea.setIdeaid(id);
		List<Leaveidea> leaveideas = leaveideaService.findLeaveideaBySome(lea);
		model.addAttribute("leaveideas", leaveideas);
		
		return "/admin/leaveidea/leaveidea";
	}
	
	
}
