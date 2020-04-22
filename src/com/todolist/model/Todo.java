package com.todolist.model;

public class Todo {
    private int id;
    private String todo;
    private String category;

    public Todo(String todo, String category) {
	super();
	this.todo = todo;
	this.category = category;
    }

    public Todo(int id, String todo, String category) {
	super();
	this.id = id;
	this.todo = todo;
	this.category = category;
    }

    public String getTodo() {
	return todo;
    }

    public void setTodo(String todo) {
	this.todo = todo;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return String.format("Todo [todo=%s, category=%s]", todo, category);
    }

}
