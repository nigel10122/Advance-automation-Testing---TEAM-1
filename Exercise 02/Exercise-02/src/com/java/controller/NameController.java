package com.java.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.java.form.*;

@WebServlet("/NameController")
public class NameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NameForm nameForm = new NameForm();
		nameForm.setName(request.getParameter("name"));
		String id = request.getParameter("id");
		session.setAttribute("nameForm",nameForm);
		nameForm.setGreetingText("Hello "+nameForm.getName());
		System.out.println("Student ID number: "+id);
		request.getSession().setAttribute("id", id);
	
		
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);		
	}

}