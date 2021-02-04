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
import util.CheckErrorMsgs;
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
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
////		response.getWriter().append("Served at: ").append(request.getContextPath());
////		doPost(request, response);
//	}

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
		//int Roomnumber=Integer.parseInt(roomnumber);  
		String decknumber = request.getParameter("decknumber");
		//int Decknumber=Integer.parseInt(decknumber);  
		String membership = request.getParameter("membership");
		String successmessage = "User updated successfully";
		

		//make userUpdate object
		User userUpdate = new User();
		
		userUpdate.setUsername(username);
		userUpdate.setPassword(password);
		userUpdate.setLastname(lastname);
		userUpdate.setFirstname(firstname);
		userUpdate.setEmail(email);
		userUpdate.setNumber(number);
		userUpdate.setRoomnumber(roomnumber);
		userUpdate.setDecknumber(decknumber);
		userUpdate.setMembership(membership);
				
		//create a database model
		UserDAO updateuser = new UserDAO(ConnectionPro.getConnection());
	
		HttpSession SuccessfullSession = request.getSession();
		HttpSession errorSession = request.getSession();
		
		String passwordError = userUpdate.validatePassword(password);
		String lastnameError = userUpdate.validateLastname(lastname);
		String firstnameError = userUpdate.validateFirstname(firstname);
		String numberError = userUpdate.validateNumber(number);
		String emailError = userUpdate.validateEmail(email);
		String roomnumberError = userUpdate.validateRoomnumber(roomnumber);
		String decknumberError = userUpdate.validateDecknumber(decknumber);

		
		CheckErrorMsgs errormsg = new CheckErrorMsgs();
		String uerrormsgs = errormsg.UpdateprofileErrorMsg( numberError,  roomnumberError, lastnameError, firstnameError,  emailError,  decknumberError, passwordError);
		
		if(!uerrormsgs.equals(""))
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
			 updateuser.updateUser(userUpdate);
			 SuccessfullSession.setAttribute("successmessage", successmessage);
			 response.sendRedirect("passengersuccessmessage.jsp");
			} 
			
			
		
	
	}		
}