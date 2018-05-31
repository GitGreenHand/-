<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>查询提供商</title>
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
						<li class="active">查询提供商</li>
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
							<form action=SelectOfferServlet method="post">
								<div class="form-group">
									<div class="field label-block">
										<h4>
											<input name="offerKey" type="Radio" value="all">所有的提供商
											&nbsp; <input name="offerKey" type="Radio" value="oname">提供商姓名
											&nbsp; <input name="offerKey" type="Radio" value="oad">提供商地址&nbsp;
											<input name="offerKey" type="Radio" value="olike">提供商交往程度&nbsp;
											<input name="offerKey" type="Radio" value="ophone">提供商电话&nbsp;
											<input name="offerKey" type="Radio" value="operson">提供商联系人&nbsp;
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
				<!-- ------------------------上边----------------------- -->
				<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>结果如下表：</h5>
							<div class="widget-buttons">
								<a href="#" data-title="Collapse" data-collapsed="false"
									class="tip collapse"><i class="icon-chevron-up"></i></a>
							</div>
						</div>

						<div class="widget-body">
							<table id="users"
								class="table table-striped table-bordered display">
								<thead>
									<tr>
										<th>提供商姓名</th>
										<th>提供商地址</th>
										<th>提供商交往程度</th>
										<th>提供商电话</th>
										<th>提供商电话</th>
										<th>功能区</th>
									</tr>
								</thead>
								<tbody>
									<!-- 这有个循环 -->
									<c:forEach var="list" items="${listResult}">
										<tr>
											<td>${list.oname}</td>
											<td>${list.oad}</td>
											<td>${list.olike}</td>
											<td>${list.ophone}</td>
											<td>${list.operson}</td>
											<td>
												<div class="btn-group">
													<a class="btn btn-small dropdown-toggle"
														data-toggle="dropdown" href="#"> 功能 <span
														class="caret"></span>
													</a>
													<ul class="dropdown-menu pull-right">

														<li><a href="UpdateOfferServlet?oname=${list.oname}"><i
																class="icon-edit"></i> 修改</a></li>
														<li><a href="DeleteOfferServlet?oname=${list.oname}"><i
																class="icon-trash"></i> 删除</a></li>
													</ul>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /widget-body -->
				</div>
				
			</div><!-- main -->
			
		</div>
		<!-- 主窗口结束 -->

	</div>
	<!--/.fluid-container-->
	<!-- wrap ends-->

	<!--主窗口结束  -->
	<%@include file="WEB-INF/jspf/footer.jspf"%>
</body>
</html>
