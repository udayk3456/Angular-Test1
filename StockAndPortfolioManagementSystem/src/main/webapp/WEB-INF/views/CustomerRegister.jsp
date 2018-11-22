<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerPage</title>
</head>
<body>
<%@include file="HomePage.jsp" %>
<div align="center">
<h3 style="color:green;">CustomerRegistration</h3>
<table>
<form:form action="" method="post" modelAttribute="customer">
<tr><td>UserName :</td><td><form:input path="userName"/></td></tr>
<tr><td>Password :</td><td><form:input path="password"/></td></tr>
<tr><td>FirstName :</td><td><form:input path="firstName"/></td></tr>
<tr><td>LastName :</td><td><form:input path="lastName"/></td></tr>
<tr><td>DateOfBirth :</td><td><form:input path="dob"/></td></tr>
<tr><td>Address :</td><td><form:input path="address"/></td></tr>
<tr><td>MobileNumber :</td><td><form:input path="mobile"/></td></tr>
<tr><td>Email :</td><td><form:input path="email"/></td></tr>
<input type="submit" value="Create Customer">
</form:form>
</table>
</div>
</body>
</html>