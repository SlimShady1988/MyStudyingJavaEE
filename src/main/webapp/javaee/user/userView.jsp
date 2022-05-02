<%@ page import="com.ee.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: SlimShady
  Date: 01.10.2021
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <div>
        <p> User NAME from PASTED JAVA CODE is  <%= ((User)request.getAttribute("User")).getName() %> </p>
        <p> User AGE from PASTED JAVA CODE is  <%= ((User)request.getSession().getAttribute("User")).getAge() %> </p>
        AND
        <jsp:useBean id="User" class="com.ee.user.model.User" scope="request"/>

        <p> User Name from PASTED BEAN is  <jsp:getProperty name="User" property="name"/> </p>
        AND
        <p> User Name from EXPRESSION LANGUAGE is  ${User.age} </p>

    </div>
<%--<jsp:useBean id="person" class="User"/>--%>
<%--<jsp:setProperty name="person" property="name" value="Victor"/>--%>
<%--<jsp:getProperty name="person" property="name"/>--%>

</body>
</html>
