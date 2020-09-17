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
      <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
      <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<div class="logo">
		  <h1 class = "text-warning"><b>Cruise Ship Activity Co-ordination System</b></h1>
</div>
		
		<br>
  <h2 class="text-center" id="title">Welcome Coordinator</h2>
			 <p class="text-center">
				<small id="passwordHelpInline" class="text-muted"> HOME PAGE </small>
			</p>
      <ul class="nav nav-tabs">
      <li class = "active"><a data-toggle="tab" href="#eventssummaryform">View Events Summary</a></li>
      </ul>
      <br>
      <div class="tab-content">
      	<div id="home" class="tab-pane fade in active">
 <div id = "eventssummaryform" class ="form">     	
<form  action="">
<table>
<tr>
 <td><label for="Date">Event Date:</label></td> 
</tr>
<tr> 
<td><input class = "form-control"  name="eventdate" id="currentDate" value = "<c:out value='${sessionScope.currentdate}'/>" ></td>
<!-- <td> Validation for date here </td>-->
</tr>

<tr>
    <td>
        &nbsp;
       
    </td>
</tr>

<tr>
<td><label for="Time">Event Time:</label></td>
</tr>
<tr>
<td><input class ="form-control"  value = "<c:out value='${sessionScope.currenttime}'/>"></td>
<!-- <td> Validation for time here </td>-->
</tr>

</table>  
<br><br>	
   <button type="submit" class="btn btn-primary">Submit</button>
<br><br>
</form>
 </div>     
      	</div>
      
      </div>
      
      

 </div>
 </div>
 </body>
 </html>