<#macro web title js="">
    <@main.html title=title css="web" js=js responsive=true>
    <div class="header">
        <div class="container">
            <div class="pure-g header-wrapper">
                <div class="pure-u left logo">
                    SLYAK
                </div>
                <div class="pure-u-1">
                    <@ui.menus/>
                </div>
            </div>
        </div>
    </div>
    <div class="container" id="container">
        <#nested />
    </div>
    </@main.html>
</#macro>