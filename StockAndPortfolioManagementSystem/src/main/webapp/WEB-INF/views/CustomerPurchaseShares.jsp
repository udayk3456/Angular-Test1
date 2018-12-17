<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerPage</title>
</head>
<body>
	<%@include file="CustomerPage.jsp"%>
	<div align="center">
		<table style="background-color: white">
			<form:form action="purchasesave" method="post" modelAttribute="purchase">
				<tr>
					<td>CustomerName</td>
					<td>:<form:select path="customer.id">
							<form:options items="${customers}" itemLabel="userName"
								itemValue="id" />
						</form:select></td>
				</tr>
				<tr>
					<td>Symbol</td>
					<td>:<form:select path="company.id">
							<form:options items="${companies}" itemLabel="companySymbol"
								itemValue="id" />
						</form:select></td>
				</tr>
				<tr>
					<td>No.of shares</td>
					<td>:<form:input path="company.companyShare.sharesAvailable.sharesPurchased" /></td>
				</tr>
				<form:hidden path="totalCost"/>
				<tr>
					<td>TermValidity</td>
					<td>:<form:select path="termValidity.id" > <form:options
							items="${termvalidity}" itemLabel="termValidity" itemValue="id" />
					</form:select>
					</td>
				</tr>
				<tr>
					<td>OrderType</td>
					<td>:<form:select path="orderType.id"> <form:options
							items="${ordertype}" itemLabel="orderType" itemValue="id" />
					</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="preview order"></td>
				</tr>
			</form:form>
		</table>
		${msg }
	</div>
</body>
</html>