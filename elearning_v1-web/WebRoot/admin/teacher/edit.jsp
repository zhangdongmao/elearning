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
			<jsp:param value="讲师编辑" name="title" />
			<jsp:param value="在这里你可以修改讲师信息" name="subTitle" />
		</jsp:include>


		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">讲师信息修改表单</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">

							<form action="<%=path%>/teacher/edit" method="post" id="asdfg"
								class="form-horizontal" enctype="multipart/form-data">
								<input type="hidden" name="id" value="${cur.getId() }">
								<input type="hidden" name="teacherPhoto" id="teacherPhoto"> 
								<input type="hidden" name="roleId" value="${role.getId() }">
								 <input type="hidden" name="userId" value="${user.getId() }">


								<div class="box-body">

									<div class="form-group">
										<label class="col-xs-1 control-label">讲师姓名：</label>

										<div class="col-xs-6 input-group">
											<input name="name" type="text" value="${cur.getName() }"
												class="form-control" placeholder="姓名">
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">讲师介绍：</label>

										<div class="col-xs-6 input-group">
											<input name="teacherIntroduce;" type="text" value="${cur.getTeacherIntroduce()}"
												class="form-control" placeholder="介绍">
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">讲师职位：</label>

										<div class="col-xs-6 input-group">
											<input name="position" type="text" value="${cur.getPosition()}"
												class="form-control" placeholder="职位">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师等级：</label>

										<div class="col-xs-6 input-group">
											<input name="level" type="text" value="${cur.getLevel()}"
												class="form-control" placeholder="等级">
										</div>
									</div>
									
									
									
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师图片：</label>
										<div class="col-xs-6 input-group">
											<div class="row">
												<div class="col-xs-6">
													<div id="mySwitchB" class="switch has-switch switch-mini">
													<input type="checkbox" data-size="mini" id="switchB" 
													${cu.getTeacherPhoto() eq 'true'?"checked":""}
													data-on-color="primary"data-on-text="已确认" data-off-text="不确认"
														data-off-color="warning">确认修改图片
													</div>
													<input id="selectImg" name="photo" type="file"class="form-control" placeholder="0">
													</div>
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
											<select name="nickname" class="form-control">
												<c:forEach items="${users}" var="users">
													<option value=""
														<c:if  test="${users.nickname  eq  user.getNickname()}"> selected="selected"</c:if>>${users.nickname}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师用户名：</label>

										<div class="col-xs-6 input-group">
											<input name="username" type="text" value="${cur.getUsername() }"
												class="form-control" placeholder="用户名">
										</div>
									</div>
									
									
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师密码：</label>

										<div class="col-xs-6 input-group">
											<input name="password" type="text" value="${cur.getPassword() }"
												class="form-control" placeholder="密码">
										</div>
									</div>
								
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师角色：</label>
										<div class="col-xs-6 input-group">
											<select name="role" class="form-control">
												<c:forEach items="${roles}" var="roles">
													<option value=""
														<c:if  test="${roles.name  eq  role.getName()}"> selected="selected"</c:if>>${roles.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>

								

								<!-- /.box-body -->
								<div class="box-footer">
									<button type="submit" class="btn btn-default">修改数据</button>
								</div>
								<!-- /.box-footer -->
							</form>

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
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>admin/js/highlight.js"></script>
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
		$('input.switch').bootstrapSwitch({
					
                    "onColor" : "success",
                    "offColor" : "success",
                    "onText" : "展示",
                    "offText" : "关闭",
                    "size" : "mini"
                });
		
		$('#mySwitchB input').on('switchChange.bootstrapSwitch', function(event, state) {
			var a=$('#teacherPhoto').val(state);
			
		}); 
		//     选择图片
		$('#selectImg').bind('change', function() {
			//兼容性
			var $file = $(this);
			var fileObj = $file[0];
			var windowURL = window.URL || window.webkitURL;
			dataURL = windowURL.createObjectURL(fileObj.files[0]);
			if (fileObj && fileObj.files && fileObj.files[0]) {
				dataURL = windowURL.createObjectURL(fileObj.files[0]);
			} else {
				dataURL = $file.val();
			}
			//返回结果
			$('#selectImgView').attr('src', dataURL);
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
</script>
