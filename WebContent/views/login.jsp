<%@ include file="common/header.jspf"%>
<nav class="navbar navbar-default">
	<a href="#" class="navbar-brand">TodoApp</a>
</nav>
<div class="container">
	<form action="LoginTodoController" method="POST">
		Username: <input type="text" name="username" required />
		Password: <input type="password" name="password" required/>
		<button type="submit" value="Log in" class="btn btn-primary">Log in</button> <font color="red">${errorMessage}</font>
	</form>
</div>

</body>
</html>
