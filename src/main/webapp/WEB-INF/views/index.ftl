<#-- @ftlvariable name="user" type="com.slyak.api.user.User" -->
<@layout.web title="test">
<div class="pure-g">
    <div class="pure-u-2-3">
        <div class="column-wrapper">
            <div class="widget">
                <div class="widget-header">
                    <div class="pure-g post-title">
                        <div class="pure-u left">
                            <div class="post-type">NOTE</div>
                        </div>
                        <div class="pure-u-1">hello world!hello world!hello world!</div>
                    </div>
                </div>
                <div class="widget-content">
                    <p>
                    Maecenas varius finibus orci vel dignissim. Nam posuere, magna pellentesque accumsan tincidunt, libero lorem convallis lectus, tincidunt accumsan enim ex ut sem. Ut in augue congue, tempus urna sit amet, condimentum
                    lorem. Pellentesque est sem, semper sit amet velit et, commodo fringilla turpis. Aenean quam erat, eleifend quis congue vitae, interdum vitae risus. Lorem ipsum dolor sit amet, consectetur adipiscing…
                    </p>
                    <div>
                        <a class="pure-button">查看更多</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="pure-u-1-3">
        <div class="column-wrapper">
            <div class="widget">
                <ul class="pure-g tabs">
                    <li class="pure-u-1-3"><a class="tab tab-active" href="#">最新</a></li>
                    <li class="pure-u-1-3"><a class="tab" href="#">最热</a></li>
                    <li class="pure-u-1-3"><a class="tab" href="#">评论</a></li>
                </ul>
                <div class="widget-content">
                    <ul>
                        <#list 0..3 as i>
                            <li class="pure-g post-simple">
                                <div class="pure-u left">
                                    <img src="http://themepixels.net/themes/smartblog/wp-content/uploads/2015/03/01-60x60.jpg" class="pure-img">
                                </div>
                                <div class="pure-u-1">
                                    <a class="post-simple-title">
                                        Post Format: Standard
                                    </a>
                                    <div>March 17, 2015</div>
                                </div>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="widget">

            </div>
            <div class="widget">

            </div>
            <div class="widget">

            </div>
        </div>
    </div>
</div>
</@layout.web>