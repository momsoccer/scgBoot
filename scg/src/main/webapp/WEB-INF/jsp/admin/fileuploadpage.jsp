<%--
  Created by IntelliJ IDEA.
  User: sungbo
  Date: 2016-06-09
  Time: 오전 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <title>Spring for Android Showcase</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Please upload a file</h1>
<form method="post" action="/api/user/fileupload" enctype="multipart/form-data">
  <p>Name: <input type="text" name="filename"/></p>
  <p><input type="file" name="file"/></p>
  <p><input type="submit"/></p>
</form>
</body>
</html>
