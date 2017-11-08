<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'course_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 使用bootstrap, 依赖jquery，所以先导入jq -->
	<script type="text/javascript" src="<%=path %>/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="<%=path %>/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<link type="text/css" rel="stylesheet" href="<%=path%>/bootstrap-3.3.7/css/bootstrap.min.css">
	
	<script type="text/javascript">
		$(function(){
			//加载课程列表数据.
			//步骤：1.通过ajax请求数据 2.将数据展示出来(dom)
			listTeacher();
			
			//保存课程: 1.监听保存按钮事件 2.提交数据到服务器进行保存的处理,提示保存结果 3.关闭保存窗口.
			$("#btnSave").click(function(){
				var formDataStr =  $("#formSave").serialize();
				$.getJSON("<%=path%>/teacher/saveTeacher?"+formDataStr,function(data){
					$('#myModal').modal("hide");//隐藏模态框.
					if(data.code=='200'){
						alert("保存成功!");//先有，后改进
						
						//刷新页面列表
						listCourse();
					}else
						alert("保存失败!失败原因:"+data.message);//先有，后改进
						
					
				});
			});
			
			function listTeacher(){
				$.getJSON("<%=path%>/teacher/list",function(data){
					var teacherData = $("#teacherData");
					teacherData.empty();
					for(var i=0; i<data.length;i++){
						var tr = "<tr>"+
		    				"<td>"+data[i].id+"</td>"+
		    				
		    				"<td>"+data[i].name+"</td>"+
		    				"<td>"+data[i].teacherIntroduce+"</td>"+
		    				"<td>"+data[i].position+"</td>"+
		    				"<td>"+data[i].level+"</td>"+
		    				"<td>"+data[i].teacherPhoto+"</td>"+
		    				
		    				"<td>"+data[i].username+"</td>"+
		    				"<td>"+data[i].password+"</td>"+
		    				
		    				
		    				"</tr>";
		    			teacherData.append(tr);
					}
				});
			}
		})
	</script>
	
  </head>
  
  <body>
    <h2>hhh</h2>
    
    
    <div class="container">
    	
    	<table class="table table-bordered table-hover">
    		<thead>
    			<tr>
    				<td>id</td>
					<td>讲师姓名</td>
					<td>讲师介绍</td>
					<td>讲师职位</td>
					<td>讲师等级</td>
					<td>讲师图片</td>
					
					<td>讲师用户名</td>
					<td>讲师密码</td>
					
				
    			</tr>
    		</thead>
    		<tbody id="courseData">
				
					
					<tr>
						<td ></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						
						
						<td></td>
						<td></td>
						
						
					</tr>
				
			</tbody>
    		
    	</table>
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
