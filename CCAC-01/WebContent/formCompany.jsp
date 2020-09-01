<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
<link href="myStyle.css" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" class="alert">
<table>
  <tr>
   <td>
    <form name="companyForm" action="<c:url value='/CompanyController?saveCompany' />" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Company ID (*): </td>
    <td> <input name="idcompany" value="<c:out value='${company.idcompany}'/>" class="text16"> </td>
  	<td> <input name="companyIDerror"  value="<c:out value='${errorMsgs.companyIDerror}'/>" class="errorMsg"> </td>
    </tr>

    <tr>
    <td> Company Name (*): </td>
    <td> <input name="company_name" value="<c:out value='${company.company_name}'/>" class="text45">  </td>
 	<td> <input name="companyNameError"  value="<c:out value='${errorMsgs.companyNameError}'/>" class="errorMsg"> </td>
    </tr>

    <tr>
    <td> Phone: </td>
    <td> <input name="phone" value="<c:out value='${company.phone}'/>" class="text16">  </td>
  	<td> <input name="phoneError"  value="<c:out value='${errorMsgs.phoneError}'/>" class="errorMsg"> </td>
    </tr>

    <tr>
    <td> Email (*): </td>
    <td> <input name="email" value="<c:out value='${company.email}'/>" class="text45">  </td>
  	<td> <input name="emailError"  value="<c:out value='${errorMsgs.emailError}'/>" class="errorMsg"> </td>
    </tr>

    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    </table>
    <input name="action" value="saveCompany" type="hidden">
    <input type="submit" value="Insert Company">
    </form>
</td>
</tr>
</table>
</body>
</html>