<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <script type="text/javascript"> 
	function countDown(secs,surl){ 
 	//alert(surl); 
 		var jumpTo = document.getElementById('jumpTo');
 		jumpTo.innerHTML=secs; 
 		if(--secs>0){ 
 		 setTimeout("countDown("+secs+",'"+surl+"')",1000); 
	 	}else{  
  		 location.href=surl; 
 		} 
	} 
	
	/* 点击跳转按钮方法 */
	function tp(){
		window.location.href = "<%=path%>${nextUrl}";
	}
  </script>

  <body>
   <h3>信息提示</h3>
   <div>${message }</div>
   <br/>
   
   <div>你可以直接点击此处<button onclick=tp()>Click</button>
   		进入${nextPageName }页面 
   </div>
   <br/>
   
   <span id="jumpTo">5</span>秒后自动跳转到 &nbsp;&nbsp;${nextPageName}
		<script type="text/javascript">countDown(5,'<%=path%>${nextUrl}');
		</script> 
   
  </body>
</html>
