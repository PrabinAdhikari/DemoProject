<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<a href="/demo/">Home</a>
	</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>userName</th>
			<th>Email Address</th>
			<th>Status</th>
		</tr>
		<tbody id="list">
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.userName}</td>
					<td>${user.email}</td>
					<td><a href="/demo/edit/${user.id}">Edit</a>|<a
						href="/demo/delete/${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>