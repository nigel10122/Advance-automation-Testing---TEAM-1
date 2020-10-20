<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Companies List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link href="myStyle.css" rel="stylesheet" type="text/css" />
<body>
      <div class="logo"><h1><a href="<c:url value='/' />">Company Management Application</a></h1></div>
      <div class="menu_nav">
  </div>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" class="errorPane">
<table>
<tr>
	<td>
	<form action="<c:url value='/CompanyController?action=searchCompany' />" method="post">
	<table style="width: 1200px; ">
	<tr>
	<tr>
  	<td> Company name: </td>
 	<td> <input name="company_name" value="<c:out value='${company.company_name}'/>" class="text45">  </td>
  	<td> <input name="companyNameError"  value="<c:out value='${errorMsgs.companyNameError}'/>" class="errorMsg"> </td>
	</tr>
    <tr>
    <td> Company ID: </td>
    <td> <input name="idcompany" value="<c:out value='${company.idcompany}'/>" class="text16"> </td>
  	<td> <input name="companyIDerror"  value="<c:out value='${errorMsgs.companyIDerror}'/>" class="errorMsg"> </td>
    </tr>
</table>
  <input type="submit" value="Submit">
	</form>      
</td>
</tr>
</table>
</body>
</html>