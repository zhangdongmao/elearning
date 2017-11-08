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
			<jsp:param value="课程编辑" name="title" />
			<jsp:param value="在这里你可以修改课程信息" name="subTitle" />
		</jsp:include>


		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">课程信息修改表单</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">

							<form action="<%=path%>/course/edit" method="get"
								class="form-horizontal" enctype="multipart/form-data">
								<input type="hidden" name="id" value="${cur.getId() }">
								<input type="hidden" name="curPhoto"
									value="${cur.getCurPhoto() }"> <input type="hidden"
									name="teacherId" value="${teacher.getId() }"> <input
									type="hidden" name="typeId" value="${type.getId() }">


								<div class="box-body">

									<div class="form-group">
										<label class="col-xs-1 control-label">课程编号：</label>

										<div class="col-xs-6 input-group">
											<input name="code" type="text" value="${cur.getCode() }"
												class="form-control" placeholder="编号">
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">课程名称：</label>

										<div class="col-xs-6 input-group">
											<input name="curName" type="text" value="${cur.getCurName()}"
												class="form-control" placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">课程类型：</label>
										<div class="col-xs-6 input-group">
											<select name="courseType" class="form-control">
												<c:forEach items="${types }" var="types">
													<option value=""
														<c:if  test="${types.name  eq  type.getName()}"> selected="selected"</c:if>>${types.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师姓名：</label>
										<div class="col-xs-6 input-group">
											<select name="teacherName" class="form-control">
												<c:forEach items="${teachers }" var="teachers">
													<option value=""
														<c:if  test="${teachers.name  eq  teacher.getName()}"> selected="selected"</c:if>>${teachers.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">开课时间：</label>
										<div class='col-xs-6 input-group date' id='datetimepicker1'>
											<input name="curStartTime" type='text'
												value="${cur.getCurStartTime()}" class="form-control" /> <span
												class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">课程章节：</label>
										<div class="col-xs-6 input-group">
											<input name="browser_count" value="" type="text"
												class="form-control" placeholder="0">
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">课程对象：</label>
										<div class="col-xs-6 input-group">
											<input name="curTargetUser" value="${cur.getCurTargetUser()}"
												type="text" class="form-control" placeholder="0">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">课程目标：</label>
										<div class="col-xs-6 input-group">
											<input name="curGoal" value="${cur.getCurGoal()}" type="text"
												class="form-control" placeholder="0">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">课程报名时间：</label>
										<div class='col-xs-6 input-group date' id='datetimepicker2'>
											<input name="curApplicantsTime" type='text'
												value="${cur.getCurApplicantsTime()}" class="form-control" />
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>

									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">推荐课程：</label> 
										<div class="switch" data-on="primary" data-off="info">
										<input type="checkbox" data-size="mini"
										
										data-on="primary" data-off="warning">
										</div>

									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">课程报名人数：</label>
										<div class="col-xs-6 input-group">
											<input name="curNumberApplicants"
												value="${cur.getCurNumberApplicants()}" type="text"
												class="form-control" placeholder="100">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">课程总时数：</label>
										<div class="col-xs-6 input-group">
											<input name="curHour" value="${cur.getCurHour()}" type="text"
												class="form-control" placeholder="100">
										</div>
									</div>




									<div class="form-group">
										<label class="col-xs-1 control-label">课程图片：</label>
										<div class="col-xs-6 input-group">
											<div class="row">
												<div class="col-xs-6">
													<div class="switch switch-mini">
													<input type="checkbox" data-size="mini" id="switchB" data-on-text="确认" data-off-text="不确认"
														name="isPhoto"data-on-color="primary" data-off-color="warning">确认修改图片 
													<input id="selectImg" name="photo" type="file"class="form-control" placeholder="0">
													</div>
												</div>
												<div class="col-xs-6">
													<img style="width: 180px;height: 135px" id="selectImgView"
														src="<%=basePath %>upload/${cu.getCurPhoto()}">
												</div>
											</div>
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">课程介绍：</label>
										<div class="col-xs-10 input-group">
											<script style="height:400px;width:1000px" id="UMeditor"
												name="introduce" type="text/plain">${cur.getCurIntroduce()}</script>
										</div>
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
	/* $('switch').bootstrapSwitch('setState',false); */
		$('input.switch').bootstrapSwitch({
					
                    "onColor" : "success",
                    "offColor" : "success",
                    "onText" : "展示",
                    "offText" : "关闭",
                    "size" : "mini"
                });
		
		/* $('#switchA.switch').bootstrapSwitch({  
				alert(1);
                onText:'打开',  
                offText:'关闭'  
            });  */
		//设置日期插件
		$('#datetimepicker1').datetimepicker({
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn')
		});


		//        选择图片
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
