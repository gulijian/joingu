<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
</script>

<!-- #section:basics/sidebar -->
<div id="sidebar" class="sidebar      sidebar-fixed            responsive">
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
	</script>
	<ul class="nav nav-list">
		<li class="active">
			<a href="index.html">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text"> 首页</span>
			</a>

			<b class="arrow"></b>
		</li>

		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-list"></i>
				<span class="menu-text"> 博客管理 </span>

				<b class="arrow fa fa-angle-down"></b>
			</a>

			<b class="arrow"></b>

			<ul class="submenu">
				<li class="">
					<a href="${basePath}/sys/comment/list">
						<i class="menu-icon fa fa-caret-right"></i>
						评论管理
					</a>

					<b class="arrow"></b>
				</li>

				<li class="">
					<a href="jqgrid.html">
						<i class="menu-icon fa fa-caret-right"></i>
						文章管理
					</a>

					<b class="arrow"></b>
				</li>
			</ul>
		</li>
		<li class="">
			<a href="widgets.html">
				<i class="menu-icon fa fa-list-alt"></i>
				<span class="menu-text"> 导航管理 </span>
			</a>

			<b class="arrow"></b>
		</li>

		<li class="">
			<a href="${basePath}/sys/qrcode/list">
				<i class="menu-icon fa fa-calendar"></i>

				<span class="menu-text">
					二维码管理
				</span>
			</a>

			<b class="arrow"></b>
		</li>

		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-file-o"></i>

				<span class="menu-text">
					系统设置

					<!-- #section:basics/sidebar.layout.badge -->
					<span class="badge badge-primary">5</span>

					<!-- /section:basics/sidebar.layout.badge -->
				</span>

				<b class="arrow fa fa-angle-down"></b>
			</a>

			<b class="arrow"></b>

			<ul class="submenu">
				<li class="">
					<a href="faq.html">
						<i class="menu-icon fa fa-caret-right"></i>
						菜单管理
					</a>

					<b class="arrow"></b>
				</li>

				<li class="">
					<a href="${basePath}/sys/department/list">
						<i class="menu-icon fa fa-caret-right"></i>
						部门管理
					</a>

					<b class="arrow"></b>
				</li>

				<li class="">
					<a href="blank.html">
						<i class="menu-icon fa fa-caret-right"></i>
						岗位管理
					</a>

					<b class="arrow"></b>
				</li>
			</ul>
		</li>
	</ul><!-- /.nav-list -->

	<!-- #section:basics/sidebar.layout.minimize -->
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>

	<!-- /section:basics/sidebar.layout.minimize -->
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
	</script>
</div>

			
			
			
			
			