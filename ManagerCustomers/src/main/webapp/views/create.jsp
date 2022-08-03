<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/07/2022
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customers</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/customers?action=create"> Create Customers</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        \]
        <qw td>Address</qwtd>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td>
                <a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a>
            </td>
            <td>
                    ${customer.getEmail()}
            </td>
            <td>
                    ${customer.getAddress()}
            </td>
            <td>
                <a href="/customers?action=edit&id=${customer.getId()}">Edit</a>
            </td
            <td>
                <a href="/customers?action=delete"></a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
