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
                  <li>
                     <a href="#">
                        <span class="glyphicon glyphicon-user"></span> 
                        <c:out value='${sessionScope.firstname}'/>
                     </a>
                  </li>
                  <li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
               </ul>
            </div>
         </nav>
         <div class="logo">
            <h1 class = "text-warning"><b>Cruise Ship Activity Co-ordination System</b></h1>
         </div>
         <br>
        <h2 class="text-center" id="title">
            Welcome, 
            <c:out value='${sessionScope.firstname}'/>
         </h2>
         <p class="text-center">
            <small id="passwordHelpInline" class="text-muted"> HOME PAGE </small>
         </p>
         <ul class="nav nav-tabs">
            <li ><a data-toggle="tab" href="#home">View Passenger Event Summary</a></li>
            <li class="active"><a data-toggle="tab" href="#menu1">List All Events</a></li>
            <li><a data-toggle="tab" href="#menu2">View Profile</a></li>
         </ul>
         <br>
         <div class="tab-content">
            <div id="home" class="tab-pane fade form boxshadow">
            <h3>View Reserved Events</h3>
            <hr>
             <form  action="EventServlet" method="post">
                        <table class="padding-table-columns" style = "margin-left:300px;">
                           <tr>
                              <td><label for="Date">Event Date:</label></td>
                           </tr>
                           <tr>
                              <td><input class = "form-control"  name="eventdate" id="currentDate" value = "<c:out value='${sessionScope.currentdate}'/>" ></td>
                             <td><p class = "errorPane"><c:out value='${sessionScope.eventdateError}'/></p></td>
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
                              <td><input class ="form-control"  name = "starttime" value = "<c:out value='${sessionScope.currenttime}'/>"></td>
                              <td><p class = "errorPane"><c:out value='${sessionScope.eventtimeError}'/></p></td>
                           </tr>
                        </table>
                        <br><br>	
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <br><br>
                     </form>
                  
                  </div>
                  
              
               <div id="menu1" class="tab-pane fade in active form boxshadow">
               <h3>Search for Events</h3>
               <hr>
                  <form  action="PassengerEventTypeServlet">
                     <table class="padding-table-columns" style = "margin-left:300px;">
                        <tr>
                           <td><label for="Date">Event Date:</label></td>
                        </tr>
                        <tr>
                           <td><input class = "form-control" name="eventdate" id="currentDate" value = "<c:out value='${sessionScope.currentdate}'/>" ></td>
                           <td><p class = "errorPane"><c:out value='${sessionScope.eventdateError}'/></p></td>
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
                           <td><input class ="form-control" name = "starttime" value = "<c:out value='${sessionScope.currenttime}'/>"></td>
                           <td><p class = "errorPane"><c:out value='${sessionScope.eventtimeError}'/></p></td>
                        </tr>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="Event">Event Type:</label></td>
                        </tr>
                        <tr>
                           <td>
                              <select name = "type" class ="form-control">
                                 <option> Show </option>
                                 <option> Athletic </option>
                              </select>
                           </td>
                           
                        </tr>
                     </table>
                     <br><br>	
                     <button type="submit" class="btn btn-primary">Submit</button>
                     <br><br>
                  </form>
               </div>
               
               <div id="menu2" class="tab-pane fade form boxshadow">
               <h3>PROFILE</h3>
               <hr>
                  <form method="get" action="passengerupdateprofile.jsp">
                     <p>
                     <table class="padding-table-columns" style = "margin-left:280px;">
                        <tr>
                           <td><label for="username">Username:</label></td>
                        </tr>
                        <tr>
                           <td><input disabled class = "form-control" type="text" value="<c:out value='${sessionScope.username}'/>" name="username" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="password">Password:</label></td>
                        </tr>
                        <tr>
                           <td><input disabled class = "form-control" type="password" value="<c:out value='${sessionScope.password}'/>" name="password" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="lastname">Lastname:</label></td>
                        </tr>
                        <tr>
                           <td><input disabled class = "form-control" type="text" value="<c:out value='${sessionScope.lastname}'/>" name="lastname" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="firstname">Firstname:</label></td>
                        </tr>
                        <tr>
                           <td><input disabled class = "form-control" type="text" value="<c:out value='${sessionScope.firstname}'/>" name="firstname" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="email">Email:</label></td>
                        </tr>
                        <tr>
                           <td><input disabled class = "form-control" type="text" value="<c:out value='${sessionScope.email}'/>" name="email" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="number">Number:</label></td>
                        </tr>
                        <tr>
                           <td><input disabled class = "form-control" type="number" value="<c:out value='${sessionScope.number}'/>" name="number" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="roomnumber">Roomnumber:</label></td>
                        </tr>
                        <tr>
                           <td><input disabled class = "form-control" type="number" value="<c:out value='${sessionScope.roomnumber}'/>" name="roomnumber" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        </tr>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="decknumber">Decknumber:</label></td>
                        </tr>
                        <tr>
                           <td><input disabled class = "form-control" type="number" value="<c:out value='${sessionScope.decknumber}'/>" name="decknumber" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                        <tr>
                           <td><label for="membership">Membership :</label></td>
                        </tr>
                        <tr>
                           <td>
                              <select disabled class = "form-control" name="membership"  required>
                                 <option>
                                    Current Membership: 
                                    <c:out value='${sessionScope.membership}'/>
                                 </option>
                                 <option disabled>-- CHANGE MEMBERSHIP--</option>
                                 <option>None</option>
                                 <option>Standard</option>
                                 <option>Superior</option>
                                 <option>Premium</option>
                              </select>
                           </td>
                     </table>
                     <br>
                     <input class="btn btn-default" type="submit" value="Update Profile">
                  </form>
                  <br><br>
               </div>
            </div>
         </div>
   
   </body>
</html>