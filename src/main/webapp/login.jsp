<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Page</h2>
	<form action="LoginController" method="post">
		Email:<input type="text" name="email"/>
		Password:<input type="password" name="password"/>
		<button type="submit">Login</button>
	</form>
	<% if(request.getAttribute("error")!=null){
		out.println(request.getAttribute("error"));
	}
	%>
</body>
</html>