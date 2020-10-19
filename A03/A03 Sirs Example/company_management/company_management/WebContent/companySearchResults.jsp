<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Companies List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="myStyle.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="<c:url value='/' />">Company Management Application</a></h1></div>
  </div>
         
 <form action="<c:url value='/CompanyController?action=listSpecificCompany' />" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTable20">Company ID</th>
				<th class="myTable35">Phone</th> 
				<th class="myTable20">Company Name</th>
				<th class="myTable30">Email</th> 
			</tr>

 		<c:forEach items="${COMPANIES}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTable20 "><c:out value="${item.idcompany}" /></td>
			<td class="myTable35 "><c:out value="${item.phone}" /></td>
			<td class="myTable20 "><c:out value="${item.company_name}" /></td>
			<td class="myTable30 "><c:out value="${item.email}" /></td>
			</tr>
		</c:forEach>
 </table>
 </form>
</body>
</html>