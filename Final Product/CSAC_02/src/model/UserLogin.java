package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class UserLogin {
	
	 String username;
	 String password;
	 String lastname;
	 String firstname;
	 String email;
	 String number;
	 String roomnumber;
	 String decknumber;
	 String membership;

	    
	 
	public UserLogin(String username, String password) {
       this.username = username;
       this.password = password;
   }
	
	public String getUsername() {
			return username;
		}

		
	public String getPassword() {
			return password;
		}

	

public void validateUser (UserLogin userL, UserLoginErrorMsgs errorMsgs) {
		
		errorMsgs.setUsernameError(validateUsername_Login(userL.getUsername()));
		errorMsgs.setPasswordError(validatePassword(userL.getPassword()));
		
	}
	
	
	 public String validateUsername_Login( String username) {
	    	String result="";
	    	char c = username.charAt(0);
			String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
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
	

		private boolean stringSize(String string, int min, int max) {
			return string.length()>=min && string.length()<=max;
		}
		
	
	

}
