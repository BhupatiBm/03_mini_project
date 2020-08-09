<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
<link rel="./css/loginForm.css">
</head>
<body>
	<h1 class="header">BIT Tech.Nic</h1>
	<h2 style="color: green">User LogIn</h2>
	<h3 style="color: red">${errMsg}</h3>
	<form:form method="POST" modelAttribute="userLogin" action="loginUser">
		<table>
			<tr>
				<td>Email:</td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="pasword" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="LogIn"></td>
			</tr>
			<tr>
				<td><a href="./forgotPassword">ForgotPassword</a>&nbsp;&nbsp;&nbsp;
				</td>
				<td><a href="./userReg">SignUp</a></td>
			<tr>
		</table>
	</form:form>
	<div class="footer">
		<p>&copy;by BIT Tech.Nic</p>
	</div>
</body>
</html>