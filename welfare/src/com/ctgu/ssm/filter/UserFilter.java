package com.ctgu.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserFilter implements Filter{

	@Override
	public void destroy() {
		//@Description: TODO
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null 
				&& request.getRequestURL().indexOf("/user/main") == -1
				&& request.getRequestURL().indexOf("/user/login") == -1
				&& request.getRequestURL().indexOf("/user/logininfo") == -1
				&& request.getRequestURL().indexOf("/user/register") == -1
				&& request.getRequestURL().indexOf("/user/activity") == -1
				&& request.getRequestURL().indexOf("/user/actinfoDetail") == -1
				&& request.getRequestURL().indexOf("/user/aboutUs") == -1
				&& request.getRequestURL().indexOf("/user/showGoods") == -1
				&& request.getRequestURL().indexOf("/user/goodsDetial") == -1
				&& request.getRequestURL().indexOf("/user/itemsearch") == -1
				&& request.getRequestURL().indexOf("/user/helpDetial") == -1
				&& request.getRequestURL().indexOf("/user/helps") == -1
				&& request.getRequestURL().indexOf("/user/registerInfo") == -1) {
			System.out.println("user 拦截器" + request.getRequestURL());
			response.sendRedirect(request.getContextPath()+"/user/login");
		}
		else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//@Description: TODO
	}

}
