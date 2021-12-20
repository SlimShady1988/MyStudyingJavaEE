<%--
  Created by IntelliJ IDEA.
  User: SlimShady
  Date: 08.10.2021
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="j_security_check" method="post">
    <label for="j_user_name"> Name:
        <input id="j_user_name" type="text" name="j_username">
    </label>
    <label for="j_password"> Password:
        <input id="j_password" type="password" name="j_password">
    </label>
    <input type="submit" value="Login">
</form>
</body>
</html>
