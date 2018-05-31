<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<li class="active">查询零件</li>
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
							<form action=PartSelectServlet method="post">
								<div class="form-group">
									<div class="field label-block">
										<h4>
											<input name="partKey" type="Radio" value="all">所有零件&nbsp;
											<input name="partKey" type="Radio" value="Pid">零件编码&nbsp;
											 <input name="partKey" type="Radio" value="Pname">零件名称&nbsp;
											<input name="partKey" type="Radio" value="Psp">零件型号&nbsp;
											<input name="partKey" type="Radio" value="Pprice">零件价格&nbsp;
											<input name="partKey" type="Radio" value="Poffer">零件提供商&nbsp;
											<input name="partKey" type="Radio" value="Ptime">零件最久存放时间&nbsp;
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
											<th>零件编码</th>
											<th>零件名称</th>
											<th>零件型号</th>
											<th>零件价格</th>
											<th>零件提供商</th>
											<th>零件最久存放时间</th>
											<th>功能区</th>
										</tr>
									</thead>
									<tbody>
										<!-- 这有个循环 -->
										
										<c:forEach var="list" items="${listResult}">
											<tr>
												<td>${list.pid}</td>
												<td>${list.pname}</td>
												<td>${list.psp}</td>
												<td>${list.pprice}</td>
												<td>${list.poffer}</td>
												<td>${list.ptime} 天 </td> 
												
												<td>
												<div class="btn-group">
													<a class="btn btn-small dropdown-toggle"
														data-toggle="dropdown" href="#"> 功能 <span
														class="caret"></span>
													</a>
													<ul class="dropdown-menu pull-right">
														
														<li><a href="UpdatePartServlet?Pid=${list.pid}"><i class="icon-edit"></i> 修改</a></li>
														<li><a href="DeletePartServlet?pid=${list.pid}"><i class="icon-trash"></i> 删除</a></li>
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
					<!-- /widget -->
				</div>
				<!-- /row-fluid -->
			</div>
			<!-- 主窗口结束 -->

		</div>
		<!--/.fluid-container-->
	<!-- wrap ends-->

	<!--主窗口结束  -->
<%@include file="WEB-INF/jspf/footer.jspf"%>
</body>
</html>
