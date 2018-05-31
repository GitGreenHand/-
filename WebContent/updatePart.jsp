<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改零件信息</title>
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
						<li class="active">修改零件信息</li>
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
							<form action="UpdatePartServletBack" method="post"
								class="form-inline">
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 商品编码</label>
									</div>
									<div class="field">
										<input type="text" class="input" readonly="readonly"
											name="P_id" size="20" value="${updatePart.pid}" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 商品名称</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_name" size="20"
											value="${updatePart.pname}" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 商品型号</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_sp" size="20"
											value="${updatePart.psp}" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 商品价格</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_price" size="20"
											value="${updatePart.pprice}" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 商品提供商</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_offer" size="20"
											value="${updatePart.poffer}" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 商品存放时间</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="P_time" size="20"
											value="${updatePart.ptime}" />
									</div>
								</div>
								<div class="form-button">
									<button class="btn btn-success" type="submit">修改</button>
								</div>
							</form>
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
