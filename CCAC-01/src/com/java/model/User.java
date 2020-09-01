package com.java.model;



import java.io.Serializable;
import com.java.data.UserDAO;

public class User implements Serializable{

	private static final long serialVersionUID = 3L;
	private String userid;
	private String username;
	private String password;
	private String lastname;
	private String firstname;
	private String email;
	private String number;
	private String roomnumber;
	private String decknumber;
	private String membership;

	
	public void setUser (String userid, String username,String password, String lastname, String firstname , String email, String number, String roomnumber, String decknumber, String membership) {
		setUserId(userid);
		setUsername(username);
		setPassword(password);
		setLastname(lastname);
		setFirstname(firstname);
		setEmail(email);
		setNumber(number);
		setRoomnumber(roomnumber);
		setDecknumber(decknumber);
		setMembership(membership);
	}
	
	public String getUserId() {
		return userid;
	}
	public void setUserId(String userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
        this.number = number;
	}

	public String getRoomnumber() {
		return roomnumber;
	}
	
	public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
	}

	public String getDecknumber() {
		return decknumber;
	}
	
	public void setDecknumber(String decknumber) {
        this.decknumber = decknumber;
	}

	public String getMembership() {
		return membership;
	}
	
	public void setMembership(String membership) {
        this.membership = membership;
	}
//
//  NOTE: 	The following code is not representative of how this would be coded in an industrial application.
//			We are using this code to maximize the ability of Pit to mutate the code to determine how
//			good the developed test cases are. This course is using this Java backend code as an application
//			of the principles learned in CSE 5321 only.
//	
	
	public void validateUser (String action, User user, UserErrorMsgs errorMsgs) {
		if (action.equals("saveUser")) {
			errorMsgs.setUsernameError(validateUsername(action,user.getUsername()));
			errorMsgs.setPasswordError(validatePassword(user.getPassword()));
			errorMsgs.setLastnameError(validateLastname(user.getLastname()));
			errorMsgs.setFirstnameError(validateFirstname(user.getFirstname()));
			errorMsgs.setEmailError(validateEmail(user.getEmail()));
			errorMsgs.setNumberError(validateNumber(user.getNumber()));
			errorMsgs.setRoomnumberError(validateRoomnumber(user.getRoomnumber()));
			errorMsgs.setDecknumberError(validateDecknumber(user.getDecknumber()));
	
			
		}
		else
			if (action.equals("searchUser")) {
				if (username.equals("") && lastname.equals("")) 
					errorMsgs.setUsernameError("Both Company Name and Company ID cannot be blank");
				else
					if (!username.equals(""))
						errorMsgs.setUsernameError(validateUsername(action, username));
			}
			else 
				if (username.equals("")) 
					errorMsgs.setUsernameError("Company ID cannot be blank");
				else
					errorMsgs.setUsernameError(validateUsername(action,username));
		
		
			if (action.equals("UserLogin")) {
				if (username.equals("") && password.equals("")) 
					errorMsgs.setUsernameError("Both Username and Password cannot be blank");
				else
					if (!username.equals(""))
						errorMsgs.setUsernameError(validateUsername(action, username));
			}
			else 
				if (username.equals("")) 
					errorMsgs.setUsernameError("Username cannot be blank");
				else
					errorMsgs.setUsernameError(validateUsername(action,username));
			
		
	errorMsgs.setErrorMsg();
		
	}
	

	private String validateUsername(String action, String username) {
		String result="";
			if (action.equals("saveUser")) {
				if (!stringSize(username,3,16))
					result= "Your Username must between 3 and 16 digits";
				else
					if (!UserDAO.Usernameunique(username))
						result="Username already in database";
			}
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

	private String validateRoomnumber(String roomnumber) {
		String result="";
		if (roomnumber.length()!=3)
			result="Roomnumber must be 3 digits in length";
		else
			if (!isTextAnInteger(roomnumber))
				result="Roomnumber must be a number";
		return result;		
	}

	private String validateDecknumber(String decknumber) {
		String result="";
		if (decknumber.length()!=1)
			result="decknumber must be 1 digit in length";
		else
			if (!isTextAnInteger(decknumber))
				result="decknumber must be a number";
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
}