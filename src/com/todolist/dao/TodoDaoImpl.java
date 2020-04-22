package com.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;

import com.todolist.model.Todo;

public class TodoDaoImpl implements TodoDao {
    private DataSource dataSource;

    List<Todo> todos = new ArrayList<Todo>();

    public TodoDaoImpl(DataSource dataSource) {
	super();
	this.dataSource = dataSource;
    }

    @Override
    public List<Todo> getTodos() throws Exception {
	String sql = "SELECT * from todo";

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
	Connection conn = null;
	PreparedStatement stmt = null;

	String sql = "INSERT INTO todo (todo, category) values (?, ?)";
	try {
	    conn = dataSource.getConnection();
	    stmt = conn.prepareStatement(sql);
	    stmt.setString(1, todo.getTodo());
	    stmt.setString(2, todo.getCategory());
	    stmt.executeUpdate();
	} finally {
	    DbUtils.close(stmt);
	    DbUtils.close(conn);
	}
    }

    @Override
    public Todo loadTodo(String theTodo) throws Exception {
	Todo myTodo = null;

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	String sql = "SELECT * FROM todo WHERE id=?";
	try {
	    int todoId = Integer.parseInt(theTodo);
	    conn = dataSource.getConnection();
	    stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, todoId);
	    rs = stmt.executeQuery();
	    if (rs.next()) {
		String todo = rs.getString("todo");
		String category = rs.getString("category");

		myTodo = new Todo(todoId, todo, category);
	    } else {
		throw new Exception("Could not find student id: " + todoId);
	    }
	    return myTodo;
	} finally {
	    DbUtils.close(rs);
	    DbUtils.close(stmt);
	    DbUtils.close(conn);
	}

    }

    @Override
    public void updateTodo(Todo todo) throws Exception {
	Connection conn = null;
	PreparedStatement stmt = null;

	String sql = "UPDATE todo SET todo=?, category=? WHERE id=?";
	try {
	    conn = dataSource.getConnection();
	    stmt = conn.prepareStatement(sql);
	    stmt.setString(1, todo.getTodo());
	    stmt.setString(2, todo.getCategory());
	    stmt.setInt(3, todo.getId());
	    stmt.executeUpdate();
	} finally {
	    DbUtils.close(stmt);
	    DbUtils.close(conn);
	}
    }

    @Override
    public void deleteTodo(String todo) throws Exception {
	Connection conn = null;
	PreparedStatement stmt = null;

	String sql = "DELETE FROM todo WHERE id=?";
	try {
	    int todoId = Integer.parseInt(todo);
	    conn = dataSource.getConnection();
	    stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, todoId);
	    stmt.executeUpdate();
	} finally {
	    DbUtils.close(stmt);
	    DbUtils.close(conn);
	}
    }
}
