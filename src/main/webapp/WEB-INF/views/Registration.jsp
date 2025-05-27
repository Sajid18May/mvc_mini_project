<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Registration Page</h2>
	<form action="RegistrationController" method="post">
		<pre>
			Name : <input type="text" name="name">
			Email :<input type="text" name="email">
			Mobile :<input type="text" name="mobile">
			<button type="submit">Register</button>
		</pre>
	</form>
	<%
	if(request.getAttribute("message")!=null){
		out.print(request.getAttribute("message"));
	}
	%>
</body>
</html>