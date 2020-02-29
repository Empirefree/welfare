package com.ctgu.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.UserService;

/**  
* @Title: UserController.java  
*
* @Package com.ctgu.ssm.controller  
*
* @Description: TODO
*
* @author Fantasy  
*
* @date 2019年4月26日  
*
* @version V1.0  
*/
@Controller
public class UserPublicController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkUsername")
	public String checkUsername(String username) {
		User user = userService.findByUsername(username);
		if(null == user) {
			return "1";
		}else {
			return "0";
		}
	}

}
