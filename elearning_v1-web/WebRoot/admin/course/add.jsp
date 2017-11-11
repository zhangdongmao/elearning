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
			<jsp:param value="课程添加" name="title" />
			<jsp:param value="在这里你可以添加课程信息" name="subTitle" />
		</jsp:include>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">课程信息添加表单</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<form class="form-horizontal" id="formSave"
								enctype="multipart/form-data">
								<input type="text" name="isPhoto" id="isPhoto"> <input
									type="text" name="recommend" id="recommend">
								<div class="box-body">
									<div class="form-group">
										<label class="col-xs-1 control-label">课程编号：</label>
										<div class="col-xs-6 input-group">
											<input name="code" type="text" value="" class="form-control"
												placeholder="">
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">课程名称：</label>
										<div class="col-xs-6 input-group">
											<input name="curName" type="text" value=""
												class="form-control" placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">课程类型：</label>
										<div class="col-xs-6 input-group">
											<select id="select1" name="courseType" class="form-control">
												<c:forEach items="${types }" var="types">
													<option id="typeName">${types.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">讲师姓名：</label>
										<div class="col-xs-6 input-group">
											<select id="select2" name="teacherName" class="form-control">
												<c:forEach items="${teachers }" var="teachers">
													<option id="teacherName">${teachers.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-xs-1 control-label">开课时间：</label>
										<div class='col-xs-6 input-group date' id='datetimepicker1'>
											<input name="curStartTime" type='text' value=""
												class="form-control" /> <span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
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
											<input name="curTargetUser" value="" type="text"
												class="form-control" placeholder="0">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">课程目标：</label>
										<div class="col-xs-6 input-group">
											<input name="curGoal" value="" type="text"
												class="form-control" placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">开课时间：</label>
										<div class='col-xs-6 input-group date' id='datetimepicker2'>
											<input name="curStartTime" type='text' value=""
												class="form-control" /> <span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-xs-1 control-label">推荐课程：</label>
										<div id="mySwitchA" class="switch has-switch switch-mini">
											<div class="switch-on switch-animate">
												<input id="switchA" type="checkbox" data-on-color="primary"
													data-off-color="warning" data-on-text="已推荐"
													data-off-text="未推荐" data-size="mini">
											</div>
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
													<div id="mySwitchB" class="switch has-switch switch-mini">
														<input type="checkbox" data-size="mini" id="switchB"
															data-on-color="primary" data-on-text="已确认"
															data-off-text="未确认" data-off-color="warning">确认修改图片
													</div>
													<input id="curPhoto" name="curPhoto" type="file"
														class="form-control" placeholder="">
												</div>
												<div class="col-xs-6">
													<img width="150px" id="myPhoto">
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
									<button id="btnSave" type="button" class="btn btn-default">添加数据</button>
								</div>
								<!-- /.box-footer -->
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
	$('#mySwitchA input').on('switchChange.bootstrapSwitch', function(event, state) {
			var a=$('#recommend').val(state);
			
		});
		$('#mySwitchB input').on('switchChange.bootstrapSwitch', function(event, state) {
			var a=$('#isPhoto').val(state);
			
		});
		//设置日期插件
		$('#datetimepicker1').datetimepicker({
			format : 'YYYY-MM-DD',
			locale : moment.locale('zh-cn')
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

			var formDataStr = $("#formSave").serialize();
			var teacherName = $("#select2 option:selected")
			var typeName = $("#select1 option:selected")
			var formData = $("#formSave")[0]; //获取jq对象对应的dom对象
			var formData1 = new FormData(formData);
			//提交图片 
			$.ajax({
				url : "<%=path%>/upload/upload3",
				data : formData1,
				type : "post",
				processData : false,
				contentType : false,
				async : false,
				cache : false,
				success : function(data) {
					console.log(data);
					var jsoObj = JSON.parse(data);
					$("#myPhoto").attr("src", "<%=path%>/" + jsoObj.imgePath)
					$('#curPhoto').val(jsoObj.imgePath)
				}
			});

			$.getJSON("<%=path%>/course/saveCourse?" + formDataStr, function(data) {
				/* $('#myModal').modal("hide");//隐藏模态框. */
				if (data.code == '200') {
					alert("保存成功!"); //先有，后改进
					//刷新页面列表
					listCourse();
				} else
					alert("保存失败!失败原因:" + data.message); //先有，后改进
			});
		});
	})
</script>
