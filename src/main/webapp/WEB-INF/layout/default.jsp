<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include.jsp" %>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='page.css'/>
</head>
<body>
<div>头部</div>
<div>sliders</div>
<div></div>

<script src="${ctx}/static/js/jquery-1.11.1.js" type="text/javascript"></script>
<sitemesh:write property='page.js'/>
</body>
</html>
