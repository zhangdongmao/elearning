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
						<form class="form-horizontal" id="formSave" enctype="multipart/form-data">
							
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
										<div class="switch" data-on="primary" data-off="info">
											
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
													<input type="checkbox" name="isPhoto" value="true">确认修改图片
													<input id="selectImg" name="photo" type="file"
														class="form-control" placeholder="0">
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
									<button id="btnSave" type="button" class="btn btn-default">添加数据</button>
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
	
	
	$(function(){
		
			$("#btnSave").click(function(){
			alert($("#select1 option:selected").val());
			alert($("#select2 option:selected").val());
				var formDataStr =  $("#formSave").serialize();
				var teacherName = $("#select2 option:selected")
				var typeName = $("#select1 option:selected")
				$.getJSON("<%=path%>/course/saveCourse?"+formDataStr,function(data){
					/* $('#myModal').modal("hide");//隐藏模态框. */
					if(data.code=='200'){
						alert("保存成功!");//先有，后改进
						
						//刷新页面列表
						listCourse();
					}else
						alert("保存失败!失败原因:"+data.message);//先有，后改进
						
					
				});
			});
		})
</script>
