<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/02/2023
  Time: 1:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Bài 1</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        label {
            width: 80px;
        }

        form {
            padding-left: 0 !important;
            display: inline-block !important;
        }
    </style>
</head>
<body>
<h3></h3>
<form action="/save">
    <label class="form-check-label" for="lettuce">
        <input type="checkbox"  name="condiment" id="lettuce" value="lettuce">
        Lettuce
    </label>
    <label class="form-check-label" for="tomato">
        <input type="checkbox"  name="condiment" id="tomato" value="tomato">
        Tomato
    </label>
    <label class="form-check-label" for="mustard">
        <input type="checkbox"  name="condiment" id="mustard" value="mustard">
        Mustard
    </label>
    <label class="form-check-label" for="sprouts">
        <input type="checkbox"  name="condiment" id="sprouts" value="sprouts">
        Sprouts
    </label>
    <hr>
    <input type="submit" value="Save" class="btn btn-secondary">
</form>
<h3>Danh sách các gia vị có trong Sandwich</h3>
<p>${condimentList}</p>
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