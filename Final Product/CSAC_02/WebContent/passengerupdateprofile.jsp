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
            <li class="active"><a data-toggle="tab" href="#home">Update Profile</a></li>

         </ul>
         <br>
         
               <!-- action="<c:url value='/PassengerUpdateProfile?action=UpdateProfile&id=${sessionScope.id}' />" -->
               <div class ="boxshadow">
               <h3>UPDATE PROFILE</h3>
               <hr>
                  <form onsubmit="return confirm('Are you sure you want to Update your Profie ?');" action="PassengerUpdateProfile"  method="post">
                     <p>
                     <table class="padding-table-columns" style = "margin-left:280px;">
                       <!--  <tr>
                           <td><label for="id">UserID:</label></td>
                        </tr>
                        <tr>
                           <td><input class = "form-control" value="<c:out value='${sessionScope.id}'/>" name="id" required></td>
                           <td>
                              <p class = "errorPane"></p>
                           </td>
                        </tr>-->
                          <tr>
                           <td>
                              &nbsp;
                           </td>
                        </tr>
                          <tr>
                           <td><label for="username">Username:</label></td>
                        </tr>
                        <tr>
                           <td><input class = "form-control"  value="<c:out value='${sessionScope.username}'/>" name="username"></td>
                           <td>
                              <p class = "errorPane"><c:out value='${sessionScope.usernameError}'/></p>
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
                           <td><input class = "form-control"  value="<c:out value='${sessionScope.password}'/>" name="password"></td>
                           <td>
                              <p class = "errorPane"><c:out value='${sessionScope.passwordError}'/></p>
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
                           <td><input class = "form-control"  value="<c:out value='${sessionScope.lastname}'/>" name="lastname"></td>
                           <td>
                              <p class = "errorPane"><c:out value='${sessionScope.lastnameError}'/></p>
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
                           <td><input class = "form-control" value="<c:out value='${sessionScope.firstname}'/>" name="firstname"></td>
                           <td>
                              <p class = "errorPane"><c:out value='${sessionScope.firstnameError}'/></p>
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
                           <td><input class = "form-control"  value="<c:out value='${sessionScope.email}'/>" name="email"></td>
                           <td>
                              <p class = "errorPane"><c:out value='${sessionScope.emailError}'/></p>
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
                           <td><input class = "form-control"  value="<c:out value='${sessionScope.number}'/>" name="number"></td>
                           <td>
                              <p class = "errorPane"><c:out value='${sessionScope.numberError}'/></p>
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
                           <td><input class = "form-control"  value="<c:out value='${sessionScope.roomnumber}'/>" name="roomnumber"></td>
                           <td>
                              <p class = "errorPane"><c:out value='${sessionScope.roomnumberError}'/></p>
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
                           <td><input class = "form-control"  value="<c:out value='${sessionScope.decknumber}'/>" name="decknumber"></td>
                           <td>
                              <p class = "errorPane"><c:out value='${sessionScope.decknumberError}'/></p>
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
                              <select class = "form-control" name="membership"  required>
                                 <option disabled>--Current Membership:--</option> 
                                 <option><c:out value='${sessionScope.membership}'/></option>
                                 <option disabled>-- CHANGE MEMBERSHIP TO--</option>
                                 <option>None</option>
                                 <option>Standard</option>
                                 <option>Superior</option>
                                 <option>Premium</option>
                              </select>
                           </td>
                     </table>
                     <br>
                     <input class="btn btn-default" type="submit" value="Update">
                  </form>
                  <br>
                  <a href = "welcome.jsp">Go back to Home Page</a>
               </div>
 
   </div>
   </body>
</html>