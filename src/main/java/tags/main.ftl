<#macro html title responsive=false js="" css="">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>${title}</title>
    <link rel="stylesheet" href="/static/css/lib/pure.css">
    <#if css?has_content>
        <link rel="stylesheet" href="/static/css/module/${css}.css">
    </#if>
    <#if responsive>
        <!--[if lte IE 8]>
        <link rel="stylesheet" href="/static/css/lib/grids-responsive-old-ie.css">
        <![endif]-->
        <!--[if gt IE 8]><!-->
        <link rel="stylesheet" href="/static/css/lib/grids-responsive.css">
        <!--<![endif]-->
    </#if>
</head>
<body>
    <@ui.m0auto width=960>
        <#nested />
    </@ui.m0auto>
    <#if js?has_content>
    <script src="/static/js/require.js"></script>
    <script>
        requirejs.config({
            baseUrl: '/static/js',
            paths: {
                "css": "../css",
                "html": "../html",
                "jquery": "lib/jquery-1.11.1"
            }
        });
    </script>
    <script src="/static/js/module/${js}.js"></script>
    </#if>
</body>
</html>
</#macro>