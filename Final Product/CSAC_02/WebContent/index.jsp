<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Join Us</title>
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
			 <h4 class="text-center">
				   <c:out value='${sessionScope.registrationsuccessmessage}'/>
			</h4>
 			<hr>
                
 <div class = "boxshadow">               
<h3>Login Account</h3>
<hr>
<form action="LoginServlet" method="post">
   					<p class = "errorPane"><c:out value='${sessionScope.InvalidError}'/></p>
<table style = "margin-left:41.5%;" class="padding-table-columns">                    
<tr>
<td><input class = "form-control row1" type="text" placeholder="Username" name="username" required style = "width : 130px;"></td>
<td><p class = "errorPane"><c:out value='${sessionScope.usernameError}'/></p></td>
</tr>
    <tr>
    <td>
        &nbsp;
       
    </td>
</tr>            
<tr>
<td><input class="form-control row2" type="password" placeholder="Password" name="password" required style = "width : 130px;"></td>
<td><p class = "errorPane"><c:out value='${sessionScope.passwordError}'/></p></td>
</tr>
</table>
<br>

                    <input class="btn btn-default" type="submit" value="Login">
           			<br>
           			<br>
                    <a href="registration.jsp">Create New Account</a>
                </form>

<br>
            

  </div>              
</div>
</div>
</body>
</html>
