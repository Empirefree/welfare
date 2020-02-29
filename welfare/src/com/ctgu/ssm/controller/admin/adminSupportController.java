package com.ctgu.ssm.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ctgu.ssm.entity.Item;
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


@Controller
@RequestMapping("/admin")
public class adminSupportController{
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

	/***************************************************操作互助***************************************************/
	/**
	 * 处理添加互助请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Support support  要添加的互助对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/support/addSupport")
	 public ModelAndView addSupport(
			 String flag,
			 @ModelAttribute Support support,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("admin/support/showAddSupport");
		}else{
			System.out.println("操作互助成功~~~");
			supportService.addSupport(support);
			mv.setViewName("redirect:admin/support/selectSupport");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Support support  要添加的互助对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/support/updateSupport")
	 public ModelAndView updateSupport(
			 String flag,
			 @ModelAttribute Support support,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			Support target = supportService.findById((support.getId()));
			mv.addObject("support",target);
			mv.setViewName("/admin/support/showupdateSupport");
		}else{
			supportService.updateSupport(support);
			mv.setViewName("redirect:/admin/support/selectSupport");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理删除互助请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@ResponseBody
	@RequestMapping(value="/support/removeSupport")
	 public String removeSupport(Integer id,ModelAndView mv){
		// 根据id删除互助
		supportService.deleteById(id);
		// 设置客户端跳转到查询请求
		System.out.println("删除互助成功~~~");
		mv.setViewName("redirect:/admin/support/selectSupport");
		return "1";
	}
	
	/**
	 * 处理/selectSupport请求
	 * */
	@RequestMapping(value="/support/selectSupport")
	 public String selectSupport(Model model){
		/** 查询互助信息     */
		System.out.println("欢迎来到互助提取界面~~~");
		List<Support> supports = supportService.findAllSupport();
		model.addAttribute("supports", supports);
		
		/*查询数字名称*/
		//用户类型名称
		List<User> temp_user1s = new ArrayList<User>();
		for(int i = 0; i < supports.size(); i++){
			Support temp = supports.get(i);
			temp_user1s.add(userService.findById(temp.getDonorid()));
		}
		model.addAttribute("temp_user1s", temp_user1s);
		//用户类型名称
		List<User> temp_user2s = new ArrayList<User>();
		for(int i = 0; i < supports.size(); i++){
			Support temp = supports.get(i);
			temp_user2s.add(userService.findById(temp.getReceiveid()));
		}
		model.addAttribute("temp_user2s", temp_user2s);
//		//活动类型名称
//		List<ActType> temp_actTypes = new ArrayList<ActType>();
//		for(int i = 0; i < supports.size(); i++){
//			Support temp = supports.get(i);
//			temp_actTypes.add(actTypeService.findById(Integer.parseInt(temp.getActtypeid())));
//		}
//		model.addAttribute("temp_actTypes", temp_actTypes);
//		//审核类型名称
//		List<AuditType> temp_audittypes = new ArrayList<AuditType>();
//		for(int i = 0; i < supports.size(); i++){
//			Support temp = supports.get(i);
//			temp_audittypes.add(auditTypeService.findById(temp.getAuditid()));
//		}
//		model.addAttribute("temp_audittypes", temp_audittypes);
//		//物品类型名称
//		List<ItemType> temp_itemtypes = new ArrayList<ItemType>();
//		for(int i = 0; i < supports.size(); i++){
//			Support temp = supports.get(i);
//			temp_itemtypes.add(itemTypeService.findById(temp.getItemid()));
//		}
//		model.addAttribute("temp_itemtypes", temp_itemtypes);
		//物品类型名称
		List<Item> temp_items = new ArrayList<Item>();
		for(int i = 0; i < supports.size(); i++){
			Support temp = supports.get(i);
			temp_items.add(itemService.findById(temp.getItemid()));
		}
		model.addAttribute("temp_items", temp_items);
		
		
		
		return "/admin/support/support";
	
	}
	/***************************************************操作完成***************************************************/
	
	/**
	 * 处理/selectSupport请求
	 * */
	@RequestMapping(value="/support/findSupport")
	 public String findSupport(Model model,
			 Integer id){
		/** 查询互助信息     */
		System.out.println("欢迎来到互助提取界面~~~");
		Support sup = new Support();
		sup.setDonorid(id);
		List<Support> supports = supportService.findSupportBySome(sup);
		sup.setReceiveid(id);
		List<Support> supports2 = supportService.findSupportBySome(sup);
		supports.addAll(supports2);
		model.addAttribute("supports", supports);
		return "/admin/support/support";
	
	}
	
}
