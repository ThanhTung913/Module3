<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/07/2022
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <%@include file="layout/head.jsp"%>
</head>
<body>
<h1 STYLE="margin-left: 400px;">DANH SÁCH KHÁCH HÀNG</h1>
<table class="table table-striped">
  <thead>
  <tr>
    <th scope="col">Tên </th>
    <th scope="col">Ngày sinh</th>
    <th scope="col">Địa chỉ</th>
    <th scope="col">Ảnh</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <th>1</th>
    <td>Mark</td>
    <td>Otto</td>
    <td>@mdo</td>
  </tr>
  <tr>
    <th>2</th>
    <td>Jacob</td>
    <td>Thornton</td>
    <td>@fat</td>
  </tr>
  <tr>
    <th >3</th>
    <td>Larry the Bird</td>
    <td>@twitter</td>
  </tr>
  </tbody>
</table>
<%@include file="layout/script.jsp"%>
</body>
</html>
