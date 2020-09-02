<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Greeting Form</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "d-flex justify-content-md-center">
<table>
<tr>
<td>

<form class = "form-group" name="greetingForm" action="NameController" method="post" style= "margin-top:100px;">


	<label for = "name">Please enter your name :</label>
	<input class = "form-control" name="name" value='${nameForm.name}'/>
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