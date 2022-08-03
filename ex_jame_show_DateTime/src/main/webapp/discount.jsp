<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 29/06/2022
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<style>
    *{
        padding: 2px;
        margin: 2px;
    }
</style>
<head>
    <title>discount</title>
    <%@include file="layout/head.jsp"%>
</head>
<body>
<form class="row g-3" action="/discount" method="post">
    <div class="col-6">
        <label for="ProductDescription" class="form-label"> Product Description </label>
        <input type="text" class="form-control" name="ProductDescription" id="ProductDescription" placeholder="input">
    </div>
    <div class="col-md-6">
        <label for="ListPrice" class="form-label">List Price</label>
        <input type="text" class="form-control" name="ListPrice" id="ListPrice">
    </div>

    <div class="col-md-6">
        <label for="DiscountPercent" class="form-label">Discount Percent</label>
        <input type="text" class="form-control" name="DiscountPercent" id="DiscountPercent">
    </div>

    <div class="col-12">
        <input type="submit" value="SUBMIT" class="btn btn-primary">
<%--        <button type="submit" class="btn btn-primary">SUBMIT</button>--%>
    </div>
</form>
<%@include file="layout/script.jsp"%>

</body>
</html>
