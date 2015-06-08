<#macro fixedLeft left leftContent rightContent>
<div class="pure-g" style="padding-left: ${left}px">
    <div class="pure-u" style="width: ${left}px;margin-right: -${left}px">
    ${leftContent}
    </div>
    <div class="pure-u-1">
    ${rightContent}
    </div>
</div>
</#macro>

<#macro fixedRight rightWidth leftContent rightContent>
<div class="pure-g" style="padding-right: ${rightWidth}px">
    <div class="pure-u-1">
    ${leftContent}
    </div>
    <div class="pure-u" style="width: ${rightWidth}px;margin-right: -${rightWidth}px;">
    ${rightContent}
    </div>
</div>
</#macro>

<#macro fixedLeftRight leftWidth rightWidth leftContent middleContent rightContent>
<div class="pure-g" style="padding-right: ${rightWidth}px">
    <div class="pure-u" style="width: ${leftWidth}px;margin-right: -${leftWidth}px;">
    ${leftContent}
    </div>
    <div class="pure-u-1">
    ${middleContent}
    </div>
    <div class="pure-u" style="width: ${rightWidth}px;margin-right: -${rightWidth}px;">
    ${rightContent}
    </div>
</div>
</#macro>