package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.UserDAO;
import model.User;
import util.ConnectionPro;

/**
 * Servlet implementation class PassengerUpdateProfile
 */
@WebServlet("/PassengerUpdateProfile")
public class PassengerUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerUpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String destination = "passengerupdateprofile.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String roomnumber = request.getParameter("roomnumber");

		String decknumber = request.getParameter("decknumber");
 
		String membership = request.getParameter("membership");
		String successmessage = "User updated successfully";
		

		//make user object
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setLastname(lastname);
		user.setFirstname(firstname);
		user.setEmail(email);
		user.setNumber(number);
		user.setRoomnumber(roomnumber);
		user.setDecknumber(decknumber);
		user.setMembership(membership);
				
		//create a database model
		UserDAO updateuser = new UserDAO(ConnectionPro.getConnection());
	
		HttpSession SuccessfullSession = request.getSession();
		HttpSession errorSession = request.getSession();
		
		String passwordError = user.validatePassword(password);
		String lastnameError = user.validateLastname(lastname);
		String firstnameError = user.validateFirstname(firstname);
		String numberError = user.validateNumber(number);
		String emailError = user.validateEmail(email);
		String roomnumberError = user.validateRoomnumber(roomnumber);
		String decknumberError = user.validateDecknumber(decknumber);
	
		
		if(!numberError.equals("") || !roomnumberError.equals("") || !lastnameError.equals("") 
				|| !firstnameError.equals("") || !emailError.equals("") || !decknumberError.equals("") || !passwordError.equals(""))
		{	
			errorSession.setAttribute("passwordError", passwordError);
			errorSession.setAttribute("lastnameError", lastnameError);
			errorSession.setAttribute("firstnameError", firstnameError);
			errorSession.setAttribute("numberError", numberError);
			errorSession.setAttribute("emailError", emailError);
			errorSession.setAttribute("roomnumberError", roomnumberError);
			errorSession.setAttribute("decknumberError", decknumberError);
		
			requestDispatcher.forward(request, response);
		
		}
		else 
			{
			 updateuser.updateUser(user);
			 SuccessfullSession.setAttribute("successmessage", successmessage);
			 response.sendRedirect("passengersuccessmessage.jsp");
			} 
			
			
		
	
	}		
}
