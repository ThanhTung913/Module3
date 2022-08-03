<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Managemet Application</title>
</head>
<body>
<h1 style="text-align: center">
    Customer Management
</h1>
<h2 style="text-align: center">
    <a href="/customer"> List Custmomer</a>
    <a href="/customer/createCustomerFollow.jsp"> Add New Customer</a>
</h2>
<div style="text-align: center">
    <table border="1" cellpadding="5" align="center">
        <caption><h2>List of Customer</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Action</th>
        </tr>

        <%--Hiển thị danh sách customer--%>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                <td>
                    <a href="edit?id=<c:out value='${customer.getId()}'/> ">Edit</a>
                    <a href="delete?id=<c:out value='${customer.getId()}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>


    </table>

</div>
</body>
</html>