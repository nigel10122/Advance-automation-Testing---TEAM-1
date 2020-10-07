
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
   
    <li class="active"><a data-toggle="tab" href="#menu1">Modify Event</a></li>
   
  </ul>
  <br>




<div class = "boxshadow">
<h3>Manager Modify Event </h3>
<hr>
<form onsubmit="return confirm('Are you sure you want to Modify the Event?');" action="<c:url value='/ManagerModifyEvent?action=ModifyEvent&eventid=${EVENTS.eventid}' />" method="post">
<table style = "margin-left:35%;" class="padding-table-columns_reserverform"> 
    
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
    </tr>
    <tr>
    <td><select  class = "form-control"  name="eventname" required> 
    <option disabled value = "">Current Event : </option>
    <option><c:out value="${EVENTS.eventname}"/></option>
    <option disabled>--Change Event to :--</option>
    <option>Bowling 1</option>
    <option>Bowling 2</option>
    <option>Movie 1</option>
    <option>Movie 2</option>
    <option>Extreme Zipline</option>
    <option>Skycourse Ropes</option>
    <option>Ice Skating</option>
    <option>Go Karting</option>
    <option>Broadway Show</option>
    <option>Planetarium</option>
    </select>
    
     </td>
    </tr>
    <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
   <tr> 
   <td><label for = "eventdate"> Event Date :</label> </td>
   </tr>
   <tr>
   <td><input  class = "form-control" value = "<c:out value="${EVENTS.eventdate}" />" name="eventdate" required>   </td>
   </tr>
   <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
   
   <tr>
    <td><label for = "starttime"> Start Time:</label> </td>
    </tr>
    <tr>
    <td><input  class = "form-control" value = "<c:out value="${EVENTS.starttime}" /> " name="starttime" required>   </td>
    </tr>
        
 <tr>
    <td>
        &nbsp;
       
    </td>
</tr> 
    <tr>
    <td><label for = "duration"> Duration:</label> </td>
    </tr>
    <tr>
    <td><input  class = "form-control" value = "<c:out value="${EVENTS.duration}" /> " name="duration" required> </td> 
    </tr>
    
          <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
    
  <tr>
    <td><label for = "location"> Location:</label> </td>
    </tr>
    <tr>
      <td><input  class = "form-control" value = "<c:out value="${EVENTS.location}" /> " name="location" required>   </td>
      </tr>
      <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
<tr>
    <td> <label for = "numberofattendees">Number of Attendees :</label> </td>
    </tr>
    <tr>
    <td><input  class = "form-control" value = "<c:out value="${EVENTS.numberofattendees}"/>" name="numberofattendees"></td>  
    </tr>
  <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
  
   <tr>
    <td> <label for = "capacity">Capacity :</label> </td>
    </tr>
    <tr>
    <td><input  class = "form-control" value = "<c:out value="${EVENTS.capacity}" /> " name="capacity" required>   </td>
    </tr>
    <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
  
    <tr> 
    <td><label for = "eventcoordinator"> Event Coordinator :</label> </td>
    </tr>
    <tr>
    <td><select  class = "form-control" name="eventcoordinator" required>  
    <option disabled>-- Current Event Coordinator : --</option>
    <option><c:out value="${EVENTS.eventcoordinator}" /></option>
    <option disabled>-- Change Event Coordinator to : --</option>
   	<c:forEach items="${USERS}" var="item">
	<option><c:out value="${item.firstname}" /> <c:out value="${item.lastname}" /></option>
	</c:forEach>
	</select>	
     </td>
    </tr>
      <tr>
    <td>
        &nbsp;
       
    </td>
</tr> 

    
    <tr>
    <td> <label for = "type">Event Type : </label></td>
    </tr>
    <tr>
    <td> <select  class = "form-control" name="type" required> 
    <option disabled>-- Current Event Type : --</option>
    <option><c:out value="${EVENTS.type}" /></option>
    <option disabled>-- Change Event Type to --</option>
    <option>Show</option>
    <option>Athletic</option>
    </select>
     </td>
    </tr>
        <tr>
    <td>
        &nbsp;
       
    </td>
</tr>
    <tr>
    <td> <label for = "estattendees">Estimated Attendees :</label> </td>
    </tr>
    <tr>
    <td> <input class = "form-control" value = "<c:out value="${EVENTS.estattendees}" />" name="estattendees" required>  </td>
    </tr>
 
</table>
<br>
<input class="btn btn-default" type="submit" value="Modify Event">

</form>
<br>
<a><input style = "background-color: transparent;" type="button" value="Go back to Event List Page" onclick="history.back()"></a>
<br><br>
</div>



</div>
</body>
</html> 			
