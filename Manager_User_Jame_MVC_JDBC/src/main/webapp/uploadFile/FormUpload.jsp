<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 14/07/2022
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jsp - Servlet UploadFile </title>
</head>
<body>
<h2>Demo UploadFile</h2>
<form method="post" action="uploadFile" enctype="multipart/form-data">
    Select File to upload: <input type="file" name="file" size="65"> <br>
    <input type="submit" value="Upload">
</form>
</body>
</html>
