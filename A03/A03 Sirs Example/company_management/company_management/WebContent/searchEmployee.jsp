<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search Employee</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="myStyle.css">
<body>
      <div class="logo"><h1><a href="<c:url value='/' />">Company Management Application</a></h1></div>
      <div class="menu_nav">
  </div>
<form action="<c:url value='EmployeeController?action=selectEmployee' />" method="post">
Select a Company Name: &nbsp;
<select name="cname">
    <c:forEach items="${company}" var="item">
        <option value="<c:out value="${item.idcompany}" />">${item.company_name} </option>
    </c:forEach>
</select>
<input type="submit" value="Submit">
</form>	
</body>
</html>