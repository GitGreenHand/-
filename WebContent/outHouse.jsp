<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>出库页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Bluth Company">
<%@include file="WEB-INF/jspf/quote.jspf"%>
</head>
<script type="text/javascript" src="jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//alert("out进来没有啊");
		$("input").change(function() {
			//获取count中的值
			var count = $("#count").val();
			//alert("count:"+count);
			//获取price中的值
			var price = $("#price").val();
			//赋值sum中的值
			// alert("price:"+price);
			$("#sum").val(count * price);
		});
	});
</script>
<body>
	<script type="text/javascript" src="jquery.js">
		
	</script>

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
					<li class="active">出库页</li>
				</ul>
			</div>
			<!-- 填充内容 -->
			<div class="row-fluid">
				<div class="widget widget-padding span12">
					<div class="widget-header">
						<i class="icon-group"></i>
						<h5>出库：</h5>
						<div class="widget-buttons"></div>
					</div>
					<div class="widget-body">
						<form action="OhouserServlet" method="post" class="form-inline">
							<div class="form-group"
								style="margin-bottom: 5px; margin-top: 5px">
								<div class="label">
									<label for="username"> 出库编号</label>
								</div>

								<div class="field">
									<input type="text" class="input" name="oid" size="20"
										value="<%=System.currentTimeMillis()%>" />
								</div>
							</div>
							<div class="form-group"
								style="margin-bottom: 5px; margin-top: 5px">
								<div class="label">
									<label for="username"> 仓库编码</label>
								</div>
								<div class="field">
									<select tabindex="1" data-placeholder="Select here.."
										name="owid">
										<c:forEach var="list" items="${listWareHouseId}">
										<option value="${list}">${list}</option>
									</c:forEach>
									</select>
									<!-- <input type="text" class="input" name="owid" size="20" /> -->
								</div>
							</div>
							<div class="form-group"
								style="margin-bottom: 5px; margin-top: 5px">
								<div class="label">
									<label for="username"> 零件编码</label>
								</div>
								<div class="field">
									<select tabindex="1" data-placeholder="Select here.."
										name="opid">
										<c:forEach var="list" items="${listPartId}">
										<option value="${list}">${list}</option>
									</c:forEach>
									</select>
									<!-- <input type="text" class="input" name="opid" size="20" /> -->
								</div>
							</div>
							<div class="form-group"
								style="margin-bottom: 5px; margin-top: 5px">
								<div class="label">
									<label for="username"> 出库时间</label>
								</div>
								<div class="field">
									<input type="text" class="input" name="otime" size="20"
										<%SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			// new Date()为获取当前系统时间%>
										value="<%=df.format(new Date())%>">
								</div>
							</div>
							<div class="form-group"
								style="margin-bottom: 5px; margin-top: 5px">
								<div class="label">
									<label for="username"> 制单人</label>
								</div>
								<div class="field">
									<input type="text" class="input" name="operson" size="20" />
								</div>
							</div>
							<div class="form-group"
								style="margin-bottom: 5px; margin-top: 5px">
								<div class="label">
									<label for="username"> 零件单价</label>
								</div>
								<div class="field">
									<input type="text" id="price" class="input" name="oprice"
										size="20" />&nbsp 元
								</div>
							</div>
							<div class="form-group"
								style="margin-bottom: 5px; margin-top: 5px">
								<div class="label">
									<label for="username"> 零件数量</label>
								</div>
								<div class="field">
									<input type="text" id="count" name="ocount" size="20" />&nbsp个
								<c:if test="${not empty message}"> <font color="red"> &nbsp提示：库存没有这么多 </font></c:if>
								</div>
							</div>
							<div class="form-group"
								style="margin-bottom: 5px; margin-top: 5px">
								<div class="label">
									<label for="username"> 总价</label>
								</div>
								<div class="field">
									<input type="text" id="sum" name="osum" size="20" />&nbsp元
								</div>
							</div>


							<div class="form-button">
								<button class="btn btn-success" type="submit">确定</button>
							</div>
						</form>
					</div>
					<!-- /widget-body -->
				</div>
				<!-- /widget -->
			</div>

		</div>
		<!--主窗口结束  -->
	</div>
	<!-- body 结束 -->
	<%@include file="WEB-INF/jspf/footer.jspf"%>
</body>
</html>
