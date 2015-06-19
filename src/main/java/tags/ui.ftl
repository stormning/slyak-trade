<#global test = true/>

<#function randomColor>
    <#return "rgb(${(math.random()*255)?int},${(math.random()*255)?int},${(math.random()*255)?int})"/>
</#function>

<#macro wrapContent>
    <#if test><div style="border: 1px solid ${randomColor()}"></#if>
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