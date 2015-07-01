<#-- @ftlvariable name="user" type="com.slyak.api.user.User" -->
<@layout.web title="test">
<div class="pure-g">
    <div class="pure-u-2-3">
        <div class="column-wrapper">
            <#list 1..3 as i>
                <div class="widget">
                    <div class="widget-header">
                        <div class="pure-g post-info">
                            <div class="pure-u left">
                                <div class="post-type">NOTE</div>
                            </div>
                            <div class="pure-u-1">
                                <div class="post-title">J2EE框架 Spring</div>
                                <div class="post-meta">
                                    <a href="#">stormning</a> 发布于 2015-06-25 (4189)查看 (64)评论
                                </div>
                            </div>
                        </div>
                    </div>
                    <img src="http://themepixels.net/themes/smartblog/wp-content/uploads/2015/03/02-748x350.jpg" class="pure-img">

                    <div class="widget-content">
                        <p>
                            Spring Framework 是一个开源的Java/Java EE全功能栈（full-stack）的应用程序框架，以Apache许可证形式发布，也有.NET平台上的移植版本。该框架基于 Expert One-on-One Java EE Design and Development（ISBN 0-7645-4385-7）一书中的代码，最初由 Rod Johnson 和 Juergen
                            Hoeller等开发。Spring Framework 提供了一个简易的开发方式，这种开发方式，将避免那些可能致使底层代码变得繁杂混乱的大量的属性文件和帮助类。
                        </p>
                        <a class="pure-button">查看更多</a>
                    </div>
                </div>
            </#list>
        </div>
    </div>
    <div class="pure-u-1-3">
        <div class="column-wrapper">
            <div class="widget">
                <div class="widget-content">
                    <form action="${homeCtl.index()}" method="get">
                        <div class="pure-g search-form">
                            <div class="pure-u-1">
                                <input type="text" name="keyword" value="${RequestParameters.keyword}">
                            </div>
                            <div class="pure-u right">
                                <button type="submit">搜索</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="widget">
                <ul class="pure-g tabs">
                    <li class="pure-u-1-3"><a class="tab tab-active" href="#">最新</a></li>
                    <li class="pure-u-1-3"><a class="tab" href="#">最热</a></li>
                    <li class="pure-u-1-3"><a class="tab" href="#">评论</a></li>
                </ul>
                <div class="widget-content">
                    <ul>
                        <#list 0..3 as i>
                            <@web.postSimple/>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="widget">
                <div class="widget-header-2">
                    最新图片
                </div>
                <div class="widget-content">
                    <img src="http://themepixels.net/themes/smartblog/wp-content/uploads/2015/03/06-600x525.jpg" class="pure-img">
                </div>
            </div>
            <div class="widget">
                <div class="widget-header-2">
                    最新文章
                </div>
                <div class="widget-content">
                    <ul>
                        <#list 0..3 as i>
                            <@web.postSimple/>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="widget">
                <div class="widget-header-2">
                    热评
                </div>
            </div>
            <div class="widget">
                <div class="widget-header-2">
                    标签
                </div>
            </div>
        </div>
    </div>
</div>
</@layout.web>