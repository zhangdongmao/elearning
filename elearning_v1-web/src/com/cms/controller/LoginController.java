package com.cms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cms.beans.Login;
import com.cms.dto.RequestResultDto;
import com.cms.services.ILoginService;

@Controller
public class LoginController extends HandlerInterceptorAdapter {
	String mess="";
	String state="";
	@Autowired
	ILoginService loginService;
	
	@RequestMapping("/login")
	@ResponseBody
	public RequestResultDto loginHandle(String username,String password,HttpSession session){
		RequestResultDto result = new RequestResultDto("200","登陆成功!","908989812jkjkjdddd");
		String hql="from Login l where l.username=?&&l.password=?";
		//password=DigestUtils.md5Hex(password);
		List<Login> logins=loginService.find(hql, username,password);
		if(logins!=null){
			session.setAttribute("login", logins.get(0));
			result =  new RequestResultDto("200","登陆成功","908989812jkjkjdddd");
		}else{
			result = new RequestResultDto("-100","登陆失败!","908989812jkjkjdddd");
		}
		
		
		
		
		return result;
	}
	
	
}
