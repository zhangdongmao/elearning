<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<script type="text/javascript" src="<%=path %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="<%=path %>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=path%>/bootstrap-3.3.7/css/bootstrap.min.css">

</head>
<script type="text/javascript">
		$(function(){
			//加载课程列表数据.
			//步骤：1.通过ajax请求数据 2.将数据展示出来(dom)
			listInformation();
			
			//保存课程: 1.监听保存按钮事件 2.提交数据到服务器进行保存的处理,提示保存结果 3.关闭保存窗口.
			$("#btnSave").click(function(){
				var formDataStr =  $("#formSave").serialize();
				$.getJSON("<%=path%>/information/saveInformation?"+formDataStr,function(data){
					$('#myModal').modal("hide");//隐藏模态框.
					if(data.code=='200'){
						alert("保存成功!");//先有，后改进
						
						//刷新页面列表
						listInformation();
					}else
						alert("保存失败!失败原因:"+data.message);//先有，后改进
						
					
				});
			});
			
			function listInformation(){
				$.getJSON("<%=path%>/information/list",function(data){
					var informationData = $("#informationData");
					informationData.empty();
					for(var i=0; i<data.length;i++){
						var tr = "<tr>"+
		    				"<td>"+data[i].id+"</td>"+
		    				"<td>"+data[i].informationDesc+"</td>"+
		    				"<td><a href='javascript:edit(...)'>编辑</a> | <a href='javascript:delete(123)'>删除</a></td>"+
		    				"</tr>";
		    			informationData.append(tr);
					}
				});
			}
		})
	</script>
	
<body>
	<h2>资讯管理-资讯类型表</h2>


	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<a href="<%=path %>/admin/information/add.jsp">添加</a>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>id</td>
					<td>资讯类型</td>
					<td>资讯标题</td>
					<td>资讯内容</td>
					<td>发布时间</td>
					<td>图片</td>
					<td>附件</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${informations}" var="is">
					<tr>
						<td>${is.id}</td>
						<td>${is.informationType.id}</td>
						<td>${is.title}</td>
						<td>${is.contents}</td>
						<td>${is.releaseTime}</td>
						<td>${is.photo}</td>
						<td>${is.attachment}</td>
						<td>

							<button type="button" 
								class="btn  btn-default ">
								<a href="<%=path %>/information/edit/list">编辑</a>
								
							</button> &nbsp;&nbsp;

							<button type="button" 
								class="btn  btn-default ">
								<a href="<%=path%>/information/delete?id=${it.id }">删除</a>
							</button>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
