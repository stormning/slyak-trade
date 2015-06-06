<#macro fixed_left left>
<div class="pure-g">
    <div class="pure-u"></div>
    <div class="pure-u"></div>
</div>
</#macro>

<#macro fixed_right right>
<div class="pure-g" style="padding-right: ${right}px">
    <div class="pure-u-1" style="margin-left: -${right}px;background-color: #777777">
        左边
    </div>
    <div class="pure-u" style="width: ${right}px;margin-right: -${right}px;background-color: #129FEA">
        右边
    </div>
</div>
</#macro>