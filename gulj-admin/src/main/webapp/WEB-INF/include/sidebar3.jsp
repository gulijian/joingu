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

		<c:forEach var="sidebarMenu" varStatus="sidebarMenuIndex" items="${sideBarParentMenuLst}">
				<yk:if test="${sidebarMenu.isParent==0}">
						<yk:then>
							<li class="">
								<a href="${basePath}/${sidebarMenu.menuUrl}">
									<i class="menu-icon fa ${sidebarMenu.menuIcon}"></i>
									<span class="menu-text">
										${sidebarMenu.menuName}
									</span>
								</a>
								<b class="arrow"></b>
							</li>
						</yk:then>
						<yk:else>
							<li class="">
								<a href="${basePath}/${sidebarMenu.menuUrl}" class="dropdown-toggle">
									<i class="menu-icon fa ${sidebarMenu.menuIcon}"></i>
									<span class="menu-text">
										${sidebarMenu.menuName}
									</span>
									<b class="arrow fa fa-angle-down"></b>
								</a>
								<b class="arrow"></b>
								<ul class="submenu">
									<c:forEach var="subMenu" varStatus="sidebarMenuIndex" items="${sidebarMenu.subMenu}">
										<li class="">
											<a href="${basePath}/${subMenu.menuUrl}">
												<i class="menu-icon fa fa-caret-right"></i>
												${subMenu.menuName}
											</a>
											<b class="arrow"></b>
										</li>
									</c:forEach>
								</ul>
							</li>
						</yk:else>
				</yk:if>
	  </c:forEach>
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

			
			
			
			
			