<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24/02/2023
  Time: 1:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bài 1</title>
</head>
<body>
<h1>Ứng dụng chuyển đổi tiền tệ</h1>
<form action="/currency" method="get">
    <input type="text" name="usd" value="${usd}">
    <input type="submit" value="Kiểm tra">
</form>

<p>VND: ${vnd} vnd </p>
</body>
</html>
