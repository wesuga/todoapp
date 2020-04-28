<%@ include file="common/header.jspf"%>
<nav class="navbar navbar-default">
	<a href="#" class="navbar-brand">TodoApp</a>
</nav>
<div class="container">
	<h1>Update Todo:</h1>
	<form action="UpdateTodoController" method="POST">
		<input type="hidden" name="todoId" value="${the_todo.id}" />
		<fieldset class="form-group">
			<legend>Description</legend>
			<input name="todo" type="text" class="form-control" value="${the_todo.todos}" required /> <br />
		</fieldset>
		<fieldset class="form-group">
			<legend>Category</legend>
			<input name="category" type="text" class="form-control" value="${the_todo.category}" required /> <br />
		</fieldset>
		<input value="Save" type="submit" class="btn btn-success" /> <a href="ListTodoController" class="btn btn-info">Back
			to List</a>
	</form>
</div>
<%@ include file="common/footer.jspf"%>