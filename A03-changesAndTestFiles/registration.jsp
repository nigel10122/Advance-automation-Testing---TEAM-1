<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
          <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
  <body class = "body">

    
        <div class="main_container">
            <div class="box">
            
            <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Cruise Ship Activity Co-ordination System</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="registration.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<div class="logo">
		  <h1 class = "text-warning"><b>Cruise Ship Activity Co-ordination System</b></h1>
</div>
		
		<br>
  <h2 class="text-center" id="title">WELCOME</h2>
			 <p class="text-center">
				<small id="passwordHelpInline" class="text-muted">Log in. Not Registered ? Register Now. </small>
			</p>
 			<hr>
<div class = "Registrationform">
	 <h3>	Register Account</h3>
<form action="RegisterServlet" method="post">
                   <p class = "errorPane"><c:out value='${sessionScope.namecombinationError}'/></p>
<table class="padding-table-columns">
<tr>
<td><input class = "form-control" type="text" placeholder="Username" name="username" required></td>
<td><p class = "errorPane"><c:out value='${sessionScope.usernameError}'/></p></td>

</tr>
                       <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
<tr>
<td><input class = "form-control" type="password" placeholder="Password" name="password" required></td>
<td><p class = "errorPane"><c:out value='${sessionScope.passwordError}'/></p></td>
</tr>
                       <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
<tr>
<td><input class = "form-control" type="text" placeholder="Lastname" name="lastname" required></td>
<td><p class = "errorPane"><c:out value='${sessionScope.lastnameError}'/></p></td>
</tr>
                       <tr>
    <td>
        &nbsp;
       
    </td>
</tr>

<tr>
<td><input class = "form-control" type="text" placeholder="Firstname" name="firstname" required></td>
<td><p class = "errorPane"><c:out value='${sessionScope.firstnameError}'/></p></td>
</tr>
                       <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
<tr>
<td><input class = "form-control" type="text" placeholder="Email" name="email" required></td>
<td><p class = "errorPane"><c:out value='${sessionScope.emailError}'/></p></td>
</tr>
                       <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
<tr>
<td><input class = "form-control" type="number" placeholder="Number" name="number" required></td>
<td><p class = "errorPane"><c:out value='${sessionScope.numberError}'/></p></td>
</tr>
                       <tr>
    <td>
        &nbsp;
       
    </td>
</tr>

<tr>
<td><input class = "form-control" placeholder="Roomnumber" name="roomnumber" required></td>
<td><p class = "errorPane"><c:out value='${sessionScope.roomnumberError}'/></p></td>
</tr>
                       <tr>
    <td>
        &nbsp;
       
    </td>
</tr>

<tr>
<td><input class = "form-control" placeholder="Decknumber" name="decknumber" required></td>
<td><p class = "errorPane"><c:out value='${sessionScope.decknumberError}'/></p></td>
                     <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
<tr>
<td><select class = "form-control" name="membership" required>
	<option>None</option>
	<option>Standard</option>
	<option>Superior</option>
	<option>Premium</option> 
	</select></td>
</table>
<br>

                   <input class="btn btn-default" type="submit" value="Register">
                   <br>
                   <br>
                   <a href="index.jsp">Already have Account?</a>
                </form>
</div>
</div>
</div>
</body>
</html>