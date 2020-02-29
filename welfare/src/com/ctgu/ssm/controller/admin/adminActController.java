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
import com.ctgu.ssm.entity.Audit_type;
import com.ctgu.ssm.entity.Item;
import com.ctgu.ssm.entity.ItemType;
import com.ctgu.ssm.entity.Item_type;
import com.ctgu.ssm.entity.Leaveidea;
import com.ctgu.ssm.entity.Offinfo;
import com.ctgu.ssm.entity.Actinfo;
import com.ctgu.ssm.entity.ActType;
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
import com.ctgu.ssm.service.ActTypeService;
import com.ctgu.ssm.service.SupportService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.SerachBase;
import com.sun.javafx.sg.prism.NGShape.Mode;


@Controller
@RequestMapping("/admin")
public class adminActController{
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
	@Qualifier("auditTypeService")
	private AuditTypeService auditTypeService;
	
	@Autowired
	@Qualifier("supportService")
	private SupportService supportService;
	
	@Autowired
	private HttpSession session;
	
	/***************************************************操作个人活动***************************************************/
	/**
	 * 处理添加个人活动请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Actinfo actinfo  要添加的个人活动对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/actinfo/addActinfo")
	 public ModelAndView addActinfo(
			 String flag,
			 @ModelAttribute Actinfo actinfo,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("actinfo/showAddActinfo");
		}else{
			System.out.println("操作个人活动成功~~~");
			actinfoService.addActinfo(actinfo);
			mv.setViewName("redirect:/actinfo/selectActinfo");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Actinfo actinfo  要添加的个人活动对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/actinfo/updateActinfo")
	 public ModelAndView updateActinfo(
			 String flag,
			 @ModelAttribute Actinfo actinfo,
			 ModelAndView mv,
			 HttpSession session, Model model){
		System.out.println("qqq");

		if(flag.equals("1")){
			//活动类型名称
			List<ActType> temp_actTypes = actTypeService.findAllActType();
			model.addAttribute("temp_actTypes", temp_actTypes);
			System.out.println(temp_actTypes + "QAQ");
			
			Actinfo target = actinfoService.findById((actinfo.getId()));
			mv.addObject("actinfo",target);
			mv.setViewName("/admin/actinfo/showUpdateActinfo");
			
		}else{
			System.out.println("QAQ");
			actinfoService.updateActinfo(actinfo);
			mv.setViewName("redirect:/admin/actinfo/selectActinfo");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理删除个人活动请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@ResponseBody
	@RequestMapping(value="/actinfo/removeActinfo")
	 public String removeActinfo(@RequestParam(value="id")String ids){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除个人活动
			actinfoService.deleteById(Integer.parseInt(id));
		}
		// 返回ModelAndView
		return "1";
	}
	
	/**
	 * 处理/selectActinfo请求
	 * */
	@RequestMapping(value="/actinfo/selectActinfo")
	 public String selectActinfo(Model model,
			 @ModelAttribute Actinfo actinfo){
		/** 查询个人活动信息     */
		List<Actinfo> actinfos = actinfoService.findAllActinfo();
		model.addAttribute("actinfos", actinfos);
		
		/*查询数字名称*/
		//用户类型名称
		List<User> temp_users = new ArrayList<User>();
		for(int i = 0; i < actinfos.size(); i++){
			Actinfo temp = actinfos.get(i);
			temp_users.add(userService.findById(temp.getUserid()));
		}
		model.addAttribute("temp_users", temp_users);
		//活动类型名称
		List<ActType> temp_actTypes = new ArrayList<ActType>();
		for(int i = 0; i < actinfos.size(); i++){
			Actinfo temp = actinfos.get(i);
			temp_actTypes.add(actTypeService.findById(Integer.parseInt(temp.getActtypeid())));
		}
		model.addAttribute("temp_actTypes", temp_actTypes);
		//审核类型名称
		List<AuditType> temp_audittypes = new ArrayList<AuditType>();
		for(int i = 0; i < actinfos.size(); i++){
			Actinfo temp = actinfos.get(i);
			temp_audittypes.add(auditTypeService.findById(temp.getAuditid()));
		}
		model.addAttribute("temp_audittypes", temp_audittypes);
//		//物品类型名称
//		List<Item_type> temp_itemtypes = new ArrayList<Item_type>();
//		for(int i = 0; i < actinfos.size(); i++){
//			Actinfo temp = actinfos.get(i);
//			temp_itemtypes.add(itemTypeService.findById(temp.getid()));
//		}
//		model.addAttribute("temp_itemtypes", temp_itemtypes);
		
		
		
		return "/admin/actinfo/actinfo";
	
	}
	
	
	/**
	 * 处理/selectActinfo请求
	 * */
	@RequestMapping(value="/actinfo/findActinfo")
	 public String findActinfo(Model model,
			String name){
		/** 查询个人活动信息     */
		List<Actinfo> actinfos = getOff(name);
		model.addAttribute("actinfos", actinfos);
		return "/admin/actinfo/actinfo";
	
	}
	
	/***************************************************操作完成***************************************************/

	/***************************************************操作活动类型***************************************************/
	/**
	 * 处理添加活动类型请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param ActType actType  要添加的活动类型对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/actType/addActType")
	 public ModelAndView addActType(
			 String flag,
			 @ModelAttribute ActType actType,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("actType/showAddActType");
		}else{
			System.out.println("操作活动类型成功~~~");
			actTypeService.addActType(actType);
			mv.setViewName("redirect:/actType/selectActType");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param ActType actType  要添加的活动类型对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/actType/updateActType")
	 public ModelAndView updateActType(
			 String flag,
			 @ModelAttribute ActType actType,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			ActType target = actTypeService.findById((actType.getId()));
			mv.addObject("actType",target);
			mv.setViewName("actType/showUpdateActType");
		}else{
			actTypeService.updateActType(actType);
			mv.setViewName("redirect:/actType/selectActType");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 处理删除活动类型请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@ResponseBody
	@RequestMapping(value="/actType/removeActType")
	 public String removeActType(@RequestParam(value="id")String ids){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除活动类型
			actTypeService.deleteById(Integer.parseInt(id));
		}
		// 返回ModelAndView
		return "1";
	}
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/actType/selectActType")
	 public String selectActType(Model model,
			 @ModelAttribute ActType actType){
		/** 查询活动类型信息     */
		List<ActType> actTypes = actTypeService.findAllActType();
		model.addAttribute("actTypes", actTypes);
		return "/actType/actType";
	
	}
	/***************************************************操作完成***************************************************/
	/**
	 * 封装搜索用户的函数
	 * 
	 * @param name
	 * @return
	 */
	public  List<Actinfo> getOff(String name){

		List<Actinfo>  actinfos = actinfoService.findAllActinfo(); 
		List<Actinfo> ret = new ArrayList<Actinfo>();
		//先从数据库获取可查内容
		int total = 0; //查到结果数量
		if(actinfos == null) {
			System.out.println("数据库内暂无内容");
		}
		else {
			//建立词库
			SerachBase searchBase = SerachBase.getSerachBase();  
			for(int i = 0; i < actinfos.size(); i++) {
				Actinfo top = actinfos.get(i);
				String[] temp = top.getName().replace(" ", "").split(","); 
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
					ret.add(actinfos.get(Integer.valueOf(id)));  
					ct++;
				}
			}
		}
		return ret;
	}
}
