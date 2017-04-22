<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="yk" uri="/WEB-INF/tlds/yk.tld"%>
<li class="active">
		<a href="${basePath}/sys/index">
			<i class="menu-icon fa fa-tachometer"></i>
			<span class="menu-text"> 首页</span>
		</a>

		<b class="arrow"></b>
	</li>

<c:forEach var="sidebarMenu" varStatus="sidebarMenuIndex" items="${sideBarParentMenuLst}">
		<yk:if test="${sidebarMenu.isParent==0}">
				<yk:then>
					<li class="" id="yk_${sidebarMenu.menuId}"  data-menuurl="${sidebarMenu.menuUrl}" onclick="changeMenu(this,1);" >
						<a href="javascript:void(0);">
							<i class="menu-icon fa ${sidebarMenu.menuIcon}"></i>
							<span class="menu-text">
								${sidebarMenu.menuName}
							</span>
						</a>
						<b class="arrow"></b>
					</li>
				</yk:then>
				<yk:else>
					<li class="" id="yk_${sidebarMenu.menuId }">
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
								<li class="" id="yksub_${subMenu.menuId}"  data-menuurl="${subMenu.menuUrl}" onclick="changeMenu(this,2);">
									<a href="javascript:void(0);">
										<i class="menu-icon fa fa-caret-right"></i>
										<span class="menu-text">
											${subMenu.menuName}
										</span>
									</a>
									<b class="arrow"></b>
								</li>
							</c:forEach>
						</ul>
					</li>
				</yk:else>
		</yk:if>
 </c:forEach>