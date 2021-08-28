<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2021/8/28
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="user">
        ${user.id}--${user.roleName}--${user.roleDsc}<br/>
    </c:forEach>
</body>
</html>
