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
			<a href="${ctx.contextPath}/sys/index">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text"> 首页</span>
			</a>

			<b class="arrow"></b>
		</li>

	<#if sideBarParentMenuLst??>
		<#list  sideBarParentMenuLst as sidebarMenu>
			<#if sidebarMenu.isParent == 0>
                <li class="" id="yk_${sidebarMenu.menuId?c}"  data-menuurl="${sidebarMenu.menuUrl!""}" onclick="changeMenu(this,1);" >
                    <a href="javascript:void(0);">
                        <i class="menu-icon fa ${sidebarMenu.menuIcon!""}"></i>
                        <span class="menu-text">
						${sidebarMenu.menuName!""}
						</span>
                    </a>
                    <b class="arrow"></b>
                </li>
			<#else >
                <li class="" id="yk_${sidebarMenu.menuId?c}">
                    <a href="${ctx.contextPath}/${sidebarMenu.menuUrl!""}" class="dropdown-toggle">
                        <i class="menu-icon fa ${sidebarMenu.menuIcon!""}"></i>
                        <span class="menu-text">
						${sidebarMenu.menuName!""}
									</span>
                        <b class="arrow fa fa-angle-down"></b>
                    </a>
                    <b class="arrow"></b>
                    <ul class="submenu">
						<#list sidebarMenu.subMenu as subMenu>
                            <li class="" id="yksub_${subMenu.menuId?c}"  data-menuurl="${subMenu.menuUrl!""}" onclick="changeMenu(this,2);">
                                <a href="javascript:void(0);">
                                    <i class="menu-icon fa fa-caret-right"></i>
                                    <span class="menu-text">
									${subMenu.menuName!""}
												</span>
                                </a>
                                <b class="arrow"></b>
                            </li>
						</#list>
                    </ul>
                </li>
			</#if>
		</#list>
	</#if>





		<#--<c:forEach var="sidebarMenu" varStatus="sidebarMenuIndex" items="${sideBarParentMenuLst}">-->
				<#--<yk:if test="${sidebarMenu.isParent==0}">-->
						<#--<yk:then>-->
							<#--<li class="" id="yk_${sidebarMenu.menuId}"  data-menuurl="${sidebarMenu.menuUrl}" onclick="changeMenu(this,1);" >-->
								<#--<a href="javascript:void(0);">-->
									<#--<i class="menu-icon fa ${sidebarMenu.menuIcon}"></i>-->
									<#--<span class="menu-text">-->
										<#--${sidebarMenu.menuName}-->
									<#--</span>-->
								<#--</a>-->
								<#--<b class="arrow"></b>-->
							<#--</li>-->
						<#--</yk:then>-->
						<#--<yk:else>-->
							<#--<li class="" id="yk_${sidebarMenu.menuId }">-->
								<#--<a href="${ctx.contextPath}/${sidebarMenu.menuUrl}" class="dropdown-toggle">-->
									<#--<i class="menu-icon fa ${sidebarMenu.menuIcon}"></i>-->
									<#--<span class="menu-text">-->
										<#--${sidebarMenu.menuName}-->
									<#--</span>-->
									<#--<b class="arrow fa fa-angle-down"></b>-->
								<#--</a>-->
								<#--<b class="arrow"></b>-->
								<#--<ul class="submenu">-->
									<#--<c:forEach var="subMenu" varStatus="sidebarMenuIndex" items="${sidebarMenu.subMenu}">-->
										<#--<li class="" id="yksub_${subMenu.menuId}"  data-menuurl="${subMenu.menuUrl}" onclick="changeMenu(this,2);">-->
											<#--<a href="javascript:void(0);">-->
												<#--<i class="menu-icon fa fa-caret-right"></i>-->
												<#--<span class="menu-text">-->
													<#--${subMenu.menuName}-->
												<#--</span>-->
											<#--</a>-->
											<#--<b class="arrow"></b>-->
										<#--</li>-->
									<#--</c:forEach>-->
								<#--</ul>-->
							<#--</li>-->
						<#--</yk:else>-->
				<#--</yk:if>-->
	  <#--</c:forEach>-->
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

			
