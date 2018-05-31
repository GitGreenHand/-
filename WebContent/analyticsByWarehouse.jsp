<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>仓库资产分析页</title>
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
					<li class="active">仓库资产分析</li>
				</ul>
			</div>
			<!-- 填充内容 -->
			<div class="row-fluid">
					<div class="widget widget-padding span12">
						<div class="widget-header">
							<i class="icon-group"></i>
							<h5>根据仓库查询：</h5>
							<div class="widget-buttons"></div>
						</div>
						<div class="widget-body">
							<form action="Pieservlet" method="post">
								<div class="form-group">
									<div class="field label-block">
										 <input name="searchInput" class="span7"  type="text" placeholder="仓库编码">
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
			<!---------------------------------------------------  -->
		<c:if test="${not empty chartColumnURL}">
			 <div class="row-fluid">
            <div class="widget-top widget widget-padding">
              <div class="widget-header"><i class="icon-signal"></i>
              <h5>零件分类如下:</h5>
              <div class="widget-buttons">
                  <a href="#" data-title="Collapse" data-collapsed="false" class="tip collapse"><i class="icon-chevron-up"></i></a>
              </div>
              </div>
              <div class="widget-body">
               <!--   <div id="donut" class="circle" style="height:200px; width:200px; background-color:white; border-radius:100px;"></div>
             -->
              <img src="${chartColumnURL}" >  
              </div>
            </div>
          </div>
          </c:if>
			<!---------------------------------------------------  -->
			<c:if test="${not empty pieChartURI}">
				 <div class="row-fluid">
            <div class="widget-top widget widget-padding">
              <div class="widget-header"><i class="icon-signal"></i>
              <h5>资产分析如下:</h5>
              <div class="widget-buttons">
                  <a href="#" data-title="Collapse" data-collapsed="false" class="tip collapse"><i class="icon-chevron-up"></i></a>
              </div>
              </div>
              <div class="widget-body">
               <!--   <div id="donut" class="circle" style="height:200px; width:200px; background-color:white; border-radius:100px;"></div>
             -->
              <img src="${pieChartURI}" >  
              </div>
            </div>
          </div>
			</c:if>
			
		</div>
		<!--主窗口结束  -->
	</div>
	<!-- body 结束 -->
	<%@include file="WEB-INF/jspf/footer.jspf"%>
</body>
</html>
