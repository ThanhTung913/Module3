<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 13/07/2022
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Servlet Upload file</title>
</head>
<body>
<h2>Demo JSP-Servlet Upload File</h2>
<form method="post" action="UploadFileServlet" enctype="multipart/form-data">
  Select file to upload: <input type="file" name="file" size="60" /><br /><br />
  <input type="submit" value="Upload" />
</form>
</body>
</html>
