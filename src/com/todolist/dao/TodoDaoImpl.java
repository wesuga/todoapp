package com.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.todolist.model.Todo;

public class TodoDaoImpl implements TodoDao {
    private DataSource dataSource;

    public TodoDaoImpl(DataSource dataSource) {
	super();
	this.dataSource = dataSource;
    }

    @Override
    public List<Todo> getTodos() throws Exception {
	List<Todo> todos = new ArrayList<>();
	String sql = "SELECT * from todos";

	try (Connection conn = dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery()) {
	    while (rs.next()) {
		int id = rs.getInt("id");
		String todo = rs.getString("todo");
		String category = rs.getString("category");

		todos.add(new Todo(id, todo, category));
	    }
	    return todos;
	}
    }

    @Override
    public void addTodo(Todo todo) throws Exception {
	String sql = "INSERT INTO todos (todo, category) values (?, ?)";
	try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	    stmt.setString(1, todo.getTodo());
	    stmt.setString(2, todo.getCategory());
	    stmt.executeUpdate();
	}
    }

    @Override
    public Todo loadTodo(String theTodo) throws Exception {
	Todo myTodo = null;
	String sql = "SELECT * FROM todos WHERE id=?";
	try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	    int todoId = Integer.parseInt(theTodo);
	    stmt.setInt(1, todoId);
	    try (ResultSet rs = stmt.executeQuery()) {
		if (rs.next()) {
		    String todo = rs.getString("todo");
		    String category = rs.getString("category");

		    myTodo = new Todo(todoId, todo, category);
		} else {
		    throw new Exception("Could not find student id: " + todoId);
		}
	    }
	    return myTodo;
	}
    }

    @Override
    public void updateTodo(Todo todo) throws Exception {
	String sql = "UPDATE todos SET todo=?, category=? WHERE id=?";
	try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	    stmt.setString(1, todo.getTodo());
	    stmt.setString(2, todo.getCategory());
	    stmt.setInt(3, todo.getId());
	    stmt.executeUpdate();
	}
    }

    @Override
    public void deleteTodo(String todo) throws Exception {
	String sql = "DELETE FROM todos WHERE id=?";
	try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
	    int todoId = Integer.parseInt(todo);
	    stmt.setInt(1, todoId);
	    stmt.executeUpdate();
	}
    }
}
