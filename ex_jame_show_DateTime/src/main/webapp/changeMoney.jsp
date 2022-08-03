<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 29/06/2022
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<style type="text/css">
    .login {
        height:180px; width:230px;
        margin:0;
        padding:10px;
        border:1px #CCC solid;
    }
    .login input {
        padding:5px; margin:5px
    }
</style>
<body>
<form action="/changeMoney", method="post">
    <div class="changeLogin">
        <h2>VIỆT NAM MÃI ĐỈNH</h2>
        <input type="text" name="VND" size="30"  placeholder="VND" />
        <input type="text" name="USD" size="30" placeholder="USD" />
        <input type="submit" value="Change"/>
    </div>
</form>
</body>
</html>

