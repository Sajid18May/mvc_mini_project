<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrations List</title>
</head>
<body>

	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile</th>
		</tr>
	<% ResultSet result=(ResultSet)request.getAttribute("regiatrations");
	while(result.next()){%>
		<tr>
			<td>
				<%=result.getString(1)%>
			</td>
			<td>
				<%=result.getString(2)%>
			</td>
			<td>
				<%=result.getString(3)%>
			</td>
			<td>
				<a href="deleteRegistration?regEmail=<%=result.getString(2)%>">delete</a>
			</td>
		</tr>
		<%} %>
	
	</table>
</body>
</html>