<%@ include file="common/header.jspf"%>
<nav class="navbar navbar-default">
	<a href="#" class="navbar-brand">TodoApp</a>
</nav>
<div class="container">
	<h1>New Todo:</h1>
	<form action="AddTodoController" method="POST">
		<fieldset class="form-group">
			<legend>Description</legend>
			<input name="todo" type="text" class="form-control" required /> <br />
		</fieldset>
		<fieldset class="form-group">
			<legend>Category</legend>
			<input name="category" type="text" class="form-control" required /> <br />
		</fieldset>
		<input value="Add" type="submit" class="btn btn-success" /> <a href="ListTodoController" class="btn btn-info">Back
			to List</a>
	</form>
</div>
<%@ include file="common/footer.jspf"%>