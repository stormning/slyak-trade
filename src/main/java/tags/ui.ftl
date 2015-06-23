<#global test = true/>

<#function randomColor>
    <#return "rgb(${(math.random()*255)?int},${(math.random()*255)?int},${(math.random()*255)?int})"/>
</#function>

<#macro wrapContent>
    <#if test>
    <div style="border: 1px solid ${randomColor()}"></#if>
    <#nested />
    <#if test></div></#if>
</#macro>

<#macro fixedLeft left leftContent rightContent>
<div class="pure-g" style="padding-left: ${left}px">
    <div class="pure-u" style="width: ${left}px;margin-right: -${left}px">
        <@wrapContent>${leftContent}</@wrapContent>
    </div>
    <div class="pure-u-1">
        <@wrapContent>${rightContent}</@wrapContent>
    </div>
</div>
</#macro>

<#macro fixedRight rightWidth leftContent rightContent>
<div class="pure-g" style="padding-right: ${rightWidth}px">
    <div class="pure-u-1">
        <@wrapContent>${leftContent}</@wrapContent>
    </div>
    <div class="pure-u" style="width: ${rightWidth}px;margin-right: -${rightWidth}px;">
        <@wrapContent>${rightContent}</@wrapContent>
    </div>
</div>
</#macro>

<#macro fixedLeftRight leftWidth rightWidth leftContent middleContent rightContent>
<div class="pure-g" style="padding-right: ${rightWidth}px">
    <div class="pure-u" style="width: ${leftWidth}px;margin-right: -${leftWidth}px;">
        <@wrapContent>${leftContent}</@wrapContent>
    </div>
    <div class="pure-u-1">
        <@wrapContent>${middleContent}</@wrapContent>
    </div>
    <div class="pure-u" style="width: ${rightWidth}px;margin-right: -${rightWidth}px;">
        <@wrapContent>${rightContent}</@wrapContent>
    </div>
</div>
</#macro>

<#macro m0auto width>
<div style="margin: 0 auto;width: ${width}px">
    <@wrapContent><#nested/></@wrapContent>
</div>
</#macro>

<#macro menusInner menus isChildren = false>
    <#assign ulClass = isChildren?string("pure-menu-children","pure-menu-list")/>
<ul class="${ulClass}">
    <#list menus as menu>
        <#assign hasChild = menu.subMenus?has_content/>
        <li class="pure-menu-item<#if menu.active> pure-menu-selected</#if><#if hasChild> pure-menu-has-children pure-menu-allow-hover</#if>">
            <a href="${menu.url}" class="pure-menu-link">${menu.title}</a>
            <#if hasChild>
                <@menusInner menus=menu.subMenus isChildren=true/>
            </#if>
        </li>
    </#list>
</ul>
</#macro>

<#macro menus root=context.getMenus()>
<div class="pure-menu pure-menu-horizontal">
    <@menusInner menus=context.getMenus() isChildren=false/>
</div>
</#macro>