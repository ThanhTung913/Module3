<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 05/07/2022
  Time: 13:37
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
        User Manager
    </h1>
    <h2>
        <a href="/userServlet?action=create">
            Add New User
        </a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Country</td>
            <td>Actions</td>
        </tr>
        <c:forEach var="user" items="${requestScope.listUser}">
            <tr>
                <td><c:out value="${user.getId()}"></c:out></td>
                <td><c:out value="${user.getName()}"></c:out></td>
                <td><c:out value="${user.getEmail()}"></c:out></td>
                <td>

                    <c:forEach items="${applicationScope.listCountry}" var="country">
                        <c:if test="${country.getId() == user.getIdCountry()}">
                            <c:out value="${country.getName()}"></c:out>
                        </c:if>
                    </c:forEach>

                </td>
                <td>
                    <a href="/userServlet?action=edit&id=${user.id}">Edit</a>
                    <a href="/userServlet?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
