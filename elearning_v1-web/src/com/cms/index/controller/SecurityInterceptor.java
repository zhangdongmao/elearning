package com.cms.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//在这个方法中检查用户是否登录
		Object user = request.getSession().getAttribute("login");
		if(user!=null){
			//已经登录，则允许访问
			return super.preHandle(request, response, handler);
		}else{
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}
	
		
		
		
	}
	
}
