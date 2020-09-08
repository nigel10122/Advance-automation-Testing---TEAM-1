<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login form</title>

</head>
<body>

<table>
  <tr>
   <td>
    <form action="<c:url value='/UserController?action=searchUser' />" method="post">
	<table style="width: 1200px; ">
	<tr>
	<tr>
  	<td> User name: </td>
 	<td> <input name="username" value="<c:out value='${user.username}'/>" class="text45">  </td>
  	<td> <input name="usernameError"  value="<c:out value='${errorMsgs.usernameError}'/>" class="errorMsg" readonly> </td>
	</tr>
    <tr>
    <td> Password: </td>
    <td> <input name="password" value="<c:out value='${user.password}'/>" type="password" class="text16"> </td>
  	<td> <input name="passwordError"  value="<c:out value='${errorMsgs.passwordError}'/>" class="errorMsg" readonly> </td>
    </tr>
</table>
    <input name="action" value="searchUser" type="hidden">
    <input type="submit" value="Log In">
	</form>  
</td>
</tr>
</table>
</body>
</html>