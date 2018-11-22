<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h3 style="color:Blue;">Add Company</h3>
<br>
<form:form action="insertcompany" method="post" modelAttribute="company">
<pre>
CompanyName  : <form:input path="companyName"/>
CompanySymbol: <form:input path="companySymbol"/>

<input type="submit" value="AddCompany">
</pre>
</form:form>
${msg}
</div>
</body>
</html>