<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'course_list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 使用bootstrap, 依赖jquery，所以先导入jq -->
<script type="text/javascript" src="<%=path%>/js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="<%=path%>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=path%>/bootstrap-3.3.7/css/bootstrap.min.css">


<script type="text/javascript">

	function edit(cu_id){
		window.location.href = "<%=path%>/course/edit/list?curId="+cu_id;
	}
	
	function del(cu_id){
		window.location.href = "<%=path%>/course/del?curId="+cu_id;
	}; 
	function add(cu_id){
		
		window.location.href = "<%=path%>/course/add/list?curId="+cu_id;
	};
	
	
</script>

</head>

<body>
	<h2>资讯管理-资讯表</h2>


	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<button type="button" onclick="add()"
								class="btn btn-primary ">添加</button>
			</div>
		</div>
		&nbsp;
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>id</td>
    				<td>资讯类型</td>
    				<td>标题</td>
    				<td>内容</td>
    				<td>上传时间</td>
    				<td>图片</td>
    				<td>附件</td>
    				<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ifDto}" var="i">
					<tr>
						<td>${i.id}</td>
						<td>${i.informationType.name}</td>
						<td>${i.title}</td>
						<td>${i.contents}</td>
						<td>${i.releaseTime}</td>
						<td>${i.photo}</td>
						<td>${i.attachment}</td>
						<td>

							<button type="button" onclick="edit(${i.id })"
								class="btn  btn-primary ">
								编辑
								
							</button> &nbsp;&nbsp;

							<button type="button" onclick="del(${i.id })"
								class="btn  btn-primary ">
								删除
							</button>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>

</body>
</html>

