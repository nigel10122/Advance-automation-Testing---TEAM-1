<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>HomeScreen</title>
</head>
<body>
<form align="right" action="<c:url value='/UserController?action=logoutUser' />" method="post">
  <label class="logoutLblPos">
  <input name="action" value="logoutUser" type="hidden">
  <input type="submit" value="log out">
  </label>
</form>
<h1 align="center">Home Screen</h1>
<form align=center method="post">
  
  
  <input type="submit" value="View Event Summary">
</form>
</body>
</html>