<%@ include file="common/header.jspf"%>
<nav class="navbar navbar-default">
	<a href="#" class="navbar-brand">TodoApp</a>
	<ul class="nav navbar-nav navbar-left">
		<li class="active"><a href="ListTodoController">My Todos</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="LogoutController">Logout</a></li>
	</ul>
</nav>
<div class="container">
	<table class="table table-striped">
		<caption>Your Todos are:</caption>
		<tr>
			<th id="desc">Description</th>
			<th id="category">Category</th>
			<th id="action">Action</th>
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
					<td>${todo.todos}</td>
					<td>${todo.category}</td>
					<td><a href="${loadTodoLink}" class="btn btn-primary">Update</a> <a class="btn btn-danger"
						href="${deleteLink}" onclick="if(!(confirm('Do you want to delete this?'))) return false">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="btn btn-success" href="AddTodoController">Add New Todo</a>
</div>
<%@ include file="common/footer.jspf"%>
