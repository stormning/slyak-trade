<#macro html title libs=[]>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>${title}</title>
    <#list libs as lib>
        <#switch lib>
            <#case "jquery">
                <script src="#{'jquery/jquery.js'}"></script>
        </#switch>
    </#list>
</head>
<body>
    <#nested />
</body>
</html>
</#macro>