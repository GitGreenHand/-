<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>个人信息页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Bluth Company">
<%@include file="WEB-INF/jspf/quote.jspf"%>
</head>
<body>
	<div id="wrap">
		<%@include file="WEB-INF/jspf/header.jspf"%>

		<div class="container-fluid">
			<!-- 侧边的目录-->
			<%@include file="WEB-INF/jspf/sideMenu.jspf"%>
		</div>
		<!-- /Side menu -->

		<!--主窗口开始  -->
		<div class="main_container">
			<div class="row-fluid">
				<ul class="breadcrumb">
					<li><a href="#">目录</a> <span class="divider">/</span></li>
					<li><a href="#">页面</a> <span class="divider">/</span></li>
					<li class="active">个人信息页</li>
				</ul>
			</div>
			<!-- 填充内容 -->
			
			<h4>编号：${staff.stid}</h4>
			<br>
			<h4>年龄：${staff.stname}</h4>
			<br>
			<h4>性别：${staff.stsex}</h4>
			 <br>
			<h4>年龄：${staff.stage}</h4>
			 <br>
			<h4>特权：${staff.stpower}</h4>
			 <br>
			
		</div>
		<!--主窗口结束  -->
	</div>
	<!-- body 结束 -->
	<%@include file="WEB-INF/jspf/footer.jspf"%>
</body>
</html>
