<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 28/02/2023
  Time: 3:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <title>Upload</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <style>
    label {
      width: 100px !important;
    }
  </style>
</head>
<body>
<h2>Upload</h2>
<table>
  <form:form action="/song" modelAttribute="song" method="post">
    <tr>
      <div class="form-group">
        <th><label for="songName">Tên bài hát:</label></th>
        <td><form:input path="name" id="songName" /></td>
      </div>
    </tr>

    <tr>
      <div class="form-group">
        <th><label for="singerName">Tên ca sĩ:</label></th>
        <td>
          <form:input path="singerName" id="singerName" />
        </td>
      </div>
    </tr>

    <tr>
      <div class="form-group">
        <th><label for="category">Thể loại:</label></th>
        <td>
          <form:checkboxes path="category" id="category" items="${categoryList}"/>
        </td>
      </div>
    </tr>

    <tr>
      <div class="form-group">
        <th><label for="songURL">File nhạc:</label></th>
        <td><form:input path="songURL" id="songURL" /></td>
      </div>
    </tr>

    <tr>
      <div class="form-group">
        <th></th>
        <td>
          <button type="submit" class="btn btn-primary">Upload</button>
          <button type="button" class="btn btn-secondary" onclick="window.location.href='/email-box'">Cancel</button>
        </td>
      </div>
    </tr>

  </form:form>
</table>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
