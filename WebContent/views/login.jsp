<%@ include file="common/header.jspf"%>
<nav class="navbar navbar-default">
	<a href="#" class="navbar-brand">TodoApp</a>
</nav>
<div class="container">
	<form class="form-inline" action="LoginController" method="POST">
		<div class="form-group">
			<input type="text" class="form-control" name="username" placeholder="Username">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" name="password" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-default">Log in</button>
		<font color="red"><b>${errorMessage}</b></font>
	</form>
</div>
<%@ include file="common/footer.jspf"%>
