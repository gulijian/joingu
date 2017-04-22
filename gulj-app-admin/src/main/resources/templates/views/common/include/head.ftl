<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="navbar" class="navbar  ace-save-state navbar-fixed-top navbar-default">
	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<!-- #section:basics/navbar.layout.brand -->
			<a href="#" class="navbar-brand">
				<small>
					<i class="fa fa-leaf"></i>
					菲剑
				</small>
			</a>
		</div>

		<!-- #section:basics/navbar.dropdown -->
		<div id="navbar-menu" class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<c:forEach var="menu" varStatus="menuIndex" items="${rootMenuLst}">
					<yk:if test="${menuIndex.index==0}">
						<yk:then>
							<li class="purple  current-active " data-rootMenuId="${menu.menuId}" onclick="changeMenuManageToShowSideBar(this);">
								<a data-toggle="dropdown" class="dropdown-toggle" href="#">
									<i class="ace-icon fa ${menu.menuIcon} icon-animated-bell"></i>
									<span class="badge badge-important">${menu.menuName}</span>
								</a>
							</li>
						</yk:then>
					<yk:else>
						<li class="purple  " data-rootMenuId="${menu.menuId}" onclick="changeMenuManageToShowSideBar(this);">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa ${menu.menuIcon} icon-animated-bell"></i>
								<span class="badge badge-important">${menu.menuName}</span>
							</a>
						</li>
					</yk:else>
				</yk:if>
				</c:forEach>
				
				<!-- #section:basics/navbar.user_menu -->
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="${bastPath}/images/user.jpg" alt="Jason's Photo" />
						<span class="user-info">
							<small>Welcome,</small>
							join
						</span>

						<i class="ace-icon fa fa-caret-down"></i>
					</a>

					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="#">
								<i class="ace-icon fa fa-cog"></i>
								设置
							</a>
						</li>

						<li>
							<a href="profile.html">
								<i class="ace-icon fa fa-user"></i>
								个人资料
							</a>
						</li>

						<li class="divider"></li>

						<li>
							<a href="${basePath}/loginOut">
								<i class="ace-icon fa fa-power-off"></i>
								退出系统
							</a>
						</li>
					</ul>
				</li>

				<!-- /section:basics/navbar.user_menu -->
			</ul>
		</div>

		<!-- /section:basics/navbar.dropdown -->
	</div><!-- /.navbar-container -->
</div>