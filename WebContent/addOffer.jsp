<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>添加商品提供商</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Bluth Company">
<!-- title 的图标 -->
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
						<li class="active">添加商品提供商</li>
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
							<form action="AddOfferServlet" method="post" class="form-inline">
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 提供商姓名 </label>
									</div>
									<div class="field">
										<input type="text" class="input" name="oname" size="20"
											placeholder="提供商姓名" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 提供商地址 </label>
									</div>
									<div class="field">
										<input type="text" class="input" name="oad" size="20"
											placeholder="提供商地址" />
									</div>
								</div>
								<!-- <div class="form-group" style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 提供商交往程度 </label>
									</div>
									<div class="field">
										<input type="text" class="input" name="olike" size="20"
											placeholder="提供商交往程度" />
									</div>
								</div> -->
								<div class="control-group">
                    <label class="control-label">提供商交往程度</label>
                      <div class="controls">
                        <select tabindex="1" data-placeholder="Select here.." class="span3" name="olike">
                           <option  value="非常好">非常好</option>
                           <option  value="好">好</option>
                           <option  value="一般">一般</option>
                           <option value="差">差</option>
                        </select>
                     </div>
                  </div>
								<div class="form-group"  style="margin-bottom: 10px; margin-top: 10px">
									<div class="label">
										<label for="username"> 提供商电话 </label>
									</div>
									<div class="field">
										<input type="text" class="input" name="ophone" size="20"
											placeholder="提供商电话" />
									</div>
								</div>
								<div class="form-group" style="margin-bottom: 10px; margin-top: 10px" >
									<div class="label">
										<label for="username"> 提供商联系人</label>
									</div>
									<div class="field">
										<input type="text" class="input" name="operson" size="20"
											placeholder="提供商联系人" />
									</div>
								</div>
								<div class="form-button">
									<button class="btn btn-success"type="submit">添加</button>
								</div>
							</form>
							<!-- <h1>我在这躲着</h1> -->
						</div>
						<!-- /widget-body -->
					</div>
					<!-- /widget -->
				</div>
				<!-- /row-fluid -->
				<!-- ------------------------上边----------------------- -->
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
