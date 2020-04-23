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

@WebServlet("/DeleteTodoController")
public class DeleteTodoController extends HttpServlet {
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
	    todoDaoImpl.deleteTodo(request.getParameter("todoId"));
	    response.sendRedirect("ListTodoController");
	} catch (Exception e) {
	    logger.warning("Error in delete todo");
	}
	
    }

}
