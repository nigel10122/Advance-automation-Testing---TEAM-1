package model;


import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.*;

import data.UserDAO;



public class User {
	 int id;
	 String username;
	 String password;
	 String lastname;
	 String firstname;
	 String email;
	 String number;
	 String roomnumber;
	 String decknumber;
	 String membership;
	 String role;
//	 String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
//	 String currentTime = new SimpleDateFormat("hh:mm aa").format(Calendar.getInstance().getTime());

    public User()
    {
    	
    }
    
//    public User(String firstname, String email, String username) {
//        this.firstname = firstname;
//        this.email = email;
//        this.username = username;
//    }




//    public User(String username,String password, String lastname, String firstname , String email, String number, String roomnumber, String decknumber, String membership) {
//    	this.username = username;
//        this.password = password;
//        this.lastname = lastname;
//        this.firstname = firstname;
//        this.email = email;
//        this.number = number;
//        this.roomnumber = roomnumber;
//        this.decknumber = decknumber;
//        this.membership = membership;
//    }


    public User(String username,String password, String lastname, String firstname , String email, String number, String roomnumber, String decknumber, String membership,String role) {
    	this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.number = number;
        this.roomnumber = roomnumber;
        this.decknumber = decknumber;
        this.membership = membership;
        this.role = role;
    }
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

//    public User(String role)
//    {
//    	this.role = role;
//    }
 

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
    
//	public String getCurrentTime() {
//		return currentTime;
//	}
//	
//	public void setCurrentTime(String currentTime) {
//		this.currentTime = currentTime;
//	}
//	
//	public String getCurrentDate() {
//		return currentDate;
//	}
//	public void setCurrentDate(String currentDate) {
//		this.currentDate = currentDate;
//	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	
	// Validation
	
	public void validateUser (User user, UserErrorMsgs errorMsgs) {
		
			errorMsgs.setUsernameError(validateUsername(user.getUsername()));
			errorMsgs.setNumberError(validateNumber(user.getNumber()));
			errorMsgs.setRoomnumberError(validateRoomnumber(user.getRoomnumber()));
			errorMsgs.setLastnameError(validateLastname(user.getLastname()));
			errorMsgs.setFirstnameError(validateFirstname(user.getFirstname()));
			errorMsgs.setEmailError(validateEmail(user.getEmail()));
			errorMsgs.setDecknumberError(validateDecknumber(user.getDecknumber()));
			errorMsgs.setPasswordError(validatePassword(user.getPassword()));
			errorMsgs.setNameCombinationError(validateNameCombination(user.getFirstname(), user.getLastname()));
			errorMsgs.setErrorMsg();
		}
	
	
	
							
						
	
	
	
	public String validateNameCombination(String firstname, String lastname) {
		String result = "";
		
		if (!UserDAO.NameCombination(firstname, lastname))
			result = "firstname lastname combination already in database";
		
		return result;
	}
	
   
	
	
    public String validateUsername(String username) {
    	String result="";
    	char c = username.charAt(0);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		if (!UserDAO.Usernameunique(username))
			result = "Username already in database";
		else
			if (!(Character.isLetter(c))) 
				{
					result ="username must start with a letter"; 
				}
			else 
				if(!stringSize(username,5,20)) {
				result = "username must be 5 to 20 characters long";
			
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
			
	
		return result;

}
	
	
	public String validatePassword(String password) {
		String result="";
		if(!(Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,29}$",password))){
			result = "must have upper and lower case letter number special character length greater than 6 and smaller than 46";
		}

		return result;		
	}
	

	public String validateLastname(String lastname) {
		String result="";
		
		boolean digit = false;
		 char[] chars = lastname.toCharArray();
		 for(char chh : chars){
	         if(Character.isDigit(chh)){
	        	digit =true;
	         }
		 }
		char c = lastname.charAt(0);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

		if (!(Character.isUpperCase(c))) 
		{
			result ="Last name must start with a capital letter"; 
		}
		else
			if(!stringSize(lastname,3,29)) {
				result = "Last name must be 3 to 29 characters long";
			
				}
			else
				if(digit) {
				
			        	 result="Last name must not contain a number";
			         }
				
				else {
					for (int i=0; i < lastname.length() ; i++)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		        	{
						char ch = lastname.charAt(i);
						if(specialCharactersString.contains(Character.toString(ch))) 
						{
		            	result = "Last name must not contain special characters";
		            	break;
						}    

		        	}
				}
					
		return result;		
	}

	
	public String validateFirstname(String firstname) {
		String result="";
		
		boolean digit = false;
		 char[] chars = firstname.toCharArray();
		 for(char chh : chars){
	         if(Character.isDigit(chh)){
	        	digit =true;
	         }
		 }
		
		char c = firstname.charAt(0);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

		if (!(Character.isUpperCase(c))) 
		{
			result ="First name must start with a capital letter"; 
		}
		else
			if(!stringSize(firstname,3,29)) {
				result = "First name must be 3 to 29 characters long";
			
				}
			else
				if (digit)
					result="First name must not contain a number";
				else {
					for (int i=0; i < firstname.length() ; i++)
		        	{
						char ch = firstname.charAt(i);
						if(specialCharactersString.contains(Character.toString(ch))) 
						{
		            	result = "First name must not contain special characters";
		            	break;
						}    

		        	}
				}
					
		return result;		
	}
	

	
	public String validateNumber(String number) {
		String result="";
		if (number.length()!=10)
			result="Phone number must be 10 digits in length";
		else
			if (!isTextAnInteger(number))
				result="Phone number must be a number";
		return result;		
	}

	public String validateRoomnumber(String roomnumber) {
		String result="";
		int length_roomnumber = String.valueOf(roomnumber).length();
		try {
		int intRoomnumber = Integer.parseInt(roomnumber);
		
		if (length_roomnumber!=3)
			result="Roomnumber must be 3 digits in length";
		
			else
				
				if (!(Math.max(100, intRoomnumber) == Math.min(intRoomnumber, 199)))
					result="Roomnumber must be between 100 and 199";
		return result;		
		
		}
		catch (NumberFormatException e) 
        {
            result="Roomnumber must be a number";
            return result;
        }
			
	}

	public String validateDecknumber(String decknumber) {
		String result="";
		int length_decknumber = String.valueOf(decknumber).length();

		
		try {
			int intDecknumber = Integer.parseInt(decknumber);
			
			if (!(length_decknumber <= 2 ))
				result="Decknumber must be 1 or 2 digits in length";
			
				else
					if (!(Math.max(1, intDecknumber) == Math.min(intDecknumber, 15)))
						result="Decknumber must be between 1 and 15";
			return result;	
			
			}
			catch (NumberFormatException e) 
	        {
	            result="Decknumber must be a number";
	            return result;
	        }
		
			
	}

	
	
	public String validateEmail(String email) {
		String result="",extension="";
		if (!email.contains("@"))
			result = "Email address needs to contain @";
		else
			if (!stringSize(email,7,45))
				result="Email address must be between 7 and 45 characters long";
			else {
				extension = email.substring(email.length()-4, email.length());
				List<String> allowedExtensions = new ArrayList<String>(6); 
				allowedExtensions.add(".org"); 
				allowedExtensions.add(".edu"); 
				allowedExtensions.add(".com");
				allowedExtensions.add(".net");
				allowedExtensions.add(".gov");
				allowedExtensions.add(".mil");


				if (!(allowedExtensions.contains(extension)))
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

