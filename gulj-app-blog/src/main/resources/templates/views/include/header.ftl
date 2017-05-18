
<header>
    <div class="container-inner">
        <h1 style="text-align:center;font-family:cursive;text-shadow:6px 2px 2px #333;color:#f3eaef;font-size:48px;position:relative;top:10px;margin:0px;">顾大仙博客</h1>
    </div>


    <div class="g_nav">
        <ul class="layui-nav" lay-filter="g-nav-filter">
        <#if blogCategoryVoList??>
            <#list blogCategoryVoList as parentCategory>
                <li class="layui-nav-item" data-tab="${parentCategory.url}">
                    <a href="${parentCategory.url}">${parentCategory.name}</a>
                    <#if  parentCategory.subBlogCategory?? && (parentCategory.subBlogCategory?size > 0)>
                        <dl class="layui-nav-child">
                            <!-- 二级菜单 -->
                            <#list parentCategory.subBlogCategory as subCategory>
                                <dd data-tab="${subCategory.url}"><a href="">${subCategory.name}</a></dd>
                            </#list>
                        </dl>
                    </#if>
                </li>
            </#list>
        </#if>
            <#--<li class="layui-nav-item" data-tab="index"><a href="index.html">首页</a></li>-->
            <#--<li class="layui-nav-item " ><a href="">产品</a></li>-->
            <#--<li class="layui-nav-item" data-tab="bigdata"><a href="bigdata.html">大数据</a></li>-->
            <#--<li class="layui-nav-item" data-tab="front">-->
                <#--<a href="javascript:;">前端</a>-->
                <#--<dl class="layui-nav-child">-->
                    <#--<!-- 二级菜单 &ndash;&gt;-->
                    <#--<dd data-tab="front"><a href="">Html5</a></dd>-->
                    <#--<dd data-tab="front"><a href="">Css3</a></dd>-->
                <#--</dl>-->
            <#--</li>-->
            <#--<li class="layui-nav-item"><a href="">社区</a></li>-->
            <#--<li class="layui-nav-item" data-tab="diary"><a href="diary.html">随笔</a></li>-->
            <#--<li class="layui-nav-item"><a href="">留言</a></li>-->
        </ul>
    </div>
</header>









