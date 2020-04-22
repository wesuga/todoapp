<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo</title>

<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">

		<table class="table table-striped">
			<caption>Your Todos are:</caption>
			<tr>
				<th>Description</th>
				<th>Category</th>
			</tr>
			<tbody>

				<c:forEach items="${todo_list}" var="todo">

					<!-- for update link -->
					<c:url var="loadTodoLink" value="LoadTodoController">
						<c:param name="tempId" value="${todo.id}" />
					</c:url>
					<!-- for delete link -->
					<c:url var="deleteLink" value="DeleteTodoController">
						<c:param name="todoId" value="${todo.id}" />
					</c:url>
					<tr>
						<td>${todo.todo}</td>
						<td>${todo.category}</td>
						<td><a href="${loadTodoLink}" class="btn btn-primary">Update</a>
							<a class="btn btn-danger" href="${deleteLink}"
							onclick="if(!(confirm('Do you want to delete this?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-success" href="AddTodoController">Add New Todo</a>
	</div>

	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>