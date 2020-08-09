<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1>ForgotPassword</h1>
<h3 style="color: red">${errMsg}</h3>
<h3 style="color: green">${succMsg}</h3>
</head>
<body>
<form:form method="get" action="performForgotPassword" modelAttribute="userForgotPassword">
	<table>
		<tr>
			<td>Registered Email:</td>
			<td> <form:input path="emailId"/></td>
		</tr>
		<tr>
			<td> <input type="submit" value="send sms"> </td>
		</tr>
	</table>

</form:form>
</body>
</html>