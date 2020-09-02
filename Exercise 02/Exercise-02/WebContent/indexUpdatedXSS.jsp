<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Greeting Form</title>
</head>
<body style="width: 450px; ">
<div class = "d-flex justify-content-md-center">
<table>
<tr>
<td>

<form class = "form-group" name="greetingForm" action="NameController" method="post" style= "margin-top:100px;">


	<label for = "name">Please enter your name :</label>
	<input class = "form-control" name="name" value=<c:out value='${nameForm.name}'/>/>
	<br>
	<label for = "id">Please enter your Student ID :</label>
	<input class = "form-control" name="id"/>
	<br>
	<input class = "btn btn-primary"  type="submit" value="Submit">
</form>
<br>
<tr><td><input id="greetingField" value='${nameForm.greetingText}' style ="background-color: white; border: none; width: 400px;" disabled="disabled" /></td></tr>
<tr><td><input id="greetingField1" value= "Student id number : <%= session.getAttribute("id") %>" style ="background-color: white; border: none; width: 400px;" disabled="disabled" /></td></tr>
<tr><td><input id="currentTime" value='${nameForm.currentTime}' style ="background-color: white; border: none; width: 400px;" disabled="disabled" /></td></tr>

</table>
</div>
</body>
</html>

