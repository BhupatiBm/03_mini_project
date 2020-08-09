<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<h1>Save Contact</h1>


<h3 style="color: green;">${sucmsg}</h3>
<h3 style="color: red;">${errmsg}</h3>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="./js/ajax.js"></script>
</head>
<body>


	<form:form action="saveUSerDtls" method="post" modelAttribute="UserAcc"
		name="form">
		<table>
			<form:hidden path="UserId" />
			<tr>
				<td>FirstName:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="emailId" /> 
					<font color='red'>
						<div id="dupEmail"></div>
					</font></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>Male: <form:radiobutton path="gender"  value="M"/>
				    &nbsp; &nbsp; Female:<form:radiobutton path="gender" value="F"/></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td> <form:input path="dob" id="datepicker"  /></td>
			</tr>

 			<tr>
 				<td>Country:</td>
 				<td>
 					<form:select path="countryId">
 					<form:option value="">--Select--</form:option>
 					<form:options items="${AllCountry}" />
 					</form:select>
 				</td>
 			</tr> 
 			<tr>
 				<td>State:</td>
 				<td>
 					<form:select path="stateId">
 					<form:option value="">--Select--</form:option>
 					</form:select>
 				</td>
 			</tr>
 			<tr>
 				<td>City:</td>
 				<td> <form:select path="cityId">
 					<form:option value="">--Select--</form:option>
 					</form:select> 
 				</td>
 			</tr> 
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Save" name="submit" id="submit"></td>
			</tr>
		</table>
	</form:form>


</body>
</html>

