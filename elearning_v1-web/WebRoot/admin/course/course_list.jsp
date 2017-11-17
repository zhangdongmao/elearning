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

<style>
	.chapterTdShow{
	display:block;
	
	
}
.chapterTdOff{
	display:none;
	
	font-size:70px;
	
}
	
</style>
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
	
		function show(){
		var chapterTr=document.getElementsByClassName('chapterShow');
		var chapterTdShow=document.getElementsByClassName('chapterTdShow');
		var chapterTdOff=document.getElementsByClassName('chapterTdOff');
			console.log(chapterTdShow.length);
			for(i=0;i<=29;i++){
				chapterTdShow[i].style.display='none';
			}
			
	}
	function getChapter(cuId){
			
		$.getJSON("<%=basePath%>chapter/list?cuId="+cuId,function(data){
			alert(1);
			var list=$('#list');
			for(i=0;i<data.length;i++){
				var tr="<tr>"+
					"<td>"+data[i]+"</td>"+
					"</tr>";
					list.append(tr);
			}
		
		
		})
	}
	
</script>

</head>

<body>
	<h2>课程管理-课程列表</h2>


	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<button type="button" onclick="add(${cu.id })"
								class="btn btn-primary ">添加课程</button>
			</div>
		</div>
		&nbsp;
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>id</td>
					<td>课程编号</td>
					<td>课程名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="list">
				<c:forEach items="${courseDto}" var="cu">
					<tr>
						<td>${cu.id}</td>
						<td>${cu.code}</td>
						<td>${cu.curName}</td>
						<td>

							<button type="button" onclick="edit(${cu.id })"
								class="btn  btn-primary ">
								编辑
								
							</button> &nbsp;&nbsp;

							<button type="button" onclick="del(${cu.id })"
								class="btn  btn-primary ">
								删除
							</button> &nbsp;&nbsp;
							<button type="button" onclick="getChapter(${cu.id })"
								class="btn  btn-primary ">
								查看章节
							</button> &nbsp;&nbsp;
							
							<button type="button" class="btn btn-primary" data-toggle="modal" 
							data-target="#exampleModal" data-whatever="">添加章节</button>
						
						
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		


	</div>
<jsp:include page="/admin/js.jsp"></jsp:include>
</body>
</html>

