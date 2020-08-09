<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<h1>Save Contact</h1>


<h3 style="color: green;">${sucmsg}</h3>
<h3 style="color: red;">${errmsg}</h3>

</head>

<link rel="stylesheet" href="/PhoneBook/css/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script src="/PhoneBook/js/form-validation.js"></script>

<script>
	$(document).ready(function(e) {
		$("#contactEmail").blur(function(event) {
			$("#dupEmail").html("");
			var emailId = $("#contactEmail").val();
			$.ajax({
				url : 'EmailVarify?email=' + emailId,
				success : function(abc) {
					if (abc == 'invalid') {
						$("#dupEmail").html("Email already registered");
						$("#contactEmail").focus();
					}
				}
			});
		});
	});
</script>


<body>


	<form:form action="savecontact" method="post" modelAttribute="contact"
		name="form">
		<table>
			<tr>
				<form:hidden path="contactId" />
				<td></
				<td>Name:</td>
				<td><form:input path="contactName" /> <form:errors
						path="contactName" /><span id="name" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="contactEmail" /> <form:errors
						path="contactEmail" /><span id="email" />
						<font color='red'>
							<div id="dupEmail"></div>
					</font>		
				</td>
						
						</td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><form:input path="contactNumber" /> <form:errors
						path="contactNumber" /><span id="number" /></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Save" name="submit" id="submit"></td>
			</tr>
		</table>
		<a href="viewAllContact">Get All Contacts</a>

	</form:form>


</body>
</html>

