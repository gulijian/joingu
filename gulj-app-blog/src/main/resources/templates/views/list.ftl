<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>顾大仙博客-关注后端，大数据</title>

    <!-- common css  start-->
    <link rel="stylesheet" href="plugins/layui/css/layui.css">
    <link rel="stylesheet" href="plugins/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/common/header/header.css">
    <link rel="stylesheet" href="css/common/section/section.css">
    <link rel="stylesheet" href="css/common/footer/footer.css">
    <!-- common css end -->
    <!-- page css start -->
    <link rel="stylesheet" href="css/diary.css">
    <link rel="stylesheet" href="css/common/sidebar/sidebar.css">
    <!-- page css end -->


</head>
<body>

<#-- header start-->
<#include "/views/include/header.ftl">
<#-- header end-->

<section class="mainbody">
    <!-- 通知内容 start -->
    <div class="noticebar">
        <i class="layui-icon" style="font-size: 20px; color: #56af45;margin-left: 10px;">&#xe645;</i>
    </div>
    <!-- 通知内容 end -->

    <div class="g-contentwrap">
        <header class="g-archive-header">
            <h1>
                <i class="fa fa-folder-open">&nbsp;分类:</i>
                <span>
                    <#if pageArticleListVo.rows??>
                        <#list  pageArticleListVo.rows as blogArticle>
                            <#if blogArticle_index == 0>
                                ${blogArticle.categoryName}
                            </#if>
                        </#list>
                    </#if>
                </span>
                <i class="g-rss fa fa-rss"></i>
            </h1>
        </header>
        <div class="article_list">
            <#if pageArticleListVo.rows??>
                <#list  pageArticleListVo.rows as blogArticle>
                    <article class="excerpt">
                        <header>
                            <h2><a href="#">${blogArticle.title}</a></h2>
                        </header>
                        <div class="g_focus">
                            <a href="#" target="_blank">
                                <img src="images/1.jpg" alt="图片" class="thumb" >
                            </a>
                        </div>
                        <span class="note">
                            ${blogArticle.content}
                        </span>
                        <div class="clearfix"></div>
                        <p class="auth-span">
                            <span><i class="fa fa-clock-o"></i>&nbsp;6个月前 (${blogArticle.createTime?string('dd日.MM月')})</span>
                            <span><i class="fa fa-eye"></i>&nbsp;${blogArticle.hot}℃</span>
                            <span>
                        <i class="fa fa-comment-o"></i>&nbsp;
                        <a href="#">${blogArticle.comment}评论</a>
                      </span>
                            <span>
                        <a href="#"><i class="fa fa-thumbs-o-up"></i>&nbsp;${blogArticle.love}喜欢</a>
                     </span>
                        </p>
                    </article>
                </#list>
            </#if>
        </div>

        <!-- 分页 start -->
        <div class="g_propagation">

        </div>
        <!-- 分页 end -->
    </div>
    <!-- 右侧sidebar start -->
    <aside class="g-sidebar">
        <div class="g-widget g-social">
            <a href="#"><i class="weibo fa fa-weibo fa-3x"></i></a>
            <a href="#"><i class="weixins fa fa-weixin fa-3x"></i></a>
            <a href="#"><i class="qqs fa fa-qq fa-3x"></i></a>
            <a href="#"><i class="githubs fa fa-github fa-3x"></i></a>
        </div>
        <div class="g-widget g-new-article-list">
            <div class="title">
                <h2>最新发布</h2>
            </div>
            <div class="content">
                <ul>
                    <li>
                        <a href="#">
                            <span class="note-thume">
                               <img src="images/2.jpg" alt="" >
                            </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一枚枚首次购推荐码一枚首次购推荐码荐码一枚首次购推荐码荐码一枚首次购推荐码一</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="note-thume">
                              <img src="images/3.jpg" alt="" >
                            </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一枚</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="note-thume">
                               <img src="images/2.jpg" alt="" >
                             </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一fjdasfjadsj</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="g-widget new-article-comment">
            <div class="title">
                <h2>最近评论</h2>
            </div>
            <div class="content">
                <ul>
                    <li>
                        <a href="#">
                            <img src="images/commet-avatar.jpg" alt="评论图片" width="20%" height="20%">
                            <div class="commet">
                                <div class="commet-author">
                                    <span><lable>顾大仙</lable><span>&nbsp;&nbsp;</span>3周前(03-24)说：</span>
                                </div>
                                <div class="content">
                                    真心希望宝宝能早点康复，一家人都健健康康的，这比什么都好，
                                </div>
                                <div class="create-author">
                                    <span><lable>评论于</lable></span><span>&nbsp;&nbsp;</span>学员福利：向极速FQ迈进！让Shad..
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="images/commet-avatar.jpg" alt="评论图片" width="20%" height="20%">
                            <div class="commet">
                                <div class="commet-author">
                                    <span><lable>顾大仙</lable><span>&nbsp;&nbsp;</span>3周前(03-24)说：</span>
                                </div>
                                <div class="content">
                                    真心希望宝宝能早点康复，一家人都健健康康的，这比什么都好，11
                                </div>
                                <div class="create-author">
                                    <span><lable>评论于</lable></span><span>&nbsp;&nbsp;</span>学员福利：向极速FQ迈进！让Shad..
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="images/commet-avatar.jpg" alt="评论图片" width="20%" height="20%">
                            <div class="commet">
                                <div class="commet-author">
                                    <span><lable>顾大仙</lable><span>&nbsp;&nbsp;</span>3周前(03-24)说：</span>
                                </div>
                                <div class="content">
                                    真心希望宝宝能早点康复，一家人都健健康康的，这比什么都好，
                                </div>
                                <div class="create-author">
                                    <span><lable>评论于</lable></span><span>&nbsp;&nbsp;</span>学员福利：向极速FQ迈进！让Shad..
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </a>
                    </li>
                </ul>

            </div>
        </div>








    </aside>
    <!-- 右侧sidebar end -->

    <!-- 清除浮动 -->
    <div class="clearfix"></div>
</section>
<!-- 清除浮动 -->
<div class="clearfix"></div>

<!-- footer start -->
<#include "/views/include/footer.ftl">
<!-- footer end -->


<!-- common js start  -->
<script type="text/javascript" src="plugins/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/common/header.js" charset="utf-8"></script>
<!-- common js end  -->



</body>
</html>
