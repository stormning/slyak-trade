<#-- @ftlvariable name="user" type="com.slyak.api.user.User" -->
<@main.html title="test" js="user">
    <@ui.menus/>
    <#assign lc>我是左边的内容</#assign>
    <#assign rc>我是右边的内容</#assign>
    <@ui.fixedRight rightWidth=300 leftContent=lc rightContent=rc/>
</@main.html>