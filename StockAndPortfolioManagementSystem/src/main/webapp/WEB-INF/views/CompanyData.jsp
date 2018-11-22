<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminPage</title>
</head>
<body>
<%@include file="AdminPage.jsp" %>
<br>
<div align="center">
<table border="1">
<tr>
<th>COMPANY NAME</th>
<th>COMPANY SYMBOL</th>
</tr>
<c:forEach items="${companies}" var="c">
<tr>
<td><c:out value="${c.companyName }" /></td>
<td><c:out value="${c.companySymbol }" /></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>