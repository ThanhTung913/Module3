<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 05/07/2022
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Manager Application</title>
</head>
<body>
<center>
    <h1>Country Manager</h1>
    <h2>
        <a href="/countryServlet?action=country"></a>
    </h2>
</center>
<div align="center">
    <form method="post" action="">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Add New Country
                </h2>
                <h2>
                    <a href="/countryServlet">List Country</a>
                </h2>
            </caption>
            <tr>
                <th>Country:</th>
                <td>
                    <input type=text name="name" id="name" size="45">
                </td>

            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>
