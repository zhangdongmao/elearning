<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'knowledge_list.jsp' starting page</title>

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
$(function(){
	listCourse();
	alert(1);
	function edit(cu_id){
		window.location.href = "<%=path%>/knowledge/edit/list?knowledgeId="+knowledge_id;
	}
	
	function del(){
	window.location.href = "<%=path%>/knowledge/del?knowledgeId="+knowledge_id;
	};
	
	function listCourse(){
				$.getJSON("<%=path%>/knowledge/list",function(data){
					var courseData = $("#courseData");
					/* courseData.empty(); */
					for(var i=0; i<data.length;i++){
						var tr = "<tr>"+
		    				"<td>"+data[i].id+"</td>"+
		    				"<td>"+data[i].name+"</td>"+
		    				"<td>"+data[i].updateTime+"</td>"+
		    				"<td>"+data[i].browserCount+"</td>"+
		    				
		    				"</tr>";
		    			courseData.append(tr);
					}
				});
			}
	})
	
</script>

</head>

<body>
	<h2>知识管理-知识列表</h2>


	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<a href="<%=path%>/admin/course/add.jsp">添加课程</a>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>id</td>
					<td>知识名称</td>
					<td>更新时间</td>
					<td>点击量</td>
				</tr>
			</thead>
			<tbody id="courseData">
				<%-- <c:forEach items="${courses}" var="cu">--%>
					<%-- <input type="hidden" name="id" value="${cu.curType.id}"> 
					<tr>
						<td id="cuId">${cu.id}</td>
						<td>${cu.code}</td>
						<td>${cu.curName}</td>
						<td>

							<button type="button" onclick="edit(${cu.id })"
								class="btn  btn-default ">编辑</button> &nbsp;&nbsp;

							<button type="button" onclick="del(${cu.id })"
								class="btn  btn-default ">删除</button>

						</td>
					</tr> --%>
				<%-- </c:forEach> --%>
			</tbody>
		</table>


	</div>

</body>
</html>

