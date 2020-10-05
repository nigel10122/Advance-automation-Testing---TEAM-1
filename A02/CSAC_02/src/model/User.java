package model;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import data.UserDAO;



public class User {
	 int id;
	 String username;
	 String password;
	 String lastname;
	 String firstname;
	 String email;
	 String number;
	 int roomnumber;
	 int decknumber;
	 String membership;
	 String role;
	 String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
	 String currentTime = new SimpleDateFormat("hh:mm aa").format(Calendar.getInstance().getTime());

    public User()
    {
    	
    }
    
    public User(String firstname, String email, String username) {
        this.firstname = firstname;
        this.email = email;
        this.username = username;
    }




    public User(String username,String password, String lastname, String firstname , String email, String number, int roomnumber, int decknumber, String membership) {
    	this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.number = number;
        this.roomnumber = roomnumber;
        this.decknumber = decknumber;
        this.membership = membership;
    }


    public User(String username,String password, String lastname, String firstname , String email, String number, int roomnumber, int decknumber, String membership,String role) {
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
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String role)
    {
    	this.role = role;
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

	public int getRoomnumber() {
		return roomnumber;
	}
	
	public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
	}

	public int getDecknumber() {
		return decknumber;
	}
	
	public void setDecknumber(int decknumber) {
        this.decknumber = decknumber;
	}

	public String getMembership() {
		return membership;
	}
	
	public void setMembership(String membership) {
        this.membership = membership;
	}
    
	public String getCurrentTime() {
		return currentTime;
	}
	
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	
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
			result = "firstname, lastname combination already in database";
		
		return result;
	}
	
    public String validateUsername_Login( String username) {
    	String result="";
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
			
	
		return result;

}
	
	
    public String validateUsername(String username) {
    	String result="";
    	char c = username.charAt(0);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		if (!UserDAO.Usernameunique(username))
			result = "Username already in database";
		else
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
			
	
		return result;

}
	
	
	public String validatePassword(String password) {
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
	

	public String validateLastname(String lastname) {
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

	
	public String validateFirstname(String lastname) {
		String result="";
		char c = lastname.charAt(0);
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

		if (!(c >= 'A' && c <= 'Z')) 
		{
			result ="First name must start with a capital letter"; 
		}
		else
			if(!stringSize(lastname,3,29)) {
				result = "First name must be 3 to 29 characters long";
			
				}
			else
				if (isTextAnInteger(lastname))
					result="First name must not be a number";
				else {
					for (int i=0; i < lastname.length() ; i++)
		        	{
						char ch = lastname.charAt(i);
						if(specialCharactersString.contains(Character.toString(ch))) 
						{
		            	result = " First name must not contain special characters";
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

	public String validateRoomnumber(int roomnumber) {
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

	public String validateDecknumber(int decknumber) {
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

	
	
	public String validateEmail(String email) {
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


