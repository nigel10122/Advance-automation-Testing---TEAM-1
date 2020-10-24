package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import data.UserDAO;
import util.ConnectionPro;







@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        
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
      //  User val = new User();
        UserLogin ul = new UserLogin( username, password ); 
        timeDate td = new timeDate();
        User user = db.login(username, password);
        HttpSession invalidsession = request.getSession();
        HttpSession SuccessfullSession = request.getSession();
        
        
       
        
        String usernameError = ul.validateUsername_Login(username);
 		String passwordError = ul.validatePassword(password);
        
        if(!usernameError.equals("") || !passwordError.equals("") ) 
     		{
     		
        	
        	errorSession.setAttribute("usernameError", usernameError);
     		errorSession.setAttribute("passwordError", passwordError);
     		requestDispatcher.forward(request, response);
     	
     		
     		}
        else 
        	if(user!=null && user.getRole().equals("Passenger"))
        	{
        	HttpSession session = request.getSession();
            session.setAttribute("logUser", user);	
            SuccessfullSession.setAttribute("successmessage", successmessage);
            SuccessfullSession.removeAttribute("successmessage");
            errorSession.removeAttribute("usernameError");	
			errorSession.removeAttribute("passwordError");	
			errorSession.removeAttribute("InvalidError");	
            response.sendRedirect("welcome.jsp");
            session.setAttribute("username", user.getUsername());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("lastname", user.getLastname());
            session.setAttribute("firstname", user.getFirstname());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("number", user.getNumber());
            session.setAttribute("roomnumber", user.getRoomnumber());
            session.setAttribute("decknumber", user.getDecknumber());
            session.setAttribute("membership", user.getMembership());
            session.setAttribute("currentdate", td.getCurrentDate());
            session.setAttribute("currenttime", td.getCurrentTime());
          }else
        	if(user!=null && user.getRole().equals("Coordinator"))
        	{
            	HttpSession session = request.getSession();
                session.setAttribute("logUser", user);
                SuccessfullSession.setAttribute("successmessage", successmessage);
                SuccessfullSession.removeAttribute("successmessage");
                errorSession.removeAttribute("usernameError");	
    			errorSession.removeAttribute("passwordError");	
    			errorSession.removeAttribute("InvalidError");	
                response.sendRedirect("coordinatorhome.jsp");
                session.setAttribute("username", user.getUsername());
                session.setAttribute("password", user.getPassword());
                session.setAttribute("lastname", user.getLastname());
                session.setAttribute("firstname", user.getFirstname());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("number", user.getNumber());
                session.setAttribute("roomnumber", user.getRoomnumber());
                session.setAttribute("decknumber", user.getDecknumber());
                session.setAttribute("membership", user.getMembership());
                session.setAttribute("currentdate", td.getCurrentDate());
                session.setAttribute("currenttime", td.getCurrentTime());
        	}
        	else
        		if(user!=null && user.getRole().equals("Manager"))
        		{
                	HttpSession session = request.getSession();
                    session.setAttribute("logUser", user);
                    SuccessfullSession.setAttribute("successmessage", successmessage);
                    SuccessfullSession.removeAttribute("successmessage");
                    errorSession.removeAttribute("usernameError");	
        			errorSession.removeAttribute("passwordError");	
        			errorSession.removeAttribute("InvalidError");	
                    response.sendRedirect("managerhome.jsp");
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("password", user.getPassword());
                    session.setAttribute("lastname", user.getLastname());
                    session.setAttribute("firstname", user.getFirstname());
                    session.setAttribute("email", user.getEmail());
                    session.setAttribute("number", user.getNumber());
                    session.setAttribute("roomnumber", user.getRoomnumber());
                    session.setAttribute("decknumber", user.getDecknumber());
                    session.setAttribute("membership", user.getMembership());
                    session.setAttribute("currentdate", td.getCurrentDate());
                    session.setAttribute("currenttime", td.getCurrentTime());
        		}
        		else
        			{	
        				invalidsession.setAttribute("InvalidError",InvalidError);
        				requestDispatcher.forward(request, response);
        				errorSession.removeAttribute("usernameError");	
        				errorSession.removeAttribute("passwordError");	
        			}

	}

}