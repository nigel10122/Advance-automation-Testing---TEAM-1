<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up form</title>
<link href="style.css" rel="stylesheet" type="text/css" />

</head>
<body>

<input name="errMsg"  id="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" class="errorPane">
<input name="errMsg"  id="errMsg" value="<c:out value='${errorMsgs.nameCombinationError}'/>" class="errorPane">

<table>
  <tr>
   <td>
    <form name="signupForm" action="<c:url value='/UserController?saveUser' />" method="post">
    <table align="center">
         <tr>
         <td>first name</td>
         <td><input name="firstname" value="<c:out value='${user.firstname}'/>"/></td>
         <td> <input name="firstname"  value="<c:out value='${errorMsgs.firstnameError}'/>" class="errorMsg" readonly> </td>
         
         </tr>
         <tr>
         <td>last name</td>
         <td><input name="lastname" value="<c:out value='${user.lastname}'/>"/></td>
         <td> <input name="lastname"  value="<c:out value='${errorMsgs.lastnameError}'/>" class="errorMsg" readonly> </td>
         
         
         </tr>
         <tr>
         <td>phone</td>
         <td><input  name="phone" value="<c:out value='${user.phone}'/>"/></td>
         <td> <input name="phone"  value="<c:out value='${errorMsgs.phoneError}'/>" class="errorMsg" readonly> </td>
         </tr>
         <tr>
         <td>user name</td>
         <td><input  name="username" value="<c:out value='${user.username}'/>"/></td>
         <td> <input name="username"  value="<c:out value='${errorMsgs.usernameError}'/>" class="errorMsg" readonly> </td>
         </tr>
          <tr>
         <td>email</td>
         <td><input name="email" value="<c:out value='${user.email}'/>"/></td>
         <td> <input name="email"  value="<c:out value='${errorMsgs.emailError}'/>" class="errorMsg" readonly> </td>
         </tr>
         <tr>
         <td>password</td>
         <td><input type="password" name="password" value="<c:out value='${user.password}'/>"/></td>
         <td> <input name="password"  value="<c:out value='${errorMsgs.passwordError}'/>" class="errorMsg" readonly> </td>
         
         </tr>
         <tr>
         <td>room number</td>
         <td><input  name="roomnumber" value="<c:out value='${user.roomnumber}'/>"/></td>
         <td> <input name="roomnumber"  value="<c:out value='${errorMsgs.roomnumberError}'/>" class="errorMsg" readonly> </td>
         
         </tr>
         <tr>
         <td>deck number</td>
         <td><input  name="decknumber" value="<c:out value='${user.decknumber}'/>"/></td>
         <td> <input name="decknumber"  value="<c:out value='${errorMsgs.decknumberError}'/>" class="errorMsg" readonly> </td>
         
         </tr>
         <tr>
         <td>membership type</td>
         <td>
         <select id="membershiptype" name="membershiptype">
         	  <option value="none">none</option>
			  <option value="standard">Standard</option>
			  <option value="superior">superior</option>
			  <option value="premium">premium</option>
		</select>
		</td>
        </tr>

        </table>
   
    <input name="action" value="saveUser" type="hidden">
    <input type="submit" value="Insert User" onclick="myFunction()" >
    
    <script>
		function myFunction() {
			
			alert("Proceed with registration?")
  					
  				
		}
		
	</script>
    
    </form>
    
</td>
</tr>
</table>

</body>
</html>