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

<link href="css/hzj.css" rel="stylesheet">
    <script src="js/bootstrap.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/moment-with-locales.min.js"></script>
</head>
    
<body>


<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading text-center">
            <h1>å­¦çä¿¡æ¯æ·»å </h1>
        </div>
        <!--é¢æ¿åå®¹-->
        <div class="panel-body">
            <!--æ¥è¯¢é¨å-->
            <div class="page-header">
                <h3>è¯·è¾å¥å­¦ççä¿¡æ¯</h3>
            </div>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-xs-2 control-label">å§åï¼</label>
                    <div class="input-group col-xs-6">
                        <input type="text" name="name" class="form-control" placeholder="è¾å¥å­¦çå§å">
                    </div>
                </div>

                </div>
                </div>
                <div class="form-group">
                    <div class="input-group col-xs-offset-2 col-xs-6">
                        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>æ·»å æ°æ®
                        </button>

                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-out"></span>è¿å
                        </button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>


</body>
</html>