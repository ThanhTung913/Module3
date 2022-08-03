<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 04/07/2022
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Customer</title>
</head>
<body>
<h1>Customer Detail</h1>
<p>
    <a href="/customers"> Back to customer list</a>
</p>
<table>
    <tr>
        <td>Name:</td>
        <td>
            <input type="text" name="name" id="name" value="${requestScope["customer"].getName()}">
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>
            <input type="text" name="email" id="email" value="${requestScope["customer"].getEmail()}">
        </td>
    </tr>
    <tr>
        <td>Address:</td>
        <td>
            <input type="text" name="address" id="address" value="${requestScope["customer"].getAddress()}">
        </td>
    </tr>
</table>
</body>

</html>
