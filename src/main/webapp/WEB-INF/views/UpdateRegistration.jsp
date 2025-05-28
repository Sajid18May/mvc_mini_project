<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Registration</title>
</head>
<body>
	<h2>Update Registration Page</h2>
	<form action="updateRegistration" method="post">
		<pre>
					<input type="hidden" name="id" value=<%=request.getAttribute("id")%>>
			Name : <input type="text" name="name" value=<%=request.getAttribute("name")%>>
			Email :<input type="text" name="email" value=<%=request.getAttribute("emailId")%>>
			Mobile :<input type="text" name="mobile" value=<%=request.getAttribute("mobile")%>>
			<button type="submit">Update</button>
		</pre>
	</form>
	<%
	if(request.getAttribute("message")!=null){
		out.print(request.getAttribute("message"));
	}
	%>
</body>
</html>