<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include.jsp" %>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
</head>
<body>
<sitemesh:write property='body'/>
<script src="${ctx}/static/js/jquery-1.11.1.js" type="text/javascript"></script>
</body>
</html>
