<%@page import="com.ee.admin.model.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <div>
        <jsp:useBean id="Admin" class="com.ee.admin.model.Admin" scope="request"/>
        Hello <p><jsp:getProperty name="Admin" property="name"/> </p>
        <button id="logout" value="logout">Logout</button>
    </div>
</body>
</html>
<script>
    document.querySelector("#logout").addEventListener("click", ()=>{
        let xhr = new XMLHttpRequest();
        xhr.open("POST", 'admin/logout', true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if(xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                location.reload()
            }
        }
        xhr.send();
    })
</script>
