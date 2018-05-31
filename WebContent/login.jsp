<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录界面</title>
<%@include file="WEB-INF/jspf/quote.jspf"%>
</head>
<body>
	<div id="wrap">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<div class="widget container-narrow">

							<div class="widget-header">
								<i class="icon-user"></i>
								<h5>登录您的账户</h5>

							</div>
							<div class="widget-body clearfix" style="padding: 25px;">
								<form action="LoginServlet" method="post">
									<div class="control-group">
										<div class="controls">

											<input class="btn-block" type="text" name="id"
												placeholder="用户名" value="${requestScope.id}">
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<input class="btn-block" type="password" name="password"
												placeholder="密码" value="${requestScope.password}">
										</div>
									</div>
									<!-- <div class="control-group">
										<label class="control-label">登录用户类型：</label>
										<div class="controls">
											<select tabindex="1" data-placeholder="Select here.."
												name="username">
												<option value="staff">普通用户</option>
												<option value="admin">管理员</option>
											</select>
										</div>
									</div> -->
					登录用户类型：
                        <select tabindex="1" data-placeholder="Select here.." class="span7"name="type">
                       <option value="staff">普通用户</option>
												<option value="admin">管理员</option>
                        </select>
                    
									<div class="control-group">
										<div class="controls clearfix">
											<label style="width: auto" class="checkbox pull-left">

											</label>
											<!-- 忘记密码的位置 还没写
									 -->
											<a style="padding: 5px 0px 0px 5px;" href="findPassword.jsp"
												class="pull-right">忘记密码？</a>
										</div>
									</div>
									<button type="submit" class="btn pull-right">登录</button>
								</form>
							</div>
						</div>
						<div style="text-align: center">
							<!--创建一个新的用户   -->
							<p>
								还未注册？ <a href="new_account.jsp">注册</a>
							</p>
						</div>
					</div>
					<!--/row-fluid-->
				</div>
				<!--/span10-->
			</div>
			<!--/row-fluid-->
		</div>
		<!--/.fluid-container-->
	</div>
	<!-- wrap ends-->
	<%@include file="WEB-INF/jspf/footer.jspf"%>
</body>
</html>
