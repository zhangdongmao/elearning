<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<%-- <%=request.getParameter("title") %> <small><%=request.getParameter("subTitle") %></small> --%>


<section class="content-header ">
<h1>
	课程信息管理<small>课程信息的查询、修改、删除</small>
</h1>
</section>
