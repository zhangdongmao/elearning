package com.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cms.dto.ResponseDto;

@Controller
@RequestMapping("/upload")
public class picture {
	@RequestMapping("/upload2")
	public void upload2(@RequestParam("photo") CommonsMultipartFile upload,
			HttpSession session) {
		// 用来检测程序运行时间
		System.out.println("----------pass--------------------");
		try {
			// 得到原始的文件名
			String fileName = upload.getOriginalFilename();
			// 得到文件的后缀名
			String extendName = fileName.substring(fileName.lastIndexOf("."));
			// 重写命名为唯一的文件名
			String onlyName = UUID.randomUUID().toString() + extendName;
			// 得到上传到服务器上的图片文件夹的全路径:C:/apache-tomcat-7.0.47/webapps/SpringMVC_001/upload
			String realyPath = session.getServletContext().getRealPath("/upload");

			File saveDir = new File(realyPath);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			File saveFile = new File(saveDir, onlyName);
			upload.transferTo(saveFile);
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 重定向
		
		
	}
}
