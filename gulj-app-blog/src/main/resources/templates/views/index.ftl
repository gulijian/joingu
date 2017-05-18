<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>顾大仙博客-关注后端，大数据</title>

    <!-- common css -->
    <#include "/views/include/public.ftl">
    <#include "/views/include/public-js.ftl">

    <!-- page css -->
    <link rel="stylesheet" type="text/css" href="plugins/laypage/skin/laypage.css">
    <link rel="stylesheet" type="text/css" href="css/index/index.css">


</head>
<!-- #00a2ca -->

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

    <!-- banner图 start -->
    <div class="g_banner" style="width:70%;float:left;margin: 10px 0px;">
        <div class="main_banner">
            <div class="htmleaf-container">
                <div  id="bootstrap-touch-slider" style="opacity: 0.9" class="carousel bs-slider fade  control-round indicators-line" data-ride="carousel" data-pause="hover" data-interval="5000" >
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#bootstrap-touch-slider" data-slide-to="0" class="active"></li>
                        <li data-target="#bootstrap-touch-slider" data-slide-to="1"></li>
                        <li data-target="#bootstrap-touch-slider" data-slide-to="2"></li>
                    </ol>
                    <!-- Wrapper For Slides -->
                    <div class="carousel-inner" role="listbox">

                        <!-- Third Slide -->
                        <div class="item active">
                            <!-- Slide Background -->
                            <img src="images/1.jpg" alt="Bootstrap Touch Slider" style="height:350px;width:100%" class="slide-image"/>
                            <div class="bs-slider-overlay"></div>
                        </div>
                        <!-- End of Slide -->

                        <!-- Second Slide -->
                        <div class="item">
                            <!-- Slide Background -->
                            <img src="images/2.jpg" alt="Bootstrap Touch Slider" style="height:350px;width:100%"  class="slide-image"/>
                            <div class="bs-slider-overlay"></div>
                        </div>
                        <!-- End of Slide -->

                        <!-- Third Slide -->
                        <div class="item">
                            <!-- Slide Background -->
                            <img src="images/3.jpg" alt="Bootstrap Touch Slider" style="height:350px;width:100%"  class="slide-image"/>
                            <div class="bs-slider-overlay"></div>
                        </div>
                        <!-- End of Slide -->
                    </div><!-- End of Wrapper For Slides -->
                    <!-- Left Control -->
                    <a class="left carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="prev">
                        <span class="fa fa-angle-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <!-- Right Control -->
                    <a class="right carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="next">
                        <span class="fa fa-angle-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div> <!-- End  bootstrap-touch-slider Slider -->
            </div>
        </div>
    </div>
    <!-- banner图  end -->

    <!-- 侧面联系 start  -->
    <div class="g-profile">
        <div class="social">
            <a href="#"><i class="weibo fa fa-weibo fa-3x"></i></a>
            <a href="#"><i class="weixins fa fa-weixin fa-3x"></i></a>
            <a href="#"><i class="qqs fa fa-qq fa-3x"></i></a>
            <a href="#"><i class="githubs fa fa-github fa-3x"></i></a>
        </div>
        <div class="motto">
            <!-- <h2 style="text-align:center">每日一语</h2> -->

        </div>
    </div>
    <!-- 侧面联系 end -->

    <!-- 文章列表 start -->
    <div class="article_list">
        <#if pageArticleListVo.rows??>
            <#list  pageArticleListVo.rows as blogArticle>
                <artice class="excerpt">
                    <header>
                        <a href="#">
                            <i class='artice_label'>${blogArticle.categoryName}</i>
                        </a>
                        <h2>
                            <a href="bigdata.html" target="_blank">${blogArticle.title}</a>
                        </h2>
                    </header>
                    <div class="g_focus">
                        <a href="#" target="_blank">
                            <img src="images/1.jpg" alt="图片" class="thumb">
                        </a>
                    </div>
                    <span class="note">
                        ${blogArticle.content}
                    </span>
                    <div style="clear:both"></div>
                    <p class="auth-span">
                        <span><i class="fa fa-clock-o"></i>&nbsp;6个月前 (${blogArticle.createTime?string('dd日.MM月')})</span>
                        <span><i class="fa fa-eye"></i>&nbsp; ${blogArticle.hot}℃</span>
                        <span>
                    <i class="fa fa-comment-o"></i>&nbsp;
                    <a href="#">${blogArticle.comment}评论</a>
                </span>
                        <span>
                    <a href="#"><i class="fa fa-thumbs-o-up"></i>&nbsp; ${blogArticle.love}喜欢</a>
                </span>
                    </p>
                    <div style="clear:both"></div>
                </artice>
            </#list>
        </#if>

        <!-- 分页 start -->
        <div class="g_propagation" id="join_gu_propagation" >
            <input type="hidden" id="totalPage" value="${pageArticleListVo.totalPage}">
        </div>
        <!-- 分页 end -->

    </div>
    <!-- 文章列表 end -->

    <!--  侧边导航 start -->
    <aside class="g-sidebar">
        <div class="g-widget g-tag">
            <div class="title">
                <h2>标签云</h2>
            </div>
            <div class="g-tags">
                <button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on left">Tooltip on left(24)</button>
                <button type="button" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="Tooltip on left">java</button>
                <button type="button" class="btn btn-info" data-toggle="tooltip" data-placement="top" title="Tooltip on left">html</button>
                <button type="button" class="btn btn-success" data-toggle="tooltip" data-placement="top" title="wordpress优化(4411)">wordpress优化(4411)</button>
                <button type="button" class="btn btn-warning" data-toggle="tooltip" data-placement="top" title="Tooltip on left">Tooltip on left</button>
                <button type="button" class="btn btn-info" data-toggle="tooltip" data-placement="top" title="Tooltip on left">Tooltip on left</button>
                <button type="button" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="Tooltip on left">Tooltip on left</button>
                <button type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="Tooltip on left">Tooltip on left</button>
            </div>
        </div>
        <div class="g-widget g-guess-like">
            <div class="title">
                <h2>猜你喜欢</h2>
            </div>
            <div class="content">
                <ul>
                    <li>
                        <a href="#">
                                <span class="note-thume">
                                   <img src="images/2.jpg" alt="" width="100px;" height="64px;">
                                </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一枚</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="note-thume">
                                  <img src="images/2.jpg" alt="" width="100px;" height="64px;">
                                </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一枚</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="note-thume">
                                   <img src="images/2.jpg" alt="" width="100px;" height="64px;">
                                 </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一fjdasfjadsj</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="note-thume">
                                   <img src="images/2.jpg" alt="" width="100px;" height="64px;">
                                 </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一fjdasfjadsj</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="note-thume">
                                   <img src="images/2.jpg" alt="" width="100px;" height="64px;">
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
                <h2>最新吐槽</h2>

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
        <div class="g-widget g-link">
            <div class="title">
                <h2>友情链接</h2>
            </div>
            <div class="g-links">
                <ul>
                    <li><a href="#">王志君博客</a></li>
                    <li><a href="#">王志君博客</a></li>
                    <li><a href="#">沧澜博客</a></li>
                    <li><a href="#">网赚博客</a></li>
                    <li><a href="#">王志君博客</a></li>
                </ul>
                <div class="clearfix">

                </div>
            </div>
        </div>





    </aside>
    <!-- 侧边导航 end -->

    <!-- 清除浮动 -->
    <div class="clear" style="clear:both"></div>
</section>

<!-- footer start -->
<#include "/views/include/footer.ftl">
<!-- footer end -->


<!-- page js start -->
<script src="js/banner/banner.js" charset="utf-8"></script>
<script src="plugins/laypage/laypage.js" charset="utf-8"></script>
<script src="http://cdn.bootcss.com/jquery.touchswipe/1.6.18/jquery.touchSwipe.min.js"></script>
<script src="js/banner/bootstrap-touch-slider.js"></script>
<script src="js/index/index.js"></script>




<script>

    $(function() {
        $('[data-toggle="tooltip"]').tooltip();
        $('#bootstrap-touch-slider').bsTouchSlider();
    });
</script>


</body>

</html>
