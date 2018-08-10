<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit and admin</title>

</head>
<body>
<%
//allow access only if session exists
if(session.getAttribute("email") == null){
	response.sendRedirect("adminlogin.jsp");
}
String cookie = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie c : cookies){
	if(c.getName().equals("user")) cookie = c.getValue();
}
}
%>
<div class="container">
  <form action="../updateadmin">

	<input type="hidden" name="id" value="${a.id}">

    <label for="name">Name</label>
    <input type="text" id="name" name="name" value="${a.name}">

    <label for="emailid">Emailid</label>
    <input type="text" id="emailid" name="emailid" value="${a.emailid}">
    
    <label for="password">Password</label>
    <input type="password" id="password" name="password" value="${a.password}">
    
    <label for="status">Status</label>
    <select id="status" name="status">
      <option value="active">active</option>
      <option value="inactive">inactive</option>
    </select>

    <input type="submit" value="update">

  </form>
</div>
</body>
</html>