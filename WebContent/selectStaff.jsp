<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>查询员工</title>
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
						<li class="active">查询员工</li>
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
							<form action=SelectStaffServlet method="post">
								<div class="form-group">
									<div class="field label-block">
										<h4>
											<input name="staffKey" type="Radio" value="all">所有的员工
											&nbsp; <input name="staffKey" type="Radio" value="stid">员工编码
											&nbsp; <input name="staffKey" type="Radio" value="stname">员工姓名&nbsp;
											<input name="staffKey" type="Radio" value="stsex">员工性别&nbsp;
											<input name="staffKey" type="Radio" value="stage">员工年龄&nbsp;
											<input name="staffKey" type="Radio" value="stpower">员工特权等级&nbsp;
											<input name="staffKey" type="Radio" value="stpart">部门&nbsp;
										</h4>
										<br> <input name="searchInput" class="span7" type="text">
										<input name="searchButton" class="btn btn-large" type="submit"
											value="查询">

									</div>
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
