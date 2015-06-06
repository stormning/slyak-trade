<#macro html title responsive=false module="">
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>${title}</title>
    <link rel="stylesheet" href="/static/css/lib/pure.css">
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
    <#nested />
    <#if module?has_content>
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
    <script src="/static/js/module/${module}.js"></script>
    </#if>
</body>
</html>
</#macro>