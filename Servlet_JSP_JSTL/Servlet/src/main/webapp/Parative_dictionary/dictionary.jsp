<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionay</title>
</head>
<%!
    Map<String, String> dic = new HashMap<>();
%>
<%
    dic.put("hello","xin chào" );
    dic.put("how","Thế nào" );
    dic.put("book","xin chào" );
    dic.put("hello","xin chào" );

    String search = request.getParameter("search");
    String result = dic.get(search);
    if (result != null){
        out.println("Work: " + search );
        out.println("result " + result);
    } else {
        out.println("Not found");
    }
%>

<body>
</body>
</html>