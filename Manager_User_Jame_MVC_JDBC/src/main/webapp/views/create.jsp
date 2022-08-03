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
    <h1>User Manager</h1>
    <h2>
        <a href="/userServlet?action=user"></a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Add New User
                </h2>
                <h2>
                    <a href="/userServlet">List User</a>
                </h2>
            </caption>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type=text name="name" id="name" size="45">
                </td>

            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45">
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <%--                    <input type="text" name="country" id="country" size="45">--%>
                    <select name="idCountry">
                        <c:forEach var="country" items="${listCountry}">
                            <option value="${country.getId()}">
                                    ${country.getName()}
                            </option>
                        </c:forEach>

                    </select>
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
