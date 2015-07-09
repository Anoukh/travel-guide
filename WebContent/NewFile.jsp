<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Name</title>
</head>
<body>
<form action="Testservlet" method="POST">
		<input type="text" name="name" />
		<input type="submit" value="Submit" />
	</form>
<%

if(request.getAttribute("message") != null){
response.getWriter().print(request.getAttribute("message"));

//String st =(String)request.getAttribute("message");
}
%>
<%if(request.getAttribute("message") != null){ %>
<p>
name is <h1><%= request.getAttribute("message")%></h1> 
</p>
<% } %>	
</body>
</html>