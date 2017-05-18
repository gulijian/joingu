<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- common css  start-->
    <#include "/views/include/public-list-css.ftl">
    <!-- common css end -->

    <!-- page css start -->
    <!-- <link rel="stylesheet" href="css/diary.css"> -->
    <link rel="stylesheet" href="/css/detail/detail.css">
    <link rel="stylesheet" href="/css/common/sidebar/sidebar.css">
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
            <h1 class="article-title">
                <a href="#">WordPress 禁止将英文半角符号转换成全角符号（字符转义)</a>
            </h1>
            <div class="meta">
                  <span class="muted">
                    <i class="fa fa-list-alt"></i>
                    <a href="#">WP教程</a>
                  </span>
                <time class="muted">
                    <i class="fa fa-user"></i>
                    <span>顾大仙</span>
                </time>
                <span class="muted">
                    <i class="fa fa-clock-o"></i>
                    <span>1年前 (2016-01-25)</span>
                  </span>
                <span class="muted">
                    <i class="fa fa-comment-o"></i>
                    <a href="#">1评论</a>
                  </span>
            </div>
        </header>
        <div class="article-detail-content">


            <p><img class="alignnone size-full wp-image-3627" src="http://images.yusi123.com/wp-content/uploads/2014/09/wordpress-logo-banner.png" alt="wordpress-logo-banner" width="720" height="218"></p><p>今天客户的网站刚用到的，记录一下，以后就知道了。菜单选项的转义用the_title即可解决。</p><p><a href="http://yusi123.com/tag/wordpress" title="" target="_blank" data-original-title="查看关于 WordPress 的文章">WordPress</a> 模式使用了 <a href="http://yusi123.com/tag/wptexturize%e5%87%bd%e6%95%b0" title="" target="_blank" data-original-title="查看关于 wptexturize函数 的文章">wptexturize函数</a>将纯文本字符转换成格式化的 HTML 实体。</p><p>标签 &lt;pre&gt;, &lt;code&gt;, &lt;kbd&gt;, &lt;style&gt;, &lt;script&gt;和&lt;tt&gt;中的文本被忽略。</p><p>对于一般写单纯码文字的人来说，这个自动将英文半角符号转换成全角符号，是很方便、智能。</p><p>但如果你经常要粘贴一些代码，而且没有使用专门的代码高亮插件，你会发现，你代码中的半角符号都会被转换成全角了！别人复制后，根本没办法直接使用！</p><p>禁止字符转义的所有代码如下，你可以根据自己的需要，选自己要的代码，添加到主题的 functions.php 文件：</p><pre class="prettyprint linenums"><ol class="linenums"><li class="L0"><span class="com">// 取消转义 Quotmarks Replacer </span></li><li class="L1"><span class="pln">$qmr_work_tags </span><span class="pun">=</span><span class="pln"> array</span><span class="pun">(</span></li><li class="L2"><span class="pln">  </span><span class="str">'the_title'</span><span class="pun">,</span><span class="pln">             </span><span class="com">// http://codex.wordpress.org/Function_Reference/the_title</span></li><li class="L3"><span class="pln">  </span><span class="str">'the_content'</span><span class="pun">,</span><span class="pln">           </span><span class="com">// http://codex.wordpress.org/Function_Reference/the_content</span></li><li class="L4"><span class="pln">  </span><span class="str">'the_excerpt'</span><span class="pun">,</span><span class="pln">           </span><span class="com">// http://codex.wordpress.org/Function_Reference/the_excerpt</span></li><li class="L5"><span class="pln">  </span><span class="com">// 'list_cats',          Deprecated. http://codex.wordpress.org/Function_Reference/list_cats</span></li><li class="L6"><span class="pln">  </span><span class="str">'single_post_title'</span><span class="pun">,</span><span class="pln">     </span><span class="com">// http://codex.wordpress.org/Function_Reference/single_post_title</span></li><li class="L7"><span class="pln">  </span><span class="str">'comment_author'</span><span class="pun">,</span><span class="pln">        </span><span class="com">// http://codex.wordpress.org/Function_Reference/comment_author</span></li><li class="L8"><span class="pln">  </span><span class="str">'comment_text'</span><span class="pun">,</span><span class="pln">          </span><span class="com">// http://codex.wordpress.org/Function_Reference/comment_text</span></li><li class="L9"><span class="pln">  </span><span class="com">// 'link_name',          Deprecated.</span></li><li class="L0"><span class="pln">  </span><span class="com">// 'link_notes',         Deprecated.</span></li><li class="L1"><span class="pln">  </span><span class="str">'link_description'</span><span class="pun">,</span><span class="pln">      </span><span class="com">// Deprecated, but still widely used.</span></li><li class="L2"><span class="pln">  </span><span class="str">'bloginfo'</span><span class="pun">,</span><span class="pln">              </span><span class="com">// http://codex.wordpress.org/Function_Reference/bloginfo</span></li><li class="L3"><span class="pln">  </span><span class="str">'wp_title'</span><span class="pun">,</span><span class="pln">              </span><span class="com">// http://codex.wordpress.org/Function_Reference/wp_title</span></li><li class="L4"><span class="pln">  </span><span class="str">'term_description'</span><span class="pun">,</span><span class="pln">      </span><span class="com">// http://codex.wordpress.org/Function_Reference/term_description</span></li><li class="L5"><span class="pln">  </span><span class="str">'category_description'</span><span class="pun">,</span><span class="pln">  </span><span class="com">// http://codex.wordpress.org/Function_Reference/category_description</span></li><li class="L6"><span class="pln">  </span><span class="str">'widget_title'</span><span class="pun">,</span><span class="pln">          </span><span class="com">// Used by all widgets in themes</span></li><li class="L7"><span class="pln">  </span><span class="str">'widget_text'</span><span class="pln">            </span><span class="com">// Used by all widgets in themes</span></li><li class="L8"><span class="pln">  </span><span class="pun">);</span></li><li class="L9"><span class="pln"> </span></li><li class="L0"><span class="kwd">foreach</span><span class="pln"> </span><span class="pun">(</span><span class="pln"> $qmr_work_tags </span><span class="kwd">as</span><span class="pln"> $qmr_work_tag </span><span class="pun">)</span><span class="pln"> </span><span class="pun">{</span></li><li class="L1"><span class="pln">  remove_filter </span><span class="pun">(</span><span class="pln">$qmr_work_tag</span><span class="pun">,</span><span class="pln"> </span><span class="str">'wptexturize'</span><span class="pun">);</span></li><li class="L2"><span class="pun">}</span></li></ol></pre><p>当然，你还可以将上面的代码分别下面的形式：</p><pre class="prettyprint linenums"><ol class="linenums"><li class="L0"><span class="str">/取消内容转义 </span></li><li class="L1"><span class="str">remove_filter('the_content', 'wptexturize');</span></li><li class="L2"><span class="str">/</span><span class="pun">/取消摘要转义</span></li><li class="L3"><span class="pln">remove_filter</span><span class="pun">(</span><span class="str">'the_excerpt'</span><span class="pun">,</span><span class="pln"> </span><span class="str">'wptexturize'</span><span class="pun">);</span></li><li class="L4"><span class="com">//取消评论转义 </span></li><li class="L5"><span class="pln">remove_filter</span><span class="pun">(</span><span class="str">'comment_text'</span><span class="pun">,</span><span class="pln"> </span><span class="str">'wptexturize'</span><span class="pun">);</span></li></ol></pre><p>如果不想修改代码的，直接<a href="http://wordpress.org/plugins/quotmarks-replacer/" target="_blank" data-original-title="" title="">下载安装 Quotmarks Replacer 插件</a>。</p><p>转载请注明：<a href="http://yusi123.com" data-original-title="" title="">欲思博客</a> » <a href="http://yusi123.com/3785.html" data-original-title="" title="">WordPress 禁止将英文半角符号转换成全角符号（字符转义）</a></p><div class="open-message"></div>

        </div>
        <div class="artice-reprint-desc">
            <span> 转载请注明：</span>
            <a href="index.html">顾大仙博客</a>&nbsp;»
            <a href="#">为什么王自如 ZEALER 中国测评停摆？有图有真相</a>
        </div>
        <div class="article-open-message">
            <i class="fa fa-volume-up"></i>
            <span>如果你觉得这篇文章或者我分享的主题对你有帮助，请支持我继续更新网站和主题 ！</span>
            <a href="#">捐赠本站</a>
        </div>
        <div class="article-social">
            <!-- <img src="images/zhifubao.jpeg" alt="" width="20%" height="20%"> -->
            <a href="#" class="like">
                <i class="fa fa-heart-o"></i>
                喜欢(
                <span class="count">45</span>
                )
            </a>
            <span class="or">or</span>
            <a href="#" class="support">
                <i class="fa fa-heart-o"></i>
                赞赏支持
            </a>
            <span class="tips">如您觉得文章不错，对您有所帮助请点击<a href="#">赞赏支持</a>可以通过“支付宝”或“微信支付”请我喝咖啡。</span>
        </div>
        <div class="article-footer-label">
            <i class="fa fa-tags"></i>
            <a href="#" rel="tag" title="">ZEALER中国</a>
            <a href="#" rel="tag" title="">ZEALER中国</a>
            <a href="#" rel="tag" title="">ZEALER中国</a>
        </div>
        <nav class="article-nav">
            <a href="#" class="up">
                <strong>上一篇</strong>
                <div>
                    <i class="fa fa-angle-double-left"></i>
                    <span> 百度联盟新推出“创新搜索样式”为站长谋福利</span>
                </div>
            </a>
            <i class="fa fa-arrows-h"></i>
            <a href="#" class="down">
                <strong>下一篇</strong>
                <div>
                    <span> 百度联盟新推出“创新搜索样式”为站长谋福利</span>
                    <i class="fa fa-angle-double-right"></i>
                </div>
            </a>
        </nav>
        <div class="comt-title">
            <div class="comt-avatar">
                <img src="/images/commet-avatar.jpg" alt="" width="30px" height="30px">
            </div>
            <div class="comt-author">
                <span>顾大仙</span>
                <span>发表我的评论</span>
            </div>
        </div>
        <div class="comt-write">
            <form action="#">
                <textarea name="name" rows="6" cols="100%"></textarea>
                <div class="comt-ctrl">
                      <span class="comt-smile-insert">
                        <i class="fa fa-smile-o fa-lg"></i>
                        <span>表情</span>
                      </span>
                    <button class="btn btn-info pull-right" type="submit" name="submit" id="submit" tabindex="5"><i class="fa fa-check-square-o"></i> 提交评论</button>
                </div>
                <div class="comt-smilies">


                </div>
            </form>
        </div>
        <div class="post-comments">
            <div class="comment-title">
                <i class="fa fa-comments-o"></i>
                <span>(</span>
                <span class="commet-count">13</span>
                <span>)</span>
                <span>个小伙伴在吐槽</span>
            </div>
            <div class="comment-list">
                <div class="commet">
                    <div>
                        <div class="author">
                            <a href="#" class="avatar">
                                <img src="/images/commet-avatar.jpg" alt="" >
                            </a>
                            <div class="info">
                                <a href="#">弗兰克</a>
                                <span class="author-tag">作者</span>
                                <div class="meta">
                                    <span>2楼</span>
                                    <time>2017.04.17 09:38</time>
                                </div>
                            </div>
                        </div>
                        <div class="commet-wrap">
                            <p>很实在，现在很多人有些扭捏，不好意思说出自己423143214扭捏，不好意思说出自己4231432141243112431扭捏，不好意思说出自己42314321412431扭捏，不好意思说出自己423143214124312431243214的真实想法</p>
                            <div class="tool-group">
                                <a href="#">
                                    <i class="fa fa-heart-o"></i>
                                    <span>6</span>人赞
                                </a>
                                <a href="#">
                                    <i class="fa fa-heart-o"></i>
                                    <span>回复</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="sub-comment-list">
                        <div class="sub-commet">
                            <p>
                                <a href="#">弗兰克</a>：
                                <span>
                                  <a href="#">@Jitter</a>
                                  <span> 你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课</span>
                                </span>
                            </p>
                            <div class="sub-tool-group">
                                <span>2017.04.17 11:22</span>
                                <a href="#" class="response">
                                    <i class="fa fa-heart-o"></i>
                                    <span>回复</span>
                                </a>
                                <a href="#" class="report">
                                    <span>举报</span>
                                </a>
                            </div>
                        </div>
                        <div class="sub-commet">
                            <p>
                                <a href="#">弗兰克</a>：
                                <span>
                                  <a href="#">@Jitter</a>
                                  <span> 你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课</span>
                                </span>
                            </p>
                            <div class="sub-tool-group">
                                <span>2017.04.17 11:22</span>
                                <a href="#" class="response">
                                    <i class="fa fa-heart-o"></i>
                                    <span>回复</span>
                                </a>
                                <a href="#" class="report">
                                    <span>举报</span>
                                </a>
                            </div>
                        </div>
                        <div class="sub-commet">
                            <p>
                                <a href="#">弗兰克</a>：
                                <span>
                                  <a href="#">@Jitter</a>
                                  <span> 你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课</span>
                                </span>
                            </p>
                            <div class="sub-tool-group">
                                <span>2017.04.17 11:22</span>
                                <a href="#" class="response">
                                    <i class="fa fa-heart-o"></i>
                                    <span>回复</span>
                                </a>
                                <a href="#" class="report">
                                    <span>举报</span>
                                </a>
                            </div>
                        </div>
                        <div class="sub-comment more-comment">
                            <a href="#" class="add-commet-btn">
                                <i class="fa fa-heart-o"></i>
                                <span>添加评论</span>
                            </a>
                            <span class="line-wrap">
                              还有<span>9</span>条评论
                            </span>
                            <a href="#">展开查看</a>
                        </div>
                        <div>
                            <form action="#" class="new-commet">
                                <textarea name="name" rows="3" placeholder="写下你的评论..."></textarea>
                                <div class="write-function-block">
                                    <a href="#" class="btn btn-info btn-send">发送</a>
                                    <a href="#" class="cancel">取消</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="commet">
                    <div>
                        <div class="author">
                            <a href="#" class="avatar">
                                <img src="/images/commet-avatar.jpg" alt="" >
                            </a>
                            <div class="info">
                                <a href="#">弗兰克</a>
                                <span class="author-tag">作者</span>
                                <div class="meta">
                                    <span>2楼</span>
                                    <time>2017.04.17 09:38</time>
                                </div>
                            </div>
                        </div>
                        <div class="commet-wrap">
                            <p>很实在，现在很多人有些扭捏，不好意思说出自己423143214扭捏，不好意思说出自己4231432141243112431扭捏，不好意思说出自己42314321412431扭捏，不好意思说出自己423143214124312431243214的真实想法</p>
                            <div class="tool-group">
                                <a href="#">
                                    <i class="fa fa-heart-o"></i>
                                    <span>6</span>人赞
                                </a>
                                <a href="#">
                                    <i class="fa fa-heart-o"></i>
                                    <span>回复</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="sub-comment-list hidden">
                        <div>
                            <form action="#" class="new-commet">
                                <textarea name="name" rows="3" placeholder="写下你的评论..."></textarea>
                                <div class="write-function-block">
                                    <a href="#" class="btn btn-info btn-send">发送</a>
                                    <a href="#" class="cancel">取消</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="commet">
                    <div>
                        <div class="author">
                            <a href="#" class="avatar">
                                <img src="/images/commet-avatar.jpg" alt="" >
                            </a>
                            <div class="info">
                                <a href="#">弗兰克</a>
                                <span class="author-tag">作者</span>
                                <div class="meta">
                                    <span>2楼</span>
                                    <time>2017.04.17 09:38</time>
                                </div>
                            </div>
                        </div>
                        <div class="commet-wrap">
                            <p>很实在，现在很多人有些扭捏，不好意思说出自己423143214扭捏，不好意思说出自己4231432141243112431扭捏，不好意思说出自己42314321412431扭捏，不好意思说出自己423143214124312431243214的真实想法</p>
                            <div class="tool-group">
                                <a href="#">
                                    <i class="fa fa-heart-o"></i>
                                    <span>6</span>人赞
                                </a>
                                <a href="#">
                                    <i class="fa fa-heart-o"></i>
                                    <span>回复</span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="sub-comment-list">
                        <div class="sub-commet">
                            <p>
                                <a href="#">弗兰克</a>：
                                <span>
                                  <a href="#">@Jitter</a>
                                  <span> 你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课</span>
                                </span>
                            </p>
                            <div class="sub-tool-group">
                                <span>2017.04.17 11:22</span>
                                <a href="#" class="response">
                                    <i class="fa fa-heart-o"></i>
                                    <span>回复</span>
                                </a>
                                <a href="#" class="report">
                                    <span>举报</span>
                                </a>
                            </div>
                        </div>
                        <div class="sub-commet">
                            <p>
                                <a href="#">弗兰克</a>：
                                <span>
                                  <a href="#">@Jitter</a>
                                  <span> 你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课你好，简书目前我还不会去打广告，有兴趣可以去在行app，深圳地区搜索弗兰克深圳地区搜索弗兰克深圳地区搜索弗兰克，然后去预约线上课</span>
                                </span>
                            </p>
                            <div class="sub-tool-group">
                                <span>2017.04.17 11:22</span>
                                <a href="#" class="response">
                                    <i class="fa fa-heart-o"></i>
                                    <span>回复</span>
                                </a>
                                <a href="#" class="report">
                                    <span>举报</span>
                                </a>
                            </div>
                        </div>
                        <div class="sub-comment more-comment">
                            <a href="#" class="add-commet-btn">
                                <i class="fa fa-heart-o"></i>
                                <span>添加评论</span>
                            </a>
                        </div>
                    </div>
                </div>



            </div>
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
                               <img src="/images/2.jpg" alt="" >
                            </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一枚枚首次购推荐码一枚首次购推荐码荐码一枚首次购推荐码荐码一枚首次购推荐码一</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="note-thume">
                              <img src="/images/3.jpg" alt="" >
                            </span>
                            <span class="note-title">限量阿里云推荐码一枚首次购推荐码一枚首次购推荐码一枚</span>
                            <span class="note-time">2016-07-01</span>
                            <span class="note-commet">16评论</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="note-thume">
                               <img src="/images/2.jpg" alt="" >
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
                            <img src="/images/commet-avatar.jpg" alt="评论图片" width="20%" height="20%">
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
                            <img src="/images/commet-avatar.jpg" alt="评论图片" width="20%" height="20%">
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
                            <img src="/images/commet-avatar.jpg" alt="评论图片" width="20%" height="20%">
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







<!-- footer start -->
<#include "/views/include/footer.ftl">
<!-- footer end -->

<!-- common js start  -->
<#include "/views/include/public-js.ftl">
<!-- common js end  -->



</body>
</html>