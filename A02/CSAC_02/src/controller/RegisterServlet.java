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




@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	

    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "registration.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		String role = "Passenger";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String roomnumber = request.getParameter("roomnumber");
		int Roomnumber=Integer.parseInt(roomnumber);  
		String decknumber = request.getParameter("decknumber");
		int Decknumber=Integer.parseInt(decknumber);  
		String membership = request.getParameter("membership");
		String registrationsuccessmessage = "User registered successfully";
		
		
		
	
		//make user object
		User user = new User();
		
		
		User userModel = new User( username, password,  lastname,  firstname , email,  number,  Roomnumber,  Decknumber,  membership, role);
		
		//create a database model
		UserDAO regUser = new UserDAO(ConnectionPro.getConnection());
		HttpSession errorSession = request.getSession();
		HttpSession SuccessfullSession = request.getSession();
		
		
		
		
		
		
		String usernameError = user.validateUsername(username);
		String passwordError = user.validatePassword(password);
		String lastnameError = user.validateLastname(lastname);
		String firstnameError = user.validateFirstname(firstname);
		String numberError = user.validateNumber(number);
		String emailError = user.validateEmail(email);
		String roomnumberError = user.validateRoomnumber(Roomnumber);
		String decknumberError = user.validateDecknumber(Decknumber);
		String namecombinationError = user.validateNameCombination(firstname, lastname);
		
		
		
			if(!usernameError.equals("") || !numberError.equals("") || !roomnumberError.equals("") || !lastnameError.equals("") 
					|| !firstnameError.equals("") || !emailError.equals("") || !decknumberError.equals("") || !passwordError.equals("") 
					|| !namecombinationError.equals(""))
			{	

				errorSession.setAttribute("usernameError", usernameError);
				errorSession.setAttribute("passwordError", passwordError);
				errorSession.setAttribute("lastnameError", lastnameError);
				errorSession.setAttribute("firstnameError", firstnameError);
				errorSession.setAttribute("numberError", numberError);
				errorSession.setAttribute("emailError", emailError);
				errorSession.setAttribute("roomnumberError", roomnumberError);
				errorSession.setAttribute("decknumberError", decknumberError);
				errorSession.setAttribute("namecombinationError", namecombinationError);
			
				requestDispatcher.forward(request, response);
		
			}
			else
				{
				regUser.saveUser(userModel); 
				response.sendRedirect("index.jsp");
				
				SuccessfullSession.setAttribute("registrationsuccessmessage", registrationsuccessmessage);
				errorSession.removeAttribute("usernameError");	
				errorSession.removeAttribute("passwordError");	
				errorSession.removeAttribute("lastnameError");	
				errorSession.removeAttribute("firstnameError");	
				errorSession.removeAttribute("numberError");	
				errorSession.removeAttribute("emailError");	
				errorSession.removeAttribute("roomnumberError");
				errorSession.removeAttribute("decknumberError");
				
					
				}
				
				
				
		
		
	}
}
