<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 26/05/2022
  Time: 13:40
  To change this template use File | Settings | File Templates.

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>
    sample exam
</h2>
<%
    int a = 9;
    for (int i = 1;i < 10;i++){
        int result = a * i;
        out.print(a + " x " + i + " = " + result + "<br>");
    }
%>

<%--<c:set var="b" value="8"/>--%>
<%--<c:forEach var="i"  begin="1" end="9">--%>
<%--&lt;%&ndash;     result = b * i;&ndash;%&gt;--%>
<%--&lt;%&ndash;    ${b} + ' x ' + ${i} + ' = ' + ${result} + <br>&ndash;%&gt;--%>
<%--    <c:out value="${b} x ${i}  = ${i * b}"/><p>--%>
<%--</c:forEach>--%>

</body>
</html>
