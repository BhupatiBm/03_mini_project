<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<h1>Unlock Your Account</h1>
<h3 style="color: red">${errMsg}</h3> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function validatePassword(){
	alert("funCalled");
	var newPass=$('#newPassword').val();
	var cnfPass=$('#confirmPassword').val();
	if(cnfPass!=newPass){
		$('#errId').text('new password and confirm password must be same');
		return false;
		}
	return true;
	}
</script>
</head>
<body>
	<form:form action="unlockUserAccount" modelAttribute="UnlockAcc" method="POST" >
		<table>
			<font color='red'> <span id='errId'/> </font>
			<tr>
				<td>Mail Id:</td>
				<td><form:input path="email"  readonly="true"/></td>
			</tr>
			<tr>
				<td>Temporary Password:</td>
				<td><form:input path="temporaryPassword"/></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td> <form:input path="newPassword"/><td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td> <form:input path="confirmPassword"/><td>
				
			</tr>
			<tr>
				<td> <input type="submit" value="Submitte" onclick="javascript:return validatePassword()" > </td>
			</tr>

		</table>
	</form:form>

</body>
</html>