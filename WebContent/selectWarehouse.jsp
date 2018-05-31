<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>查询仓库</title>
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
	 </div>
			<!-- 侧边的目录结束-->
		<!-- 主窗口开始 -->
<div class="main_container" id="tables_page">
			<div class="row-fluid">
				<ul class="breadcrumb">
					<li><a href="#">目录</a> <span class="divider">/</span></li>
					<li><a href="#">页面</a> <span class="divider">/</span></li>
					<li class="active">查询仓库</li>
				</ul>
			</div>
		<div class="row-fluid">
          <div class="widget widget-padding span12">
            <div class="widget-header">
              <i class="icon-group"></i>
              <h5>查询：</h5>
              <div class="widget-buttons">
              </div>
            </div>  
            <div class="widget-body">
            <form action=WarehouseSelectServlet method="post">
								<div class="form-group">
									<div class="field label-block">
										<h4> 							
										<input name="warehouseKey" type="Radio" value="all">所有仓库  &nbsp;  
										<input name="warehouseKey" type="Radio" value="wid">仓库编码  &nbsp;  
										<input name="warehouseKey" type="Radio" value="wad">仓库地址&nbsp;
										<input name="warehouseKey" type="Radio" value="wsize">仓库大小&nbsp;
										<input name="warehouseKey" type="Radio" value="wphone">仓库电话&nbsp;
										<input name="warehouseKey" type="Radio" value="wperson">仓库管理员&nbsp;
										<input name="warehouseKey" type="Radio" value="wspce">仓库剩余大小&nbsp;
										</h4> 
										<br>
										<input name="searchInput" class="span7" type="text">
										<input name="searchButton" class="btn btn-large"type="submit" value="查询">
				
									</div>
								</div>
							</form>
            </div> <!-- /widget-body -->
          </div> <!-- /widget -->
        </div> <!-- /row-fluid -->
		<!-- 主窗口结束 -->

    </div><!--/.fluid-container-->
    </div><!-- wrap ends-->

		<!--主窗口结束  -->
		 <%@include file="WEB-INF/jspf/footer.jspf"%>
</body>
</html>
