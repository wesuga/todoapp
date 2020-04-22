package com.todolist.dao;

import java.util.List;

import com.todolist.model.Todo;

public interface TodoDao {
    List<Todo> getTodos() throws Exception;

    void addTodo(Todo todo) throws Exception;

    void deleteTodo(String todo) throws Exception;

    Todo loadTodo(String todo) throws Exception;

    void updateTodo(Todo todo) throws Exception;
}
