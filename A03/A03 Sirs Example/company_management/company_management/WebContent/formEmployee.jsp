<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="myStyle.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<input name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" class="errorPane">
<table>
 <tr>
 <td>
 <form name="employeeForm" action="<c:url value='/EmployeeController' />" method="post">
 <table>
 <tr>
 <td> Employee ID (*): </td>
 <td>
 <input name="idemployee" value="<c:out value='${employee.idemployee}'/>" class="text16"> 
 	<td> <input name="employeeIDerror" value="<c:out value='${errorMsgs.employeeIDerror}'/>" class="errorMsg"> </td>
 </tr>
 <tr>
 <td> First Name (*): </td>
 <td>
 <input name="name" value="<c:out value='${employee.name}'/>" class="text45"> 
 	<td> <input name="firstNameError" value="<c:out value='${errorMsgs.firstNameError}'/>" class="errorMsg"> </td>
 </tr>
 <tr>
 <td> Last Name (*): </td>
 <td>
 <input name="surname" value="<c:out value='${employee.surname}'/>" class="text45"> 
 	<td> <input name="lastNameError" value="<c:out value='${errorMsgs.lastNameError}'/>" class="errorMsg"> </td>
 </tr>
 <tr>
 <td> Company Badge (*): </td>
 <td>
 <input name="badge" value="<c:out value='${employee.badge}'/>" class="text5"> 
 	<td> <input name="companyBadgeError" value="<c:out value='${errorMsgs.companyBadgeError}'/>" class="errorMsg"> </td>
 </tr>
 <tr>
 <td colspan="2">(*) Mandatory field</td>
 </tr>
 </table>
 <input name="action" value="insertEmployee" type="hidden">
	<input name="insertEmpbutton" type="submit" value="insertEmployee">
	<input name="doneButton" type="submit" value="Done">
				</form>
</td>
</tr>
</table>
</body>
</html>