<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Company Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">

      <div class="logo"><h1><a href="<c:url value='/' />">Company Management Application</a></h1></div>
  <div class="content">  

      <div class="menu_nav">
        <ul>
          <li><a href="<c:url value='/CompanyController?action=listCompany' />"><span>List Companies</span></a></li>
          <li><a href="<c:url value='/formCompany.jsp' />"><span>Insert Company</span></a></li>  
          <li><a href="<c:url value='/searchCompany.jsp' />"><span>Search Companies</span></a></li>  
          <li><a href="<c:url value='/EmployeeController?action=searchEmployee' />"><span>Search Employee</span></a></li>  
        </ul>
      </div>
    </div>
  </div>
  </div>
  </div>  
</body>
</html>