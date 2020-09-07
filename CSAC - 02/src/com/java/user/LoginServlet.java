package com.java.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.java.connection.ConnectionPro;







@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        
    }
    
    private String validateUsername( String username) {
		String result="";
			
				if (!stringSize(username,8,16))
					result= "Your Username must between 8 and 16 digits";
			
			
		return result;
	}
	
    
	private String validatePassword(String password) {
		String result="";
		if (!stringSize(password,8,10))
			result= "Your password must between 8 and 10 characters";
		else
			if (Character.isLowerCase(password.charAt(0)))
				result="Your password must start with a capital letter";
		return result;		
	}
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	

	

	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//feth data from login form
		String destination = "index.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String InvalidError = "Invalid Username or Password";
        String successmessage = "User registered successfully";
        HttpSession errorSession = request.getSession();
        UserDAO db =  new UserDAO(ConnectionPro.getConnection());
        User user = db.login(username, password);
        HttpSession invalidsession = request.getSession();
        HttpSession SuccessfullSession = request.getSession();
        
        if(!stringSize(username,8,16) || 
     		   !stringSize(password,8,10) || Character.isLowerCase(password.charAt(0))) 
     		{
     		String usernameError = validateUsername(username);
     		String passwordError = validatePassword(password);
     
     		errorSession.setAttribute("usernameError", usernameError);
     		errorSession.setAttribute("passwordError", passwordError);
     		requestDispatcher.forward(request, response);
     		}
        
        else 
        if(user!=null){
        	HttpSession session = request.getSession();
            session.setAttribute("logUser", user);
            SuccessfullSession.setAttribute("successmessage", successmessage);
            SuccessfullSession.removeAttribute("successmessage");
            errorSession.removeAttribute("usernameError");	
			errorSession.removeAttribute("passwordError");	
			errorSession.removeAttribute("InvalidError");	
            response.sendRedirect("welcome.jsp");
            
        }else
        	
        {	
        
            invalidsession.setAttribute("InvalidError",InvalidError);
            requestDispatcher.forward(request, response);
        
        }

	}

}
