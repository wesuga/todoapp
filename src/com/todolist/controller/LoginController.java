package com.todolist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	if ((username.equals("test")) && (password.equals("1234"))) {
	    request.getSession().setAttribute("username", username);
	    response.sendRedirect("ListTodoController");
	} else {
	    request.setAttribute("errorMessage", "Invalid credentials.");
	    request.getRequestDispatcher("views/login.jsp").forward(request, response);
	}
    }
}
