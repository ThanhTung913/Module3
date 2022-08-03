<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/07/2022
  Time: 08:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <c:out value="${'c: out test'}"/>--%>
<%--    <br>--%>
<%--    <c:out value="${'....'}"/>--%>
<c:set scope="request" var="greeting" value="hello would" />
Greeting:  <c:set value="greeting"/>
</body>
</html>