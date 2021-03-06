<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>企业在线学习平台</title>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="public_css/index.css">
    <link rel="stylesheet" href="public_css/public.css">
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="public_css/headerAndFooter.css">
</head>
<body style="background: #ebebeb">

<header class="header">

    <div class="nav navbar-default navbar-static-top">
        <div class="container navContainer">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle " data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><img class="logoImg" src="assets/img/logo.png"></a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-left">
                    <li class=" headerNav active"><a href="<%=basePath%>index.jsp">首页</a></li>
                    <li class=" headerNav"><a href="<%=basePath%>course/index/list">课程</a></li>
                    <li class=" headerNav"><a href="wkPlan/plan.html">计划</a></li>
                    <li class=" headerNav"><a href="wkTrain/train.html">培训</a></li>
                    <li class="headerNav"><a href="wkKnowledge/knowledge.html">知识</a></li>
                    <li class=" headerNav"><a href="wkLecturer/lectuer.html">讲师</a></li>
                    <li class=" headerNav"><a href="wkInformation/information.html">资讯</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">我的课堂</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            <span class="headerDropdownImg"><img src="assets/img/avatar.jpg"
                                                                 class="img-circle headerDropdownImg"></span>
                            普通学员
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">个人中心</a></li>
                            <li><a href="#">账号设置</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">退出</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <span class="glyphicon glyphicon-bullhorn hidden-lt-ie8"></span>
                            <span class="badge badge-important">19</span>
                        </a>
                    </li>
                    <li>
                        <a href="#"><span class="glyphicon glyphicon-envelope hidden-lt-ie8"></span></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</header>

<div class="container ">
    <div class="carousel slide" id="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carousel" data-slide-to="0" class="active"></li>
            <li data-target="#carousel" data-slide-to="1"></li>
            <li data-target="#carousel" data-slide-to="2"></li>
            <li data-target="#carousel" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img src="assets/img/slide001.png" alt="">
            </div>
            <div class="item">
                <img src="assets/img/slide003.png" alt="">
            </div>
            <div class="item">
                <img src="assets/img/slide005.png" alt="">
            </div>
            <div class="item">
                <img src="assets/img/slide006.jpg" alt="">
            </div>
        </div>
        <a href="#carousel" class="left carousel-control" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a href="#carousel" class="right carousel-control" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>

    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="course-main">
                <div class="course-content">
                    <div class="panel panel-default">
                        <div class="panel-heading ">
                            <h2 class="panel-title recommend-title">
                                &nbsp;推荐课程
                                <a href="javascript:void(0)" class="pull-right title-more">更多&gt;&gt;</a>
                            </h2>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-4"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-4"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-4"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-4"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>

                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="course-main">
                <div class="course-content">
                    <div class="panel panel-default">
                        <div class="panel-heading ">
                            <h2 class="panel-title recommend-title">
                                &nbsp;推荐课程
                                <a href="javascript:void(0)" class="pull-right title-more">更多&gt;&gt;</a>
                            </h2>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-4"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-5"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-3"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-2"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>

                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="course-main">
                <div class="course-content">
                    <div class="panel panel-default">
                        <div class="panel-heading ">
                            <h2 class="panel-title recommend-title">
                                &nbsp;推荐课程
                                <a href="javascript:void(0)" class="pull-right title-more">更多&gt;&gt;</a>
                            </h2>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-4"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="javascript:void(0)" class="teacher-name">李勇</a>
                                            <a href="javascript:void(0)" class="teacher-des">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-5"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="">李勇</a>
                                            <a href="">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-3"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="">李勇</a>
                                            <a href="">简介</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="course-box">
                                        <a href="javascript:void(0)" class="course-img">
                                            <img src="assets/img/img001.jpg" alt="">
                                            <h3>学习平台演示教程</h3>
                                        </a>
                                        <p class="course-des">本节为演示课程，其中收集了3D、mp4、flash、scorm、网页等各种形式的...</p>
                                        <span class="evaluate">
                                            <span class="glyphicon glyphicon-user course-icon"></span>
                                            <span class="star star-2"></span>
                                            <span class="evaluate-count"><span>999</span>评价</span>
                                        </span>
                                        <span>
                                            讲师：
                                            <a href="">李勇</a>
                                            <a href="">简介</a>
                                        </span>
                                    </div>
                                </div>

                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>



<!--脚注部分开始-->
<div class="footer">
    <div class="container">
        <div class="footer-links">
            <ul class="site-footer-links">
                <li><a href="#">关于我们</a></li>
                <li><a href="#">联系我们</a></li>
                <li><a href="#">帮助</a></li>
                <li>
                    <a href="#">
                        下载客户端
                    </a>
                </li>
            </ul>
        </div>
        <!--清除浮动-->
        <div class="clearfix"></div>
        <div class="footer-copyright">
            Powered by
            <a href="http://www.jingjichang.com.cn" target="_blank">在线学习平台</a>
            ©2013-2017 &nbsp;
        </div>
    </div>
</div>
<!--脚注部分结束-->
</body>
</html>
