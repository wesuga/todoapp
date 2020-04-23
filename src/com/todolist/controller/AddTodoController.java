package com.todolist.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.todolist.dao.TodoDaoImpl;
import com.todolist.model.Todo;

@WebServlet("/AddTodoController")
public class AddTodoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoDaoImpl todoDaoImpl;
    private Logger logger;

    @Resource(name = "jdbc/todoapp")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
	super.init();

	try {
	    todoDaoImpl = new TodoDaoImpl(dataSource);
	} catch (Exception e) {
	    throw new ServletException(e);
	}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try {
	    request.getRequestDispatcher("views/add-todo.jsp").forward(request, response);
	} catch (Exception e) {
	    logger.warning("Error page");
	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try {
	    String newTodo = request.getParameter("todo");
	    String category = request.getParameter("category");
	    todoDaoImpl.addTodo(new Todo(newTodo, category));
	    response.sendRedirect("ListTodoController");
	} catch (Exception e) {
	    logger.warning("Error in add todo");
	}
    }
}
