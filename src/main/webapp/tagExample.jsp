<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" uri="http://bnv.su" %>
<%@ taglib prefix="tag2" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Tags </title>
</head>
<body>
Hello Tag Example
<br>
<%--<tag:MyTag name="XAZA"/>--%>
<%--    <tag:InnerTag>TAK</tag:InnerTag>--%>
<br>
Function included
<b> ${tag:minus(100, 50)} </b>
<br>
Included Attribute from Context ${nameFromAttribute}
<tag2:simpleTag name="Vic" >AAAAAAAAA</tag2:simpleTag>

</body>
</html>
