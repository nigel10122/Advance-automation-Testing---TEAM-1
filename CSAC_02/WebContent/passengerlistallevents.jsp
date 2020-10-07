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
   
    <li class="active"><a data-toggle="tab" href="#menu1">List All Events</a></li>
    
  </ul>

<br>
<div class = "boxshadow">
<h3> Available Events </h3>
<hr>
 <form action="PassengerReserveEventform" method="post">         
       <table class="table  table-hover table-dark"> 
			<tr> 
				
				<th>Event Name</th>
				<th>Event Date</th> 
				<th>Start Time</th>
				<th>Duration</th> 
				<th>Location</th>
				<th>Estimated Attendees</th>
				<th>View Selected Event</th>

				
			</tr>

 		<c:forEach items="${EVENTS}" var="item" varStatus="status">
			<tr>
				
			<td><c:out value="${item.eventname}" /></td>
			<td><c:out value="${item.eventdate}" /></td>
			<td><c:out value="${item.starttime}" /></td>
			<td><c:out value="${item.duration}" /></td>
			<td><c:out value="${item.location}" /></td>
			<td><c:out value="${item.estattendees}" /></td>
         	<td><b><i><a href="<c:url value='/PassengerReserveEventform?action=listSpecificCompany&eventid=${item.eventid}' />">View</a></i></b></td>
			</tr>
		</c:forEach>
 </table>

 </form>
 <br>
<a href = "welcome.jsp">Go back to Home Page</a>
</div>



</div>
</body>
</html> 			
