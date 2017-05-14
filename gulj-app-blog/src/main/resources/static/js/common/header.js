$(function() {
    //切换菜单，改变菜单样式
    var menuTab = sessionStorage.getItem("menu-tab");
    if(menuTab == "" || menuTab == undefined || menuTab == null){
       menuTab = "index";//默认选中首页
    }
    $(".g_nav .layui-nav").find("li").each(function(index, el) {
          var currentTab = $(el).data("tab");
          if(menuTab == currentTab){
              $(el).addClass('layui-this').siblings().removeClass('layui-this');
          }
    });
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function() {
        var element = layui.element();
        element.on('nav(g-nav-filter)', function(elem) {
            console.log(elem); //得到当前点击的DOM对象
            var tab = $(elem).data("tab");
            sessionStorage.setItem("menu-tab",tab);
            $(elem).removeClass('layui-this');
        });
    });
});
