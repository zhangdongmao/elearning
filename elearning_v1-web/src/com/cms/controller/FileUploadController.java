package com.cms.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ucai ctrl+shift+o --- 快速导入依赖的类
 * 1.使用io上传文件
 * 2.是使用springMVC上传文件
 * 3.上传文件的异常处理: 使用@Exceptionhandler注解
 * 
 */

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	// 如果没有返回任何东西，默认就导航到路径对应的jsp中.
	@RequestMapping("/FileUpload")
	public void FileUpload() {

	}

	// 1.使用io流上传。
	// @RequestParam -- 将表单提交的参数转成controller的方法的参数注入进来,
	// CommonsMultipartFile file--上传的文件会封装到这个参数。
	@RequestMapping("/upload1")
	public String upload1(@RequestParam("file1") CommonsMultipartFile upload, String userName, HttpSession session)
			throws IOException {
		System.out.println("---userName--" + userName);

		// 用来检测程序运行时间
		long startTime = System.currentTimeMillis();

		// 获取原始的文件名
		System.out.println("fileName：" + upload.getOriginalFilename());

		// 得到原始的文件名:laodong.jpg
		String fileName = upload.getOriginalFilename();
		// 得到文件的后缀名 .jpg
		String extendName = fileName.substring(fileName.lastIndexOf("."));

		// 重写命名为唯一的文件名
		String onlyName = UUID.randomUUID().toString() + extendName;
		// 得到上传到服务器上的图片文件夹的全路径:C:/apache-tomcat-7.0.47/webapps/SpringMVC_001/upload
		String realyPath = session.getServletContext().getRealPath("/upload");

		System.out.println("真正的上传的路径: " + realyPath);

		File saveDir = new File(realyPath);
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}

		File saveFile = new File(saveDir, onlyName);

		InputStream in = upload.getInputStream();// 网络读入
		OutputStream out = new FileOutputStream(saveFile);// 输出到服务器上的硬盘

		byte[] bytes = new byte[1024];// 定义缓冲区
		int length = in.read(bytes);
		while (length != -1) {
			out.write(bytes, 0, length);
			// 继续读
			length = in.read(bytes);
		}
		out.flush();
		out.close();
		in.close();

		long endTime = System.currentTimeMillis();
		System.out.println("方法一的运行时间：" + String.valueOf(endTime - startTime) + "ms");

		session.setAttribute("message", "上传成功");
		// 重定向
		return "redirect:/file_upload_result.jsp";// 重定向使用redirect 关键字
	}

	// 演示采用spring提供的api保存
		@RequestMapping("/upload2")
		public String upload2(@RequestParam("file2") CommonsMultipartFile upload,
				HttpSession session) throws IOException {
			// 用来检测程序运行时间
			long startTime = System.currentTimeMillis();
			System.out.println("fileName：" + upload.getOriginalFilename());
		
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
			
			long endTime = System.currentTimeMillis();
			System.out.println("方法2的运行时间：" + String.valueOf(endTime - startTime)
					+ "ms");
			// 重定向
			return "redirect:/file_upload_result.jsp";
		}

	// 3.ajax请求
	@RequestMapping("/upload3")
	@ResponseBody
	//MultipartHttpServletRequest -- 封装以后的request对象，包含了上传的文件的内容
	public String upload3(HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;

			// 普通表单数据
			Map<String, String[]> dataMap = mulRequest.getParameterMap();
			String[] userName = dataMap.get("userName");
			System.out.println("----userName----" + userName);

			// 文件表单数据 -- 不管多少个文件，都通过次对象获取。key是表单的名字
			Map<String, MultipartFile> fileMap = mulRequest.getFileMap();
			
			MultipartFile file1 = fileMap.get("file1");
			MultipartFile file2 = fileMap.get("file2");

			// 文件保存路径
			String realPath = request.getServletContext().getRealPath("/upload");
			File fileSave = new File(realPath, file1.getOriginalFilename());

			file1.transferTo(fileSave);

			String imgePath = "upload/" + file1.getOriginalFilename();

			return "{\"resultCode\":\"1\",\"imgePath\":\"" + imgePath + "\"}";
		}
		return "{\"resultCode\":\"-11\"}";
	}
	
	//处理文件上传异常
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView fileUploadExceptionHandle(MaxUploadSizeExceededException ex){
		ModelAndView mv = new ModelAndView("/error");
		//model.addAttribute("message","你的文件大小已经超出限制，最大允许文件大小是:" +(ex.getMaxUploadSize()/(1024*1024)+" M!"));
		mv.addObject("message","你的文件大小已经超出限制，最大允许文件大小是:" +(ex.getMaxUploadSize()/(1024*1024)+" M!"));
		
		return mv;
	}
}
