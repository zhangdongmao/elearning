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
			//加载课程列表数据.
			//步骤：1.通过ajax请求数据 2.将数据展示出来(dom)
	listKnowledgeType();
		
		//保存知识类型: 1.监听保存按钮事件 2.提交数据到服务器进行保存的处理,提示保存结果 3.关闭保存窗口.
			$("#btnSave").click(function(){
				var formDataStr =  $("#formSave").serialize();
				alert(formDataStr);
				$.getJSON("<%=path%>/knowledgeType/saveKnowledgeType?"+formDataStr,function(data){
					$('#myModal').modal("hide");//隐藏模态框.
					if(data.code=='200'){
						alert("保存成功!");//先有，后改进
						//刷新页面列表
						listKnowledgeType();
						//$("#formSave").reset();//不能使用jq对象调用dom对象的方法
						$("#formSave")[0].reset();//重置表单窗口 -- jq对象是一个伪数组，第0个数据就是对应的DOM对象
					}else
						alert("保存失败!失败原因:"+data.message);//先有，后改进
				});
			});
		
	})
	function listKnowledgeType(){
		$.getJSON("knowledgeType/list",function(data){
			var teacherData = $("#teacherData");
			teacherData.empty();
			for(var i=0; i<data.length;i++){
				var tr = "<tr>"+
    				"<td>"+data[i].id+"</td>"+
    				"<td>"+data[i].name+"</td>"+
    				"<td>"+data[i].code+"</td>"+
    				"<td>"+
					"<a class='btn btn-primary' href='javascript:edit("+data[i].id+")'>编辑</a> &nbsp;&nbsp;"+
					"<a class='btn btn-primary' href='javascript:del("+data[i].id+")'>删除</a> &nbsp;&nbsp;"+
					"</td>"+
    				"</tr>";
    			teacherData.append(tr);	
			}
		})
	}
	
	function del(ktId){
		$.getJSON("<%=path%>/knowledgeType/del",{ktId:ktId},function(data){
			//$('#myModal').modal("hide");//隐藏模态框.
				if(data.code=='200'){
					alert("知识删除成功!");
					//刷新页面列表
					listKnowledgeType();
				}else
					alert("知识删除失败!失败原因:"+data.message);//先有，后改进
			});
	} 
	
	
	//实现编辑课程功能:1.点击"编辑“ ，打开编辑窗口 2.通过ajax从服务器获取课程信息，填入到编辑窗口
		// 3.在用户输入完修改数据后，点击保存通过ajax保存数据
		//注意 edit函数需要将作用域扩展到全局
		function edit(ktId){
			//显示编辑窗口
			$("#myModalEdit").modal("show");
			//获取课程id对应的最新数据，填充到表单中
			$.getJSON("<%=path%>/knowledgeType/getknowledgeType?",{ktId:ktId},function(data){
				$("#id").val(data.id);
				$("#name").val(data.name);
				$("#code").val(data.code);
			});
		}
		
	//监听编辑保存按钮事件，点击时候， 保存出数据
	$(function(){
		$("#btnEditSave").click(function(){
				var formDataStr =  $("#formEdit").serialize();
				$.getJSON("<%=path%>/knowledgeType/update?"+formDataStr,function(data){
					if(data.code=='200'){
						alert("编辑保存成功!");
						//刷新页面列表
						listKnowledgeType();
						$("#formEdit")[0].reset();//重置表单窗口 -- jq对象是一个伪数组，第0个数据就是对应的DOM对象
					}else
						alert("保存失败!失败原因:"+data.message);//先有，后改进
						
					$("#myModalEdit").modal("hide");
					});
			})
		})
	

	
</script>

</head>

<body>
	<h2>知识类型管理-知识类型列表</h2>


	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">添加知识类型</button>
			</div>
		</div>
		&nbsp;
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<td>id</td>
					<td>知识类型名称</td>
					<td>知识类型编码</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="teacherData">
				<%-- <c:forEach items="${kt}" var="kt">
					<tr>
						<td>${kt.id}</td>
						<td>${kt.name}</td>
						<td>${kt.code}</td>
						<td>

							<button type="button" onclick="edit(${kt.id })"
								class="btn  btn-primary ">
								编辑
								
							</button> &nbsp;&nbsp;

							<button type="button" onclick="del(${kt.id })"
								class="btn  btn-primary ">
								删除
							</button>

						</td>
					</tr>
				</c:forEach> --%>
			</tbody>
		</table>
	</div>


	<!-- 添加知识类型 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加知识类型</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="formSave">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">知识类型名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="tkid"
									name="name" placeholder="知识类型名称">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">知识类型编码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="tkcode" name="code"
									placeholder="知识类型编码">
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



	<!-- 编辑知识类型 -->
	<div class="modal fade" id="myModalEdit" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">编辑知识类型</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="formEdit">
						<!-- 使用hidden 存储知识类型id -->
						<input type="hidden" class="form-control" id="id" name="id" >

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">知识类型名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name"
									name="name" placeholder="知识类型名称">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">知识类型编码</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="code"
									name="code" placeholder="知识类型编码">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="btnEditSave" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

