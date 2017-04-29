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
		<#include "/views/common/include/public.ftl">
	</head>

	<body class="no-skin">
		
		<#include "/views/common/include/head.ftl">

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
		
			<#include "/views/common/include/sidebar.ftl">
			
			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="main-content-inner">
				
					<div class="row content-tabs">
			                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
			                </button>
			                <nav class="page-tabs J_menuTabs">
			                    <div class="page-tabs-content" style="margin-left: -13px;">
			                        <a href="javascript:;" class="J_menuTab active" data-id="index_v1.html">首页</a>
			                   		<!-- <a href="javascript:;" class="J_menuTab" data-id="graph_flot.html">Flot 
			                   			 <i class="fa fa-times-circle"></i>
			                   		</a>
			                   	    <a href="javascript:;" class="J_menuTab active" data-id="graph_morris.html">Morris.js 
			                   	  		<i class="fa fa-times-circle"></i>
			                   	    </a> -->
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
			                        <li class="J_tabCloseAll" onclick="closeAllTab(this)"><a>关闭全部选项卡</a>
			                        </li>
			                        <li class="J_tabCloseOther" onclick="closeOtherTab(this)"><a>关闭其他选项卡</a>
			                        </li>
			                    </ul>
			                </div>
			                <a href="${ctx.contextPath}/loginOut" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
           		    </div>
				
					<!-- #section:basics/content.breadcrumbs -->
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
						<!-- <ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul> -->
					</div>

					<!-- /section:basics/content.breadcrumbs -->
					<div class="page-content">
						<div class="page-header">
							<ul class="breadcrumb" id="page-content-breadcrumb">
								<li>
									<i class="ace-icon fa fa-home home-icon"></i>
									<a href="/sys/index">首页</a>
								</li>
								<!-- <li class="active">Dashboard111</li> -->
							</ul>
						</div><!-- /.page-header -->
						 <div class="row" id="pageContentIframe">
                      		 <iframe class="yk_iframe" name="iframe0" scrolling="yes"  frameborder="no" border="0" width="100%" height="80%" src="indexContent"  data-id="index_v1.html"  style=""></iframe>
                   		 </div>
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<%@include file="/WEB-INF/include/foot.jsp" %>
			</div>
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
		
		<script type="text/javascript">
		 //改变菜单 
		 function changeMenu(obj,level){
			//当前菜单id
			var currentMenuId  =  $(obj).attr("id").split("_")[1];
			//当前菜单名称
			var currentMenuName = $(obj).find("span").html();
			//当前菜单url
	 		var currentMenuUrl =  $(obj).data("menuurl");
			//改变菜单样式
			changeMenuStyle(obj,level);
			//改变面包屑导航
			changeBreadCrumb(obj,currentMenuName,level);
			//为选中的菜单添加tab选项
			changeMenuAddTab(obj,currentMenuId,currentMenuName,currentMenuUrl);
		 }
		 
		 //改变面包屑导航
		 function changeBreadCrumb(obj,currentMenuName,level){
			 //当前管理的菜单
			 var currentManageName = null;
			 $("#navbar-menu").find("ul li").each(function(i,n){
				 var isActive = $(n).attr("class");
				 if(undefined != isActive){
					 if(isActive.indexOf("current-active") != -1){
						 currentManageName = $(this).find("span").html();
					 }
				 }
			 });
			 
			 //当前菜单的父菜单
			 var currentParentMenuName = null;
			 if(level == 2){
				 currentParentMenuName = $(obj).parent().parent().find("a:first").find("span").html();
			 }
			 //改变面包屑导航
			 $("#page-content-breadcrumb").html(""); //先清空
			 if(null != currentParentMenuName){
				 $("#page-content-breadcrumb").append(
							"<li>"+
								"<i class='ace-icon fa fa-home home-icon'></i>"+
								"<a href='/sys/index'>首页</a>"+
							"</li>"+
						 	"<li class='active'>"+currentManageName+"</li>"+
							"<li class='active'>"+currentParentMenuName+"</li>"+
							"<li class='active'>"+currentMenuName+"</li>"
			      );
			 }else{
				 $("#page-content-breadcrumb").append(
							"<li>"+
								"<i class='ace-icon fa fa-home home-icon'></i>"+
								"<a href='/sys/index'>首页</a>"+
							"</li>"+
						 	"<li class='active'>"+currentManageName+"</li>"+
							"<li class='active'>"+currentMenuName+"</li>"
			      );
			 }
		 }
		 
		 
		 //改变菜单样式
		 function changeMenuStyle(obj,level){
			 if(level == 1){//选中一级菜单
				//当前元素激活
				$(obj).addClass("active").siblings().removeClass("active").removeClass("open");
			 	//同级元素的其它元素的子元素样式取消
			 	$(obj).siblings().find("ul li").removeClass("active");
				//同级元素的其它元素隐藏
				$(obj).siblings().find("ul").css({"display":"none"});
			 }else{//选中二级菜单
				//父元素激活
				$(obj).parent().parent().addClass("active").siblings().removeClass("active");
				//父元素同级元素下的子元素去除激活状态
				$(obj).parent().parent().siblings().find("li").removeClass("active");
				//父元素同级元素的其它元素隐藏
				$(obj).parent().parent().siblings().find("ul").css({"display":"none"});
				$(obj).parent().parent().siblings().removeClass("open");
				//当前元素激活
				$(obj).addClass("active").siblings().removeClass("active");
			 }
		 }
		 
		//为选中的菜单添加tab选项
		 function changeMenuAddTab(obj,currentMenuId,currentMenuName,currentMenuUrl){
			 //是否添加选项卡，默认添加
			 var isAddTabFlag = true;
			 //添加tab选项卡，判断tab选项卡是否已经添加
			 $(".content-tabs .J_menuTabs .page-tabs-content a:first").nextAll().each(function(i,n){
				  //判断是否添加选项卡，相等，则选项卡已经添加
				  if(currentMenuId == $(this).data("menuid") ){
					  isAddTabFlag = false;
				  }
			 });
			 if(isAddTabFlag){//添加选项卡
				 $(".content-tabs .J_menuTabs .page-tabs-content").append(
						 "<a href='javascript:;' class='active J_menuTab' id='"+currentMenuId+"' data-menuid='"+currentMenuId+"' data-menuurl='"+currentMenuUrl+"' onclick='changeTab(this)'>"+
						 	""+currentMenuName+"<i class='fa fa-times-circle' onclick='closeTab(this)'></i>"+
						 "</a>"
			 	  ); 
			 	  //添加选项卡再添加iframe，并显示
			 	  $("#pageContentIframe").append(
			 			 "<iframe class='yk_iframe' id='iframe_"+currentMenuId+"' name='iframe_"+currentMenuId+"' scrolling='yes'  frameborder='no' border='0' width='100%' height='80%' src='/"+currentMenuUrl+"'  data-id='index_v1.html'  style='display:block'></iframe>"
			 	  );
			 	  //其它选项卡隐藏
			 	  $("#iframe_"+currentMenuId+"").siblings().css({"display":"none"});
			 
				 // 新添加tab激活,同级元素去除激活状态
				 $("#"+currentMenuId+"").siblings().removeClass("active");
			 }else{//选项卡已经添加，激活
				 $("#"+currentMenuId+"").addClass("active").siblings().removeClass("active");
			 	  //iframe已经添加，激活，同级隐藏
				 $("#iframe_"+currentMenuId+"").css({"display":"block"}).siblings().css({"display":"none"});
			 }
		 }
		 
		//切换tab选项卡
		function changeTab(obj){
			//激活当前tab状态
			$(obj).addClass("active").siblings().removeClass("active");
			//当前tab选项卡对应的菜单id
			var currentTabMenuId = $(obj).data("menuid");
			//根据menuId显示tab对应的iframe，其它iframe隐藏
			$("#iframe_"+currentTabMenuId+"").css({"display":"block"}).siblings().css({"display":"none"});
			
			 //改变面包屑导航
			//changeBreadCrumb(currentMenuName,level)
			
		}
		
		//i标签关闭tab选项卡,删除iframe
		function closeTab(obj){
			//判断关闭的选项卡是否是选中的选项卡
			var isActive = $(obj).parent().attr("class");
			if(isActive.indexOf("active") != -1){//关闭的是当前的激活的选项卡
				//若激活的选项卡是最后一个选项卡
				var nextTab = $(obj).parent().next().attr("class");
				if(undefined == nextTab || "" == nextTab || null == nextTab){//关闭的是最后的一个选项卡
					//关闭激活选项卡，前一个选项卡激活，对应的iframe显示
					$(obj).parent().prev().addClass("active");
					var currentTabMenuId = $(obj).parent().data("menuid");
					$("#iframe_"+currentTabMenuId+"").prev().css({"display":"block"})
					//删除选项卡以及对应的iframe
					$(obj).parent().remove();
					$("#iframe_"+currentTabMenuId+"").remove();
				}else{//激活选项卡不是最后一个
					//关闭激活选项卡，后一个选项卡激活，对应的iframe显示
					$(obj).parent().next().addClass("active");
					var currentTabMenuId = $(obj).parent().data("menuid");
					$("#iframe_"+currentTabMenuId+"").next().css({"display":"block"})
					//删除选项卡以及对应的iframe
					$(obj).parent().remove();
					$("#iframe_"+currentTabMenuId+"").remove();
				} 
			}else{//关闭非选中的选项卡
				//删除选项卡以及对应的iframe
				var currentTabMenuId = $(obj).parent().data("menuid");
				$(obj).parent().remove();
				$("#iframe_"+currentTabMenuId+"").remove();
			}
		}
		
		//选中菜单首页
		function chooseIndex(obj){
			//改变菜单样式
			$(obj).addClass("active").siblings().removeClass("active").removeClass("open").find("ul").css({"display":"none"});
			$(obj).siblings().find("span").removeClass("open");
			$(obj).siblings().find("li").removeClass("active");
			//改变选项卡样式
			$(".content-tabs .J_menuTabs .page-tabs-content a:first").addClass("active").siblings().removeClass("active");
			//首页iframe显示
			$("#pageContentIframe iframe:first").css({"display":"block"}).siblings().css({"display":"none"});
		}
		
		//选中tab首页
		$(".content-tabs .J_menuTabs .page-tabs-content a:first").bind("click",function(){
			$(this).addClass("active").siblings().removeClass("active");
			$("#pageContentIframe iframe:first").css({"display":"block"}).siblings().css({"display":"none"});
		});
		
		
		//关闭全部选项卡
		function closeAllTab(obj){
			//关闭所有选项卡
			$(".content-tabs .J_menuTabs .page-tabs-content a:first").siblings().remove();
			//首页激活
			$(".content-tabs .J_menuTabs .page-tabs-content a:first").addClass("active");
			//关闭所有的iframe
			$("#pageContentIframe iframe:first").siblings().remove();
			//首页iframe显示
			$("#pageContentIframe iframe:first").css({"display":"block"});
		}
		
		//关闭其它选项卡
		function closeOtherTab(obj){
			var isActiveTabFlag = true;
			$(".content-tabs .J_menuTabs .page-tabs-content a:first").nextAll().each(function(i,n){
				  //获取激活的选项卡
				  var activeStr =  $(this).attr("class");
				  if(activeStr.indexOf("active") != -1){
					  isActiveTabFlag = false;
				  }
			 });
		}
		
		//改变一级菜单，切换左侧菜单
		function changeMenuManageToShowSideBar(obj){
			//改变样式
			$(obj).addClass("current-active").siblings().removeClass("current-active")
			var currentMenuId = $(obj).data("rootmenuid")
			$.ajax({
				url:"/changeMenuManage",
				type:"post",
				data:{"menuId":currentMenuId},
				success:function(data){
					$("#sidebar").find("ul").html(data);
				},error:function(){
					alert("出错啦");
				}
			});
		}
	</script>



		<#-- iframe 自适应 start-->
        <script>
            var browserVersion = window.navigator.userAgent.toUpperCase();
            var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
            var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
            var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
            var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
            var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
            var isIE9More = (! -[1, ] == false);
            function reinitIframe(iframeId, minHeight) {
                try {
                    var iframe = document.getElementById(iframeId);
                    var bHeight = 0;
                    if (isChrome == false && isSafari == false)
                        bHeight = iframe.contentWindow.document.body.scrollHeight;

                    var dHeight = 0;
                    if (isFireFox == true)
                        dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
                    else if (isIE == false && isOpera == false)
                        dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
                    else if (isIE == true && isIE9More) {//ie9+
                        var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
                        if (heightDeviation == 0) {
                            bHeight += 3;
                        } else if (heightDeviation != 3) {
                            eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
                            bHeight += 3;
                        }
                    }
                    else//ie[6-8]、OPERA
                        bHeight += 3;

                    var height = Math.max(bHeight, dHeight);
                    if (height < minHeight) height = minHeight;
                    iframe.style.height = height + "px";
                } catch (ex) { }
            }
            function startInit(iframeId, minHeight) {
                eval("window.IE9MoreRealHeight" + iframeId + "=0");
                window.setInterval("reinitIframe('" + iframeId + "'," + minHeight + ")", 100);
            }


            startInit('iframe_23', 100);
        </script>




	</body>
</html>