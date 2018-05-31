<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
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
					<li class="active">主页</li>
				</ul>
				<h2 class="heading">公司的信息</h2>

			</div>
			<div class="row-fluid">
				<div class="widget widget-padding span12">
					<div class="widget-header">
						<i class="icon-rss"></i>
						<h5>公司发展历史</h5>
						<div class="widget-buttons">
							<a href="#" data-title="Collapse" data-collapsed="false"
								class="tip collapse">
								<i class="icon-chevron-up">
								</i></a>
							</div>
						</div>
							
							
							<div class="widget-body">

								
								
								<div>
									1969.10 第二汽车制造厂零部件专业厂陆续开始建设<br> 1999.8 东风汽车公司组建成立零部件管理部<br>
									2000.8.28东风汽车公司零部件事业部成立<br> 2003.7.1
									东风汽车零部件事业部整体进入东风汽车有限公司<br> 2003.8.19东风汽车有限公司零部件事业部成立<br>
									2010.2.8东风汽车零部件（集团）有限公司成立<br>
								</div>
								<h5>零部件集团公司成立</h5>
								<br>

								<div>
									全力打造中国汽车零部件航母，致力成为最具竞争力的， 能够持续为客户提供增值服务的东风汽车零部件(集团)有限公司成立大会，
									于2010年2月8日在湖北省十堰市隆重举行 。<br>
									出席并祝贺东风汽车零部件(集团)有限公司成立大会的主要合作伙伴和重要客户有
									：丸红株式会社、德国贝洱亚太管理有限公司、美国伟世通公司、苏州创元投资发展
									(集团)有限公司、康明斯滤清器(亚太)有限公司、富士精工株式会社、
									博泽中国管理有限公司、郑州宇通集团有限公司、北京福田汽车股份有限公司、
									中国重汽集团有限公司、重庆红岩汽车有限责任公司、陕西重型汽车有限公司、 金龙联合汽车工业(苏州)有限公司。<br>
									在东风汽车零部件(集团)有限公司成立大会上， 东风汽车公司总经理、党委书记，东风汽车有限公司董事长徐平说：
									“东风汽车零部件(集团)有限公司的成立，是东风零部件经营体制上的一次重大调整
									，也是东风发展史上的一件大事，是东风汽车公司贯彻落实科学发展观、 继续深化改革，加快做强做大零部件业务的重大举措。
									对于推动东风零部件事业快速发展必将产生重大而深远的意义！”<br> 东风汽车有限公司总裁中村公泰说：过去的5年，
									零部件事业部作为东风有限主要的事业板块，承受了巨大的经营压力， 也取得了长足的发展。通过“内降成本，外拓市场”有效化解了
									材料持续涨价和产品不断降价的风险；通过持续的QCD改善， 工厂体质得到强化；通过强化管理和过程控制，
									整体管理水平和经营质量得到显著提升；通过合资合作和业务重组， 优化了资源结构，整体竞争能力显著增强。
									这些努力和成绩为新公司的成功奠定了良好的基础， 也使得我们对新公司的成功充满信心和期待。 <br>
								</div>
							</div>
						</div>
					</div>
				</div>
</div>
			<!--主窗口结束  -->
		<!-- Main window -->
	  	
		<%@include file="WEB-INF/jspf/footer.jspf"%>
</body>
</html>
