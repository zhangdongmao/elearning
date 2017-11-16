<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
	function add(cu_id){
		window.location.href = "<%=path%>/teacher/add/list?curId="+cu_id;
	}
	function edit(cu_id){
		window.location.href = "<%=path%>/teacher/edit/list?curId="+cu_id;
	}
	
	function del(cu_id){
	alert("确定删除");
	window.location.href = "<%=path%>/teacher/del?curId="+cu_id;
	};
	
   $(function(){
	listTeacher();
	})
	
</script>

</head>

<body>
	<h2>讲师管理-讲师列表</h2>


	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<a href="<%=path%>/admin/teacher/add.jsp">添加讲师信息</a>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>id</td>
					<td>讲师姓名</td>
					<td>讲师介绍</td>
					<td>讲师职位</td>
					<td>讲师等级</td>
					<td>讲师图片</td>
					
					<td>讲师用户名</td>
					<td>讲师密码</td>
					
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="teacherData">
				<c:forEach items="${teacher}" var="cu">
					
					<tr>
						<td >${cu.id}</td>
						<td>${cu.name}</td>
						<td>${cu.teacherIntroduce}</td>
						<td>${cu.position}</td>
						<td>${cu.level}</td>
						<td>${cu.teacherPhoto}</td>
						
						
						<td>${cu.username}</td>
						<td>${cu.password}</td>
						
						<td>

							<button type="button" onclick="edit(${cu.id })"
								class="btn  btn-default ">编辑</button> &nbsp;&nbsp;

							<button type="button" onclick="del(${cu.id })"
								class="btn  btn-default ">删除</button>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>

</body>
</html>
