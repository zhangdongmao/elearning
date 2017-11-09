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

<title>My JSP 'informationType_list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 使用bootstrap, 依赖jquery，所以先导入jq -->
<script type="text/javascript" src="<%=path %>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=path %>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/bootstrap-3.3.7/css/bootstrap.min.css">
</head>
<script type="text/javascript">
		//删除资讯类型
			function deleteInformationType(it_id){
				$.getJSON("<%=path%>/informationType/delete",{it_id:it_id},function(data){
				if(data.code=='200'){
					alert("删除成功!");
					//刷新页面列表
					listInformationType2();
				}else
					alert("删除失败!Caused by:"+data.message);
				})
			}
			
			$("#btnSave").click(function(){
				var formDataStr =  $("#formSave").serialize();
				$.getJSON("<%=path%>/informationType/saveInformationType?"+formDataStr,function(data){
					$('#myModal').modal("hide");//隐藏模态框.
					if(data.code=='200'){
						alert("添加成功!");//先有，后改进
						//刷新页面列表
						listInformationType2();
					}else
						alert("保存失败!失败原因:"+data.message);//先有，后改进
				});
			});
			
			function listInformationType2(){
				$.getJSON("<%=path%>/informationType/list",function(data){
					var informationTypeData = $("#informationTypeData");
					informationTypeData.empty();
					for(var i=0; i<data.length;i++){
						var tr="<tr>"+
		    				"<td>"+data[i].id+"</td>"+
		    				"<td>"+data[i].name+"</td>"+
		    				"<td>"+"<a href='javascript:editInformationType("+data[i].id+")'>编辑</a> | <a href='javascript:deleteInformationType("+data[i].id+")'>删除</a>"+
		    				"</td>"+
		    				"</tr>";
		    			informationTypeData.append(tr);
					}
				});
			}
			
		$(function(){
//加载课程列表数据.
//步骤：1.通过ajax请求数据 2.将数据展示出来(dom)
			listInformationType();
//保存课程: 1.监听保存按钮事件 2.提交数据到服务器进行保存的处理,提示保存结果 3.关闭保存窗口.
			function listInformationType(){
				$.getJSON("<%=path%>/informationType/list",function(data){
					var informationTypeData = $("#informationTypeData");
					for(var i=0; i<data.length;i++){
					console.log(data[i]);
						var tr="<tr>"+
		    				"<td>"+data[i].id+"</td>"+
		    				"<td>"+data[i].name+"</td>"+
		    				/* "<td><button type="button" class="btn  btn-default "><a href='javascript:editInformationType("+data[i].id+")'>编辑</a></button>|"+
							"<button type="button" class="btn  btn-default "><a href='javascript:deleteInformationType("+data[i].id+")'>删除</a></button>"+ */
		    				"<td>"+"<a href='javascript:editInformationType("+data[i].id+")'>编辑</a> | <a href='javascript:deleteInformationType("+data[i].id+")'>删除</a>"+
		    				"</td>"+
		    				"</tr>";
		    			informationTypeData.append(tr);
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
				<a href="<%=path %>/admin/informationType/add.jsp">添加</a>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>id</td>
					<td>资讯类型名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="informationTypeData">
					<tr >
					<%--	<td>

						  	<button type="button" class="btn  btn-default ">
								<a href="<%=path %>/informationType/edit/list">编辑</a>

							</button> &nbsp;&nbsp;

							<button type="button" class="btn  btn-default ">
								<a href="<%=path%>/informationType/delete?it_id=${it.id }">删除</a>
							</button> 

						</td>--%>
					</tr> 
				
			</tbody>
		</table>
	</div>

</body>
</html>
