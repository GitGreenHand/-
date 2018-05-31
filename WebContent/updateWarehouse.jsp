<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改仓库</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Bluth Company">
<%@include file="WEB-INF/jspf/quote.jspf"%>
		
</head>
<body>
	<div id="wrap">
		<%@include file="WEB-INF/jspf/header.jspf"%>
		

		<div class="container-fluid">
			<!-- 侧边的目录开始-->
			<%@include file="WEB-INF/jspf/sideMenu.jspf"%>
	
			<!-- 侧边的目录结束-->
			<!-- 主窗口开始 -->
			<div class="main_container" id="tables_page">
				<div class="row-fluid">
					<ul class="breadcrumb">
						<li><a href="#">目录</a> <span class="divider">/</span></li>
						<li><a href="#">页面</a> <span class="divider">/</span></li>
						<li class="active">修改仓库</li>
					</ul>
				</div>
				<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>查询：</h5>
							<div class="widget-buttons"></div>
						</div>
						<div class="widget-body">
						
						
							<!-- <h1>我在这躲着</h1> -->
<form  action="UpdateWarehouseServletBack" method="post"
 class="form-inline">
	<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
		<div class="label">
										
			<label for="username">
				仓库编码</label>
		</div>
		<div class="field">
			<input type="text" class="input" 
			 readonly = "readonly" name="wid" 
			size="20"
			value="${updateWarehouse.wid}"
			  />
		</div>
	</div>
	<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
		<div class="label">
			<label for="username">
				仓库地址</label>
		</div>
		<div class="field">
			<input type="text" class="input" 
			 name="wad" size="20"  
			 value="${updateWarehouse.wad}"/>
		</div>
	</div>
	<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
		<div class="label">
			<label for="username">
				仓库大小</label>
		</div>
		<div class="field">
			<input type="text" class="input"  
			name="wsize" size="20" 
			value="${updateWarehouse.wsize}" />
		</div>
	</div>
	<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
		<div class="label">
			<label for="username">
				仓库电话</label>
		</div>
		<div class="field">
			<input type="text" class="input" 
			 name="wphone" size="20" 
			 value="${updateWarehouse.wphone}" />
		</div>
	</div>
	<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
		<div class="label">
			<label for="username">
				仓库管理员</label>
		</div>
		<div class="field">
			<input type="text" class="input" 
			 name="wperson" size="20" 
			 value="${updateWarehouse.wperson}" />
		</div>
	</div>
	<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
		<div class="label">
			<label for="username">
				仓库剩余空间大小</label>
		</div>
		<div class="field">
			<input type="text" class="input"  
			name="wspace" size="20"
			value="${updateWarehouse.wspace}"  />
		</div>
	</div>
	<div class="form-button" >
		<button class="btn btn-success" type="submit">
			修改</button>
	</div>
</form>
							<!-- <h1>我在这躲着</h1> -->
						</div>
						<!-- /widget-body -->
					</div>
					<!-- /widget -->
				</div>
				<!-- /row-fluid -->
			</div>
			<!-- 主窗口结束 -->

		</div>
		<!--/.fluid-container-->
	</div>
	<!-- wrap ends-->

	<!--主窗口结束  -->
  <%@include file="WEB-INF/jspf/footer.jspf"%>
	  
</body>
</html>
