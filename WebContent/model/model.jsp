<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Bluth Company">
<!-- title 的图标 -->
<link rel="shortcut icon" href="assets/ico/favicon.html">
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/theme.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/css/alertify.css" rel="stylesheet">
<link href="http://fonts.useso.com/css?family=Open+Sans:400,700"
	rel="stylesheet" type="text/css">
<!-- title 的图标 -->
<link rel="Favicon Icon" href="favicon.ico">

</head>
<body>
	<div id="wrap">
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<div class="logo">
						<img src="assets/img/logo2.png" height="20px" width="100px"
							alt="Realm Admin Template">
					</div>
					<div class="top-menu visible-desktop">
						<ul class="pull-left">
							<li><a> <i class="icon-globe"></i> 欢迎使用零部件管理系统
							</a></li>
						</ul>
						<ul class="pull-right">
							<li><a href="login.jsp"><i class="icon-off"></i> Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<!-- 侧边的目录-->
			<div class="sidebar-nav nav-collapse collapse">
				<div class="user_side clearfix">
					<img src="assets/img/odinn.jpg" alt="没找到用户的图片">
					<!-- 获取当前用户的姓名 -->
					<div>
						<h5>当前用户：${sessionScope.id}</h5>
					</div>
					<!-- 出理用户的个人界面 -->
					<div>
						<a href="personDetail.jsp"><i class="icon-cog"></i> 个人主页</a>
					</div>
				</div>
				<div class="accordion" id="accordion2">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle active b_F79999" href="main.jsp"><i
								class="icon-dashboard"> </i> <span>主页</span></a>
						</div>
					</div>
					<!-- 一组数据开始 -->
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_C3F7A7 collapsed"
								data-toggle="collapse" data-parent="#accordion2"
								href="#collapse1"> <i class="icon-magic"> <!-- 第一功能面板 -->
							</i> <span>零件管理</span></a>
						</div>
						<!--第一功能面板的子功能目录开始  -->
						<div id="collapse1" class="accordion-body collapse">
							<div class="accordion-inner">
								<!--第一个功能的链接  -->
								<a class="accordion-toggle" href="PartSelectServlet"> <i
									class="icon-star">查询零件信息 </i>
								</a>
								<!--第二个功能的链接  -->
								<a class="accordion-toggle" href="#"> <i
									class="icon-list-alt"> 添加零件信息 </i>
								</a>
								<!--第三个功能的链接  -->
								<a class="accordion-toggle" href="#"> <i class="icon-table">
								</i> 修改零件信息
								</a>
								<!--第四个功能的链接  -->
								<a class="accordion-toggle" href="#"> <i class="icon-circle">
								</i> 删除零件信息
								</a>
							</div>
						</div>
						<!--第一功能面板的子功能目录结束 -->
					</div>
					<!-- 一组数据结束 -->
					<!-- 第二组下拉面板开始 -->
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_9FDDF6 collapsed"
								data-toggle="collapse" data-parent="#accordion2"
								href="#collapse2"> <!-- 第二个功能面板 --> <i class="icon-reorder"></i>
								<span>仓库管理</span></a>
						</div>
						<div id="collapse2" class="accordion-body collapse">
							<div class="accordion-inner">
								<a class="accordion-toggle" href="#"> <i class="icon-rss"></i>
									入库管理
								</a> <a class="accordion-toggle" href="#"> <i
									class="icon-calendar"></i> 出库管理
								</a> <a class="accordion-toggle" href="#"> <i
									class="icon-picture"></i> 仓库信息查询
								</a>
							</div>
						</div>
					</div>
					<!-- 第二组下拉面板结束 -->
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_F6F1A2" href="#"><i
								class="icon-tasks"> </i> <span>Tasks</span></a>
						</div>
					</div>
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_C1F8A9" href="#"> <i
								class="icon-bar-chart"></i> <span>Analytics</span></a>
						</div>
					</div>
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_9FDDF6" href="#"> <i
								class="icon-bullhorn"></i> <span>Support Tickets</span></a>
						</div>
					</div>
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle b_F5C294" href="#"> <i
								class="icon-user"></i> <span>Users</span></a>
						</div>
					</div>
				</div>
			</div>
	<!-- /Side menu    end -->
		<!-- Main window -->
<div class="main_container" id="tables_page">
			<div class="row-fluid">
				<ul class="breadcrumb">
					<li><a href="#">Home</a> <span class="divider">/</span></li>
					<li><a href="#">Pages</a> <span class="divider">/</span></li>
					<li class="active">Tables</li>
				</ul>
				<h2 class="heading">
					Tables      
				</h2>
			</div>

          <div class="row-fluid">
            <div class="widget widget-padding span12">
              <div class="widget-header">
                <i class="icon-table"></i>
                <h5>Tables</h5>
                <div class="widget-buttons">
                  <a href="http://twitter.github.com/bootstrap/base-css.html#tables" data-title="Documentation" class="tip" target="_blank"><i class="icon-external-link"></i></a>
                  <a href="#" data-title="Collapse" data-collapsed="false" class="tip collapse"><i class="icon-chevron-up"></i></a>
                </div>
              </div>  
              <div class="widget-body">
                <div class="row-fluid">
                  <div class="span6">
                    <h5>Default <small>(class="table")</small></h5>
                    <table class="table">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Username</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1</td>
                          <td>Mark</td>
                          <td>Otto</td>
                          <td>@mdo</td>
                        </tr>
                        <tr>
                          <td>2</td>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                        </tr>
                        <tr>
                          <td>3</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="span6">
                    <h5>Striped <small>(class="table table-striped")</small></h5>
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Username</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1</td>
                          <td>Mark</td>
                          <td>Otto</td>
                          <td>@mdo</td>
                        </tr>
                        <tr>
                          <td>2</td>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                        </tr>
                        <tr>
                          <td>3</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                      </tbody>
                    </table>
                  </div> 
                </div> 
                <hr>
                <div class="row-fluid">
                  <div class="span6">
                    <h5>Bordered <small>(class="table table-bordered")</small></h5>
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Username</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1</td>
                          <td>Mark</td>
                          <td>Otto</td>
                          <td>@mdo</td>
                        </tr>
                        <tr>
                          <td>2</td>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                        </tr>
                        <tr>
                          <td>3</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="span6">
                    <h5>Condensed <small>(class="table table-condensed")</small></h5>
                    <table class="table table-condensed">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Username</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1</td>
                          <td>Mark</td>
                          <td>Otto</td>
                          <td>@mdo</td>
                        </tr>
                        <tr>
                          <td>2</td>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                        </tr>
                        <tr>
                          <td>3</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                      </tbody>
                    </table>
                  </div> 
                </div>  
                <hr>
                <div class="row-fluid">
                  <div class="span6">
                    <h5>Different colored rows <small>( tr class="error", tr class="success", tr class="info")</small></h5>
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Username</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="success">
                          <td>1</td>
                          <td>Mark</td>
                          <td>Otto</td>
                          <td>@mdo</td>
                        </tr>
                        <tr class="error">
                          <td>2</td>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                        </tr>
                        <tr class="info">
                          <td>3</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="span6">
                    <h5>All combined  <small>(class="table table-striped table-bordered table-condensed")</small></h5>
                    <table class="table table-striped table-bordered table-condensed">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Username</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1</td>
                          <td>Mark</td>
                          <td>Otto</td>
                          <td>@mdo</td>
                        </tr>
                        <tr>
                          <td>2</td>
                          <td>Jacob</td>
                          <td>Thornton</td>
                          <td>@fat</td>
                        </tr>
                        <tr>
                          <td>3</td>
                          <td>Larry</td>
                          <td>the Bird</td>
                          <td>@twitter</td>
                        </tr>
                      </tbody>
                    </table>
                  </div> 
                </div> 
              </div><!--/widget-body-->
            </div> <!-- /widget -->
          </div> <!-- /row-fluid -->

		<div class="row-fluid">
          <div class="widget widget-padding span12">
            <div class="widget-header">
              <i class="icon-group"></i>
              <h5>Dynamic Table</h5>
              <div class="widget-buttons">
                  <a href="http://www.datatables.net/usage/" data-title="Documentation" class="tip" target="_blank"><i class="icon-external-link"></i></a>
                  <a href="#" data-title="Collapse" data-collapsed="false" class="tip collapse"><i class="icon-chevron-up"></i></a>
              </div>
            </div>  
            <div class="widget-body">
              <table id="users" class="table table-striped table-bordered dataTable">
                <thead>
                  <tr>
                    <th>User</th>
                    <th>Group</th>
                    <th>Registered</th>
                    <th>Status</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Amie</td>
                    <td>Admin</td>
                    <td>20-05-2012</td>
                    <td><span class="label label-success">Active</span></td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                        Action
                          <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                          <li><a href="#"><i class="icon-envelope"></i> Email</a></li>
                          <li><a href="#"><i class="icon-edit"></i> Edit</a></li>
                          <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>Katy</td>
                    <td>User</td>
                    <td>12-08-2012</td>
                    <td><span class="label label-success">Active</span></td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                        Action
                          <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                          <li><a href="#"><i class="icon-envelope"></i> Email</a></li>
                          <li><a href="#"><i class="icon-edit"></i> Edit</a></li>
                          <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>Serena</td>
                    <td>User</td>
                    <td>05-01-2013</td>
                    <td><span class="label label-success">Active</span></td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                        Action
                          <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                          <li><a href="#"><i class="icon-envelope"></i> Email</a></li>
                          <li><a href="#"><i class="icon-edit"></i> Edit</a></li>
                          <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>Christian</td>
                    <td>User</td>
                    <td>18-07-2011</td>
                    <td><span class="label label-important">Banned</span></td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                        Action
                          <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                          <li><a href="#"><i class="icon-envelope"></i> Email</a></li>
                          <li><a href="#"><i class="icon-edit"></i> Edit</a></li>
                          <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>Nelson</td>
                    <td>User</td>
                    <td>03-06-2012</td>
                    <td><span class="label label-success">Active</span></td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                        Action
                          <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                          <li><a href="#"><i class="icon-envelope"></i> Email</a></li>
                          <li><a href="#"><i class="icon-edit"></i> Edit</a></li>
                          <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>Odessa</td>
                    <td>User</td>
                    <td>08-05-2012</td>
                    <td><span class="label label-success">Active</span></td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                        Action
                          <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                          <li><a href="#"><i class="icon-envelope"></i> Email</a></li>
                          <li><a href="#"><i class="icon-edit"></i> Edit</a></li>
                          <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>Allan</td>
                    <td>User</td>
                    <td>06-04-2012</td>
                    <td><span class="label">Inactive</span></td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                        Action
                          <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                          <li><a href="#"><i class="icon-envelope"></i> Email</a></li>
                          <li><a href="#"><i class="icon-edit"></i> Edit</a></li>
                          <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>Hillary</td>
                    <td>User</td>
                    <td>03-08-2012</td>
                    <td><span class="label label-success">Active</span></td>
                    <td>
                      <div class="btn-group">
                        <a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">
                        Action
                          <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                          <li><a href="#"><i class="icon-envelope"></i> Email</a></li>
                          <li><a href="#"><i class="icon-edit"></i> Edit</a></li>
                          <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                        </ul>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div> <!-- /widget-body -->
          </div> <!-- /widget -->
        </div> <!-- /row-fluid -->

		</div>
		<!-- /Main window -->

    </div><!--/.fluid-container-->
    </div><!-- wrap ends-->

		<!--主窗口结束  -->
	
	
	<script type="text/javascript" src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="assets/js/raphael-min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>
	<script type="text/javascript" src='assets/js/sparkline.js'></script>
	<script type="text/javascript" src='assets/js/morris.min.js'></script>
	<script type="text/javascript" src="assets/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.masonry.min.js"></script>
	<script type="text/javascript"
		src="assets/js/jquery.imagesloaded.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.facybox.js"></script>
	<script type="text/javascript" src="assets/js/jquery.alertify.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.knob.js"></script>
	<script type='text/javascript' src='assets/js/fullcalendar.min.js'></script>
	<script type='text/javascript' src='assets/js/jquery.gritter.min.js'></script>
	<script type="text/javascript" src="assets/js/realm.js"></script>
	<script type="text/javascript" src="assets/js/jquery.slimscroll.min.js"></script>
</body>
</html>
