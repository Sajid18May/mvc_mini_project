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
			<th>Delete</th>
			<th>Update</th>
		</tr>
	<% ResultSet result=(ResultSet)request.getAttribute("regiatrations");
	while(result.next()){%>
		<tr>
			<td>
				<%=result.getString(2)%>
			</td>
			<td>
				<%=result.getString(3)%>
			</td>
			<td>
				<%=result.getString(4)%>
			</td>
			<td>
				<a href="deleteRegistration?regEmail=<%=result.getString(3)%>">delete</a>
			</td>
			<td>
				<a href="updateRegistration?id=<%=result.getString(1)%>">update</a>
			</td>
		</tr>
		<%} %>
	
	</table>
</body>
</html>