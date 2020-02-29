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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ctgu.ssm.entity.ActType;
import com.ctgu.ssm.entity.Offinfo;
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
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.AdminService;
import com.ctgu.ssm.service.ApplyService;
import com.ctgu.ssm.service.ItemService;
import com.ctgu.ssm.service.ItemTypeService;
import com.ctgu.ssm.service.LeaveideaService;
import com.ctgu.ssm.service.OffinfoService;
import com.ctgu.ssm.service.SupportService;
import com.ctgu.ssm.service.UserService;
import com.ctgu.ssm.utils.ImageUtil;
import com.ctgu.ssm.utils.SerachBase;

@Controller
@RequestMapping("/admin")
public class adminOffController {
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

	/***************************************************
	 * 操作官方活动
	 ***************************************************/
	/**
	 * 处理添加官方活动请求
	 * 
	 * @param String
	 *            flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Offinfo
	 *            offinfo 要添加的官方活动对象
	 * @param ModelAndView
	 *            mv
	 */
	@RequestMapping("/offinfo/addOff")
	public String addOff() {
		return "admin/offinfo/showAddOffinfo";
	}
	@RequestMapping("/offinfo/addOffinfo")
	public ModelAndView addOffinfo(String flag, @ModelAttribute Offinfo offinfo, ModelAndView mv,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session) {
		System.out.println("before if");
		if (flag.equals("1")) {
			mv.setViewName("admin/offinfo/showAddOffinfo");
		} else {
			if (file == null) {
				System.out.println("文件为空！！！");
				mv.setViewName("redirect:/admin/offinfo/addOffinfo?flag=1");
				return mv;
			}
			// 上传图像：第一个参数为子文件路径，第二个为文件对象
			String imgpath = ImageUtil.generateNormalImg("", file);
			System.out.println("图片路径：" + imgpath);
			// 添加到对象：
			if (imgpath != null && !imgpath.equals("")) {
				Admin user = (Admin) session.getAttribute("admin");
				System.out.println(user);
				offinfo.setUserid(user.getId());
				offinfo.setActimg(imgpath);
				offinfo.setActtypeid("3");
				offinfoService.addOffinfo(offinfo);
			} else {
				System.out.println("获取图片路径失败！");
			}
			mv.setViewName("redirect:/admin/offinfo/selectOffinfo");
		}
		// 返回
		return mv;
	}

	/**
	 * 处理添加请求
	 * 
	 * @param String
	 *            flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Offinfo
	 *            offinfo 要添加的官方活动对象
	 * @param ModelAndView
	 *            mv
	 */
	@RequestMapping(value = "/offinfo/updateOffinfo")
	public ModelAndView updateOffinfo(String flag, @ModelAttribute Offinfo offinfo,ModelAndView mv,
			HttpSession session, Model model) {
		if (flag.equals("1")) {
			//活动类型名称
			List<ActType> temp_actTypes = actTypeService.findAllActType();
			model.addAttribute("temp_actTypes", temp_actTypes);
			
			Offinfo target = offinfoService.findById((offinfo.getId()));
			mv.addObject("offinfo", target);
			mv.setViewName("/admin/offinfo/showUpdateOffinfo");
		} else {
			offinfoService.updateOffinfo(offinfo);
			mv.setViewName("redirect:/admin/offinfo/selectOffinfo");
		}
		// 返回
		return mv;
	}

	/**
	 * 处理删除官方活动请求
	 * 
	 * @param String
	 *            ids 需要删除的id字符串
	 * @param ModelAndView
	 *            mv
	 */
	@ResponseBody
	@RequestMapping(value = "/offinfo/removeOffinfo")
	public String removeOffinfo(Integer id, ModelAndView mv) {
		// 根据id删除官方活动
		offinfoService.deleteById(id);
		// 设置客户端跳转到查询请求
		System.out.println("删除官方活动成功~~~");
		mv.setViewName("redirect:/admin/offinfo/selectOffinfo");
		return "1";
	}

	/**
	 * 处理/findUser请求
	 */
	@RequestMapping(value = "/user/findOffinfo")
	public String findOffinfo(Model model, @RequestParam("name") String name) {
		/** 查询用户 */
		List<Offinfo> offinfos = getOff(name);
		model.addAttribute("offinfos", offinfos);
		return "/admin/offinfo/offinfo";
	}

	/**
	 * 处理/login请求
	 */
	@RequestMapping(value = "/offinfo/selectOffinfo")
	public String selectOffinfo(Model model) {
		/** 查询官方活动信息 */
		System.out.println("欢迎来到官方活动提取界面~~~");
		List<Offinfo> offinfos = offinfoService.findAllOffinfo();
		model.addAttribute("offinfos", offinfos);
		
		/*查询数字名称*/
		//用户类型名称
		List<User> temp_users = new ArrayList<User>();
		for(int i = 0; i < offinfos.size(); i++){
			Offinfo temp = offinfos.get(i);
			temp_users.add(userService.findById(temp.getUserid()));
		}
		model.addAttribute("temp_users", temp_users);
		//活动类型名称
		List<ActType> temp_actTypes = new ArrayList<ActType>();
		for(int i = 0; i < offinfos.size(); i++){
			Offinfo temp = offinfos.get(i);
			temp_actTypes.add(actTypeService.findById(Integer.parseInt(temp.getActtypeid())));
		}
		model.addAttribute("temp_actTypes", temp_actTypes);
		
//		//审核类型名称
//		List<AuditType> temp_audittypes = new ArrayList<AuditType>();
//		for(int i = 0; i < offinfos.size(); i++){
//			Offinfo temp = offinfos.get(i);
//			temp_audittypes.add(auditTypeService.findById(temp.getAuditid()));
//		}
//		model.addAttribute("temp_audittypes", temp_audittypes);
//		//物品类型名称
//		List<Item_type> temp_itemtypes = new ArrayList<Item_type>();
//		for(int i = 0; i < offinfos.size(); i++){
//			Offinfo temp = offinfos.get(i);
//			temp_itemtypes.add(itemTypeService.findById(temp.getid()));
//		}
//		model.addAttribute("temp_itemtypes", temp_itemtypes);
		
		
		
		return "/admin/offinfo/offinfo";

	}

	/***************************************************
	 * 操作完成
	 ***************************************************/
	/**
	 * 封装搜索用户的函数
	 * 
	 * @param name
	 * @return
	 */
	public List<Offinfo> getOff(String name) {

		List<Offinfo> offinfos = offinfoService.findAllOffinfo();
		List<Offinfo> ret = new ArrayList<Offinfo>();
		// 先从数据库获取可查内容
		int total = 0; // 查到结果数量
		if (offinfos == null) {
			System.out.println("数据库内暂无内容");
		} else {
			// 建立词库
			SerachBase searchBase = SerachBase.getSerachBase();
			for (int i = 0; i < offinfos.size(); i++) {
				Offinfo top = offinfos.get(i);
				String[] temp = top.getName().replace(" ", "").split(",");
				for (String tt : temp)
					searchBase.add(i + "", tt, tt); // 这里用链表的序号可以方便下面取出对应的节点
			}
			// 查询
			String ids = searchBase.getIds(name); // 返回包含查询商品的名字的商品的id并按出现频率排序，已逗号隔开
			// System.out.println(ids +
			// "-------------------查询结果=============================");
			if (ids != null && !"".equals(ids)) {
				String num[] = ids.split(","); // 用,分割取出id
				int ct = 0;
				for (String id : num) {
					ret.add(offinfos.get(Integer.valueOf(id)));
					ct++;
				}
			}
		}
		return ret;
	}

}
