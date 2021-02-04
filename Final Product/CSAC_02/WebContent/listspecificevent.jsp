
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
         
            
            <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Cruise Ship Activity Co-ordination System</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> <c:out value='${sessionScope.firstname}'/> </a></li>
      <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
<div class="logo">
		  <h1 class = "text-warning"><b>Cruise Ship Activity Co-ordination System</b></h1>
</div>
		
		<br>
  <h2 class="text-center" id="title">Welcome, <c:out value='${sessionScope.firstname}'/></h2>
			 <p class="text-center">
				<small id="passwordHelpInline" class="text-muted"> HOME PAGE </small>
			</p>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Selected Event Details</a></li>

  </ul>
  <br>

  




<div class = "boxshadow_alternate">
<h3> Selected Event Details</h3>
<hr>

<table class="table-alignment"> 
 
    <tr> 
    <td class = "table-headers"> Event ID: </td>
    <td class = "table-data"> <c:out value="${EVENTS.eventid}" /> </td>
    </tr>

    <tr>
    <td class = "table-headers"> Event Name : </td>
    <td class = "table-data"> <c:out value="${EVENTS.eventname}"/> </td>
    </tr>

    <tr>
    <td class = "table-headers"> Event Date : </td>
    <td class = "table-data"> <c:out value="${EVENTS.eventdate}" /> </td>
    </tr>

    <tr>
    <td class = "table-headers"> Start Time: </td>
    <td class = "table-data"> <c:out value="${EVENTS.starttime}" /> </td>
    </tr>
    
    <tr>
    <td class = "table-headers"> Duration: </td>
    <td class = "table-data"> <c:out value="${EVENTS.duration}" /> </td>
    </tr>
    
       <tr>
    <td class = "table-headers"> Location: </td>
    <td class = "table-data"> <c:out value="${EVENTS.location}" /> </td>
    </tr>

    <tr>
    <td class = "table-headers"> Number of Attendees : </td>
    <td class = "table-data"> <c:out value="${EVENTS.numberofattendees}"/> </td>
    </tr>

    <tr>
    <td class = "table-headers"> Capacity : </td>
    <td class = "table-data"> <c:out value="${EVENTS.capacity}" /> </td>
    </tr>

    <tr>
    <td class = "table-headers"> Event Coordinator : </td>
    <td class = "table-data"> <c:out value="${EVENTS.eventcoordinator}" /> </td>
    </tr>
    
    <tr>
    <td class = "table-headers"> Event Type : </td>
    <td class = "table-data"> <c:out value="${EVENTS.type}" /> </td>
    </tr>
    
    <tr>
    <td class = "table-headers"> Estimated Attendees : </td>
    <td class = "table-data"> <c:out value="${EVENTS.estattendees}" /> </td>
    </tr>


</table>
<br>
<form>
<a><input style = "background-color: transparent;" type="button" value="Go back to Event Summary page" onclick="history.back()"></a>
</form>
</div>


</div>
</body>
</html> 			