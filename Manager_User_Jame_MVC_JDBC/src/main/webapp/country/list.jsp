<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 15/07/2022
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Manager Application</title>
</head>
<body>
<center>
    <h1>
        Country Manager
    </h1>
    <h2>
        <a href="/countryServlet?action=create">
            Add New Country
        </a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Countrys</h2></caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Action</td>
        </tr>
        <c:forEach var="country" items="${listCountry}">
            <tr>
                <td><c:out value="${country.getId()}"></c:out></td>
                <td><c:out value="${country.getName()}"></c:out></td>
                <td>
                    <a href="/countryServlet?action=edit&id=${country.id}">Edit</a>
                    <a href="/countryServlet?action=delete&id=${country.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>