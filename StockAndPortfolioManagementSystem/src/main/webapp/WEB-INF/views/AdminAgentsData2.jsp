<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminPage</title>
<style type="text/css">
tr {
	background-color: white;
	text-align: center;
}

tr:nth-child(even) {
	background-color: azure;
}

tr:hover {
	background-color: aqua;
}

th {
	color: white;
	background-color: green;
}
/* td{
text-align:center;
} */
</style>
</head>
<body>
	<%@include file="AdminPage.jsp"%>
	<br>
	<div align="center">
		<c:choose>
			<c:when test="${!empty agents}">
				<table border="1" width="50%">
					<tr>
						<h4 style="color: purple;">
							<b>Agents List</b>
						</h4>
					</tr>
					<tr>
						<th>USERNAME</th>
						<th>FIRSTNAME</th>
						<th>LASTNAME</th>
						<th>ADDRESS</th>
						<th>MOBILE</th>
						<th>EMAIL</th>
						<th>OCCUPATION</th>
						<th>STATUS</th>
					</tr>
					<c:forEach items="${agents}" var="c">
						<tr>
							<td><c:out value="${c.userName }" /></td>
							<td><c:out value="${c.firstName}" /></td>
							<td><c:out value="${c.lastName }" /></td>
							<td><c:out value="${c.address }" /></td>
							<td><c:out value="${c.mobile }" /></td>
							<td><c:out value="${c.email }" /></td>
							<td><c:out value="${c.occupation }" /></td>
							<td><c:out value="${c.status}" /></td>
						</tr>
					</c:forEach>
				</table>
				<br>
			</c:when>
			<c:otherwise>
				<h3>No Content available</h3>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>