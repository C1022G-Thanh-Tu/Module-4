<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24/02/2023
  Time: 1:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bài 2</title>
</head>
<body>
<form action="/dictionary" method="get">
    <input type="text" name="eng" value="${eng}">
    <input type="submit" name="" value="Kết quả">
</form>
<p>${result}</p>
</body>
</html>
