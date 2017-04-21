<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>菲剑后台管理系统</title>
	   	<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	  	<%@include file="/WEB-INF/include/public.jsp" %>
	</head>

	<body class="no-skin">
		
		<%@include file="/WEB-INF/include/head.jsp" %>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
		
			<%@include file="/WEB-INF/include/sidebar.jsp" %>
			
			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="main-content-inner">
				
					<div class="row content-tabs">
			                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
			                </button>
			                <nav class="page-tabs J_menuTabs">
			                    <div class="page-tabs-content" style="margin-left: -13px;">
			                        <a href="javascript:;" class="J_menuTab" data-id="index_v1.html">首页</a>
			                   		<a href="javascript:;" class="J_menuTab" data-id="graph_flot.html">Flot 
			                   			 <i class="fa fa-times-circle"></i>
			                   		</a>
			                   	    <a href="javascript:;" class="J_menuTab active" data-id="graph_morris.html">Morris.js 
			                   	  		<i class="fa fa-times-circle"></i>
			                   	    </a>
			                   	  </div>
			                </nav>
			                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
			                </button>
			                <div class="btn-group roll-nav roll-right">
			                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>
			
			                    </button>
			                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
			                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
			                        </li>
			                        <li class="divider"></li>
			                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
			                        </li>
			                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
			                        </li>
			                    </ul>
			                </div>
			                <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
           		    </div>
				
					<!-- #section:basics/content.breadcrumbs -->
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul>
						
						
						
					</div>

					<!-- /section:basics/content.breadcrumbs -->
					<div class="page-content">
						<div class="page-header">
							<h1>
								Dashboard
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									overview &amp; stats
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									
									commet
									
									
								</div><!-- /.row -->

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							Application &copy; 2013-2014
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>

					<!-- /section:basics/footer -->
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>	
		</div><!-- /.main-container -->
		
		
		<script type="text/javascript">
			$(function(){
				$("#sidebar-collapse").click(function(){
					var flag = $("#sidebar").hasClass("menu-min");
					if(flag){
						$(".content-tabs").css("left","200px");
					}else{
						$(".content-tabs").css("left","56px");
					}
				});
			});
		</script>
		
	</body>
</html>