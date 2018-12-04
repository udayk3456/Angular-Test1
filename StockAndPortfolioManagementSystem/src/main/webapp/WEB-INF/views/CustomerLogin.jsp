<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerPage</title>
</head>
<body>
<%@include file="HomePage.jsp" %>
<div align="center">
<c:forEach items="${customers}" var="c">
<table>
<tr>
<td><a href="customer/${c.id}/home">${c.userName}:CustomerLogin</a></td>
</tr>
</table>
</c:forEach>
<a href="customerregister">CLICKHERE</a>ForRegistration
<br>
${msg}
</div>
</body>
</html>