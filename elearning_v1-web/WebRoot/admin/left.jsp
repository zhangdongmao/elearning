<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="images/main/member.gif" width="44" height="44" /></div>
    <span>用户：admin<br>角色：超级管理员</span>
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>课程管理</span>
        <a href="<%=path %>/course/list" target="mainFrame" onFocus="this.blur()">课程列表</a>
        <a href="main_list.html" target="mainFrame" onFocus="this.blur()">列表页</a>
         <a href="<%=path %>/teacher/list" target="mainFrame" onFocus="this.blur()">教师列表</a>
        <a href="main_message.html" target="mainFrame" onFocus="this.blur()">留言页</a>
        <a href="main_menu.html" target="mainFrame" onFocus="this.blur()">栏目管理</a>
      </div>
      <div>
        <span>资讯管理</span>
        <a href="<%=path %>/informationType/toList" target="mainFrame" onFocus="this.blur()">资讯类型</a>
        <a href="<%=path %>/information/list" target="mainFrame" onFocus="this.blur()">资讯</a>
      </div>
      <div>
		<span>知识管理</span> 
		<a href="<%=basePath %>knowledgeType/toknowledgeTypeList" target="mainFrame" onFocus="this.blur()">知识类型</a> 
		<a href="<%=basePath %>knowledge/toknowledgeList" target="mainFrame" onFocus="this.blur()">知识列表</a>
	  </div>
      <div class="collapsed">
		<span>课程管理</span> 
		<a href="<%=path %>/teacherst" target="mainFrame" onFocus="this.blur()">教师列表</a> 
		<a href="main_info.html" target="mainFrame" onFocus="this.blur()">列表详细页</a>
		<a href="main_message.html" target="mainFrame" onFocus="this.blur()">留言页</a>
		<a href="main_menu.html" target="mainFrame" onFocus="this.blur()">栏目管理</a>
	 </div>

    </div>
</body>
</html>