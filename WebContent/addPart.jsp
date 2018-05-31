<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>查询零件</title>
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
						<li class="active">添加零件</li>
					</ul>
				</div>
				<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>添加：</h5>
							<div class="widget-buttons"></div>
						</div>
						<div class="widget-body">
							<form action="partAddServlet" method="post" class="form-inline">
								<div class="form-group" style="margin-bottom: 5px; margin-top: 5px">
									<div class="label">
										<label for="username"> 零件编码</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_id" size="20"
											placeholder="零件编码" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 5px; margin-top: 5px">
									<div class="label">
										<label for="username"> 零件名称</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_name" size="20"
											placeholder="零件名称" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 5px; margin-top: 5px">
									<div class="label">
										<label for="username"> 零件型号</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_sp" size="20"
											placeholder="零件型号" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 5px; margin-top: 5px">
									<div class="label">
										<label for="username"> 零件价格</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_price" size="20"
											placeholder="零件价格" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 5px; margin-top: 5px">
									<div class="label">
										<label for="username"> 零件提供商</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_offer" size="20"
											placeholder="零件提供商" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 5px; margin-top: 5px">
									<div class="label">
										<label for="username"> 零件存放时间</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_time" size="20"
											placeholder="零件存放时间" />
									</div>
								</div>
								<div class="form-button">
									<button class="btn btn-success" type="submit">添加</button>
								</div>
							</form>
							<!-- <h1>我在这躲着</h1> -->
						</div>
						<!-- /widget-body -->
					</div>
					<!-- /widget -->
				</div>
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
