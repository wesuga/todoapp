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
		<h1>New Todo:</h1>
		<form action="AddTodoController" method="POST">
			<fieldset class="form-group">
				<label>Description</label> <input name="todo" type="text"
					class="form-control" /> <br />
			</fieldset>
			<fieldset class="form-group">
				<label>Category</label> <input name="category" type="text"
					class="form-control" /> <br />
			</fieldset>
			<input value="Add" type="submit" class="btn btn-success" /> <a
				href="ListTodoController" class="btn btn-info">Back to List</a>
		</form>
	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>