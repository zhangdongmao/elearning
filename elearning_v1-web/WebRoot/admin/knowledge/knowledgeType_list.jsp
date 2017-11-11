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

<title>My JSP 'knowledgeType_list.jsp' starting page</title>

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
	function edit(kt_id){
		window.location.href = "<%=path%>/course/edit/list?knowledgeTypeId="+kt_id;
	}
	function del(ktid){
	alert(1);
		window.location.href = "<%=path%>/knowledgeType/del?ktid="+ktid;
	}
	function add(kt_id){
		
		window.location.href = "<%=path%>/course/add/list?ktid="+kt_id;
	}
	
	function listCourse(){
				$.getJSON("<%=path%>/knowledgeType/list",function(data){
					var knowledgeTypeData = $("#knowledgeTypeData");
					/* courseData.empty(); */
					for(var i=0; i<data.length;i++){
						var tr = "<tr>"+
		    				"<td>"+data[i].id+"</td>"+
		    				"<td>"+data[i].name+"</td>"+
		    				"<td>"+data[i].code+"</td>"+
		    				"<td><a href='<%=path%>/knowledgeType/del?ktid='"+data[i].id+"><button type='button'>删除</button></a> &nbsp;&nbsp;"+
		    				"<a href='<%=path%>/knowledgeType/edit?ktid='"+data[i].id+"><button type='button'>编辑</button></a></td>"+
		    				"</tr>";
		    				
		    			knowledgeTypeData.append(tr);
					}
				});
			}
	})
	
</script>
</head>

<body>
	<h2>知识管理-知识类型列表</h2>


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
					<td>知识类型名称</td>
					<td>知识类型编码</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="knowledgeTypeData">
				
			</tbody>
		</table>


	</div>

</body>
</html>

