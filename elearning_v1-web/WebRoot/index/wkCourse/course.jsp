<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>企业在线学习平台</title>


<link rel="stylesheet"
	href="<%=basePath %>index/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath %>index/public_css/index.css">
<link rel="stylesheet" href="<%=basePath %>index/public_css/public.css">
<script src="<%=basePath %>index/bower_components/jquery/dist/jquery.min.js"></script>
<script
	src="<%=basePath %>index/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="<%=basePath %>index/public_css/headerAndFooter.css">


</head>
<body style="background: #ebebeb">

	<header class="header">

	<div class="nav navbar-default navbar-static-top">
		<div class="container navContainer">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle " data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../index.jsp"><img class="logoImg"
					src="../assets/img/logo.png"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-left">
					<li class=" headerNav"><a href="../index.html">首页</a></li>
					<li class=" headerNav active"><a
						href="../wkCourse/course.html">课程</a></li>
					<li class=" headerNav"><a href="../wkPlan/plan.html">计划</a></li>
					<li class=" headerNav"><a href="../wkTrain/train.html">培训</a></li>
					<li class="headerNav"><a href="../wkKnowledge/knowledge.html">知识</a></li>
					<li class=" headerNav"><a href="../wkLecturer/lectuer.html">讲师</a></li>
					<li class=" headerNav"><a
						href="../wkInformation/information.html">资讯</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">我的课堂</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"> <span class="headerDropdownImg"><img
								src="../assets/img/avatar.jpg"
								class="img-circle headerDropdownImg"></span> 普通学员 <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">个人中心</a></li>
							<li><a href="#">账号设置</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">退出</a></li>
						</ul></li>
					<li><a href="#"> <span
							class="glyphicon glyphicon-bullhorn hidden-lt-ie8"></span> <span
							class="badge badge-important">19</span>
					</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-envelope hidden-lt-ie8"></span></a></li>
				</ul>
			</div>
		</div>
	</div>

	</header>

	<div class="container course-content">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col-md-2 col-sm-12 col-xs-12">
						<h3 class="course-title">课程</h3>
					</div>
					<div class="col-md-4 col-md-offset-1 col-sm-12 padding-top search ">
						<div class="input-group pull-right">
							<input type="text" class="form-control">
							<div class="input-group-btn">
								<button class="btn btn-default">
									<span class="glyphicon glyphicon-search"></span> 搜索
								</button>
							</div>
						</div>
					</div>
					<div class="col-md-5  col-sm-12 col-xs-12 padding-top">
						<div class="btn-group pull-right " data-toggle="buttons">
							<label class="btn btn-default"> <input type="radio"
								name="options" id="option1">全部
							</label> <label class="btn btn-default"> <input type="radio"
								name="options" id="option2">最新
							</label> <label class="btn btn-default"> <input type="radio"
								name="options" id="option3">热门
							</label> <label class="btn btn-default"> <input type="radio"
								name="options" id="option4">推荐
							</label> <label class="btn btn-default"> <input type="radio"
								name="options" id="option5">岗位课程
							</label>
						</div>
					</div>

				</div>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3">
						<ul class="nav nav-pills nav-stacked">
							<li class="active"><a href="javasript:void(0)">全部分类</a></li>
							<li><a href="javasript:void(0)">平台演示课程<span
									class="badge pull-right">42</span></a></li>
							<li><a href="javasript:void(0)">操作系统<span
									class="badge pull-right">12</span></a></li>
							<li><a href="javasript:void(0)">WEB前端课程<span
									class="badge pull-right">32</span></a></li>
							<li><a href="javasript:void(0)">保险业<span
									class="badge pull-right">2</span></a></li>
							<li><a href="javasript:void(0)">职业素养课程<span
									class="badge pull-right">4</span></a></li>
							<li><a href="javasript:void(0)">数据处理<span
									class="badge pull-right">46</span></a></li>
						</ul>
					</div>
					<div class="col-md-9">
						<div class="container box-tips">
							<ul class="nav nav-pills">
								<li><a href="">前端开发</a></li>
								<li><a href="">专家报告</a></li>
								<li><a href="">演示</a></li>
								<li><a href="">移动开发</a></li>
								<li><a href="">后端开发</a></li>
								<li><a href="">项目经理</a></li>
								<li><a href="">高级</a></li>
								<li><a href="">初级</a></li>
								<li><a href="">前端开发</a></li>
								<li><a href="">专家报告</a></li>
								<li><a href="">演示</a></li>
								<li><a href="">移动开发</a></li>
								<li><a href="">后端开发</a></li>
								<li><a href="">项目经理</a></li>
								<li><a href="">高级</a></li>
								<li><a href="">初级</a></li>
								<li><a href="">高级</a></li>
								<li><a href="">初级</a></li>
								<li><a href="">高级</a></li>
								<li><a href="">初级</a></li>
								<li><a href="">高级</a></li>
								<li><a href="">初级</a></li>
							</ul>

						</div>
						<div class="container box-course">
							<c:forEach items="${courses }" var="courses">
							<div class="col-md-4 col-sm-6">
								<div class="course-box">
									<a href="course_des.html" class="course-img"> <img
										src="<%=basePath%>index/assets/img/img001.jpg" alt="">
										<h3>${courses.curName}</h3>
									</a>
									<p class="curIntroduce">${courses.curIntroduce}</p>
									<span class="evaluate"> <span
										class="glyphicon glyphicon-user course-icon"></span> <span
										class="star star-4"></span> <span class="evaluate-count"><span>999</span>评价</span>
									</span> <span> 讲师： <a href="javascript:void(0)"
										class="teacher-name">${courses.curTeacher.name}</a> <a
										href="javascript:void(0)" class="teacher-des">简介</a>
									</span>
								</div>
							</div>
							</c:forEach>
						
						</div>
						<div class="container">
							<strong>总数:</strong><span>15</span>
						</div>
						<div class="bottomBtn">
							<ul class="pagination">
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">下一页</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="footer">
			<div class="container">
				<div class="footer-links">
					<ul class="site-footer-links">
						<li><a href="#">关于我们</a></li>
						<li><a href="#">联系我们</a></li>
						<li><a href="#">帮助</a></li>
						<li><a href="#"> 下载客户端 </a></li>
					</ul>
				</div>
				<!--清除浮动-->
				<div class="clearfix"></div>
				<div class="footer-copyright">
					Powered by <a href="http://www.jingjichang.com.cn" target="_blank">在线学习平台</a>
					©2013-2017 &nbsp;
				</div>
			</div>
		</div>
</body>
</html>
