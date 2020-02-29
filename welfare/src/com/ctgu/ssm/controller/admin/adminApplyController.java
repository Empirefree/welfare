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
public class adminApplyController{
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
	@Qualifier("auditTypeService")
	private AuditTypeService auditTypeService;
	
	@Autowired
	@Qualifier("supportService")
	private SupportService supportService;
	
	@Autowired
	private HttpSession session;
	
/***************************************************操作申请***************************************************/
	/**
	 * 处理添加申请请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Apply apply  要添加的申请对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/apply/addApply")
	 public ModelAndView addApply(
			 String flag,
			 @ModelAttribute Apply apply,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("admin/apply/showAddApply");
		}else{
			System.out.println("操作申请成功~~~");
			applyService.addApply(apply);
			mv.setViewName("redirect:admin/apply/selectApply");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Apply apply  要添加的申请对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/apply/updateApply")
	 public ModelAndView updateApply(
			 @RequestParam("flag") String flag,
			 String remarks,
			 @ModelAttribute Apply apply,
			 ModelAndView mv,
			 HttpSession session){
		System.out.println("欢迎来到申请页面~~~");
		if(flag.equals("1")){
			Apply target = applyService.findById((apply.getId()));
			mv.addObject("apply",target);
			mv.setViewName("/admin/apply/showupdateApply");
			
		}else{
			applyService.updateApply(apply);
//			System.out.println("请求：" + apply);
			if(apply.getAuditid() == 2) {
				
				System.out.println("领取成功");
				Item item = itemService.findById(apply.getItemid());
				
				if(item.getItemcount() <= 0){  // 领取失败
					System.out.println("cannot apply, num letter 0");
				}
				else{
					item.setItemcount(item.getItemcount() - 1);
					itemService.updateItem(item);
					Support support = new Support();
					support.setReceiveid(apply.getUserid());
					support.setItemid(apply.getItemid());
					support.setItemnum(1);
					support.setDistin(0);
					support.setDonorid(itemService.findById(apply.getItemid()).getUserid());
					support.setRemarks(remarks);
					supportService.addSupport(support);
				}
			}
			mv.setViewName("redirect:/admin/apply/selectApply");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理删除申请请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@ResponseBody
	@RequestMapping(value="/apply/removeApply")
	 public String removeApply(Integer id,ModelAndView mv){
		// 根据id删除申请
		applyService.deleteById(id);
		// 设置客户端跳转到查询请求
		System.out.println("删除申请成功~~~");
		mv.setViewName("redirect:/admin/apply/selectApply");
		return "1";
	}
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/apply/selectApply")
	 public String selectApply(Model model){
		/** 查询申请信息     */
		System.out.println("欢迎来到申请提取界面~~~");
		List<Apply> applys = applyService.findAllApply();
		model.addAttribute("applys", applys);
		
		/*查询数字名称*/
		//用户类型名称
		List<User> temp_users = new ArrayList<User>();
		for(int i = 0; i < applys.size(); i++){
			Apply temp = applys.get(i);
			temp_users.add(userService.findById(temp.getUserid()));
		}
		model.addAttribute("temp_users", temp_users);
//		//活动类型名称
//		List<ActType> temp_actTypes = new ArrayList<ActType>();
//		for(int i = 0; i < applys.size(); i++){
//			Apply temp = applys.get(i);
//			temp_actTypes.add(actTypeService.findById(Integer.parseInt(temp.getActtypeid())));
//		}
//		model.addAttribute("temp_actTypes", temp_actTypes);
		//审核类型名称
		List<AuditType> temp_audittypes = new ArrayList<AuditType>();
		for(int i = 0; i < applys.size(); i++){
			Apply temp = applys.get(i);
			temp_audittypes.add(auditTypeService.findById(temp.getAuditid()));
		}
		model.addAttribute("temp_audittypes", temp_audittypes);
//		//物品类型名称
//		List<ItemType> temp_itemtypes = new ArrayList<ItemType>();
//		for(int i = 0; i < applys.size(); i++){
//			Apply temp = applys.get(i);
//			temp_itemtypes.add(itemTypeService.findById(temp.getItemid()));
//		}
//		model.addAttribute("temp_itemtypes", temp_itemtypes);
		//物品类型名称
		List<Item> temp_items = new ArrayList<Item>();
		for(int i = 0; i < applys.size(); i++){
			Apply temp = applys.get(i);
			temp_items.add(itemService.findById(temp.getItemid()));
		}
		model.addAttribute("temp_items", temp_items);
		
		return "/admin/apply/apply";
	
	}
	/***************************************************操作完成***************************************************/
	
	/**
	 * 处理/findApply请求
	 * */
	@RequestMapping(value="/apply/findApply")
	 public String findApply(Model model,
			 Integer itemid){
		/** 查询申请信息     */
		System.out.println("欢迎来到申请提取界面~~~");
		Apply app = new Apply();
		app.setItemid(itemid);
		List<Apply> applys = applyService.findApplyBySome(app);
		model.addAttribute("applys", applys);
		return "/admin/apply/apply";
	}
	
}
