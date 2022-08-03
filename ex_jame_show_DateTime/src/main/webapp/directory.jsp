<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 29/06/2022
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="layout/head.jsp"%>
</head>
<body>
    <form action="/directory", method="post">
        <h1>
            VIETNAM DIRECTORY
        </h1>
        <input type="text" name="search" placeholder="search...">
        <input type="submit" value="Submit">
    </form>
    <%@include file="layout/script.jsp"%>
</body>
</html>
