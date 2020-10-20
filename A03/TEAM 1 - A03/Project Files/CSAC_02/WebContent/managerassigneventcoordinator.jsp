
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
  <h2 class="text-center" id="title">Welcome <c:out value="${sessionScope.firstname} ${sessionScope.lastname} " /></h2>
			 <div class="text-center">
				<h4 id="passwordHelpInline" class="text-muted"> MANAGER HOME PAGE </h4>
			</div>
  <ul class="nav nav-tabs">
   
    <li class="active"><a data-toggle="tab" href="#menu1">Assign Event Coordinator</a></li>
   
  </ul>
  <br>




<div class = "boxshadow">
<h3>Assign Event Coordinator </h3>
<hr>
<form onsubmit="return confirm('Are you sure you want to Assign this Coordinator to the Event?');" action="<c:url value='/ManagerAssignCoordinator?action=AssignCoordinator&eventid=${EVENTS.eventid}' />" method="post">
<table style = "margin-left:85px;" class="padding-table-columns_reserverform"> 
    
<!-- <tr><td><label for = "eventid"> Event ID: </label></td></tr>
    <tr><td><input class = "form-control" value = " <c:out value="${EVENTS.eventid}" /> ">  </td>
    </tr>
<tr>
    <td>
        &nbsp;
       
    </td>
</tr> -->

   
    <tr>
    <td><label for = "eventname"> Event Name :</label> </td>
    <td><label for = "eventdate"> Event Date :</label> </td>
    <td><label for = "starttime"> Start Time:</label> </td>
    </tr>
   <tr> 
   <td><input disabled  class = "form-control" value = " <c:out value="${EVENTS.eventname}"/>" name="eventname" required>  </td>
   <td><input disabled class = "form-control" value = " <c:out value="${EVENTS.eventdate}" />" name="eventdate" required>   </td>
   <td><input disabled class = "form-control" value = "<c:out value="${EVENTS.starttime}" /> " name="starttime" required>   </td>
   </tr>
<tr>
    <td>
        &nbsp;
       
    </td>
</tr>
   


    <tr>
    <td><label for = "duration"> Duration:</label> </td>
    <td><label for = "location"> Location:</label> </td>
    <td> <label for = "numberofattendees">Number of Attendees :</label> </td>
    </tr>
    <tr>
  	<td><input disabled  class = "form-control" value = "<c:out value="${EVENTS.duration}" /> " name="duration" required> </td> 
    <td><input disabled  class = "form-control" value = "<c:out value="${EVENTS.location}" /> " name="location" required>  
    <td><input disabled  class = "form-control" value = " <c:out value="${EVENTS.numberofattendees}"/>" name="numberofattendees">
    </tr>
 <tr>
    <td>
        &nbsp;
       
    </td>
</tr>   

    <tr>
    <td> <label for = "capacity">Capacity :</label> </td>
    <td> <label for = "type">Event Type : </label></td>
    <td> <label for = "estattendees">Estimated Attendees :</label> </td>
 	</tr>
    <tr>
    <td><input disabled  class = "form-control" value = "<c:out value="${EVENTS.capacity}" /> " name="capacity" required>   </td>
    <td> <input disabled  class = "form-control" value = " <c:out value="${EVENTS.type}" />" name="type" required>  </td>
    <td> <input disabled class = "form-control" value = " <c:out value="${EVENTS.estattendees}" />" name="estattendees" required>  </td>
    </tr>
<tr>
    <td><hr></td>
    <td><hr></td>
    <td><hr></td>
</tr>

<tr>
<td>&nbsp;</td>
<td><label for = "eventcoordinator"> Event Coordinator :</label> </td>
<td>&nbsp;</td>
</tr>
<tr>
<td>&nbsp;</td>

<td>
<b>

<select  class = "form-control" name="eventcoordinator" required>
	<option disabled>-- Current Event Coordinator : --</option>
	<option><c:out value="${EVENTS.eventcoordinator}" /></option>
	<option disabled>-- Assign New Event Coordinator : --</option>
	<c:forEach items="${USERS}" var="item">
	<option><c:out value="${item.firstname}" /> <c:out value="${item.lastname}" /></option>
	</c:forEach>		
</select>
   
</b>
</td>	
<td><p class = "errorPane"><c:out value='${sessionScope.coordinatorerrormsg}'/></p></td>
</tr>

 
</table>
<br>
<input class="btn btn-default" type="submit" value="Assign Coordinator">

</form>
<br>
<a><input style = "background-color: transparent;" type="button" value="Go back to Event List Page" onclick="history.back()"></a>
</div>



</div>
</body>
</html> 			
