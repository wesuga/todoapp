package com.todolist.model;

public class Todo {
    private int id;
    private String todos;
    private String category;

    public Todo(int id, String todos, String category) {
	super();
	this.id = id;
	this.todos = todos;
	this.category = category;
    }

    public Todo(String todos, String category) {
	super();
	this.todos = todos;
	this.category = category;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTodos() {
	return todos;
    }

    public void setTodos(String todos) {
	this.todos = todos;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    @Override
    public String toString() {
	return String.format("Todo [todos=%s, category=%s]", todos, category);
    }
}
