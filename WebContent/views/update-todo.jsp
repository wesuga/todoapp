<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Todo</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>New Todo:</h1>
		<form action="UpdateTodoController" method="POST">
			<input type="hidden" name="todoId" value="${the_todo.id}" />
			<fieldset class="form-group">
				<legend>Description</legend>
				<input name="todo" type="text" class="form-control"
					value="${the_todo.todo}" /> <br />
			</fieldset>
			<fieldset class="form-group">
				<legend>Category</legend>
				<input name="category" type="text" class="form-control"
					value="${the_todo.category}" /> <br />
			</fieldset>
			<input value="Save" type="submit" class="btn btn-success" /> <a
				href="ListTodoController" class="btn btn-info">Back to List</a>
		</form>
	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>