<%@ page import="java.util.Date" %>
<%--<%@ page import="genericParam.FromOtherClass" %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MAIN JSP</title>
</head>
<body>
    <% %>
    <h2><%= "HEllO JSP" %></h2>
<%--    <h2>--%>
<%--        <%--%>
<%--            out.println("XA_XA_XA \n");--%>
<%--            Date now = new Date();--%>
<%--            String some = " ToDay is  - " + now ;--%>
<%--            FromOtherClass foClass = new FromOtherClass();--%>
<%--        %>--%>
<%--        <%= some %>--%>
<%--        <%= "</br>" %>--%>
<%--        <%= foClass.getInfo() %>--%>
<%--    </h2>--%>
    <%= "</br>" %>
    <form action="${pageContext.request.contextPath}/main" method="get">
        <label for="id"> Id:</label>
        <input type="text" id="id" name="id">
        <label for="name"> Name:</label>
        <input type="text" id="name" name="name">
        <label for="pass"> Password:</label>
        <input type="password" id="pass" name="pass">
        <input type="submit">
    </form>
    <button role="button"><a href="${pageContext.request.contextPath}/persons">Persons</a></button>


</body>
</html>
