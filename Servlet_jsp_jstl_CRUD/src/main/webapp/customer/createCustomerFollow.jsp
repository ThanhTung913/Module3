<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message {
            color: red;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form method="post" action="/create">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>ID:</td>
                <c:if test="${message != null}">
                    <p style="color: red">
                        <c:out value="${message}"></c:out>
                    </p>
                </c:if>
                <td><input type="text" name="name" id="id" size="45"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" size="45" value="${customer.getName()}"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone" id="Phone" size="45" value="${custome.getPhone()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" size="45" value="${customer.getEmail()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>