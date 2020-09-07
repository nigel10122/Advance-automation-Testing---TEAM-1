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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String validateUsername( String username) {
		String result="";
			
				if (!stringSize(username,8,16))
					result= "Your Username must between 8 and 16 digits";
				else
					if (!UserDAO.Usernameunique(username))
						result="Username already in database";
			
		return result;
	}
	
	private String validateLastname(String lastname) {
		String result="";
		if (!stringSize(lastname,3,45))
			result= "Your Lastname must between 3 and 45 characters";
		else
			if (Character.isLowerCase(lastname.charAt(0)))
				result="Your Lastname must start with a capital letter";
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

	private String validateFirstname(String firstname) {
		String result="";
		if (!stringSize(firstname,3,45))
			result= "Your Firstname must between 3 and 45 characters";
		else
			if (Character.isLowerCase(firstname.charAt(0)))
				result="Your Firstname must start with a capital letter";
		return result;		
	}
	
	private String validateNumber(String number) {
		String result="";
		if (number.length()!=10)
			result="Phone number must be 10 digits in length";
		else
			if (!isTextAnInteger(number))
				result="Phone number must be a number";
		return result;		
	}

	private String validateRoomnumber(int roomnumber) {
		String result="";
		int length_roomnumber = String.valueOf(roomnumber).length();

		if (length_roomnumber!=3)
			result="Roomnumber must be 3 digits in length";
		else
			if (!(roomnumber == (int)roomnumber))
				result="Roomnumber must be a number";
			else
				
				if (!(roomnumber >= 100 && roomnumber <=199))
					result="Roomnumber must be between 100 and 199";
		return result;		
	}

	private String validateDecknumber(int decknumber) {
		String result="";
		int length_decknumber = String.valueOf(decknumber).length();

		if (!(length_decknumber <= 2 ))
			result="Decknumber must be 1 or 2 digits in length";
		else
			if (!(decknumber == (int)decknumber))
				result="Decknumber must be a number";
			else
				if (!(decknumber >= 1 && decknumber <=15))
					result="Decknumber must be between 1 and 15";
		return result;		
	}

	
	
	private String validateEmail(String email) {
		String result="",extension="";
		if (!email.contains("@"))
			result = "Email address needs to contain @";
		else
			if (!stringSize(email,7,45))
				result="Email address must be between 7 and 45 characters long";
			else {
				extension = email.substring(email.length()-4, email.length());
				if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com") 
						&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
					result = "Invalid domain name";				
			}
		return result;		
	}

//	This section is for general purpose methods used internally in this class


	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	

	
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
	

    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = "registration.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String roomnumber = request.getParameter("roomnumber");
		String successmessage = "User registered successfully";
		int Roomnumber=Integer.parseInt(roomnumber);  
		int length_roomnumber = String.valueOf(Roomnumber).length();
		String decknumber = request.getParameter("decknumber");
		int Decknumber=Integer.parseInt(decknumber);  
		int length_decknumber = String.valueOf(Decknumber).length();
		
		String membership = request.getParameter("membership");
		String extension = email.substring(email.length()-4, email.length());
		//make user object
		User userModel = new User( username, password,  lastname,  firstname , email,  number,  Roomnumber,  Decknumber,  membership);
		//create a database model
		UserDAO regUser = new UserDAO(ConnectionPro.getConnection());
		HttpSession errorSession = request.getSession();
		HttpSession SuccessfullSession = request.getSession();
		
		
		
		if(!stringSize(username,8,16) || !UserDAO.Usernameunique(username) || 
		   !stringSize(password,8,10) || Character.isLowerCase(password.charAt(0)) ||
		   !stringSize(lastname,3,45) || Character.isLowerCase(lastname.charAt(0)) ||
		   !stringSize(firstname,3,45) || Character.isLowerCase(firstname.charAt(0))||
		   number.length()!=10 || !isTextAnInteger(number) ||
		   length_roomnumber!=3 || !(Roomnumber == (int)Roomnumber) || !(Roomnumber >= 100 && Roomnumber <=199) ||
		   !(length_decknumber <=2) || !(Decknumber == (int)Decknumber) || !(Decknumber >= 1 && Decknumber <=15) ||
		   !email.contains("@") || !extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com") 
			&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil") )
		{
		String usernameError = validateUsername(username);
		String passwordError = validatePassword(password);
		String lastnameError = validateLastname(lastname);
		String firstnameError = validateFirstname(firstname);
		String numberError = validateNumber(number);
		String emailError = validateEmail(password);
		String roomnumberError = validateRoomnumber(Roomnumber);
		String decknumberError = validateDecknumber(Decknumber);
		
		
		
		errorSession.setAttribute("usernameError", usernameError);
		errorSession.setAttribute("passwordError", passwordError);
		errorSession.setAttribute("lastnameError", lastnameError);
		errorSession.setAttribute("firstnameError", firstnameError);
		errorSession.setAttribute("numberError", numberError);
		errorSession.setAttribute("emailError", emailError);
		errorSession.setAttribute("roomnumberError", roomnumberError);
		errorSession.setAttribute("decknumberError", decknumberError);
	
		
		requestDispatcher.forward(request, response);
		}
		else {
//register
			
			regUser.saveUser(userModel); 
			response.sendRedirect("index.jsp");
			
			SuccessfullSession.setAttribute("successmessage", successmessage);
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
