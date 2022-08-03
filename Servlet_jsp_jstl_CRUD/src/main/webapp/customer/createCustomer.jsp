<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 12/07/2022
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <%@include file="/layout/head.jsp" %>
    <style>
        * {
            padding: 2px;
            margin: 2px;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">
    Add New Customers
</h1>
<div class="container" style="margin: auto">

    <form class="row g-3" method="post" action="create">
        <div class="col-md-6">
            <c:if test="${messge != null}">
                <p style="color: red">
                    <c:out value="${message}"></c:out>
                </p>
            </c:if>
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>
        <div class="col-md-6">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="vd: Tung Dep Trai"
                   value="${customer.name}">
        </div>
        <div class="col-md-6 ">
            <label for="phone" class="form-label">Phone</label>
            <input type="text" class="form-control" id="phone" placeholder="vd:0987654321" name="phone"
                   value="${customer.phone}">
        </div>
        <div class=" col-md-6">
            <label for="email" class="form-label">Email</label>
            <input type="text" class="form-control" id="email" placeholder="thanhtung@gmail.com" name="email"
                   value="${customer.email}">
        </div>

        <div class=" col-md-12">
            <button type="submit" class="btn btn-primary" name="create">Create</button>
        </div>
    </form>
</div>
<%@include file="/layout/script.jsp" %>


</body>
</html>
