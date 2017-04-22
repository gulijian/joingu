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
		<!-- 头部开始-->
		<div id="navbar" class="navbar navbar-default">
 		 	<%@include file="/WEB-INF/include/head.jsp" %>  
		</div>
		<!-- 头部结束-->

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<!-- 左侧菜单开始-->
			<div id="sidebar" class="sidebar responsive">
				<%@include file="/WEB-INF/include/sidebar.jsp" %>
			</div>
			<!-- 左侧菜单结束-->
			
			<!-- 内容容器开始 -->
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
					<!-- 面包屑 开始 -->
					<div class="breadcrumbs breadcrumbs-fixed" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul>
					</div>
					<!-- 面包屑 结束 -->

					<!-- /section:basics/content.breadcrumbs -->
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="alert alert-block alert-success">
									<button type="button" class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>

									<i class="ace-icon fa fa-check green"></i>

									Welcome to
									<strong class="green">
										Ace
										<small>(v1.3.4)</small>
									</strong>,
										dmin template.
								</div>


								<!-- #section:custom/extra.hr -->
								<div class="hr hr32 hr-dotted"></div>


							

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<%@include file="/WEB-INF/include/foot.jsp" %>
			</div>
		</div><!-- /.main-container -->

		
	</body>
</html>
