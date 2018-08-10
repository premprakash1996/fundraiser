<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//allow access only if sess ion exists
String user = null;
if(session.getAttribute("email") == null){
	response.sendRedirect("adminlogin.jsp");
}else user = (String) session.getAttribute("email");
String cookie = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie c : cookies){
	if(c.getName().equals("email")) cookie = c.getValue();
	if(c.getName().equals("JSESSIONID")) sessionID = c.getValue();
}
}
%>
<a href="newadmin.jsp">add an admin</a>
<a href="admins">show admins</a>
</body>
</html>