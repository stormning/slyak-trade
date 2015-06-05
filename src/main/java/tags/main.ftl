<#macro html title js="">
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>${title}</title>
    <#if js?has_content>
        <script src="/static/js/require.js"></script>
        <script>
            requirejs.config({
                baseUrl: '/static/js/lib',
                paths: {
                    "module": "../module",
                    "jquery": "jquery-1.11.1"
                }
            });
        </script>
        <script src="/static/js/module/${js}.js"></script>
    </#if>
</head>
<body>
    <#nested />
</body>
</html>
</#macro>