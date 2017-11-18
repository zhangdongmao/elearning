<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Data Tables</title>
<jsp:include page="/admin/link.jsp"></jsp:include>

<link
	href="<%=basePath%>res/umeditor1.2.3/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=basePath%>res/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link
	href="<%=basePath%>res/bootstrap-datetimepicker/css/bootstrap-datetimepicker-standalone.css"
	rel="stylesheet">
<link href="<%=basePath%>admin/css/highlight.css" rel="stylesheet">

<link
	href="https://unpkg.com/bootstrap-switch/dist/css/bootstrap3/bootstrap-switch.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/assets/css/docs.min.css"
	rel="stylesheet">
<link href="<%=basePath%>admin/css/main.css" rel="stylesheet">





</head>
<body class="hold-transition my-contentheader ">
	<div class="wrapper">

		<!-- Left side column. contains the logo and sidebar -->

		<!-- Content Wrapper. Contains page content -->

		<!-- Content Header (Page header) -->
		<jsp:include page="/admin/infoHead.jsp">
			<jsp:param value="讲师表添加" name="title" />
			<jsp:param value="在这里你可以添加讲师信息" name="subTitle" />
		</jsp:include>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">讲师信息添加表单</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<form class="form-horizontal" id="formSave" method="post"
								enctype="multipart/form-data">
								<div class="box-body">
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师姓名：</label>
										<div class="col-xs-6 input-group">
											<input name="name" type="text" value="" class="form-control"
												placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师介绍：</label>
										<div class="col-xs-10 input-group">
											<script style="height:400px;width:1000px" id="UMeditor"
												name="teacherIntroduce" type="text/plain">${cur.getTeacherIntroduce()}</script>
										</div>
									</div>


									<div class="form-group">
										<label class="col-xs-1 control-label">讲师职位：</label>
										<div class="col-xs-6 input-group">
											<input name="position" type="text" value=""
												class="form-control" placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师等级：</label>
										<div class="col-xs-6 input-group">
											<input name="level" type="text" value="" class="form-control"
												placeholder="">
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">讲师图片：</label>
										<div class="col-xs-6 input-group">
											<div class="row">
												<div class="col-xs-6">
													<input id="selectImg" name="teacherPhoto" type="file"
													 class="form-control" placeholder="">
												</div>
												<div class="col-xs-6">
													<img style="width: 180px;height: 135px" id="selectImgView"
														src="<%=basePath %>upload/${cu.getTeacherPhoto()}">
												</div>
											</div>
										</div>
									</div>


									<div class="form-group">
										<label class="col-xs-1 control-label">用户表昵称：</label>
										<div class="col-xs-6 input-group">
											<select id="select1" name="userInfor" class="form-control">
												<c:forEach items="${users}" var="users">
													<option id="nickname">${users.nickname}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">课讲师用户名：</label>
										<div class="col-xs-6 input-group">
											<input name="username" value="" type="text"
												class="form-control" placeholder="0">
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">讲师密码：</label>
										<div class="col-xs-6 input-group">
											<input name="password" value="" type="text"
												class="form-control" placeholder="0">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师角色：</label>
										<div class="col-xs-6 input-group">
											<select id="select2" name="role" class="form-control">
												<c:forEach items="${role }" var="role">
													<option id="name">${role.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>


								</div>
								<!-- /.box-body -->
								<!-- /.box-footer -->
							</form>
							<div class="box-footer">
								<button id="btnSave" type="button" class="btn btn-default">添加数据</button>
							</div>
						</div>
						<!-- /.box-body -->
					</div>


				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</section>
		<!-- /.content -->


	</div>
	<!-- ./wrapper -->
	<jsp:include page="/admin/js.jsp"></jsp:include>
	<script src="<%=basePath%>admin/js/highlight.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://unpkg.com/bootstrap-switch"></script>
	<script src="<%=basePath%>admin/js/main.js"></script>
	<script
		src="<%=basePath%>res/bootstrap-datetimepicker/js/moment.min.js"></script>
	<script
		src="<%=basePath%>res/bootstrap-datetimepicker/js/moment-with-locales.min.js"></script>
	<script
		src="<%=basePath%>res/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

	<!-- 配置文件 -->
	<script type="text/javascript"
		src="<%=basePath%>res/umeditor1.2.3/third-party/template.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>res/umeditor1.2.3/umeditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript"
		src="<%=basePath%>res/umeditor1.2.3/umeditor.js"></script>

	<script type="text/javascript"
		src="<%=basePath%>res/umeditor1.2.3/lang/zh-cn/zh-cn.js"></script>

</body>
</html>


<script>


	$(function() {

		$('#mySwitchB input').on('switchChange.bootstrapSwitch', function(event, state) {
			var a = $('#teacherPhoto').val(state);

		});




		//初始化富文本
		var ue = UM.getEditor('UMeditor', {
			autoHeightEnabled : false,
			toolbar : [
				'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
				'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize',
				'| justifyleft justifycenter justifyright justifyjustify |',
				'link unlink | emotion image video  | map',
				'| horizontal print preview', 'drafts', 'formula'
			]
		});
	});
	$(function() {
		$("#btnSave").click(function() {

			var formDataStr = $("#formSave")[0];
			var formData = new FormData(formDataStr);
			var url = "<%=basePath%>teacher/saveTeacher";
			alert("添加成功");
			$.ajax({
				url : url,  /*这是处理文件上传的servlet*/
				type : 'post',
				data : formData,
            	contentType:false,
				async : false,
				cache : false,
				processData : false,
				success : function(returndata) {
				
				window.location.href = "<%=path%>/teacher/list";	
					
				},
				error : function(returndata) {
					console.log(returndata);
				}
			});
		});
	})
</script>
