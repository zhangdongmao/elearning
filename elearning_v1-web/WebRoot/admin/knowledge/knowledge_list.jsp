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
	listKnowledge();
		
		//保存知识类型: 1.监听保存按钮事件 2.提交数据到服务器进行保存的处理,提示保存结果 3.关闭保存窗口.
			$("#btnSave").click(function(){
			alert(111);
				var formDataStr =  $("#formSave").serialize();
				alert(formDataStr);
				$.getJSON("<%=path%>/knowledge/saveKnowledge?"+formDataStr,function(data){
					alert(222);
					$('#myModal').modal("hide");//隐藏模态框.
					if(data.code=='200'){
						alert("保存成功!");//先有，后改进
						//刷新页面列表
						listKnowledge();
						//$("#formSave").reset();//不能使用jq对象调用dom对象的方法
						$("#formSave")[0].reset();//重置表单窗口 -- jq对象是一个伪数组，第0个数据就是对应的DOM对象
					}else
						alert("保存失败!失败原因:"+data.message);//先有，后改进
				});
			});
	})
	var datakname = new Array();
	function listKnowledge(){
		$.getJSON("knowledge/list",function(data){
			var knowledgeData = $("#knowledgeData");
			knowledgeData.empty();
			
			for(var i=0; i<data.length;i++){
			datakname[i] = data[i].ktname;
				var tr = "<tr>"+
    				"<td>"+data[i].id+"</td>"+
    				"<td>"+data[i].ktname+"</td>"+
    				"<td>"+data[i].name+"</td>"+
    				"<td>"+data[i].nickname+"</td>"+
    				"<td>"+data[i].updateTime+"</td>"+
    				"<td>"+data[i].browserCount+"</td>"+
    				"<td>"+
					"<a class='btn btn-primary' href='javascript:edit("+data[i].id+")'>编辑</a> &nbsp;&nbsp;"+
					"<a class='btn btn-primary' href='javascript:del("+data[i].id+")'>删除</a> &nbsp;&nbsp;"+
					"</td>"+
    				"</tr>";
    			knowledgeData.append(tr);	
			}
		})
	}
	/* function listktname(){
		$.getJSON("knowledge/list",function(data){
		var ktname = $("#ktname");
		ktname.empty();
		var kn = data.ktname;
		ktname.append(kn);
		)}
	} */
	
	function del(klId){
		$.getJSON("<%=path%>/knowledge/del",{klId:klId},function(data){
				if(data.code=='200'){
					alert("知识删除成功!");
					//刷新页面列表
					listKnowledge();
				}else
					alert("知识删除失败!失败原因:"+data.message);//先有，后改进
			});
	} 
	
	function edit(klId){
		window.location.href = "<%=path%>/knowledge/edit/list?knowledgeId="+knowledge_id;
	}
	
</script>

</head>

<body>
	<h2>知识管理-知识列表</h2>


	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">添加知识</button>
			</div>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>id</td>
					<td>知识类型名称</td>
					<td>知识名称</td>
					<td>用户昵称</td>
					<td>更新时间</td>
					<td>点击量</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="knowledgeData">
				<%-- <c:forEach items="${kd}" var="kd">
					<tr>
						<td>${kd.id}</td>
						<td>${kd.name}</td>
						<td>${kd.updateTime}</td>
						<td>${kd.browserCount}</td>
						<td>

							<button type="button" onclick="edit(${kd.id })"
								class="btn  btn-primary ">
								编辑
								
							</button> &nbsp;&nbsp;

							<button type="button" onclick="del(${klId })"
								class="btn  btn-primary ">
								删除
							</button>

						</td>
					</tr>
				</c:forEach> --%>
			</tbody>
		</table>
	</div>
	
	<!-- 添加知识 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加知识</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="formSave">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">知识类型</label>
							<div class="col-sm-10">
							<select id="ktname">
								
							</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">知识名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name"
									name="name" placeholder="知识名称">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="uacUserinfor"
									name="uacUserinfor" placeholder="用户id">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">更新时间</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="updateTime" name="updateTime"
									placeholder="更新时间">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">点击量</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="browserCount" name="browserCount"
									placeholder="点击量">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="btnSave" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>

	

</body>
</html>
