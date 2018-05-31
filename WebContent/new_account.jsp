<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
  <head>
    <title>注册界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Bluth Company">
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
						<i class="icon-edit"></i>
						<h5>创建一个用户</h5>
					</div>  
					<div class="widget-body clearfix" style="padding:25px;">
		<!--还没写  -->				<form action="RegisterServlet">
		      				<!--提交的位置  -->
							<div class="control-group ">
								<label for="form_username">用户名:</label>
								<div class="controls"><input class="btn-block" type="text" name="id" ></div>
							</div>

							<div class="control-group ">
								<label for="form_password"> 密码:</label>
								<div class="controls"><input class="btn-block" type="password" name="password" ></div>
							</div>
			
							<button type="submit" class="btn btn-large btn-block">立即注册</button>
						</form>
					</div>  
				</div>  
        	</div><!--/row-fluid-->
        </div><!--/span10-->
      </div><!--/row-fluid-->
    </div><!--/.fluid-container-->
    </div><!-- wrap ends-->
  </body>
</html>
