<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询的所有账户</h3>

    <c:forEach items="${list}" var="account">
        ${account.name}
    </c:forEach>
</body>
</html>
