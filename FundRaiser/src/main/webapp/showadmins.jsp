<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Admins list here</title>
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
<H3> List of all Admins</H3>
<table>
<tr> <th>ID</th> <th>Name </th>  <th> email id </th> <th> date </th> <th> status </th></tr>
<c:forEach items="${admins}" var="a">

<tr> <td> ${a.id} </td> <td> ${a.name}</td> <td> ${a.emailid}</td> <td> ${a.date} </td> 
<td>${a.status}</td> <td><a href="editadmincontroller/${a.id}">edit</a></td></tr>

</c:forEach>
</table>
</body>
</html>