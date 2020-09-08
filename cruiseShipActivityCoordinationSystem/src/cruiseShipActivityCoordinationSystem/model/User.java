package cruiseShipActivityCoordinationSystem.model;

import java.io.Serializable;
import java.util.regex.Pattern;


import cruiseShipActivityCoordinationSystem.data.UserDAO;
//import cruiseShipActivityCoordinationSystem.data.UserDAO;
import cruiseShipActivityCoordinationSystem.model.User;
import cruiseShipActivityCoordinationSystem.model.UserErrorMsgs;

public class User implements Serializable{
	private static final long serialVersionUID = 3L;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String firstname;
	private String lastname;
	private String roomnumber;
	private String decknumber;
	private String membershiptype;
	
	public void setUser (String username, String password,String email, String phone, String firstname, String lastname, String roomnumber, String decknumber, String membershiptype) {
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setPhone(phone);
		setFirstname(firstname);
		setLastname(lastname);
		setRoomnumber(roomnumber);
		setDecknumber(decknumber);
		setMembershiptype(membershiptype);
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getMembershiptype() {
		return membershiptype;
	}
	public void setMembershiptype(String membershiptype) {
		this.membershiptype = membershiptype;
	}
	
	
	public void validateUser (String action, User user, UserErrorMsgs errorMsgs) {
		if (action.equals("saveUser")) {
			errorMsgs.setUsernameError(validateUsername(action,user.getUsername()));
			errorMsgs.setPhoneError(validatePhone(user.getPhone()));
			errorMsgs.setRoomnumberError(validateRoomnumber(user.getRoomnumber()));
			errorMsgs.setLastnameError(validateLastname(user.getLastname()));
			errorMsgs.setFirstnameError(validateFirstname(user.getFirstname()));
			errorMsgs.setEmailError(validateEmail(user.getEmail()));
			errorMsgs.setDecknumberError(validateDecknumber(user.getDecknumber()));
			errorMsgs.setPasswordError(validatePassword(user.getPassword()));
			errorMsgs.setNameCombinationError(validateNameCombination(user.getFirstname(), user.getLastname()));
		}
		else
				if (action.equals("searchUser")) {
					if (username.equals("") && password.equals("")) 
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



			
		
		errorMsgs.setErrorMsg();
	}
	
	private String validateNameCombination(String firstname, String lastname) {
		String result = "";
		
		if (!UserDAO.NameCombination(firstname, lastname))
			result = "firstname, lastname combination already in database";
		
		return result;
	}
	
	
	private String validatePassword(String password) {
		String result="";
		if(!(Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,29}$",password))){
			result = "Password must contain an upper case letter, \r\n" + 
					"a lower case letter, \r\n" + 
					"7 < Length < 30, \r\n" + 
					"a number, \r\n" + 
					"a special character. ";
		}

		return result;		
	}
	
	private String validateDecknumber(String decknumber) {
		String result="";
		if (!stringSize(decknumber,1,2))
			result="Deck number must be 1 to 2 digits in length";
		else
			if (!isTextAnInteger(decknumber))
				result="Deck number number must be a number";
			else
				if(!((Integer.parseInt(decknumber) > 0) && (Integer.parseInt(decknumber) < 16))) {
					result = "Deck number must be between 1 and 15 (both inclusive)";
				}
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
	
	private String validateFirstname(String lastname) {
		String result="";
		char c = firstname.charAt(0);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

		if (!(c >= 'A' && c <= 'Z')) 
		{
			result ="First name must start with a capital letter"; 
		}
		else
			if(!stringSize(firstname,3,29)) {
				result = "First name must be 3 to 29 characters long";
			
				}
			else
				if (isTextAnInteger(firstname))
					result="First name must not be a number";
				else {
					for (int i=0; i < firstname.length() ; i++)
		        	{
						char ch = firstname.charAt(i);
						if(specialCharactersString.contains(Character.toString(ch))) 
						{
		            	result = " First name must not contain special characters";
		            	break;
						}    

		        	}
				}
					
		return result;		
	}
	
	private String validateLastname(String lastname) {
		String result="";
		char c = lastname.charAt(0);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

		if (!(c >= 'A' && c <= 'Z')) 
		{
			result ="Last name must start with a capital letter"; 
		}
		else
			if(!stringSize(lastname,3,29)) {
				result = "Last name must be 3 to 29 characters long";
			
				}
			else
				if (isTextAnInteger(lastname))
					result="Last name must not be a number";
				else {
					for (int i=0; i < lastname.length() ; i++)
		        	{
						char ch = lastname.charAt(i);
						if(specialCharactersString.contains(Character.toString(ch))) 
						{
		            	result = " Last name must not contain special characters";
		            	break;
						}    

		        	}
				}
					
		return result;		
	}
	
	private String validatePhone(String phone) {
		String result="";
		if (phone.length()!=10)
			result="Phone number must be 10 digits in length";
		else
			if (!isTextAnInteger(phone))
				result="Phone number must be a number";
		return result;		
	}
	
	private String validateRoomnumber(String roomnumber) {
		String result="";
		if (roomnumber.length()!=3)
			result="Room number must be 3 digits in length";
		else
			if (!isTextAnInteger(roomnumber))
				result="Room number number must be a number";
			else
				if(!((Integer.parseInt(roomnumber) > 99) && (Integer.parseInt(roomnumber) < 200))) {
					result = "Room number must be between 100 and 199 (both inclusive)";
				}
		return result;		
	}
	
	private String validateUsername(String action, String username) {
		String result="";
		if (!UserDAO.UsernameUnique(username))
			result = "Username already in database";
		else
			if (action.equals("saveUser")) {
				char c = username.charAt(0);
				String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
				if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) 
				{
					result ="username must start with a letter"; 
				}
			else 
				if(!stringSize(username,5,20)) {
				result = "username must be 4 to 21 characters long";
			
				}
				else 
				{  
					for (int i=0; i < username.length() ; i++)
			        	{
							char ch = username.charAt(i);
							if(specialCharactersString.contains(Character.toString(ch))) 
							{
			            	result = "must not contain special characters";
			            	break;
							}    

				}
	
		}
			
	}
		return result;

	}
	
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