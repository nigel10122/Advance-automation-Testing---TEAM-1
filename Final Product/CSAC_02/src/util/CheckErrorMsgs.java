package util;

import java.util.ArrayList;
import java.util.List;

public class CheckErrorMsgs {
	
	
	public String LoginErrorMsg(String usernameError, String passwordError) {
		String errorMsg = "";
		String check;
		List<String> errorPresent = new ArrayList<String>(6); 
		errorPresent.add(usernameError); 
		errorPresent.add(passwordError);
		for(int counter = 0; counter < errorPresent.size(); counter++) {
			check = errorPresent.get(counter);
			if(check!="") {
				errorMsg = "Please correct the following errors";
				
			}
		}
		return errorMsg;
}
	
	
	public String RegisterErrorMsg(String usernameError, String numberError, String roomnumberError, String lastnameError, String firstnameError, String emailError, String decknumberError,String passwordError, String nameCombinationError) {
		String errorMsg = "";
		List<String> errorPresent = new ArrayList<String>(6); 
		errorPresent.add(usernameError); 
		errorPresent.add(numberError); 
		errorPresent.add(roomnumberError);
		errorPresent.add(lastnameError);
		errorPresent.add(firstnameError);
		errorPresent.add(emailError);
		errorPresent.add(decknumberError);
		errorPresent.add(passwordError);
		errorPresent.add(nameCombinationError);
		String check;
		for(int counter = 0; counter < errorPresent.size(); counter++) {
			check = errorPresent.get(counter);
			if(check!="") {
				errorMsg = "Please correct the following errors";

			}
		}
		
		return errorMsg;
		
	}	
	
	public String UpdateprofileErrorMsg( String numberError, String roomnumberError, String lastnameError, String firstnameError, String emailError, String decknumberError,String passwordError) {
		String errorMsg = "";
		List<String> errorPresent = new ArrayList<String>(6); 
		errorPresent.add(numberError); 
		errorPresent.add(roomnumberError);
		errorPresent.add(lastnameError);
		errorPresent.add(firstnameError);
		errorPresent.add(emailError);
		errorPresent.add(decknumberError);
		errorPresent.add(passwordError);
		String check;
		for(int counter = 0; counter < errorPresent.size(); counter++) {
			check = errorPresent.get(counter);
			if(check!="") {
				errorMsg = "Please correct the following errors";

			}
		}
		
		return errorMsg;
		
	}	
	
	
	public String ModifyEventErrorMsg(String eventdateError,String capacityError,String durationError, String locationError,String numberofattendeesError,String estattendeesError, String starttimeError) {
		String errorMsg = "";
		List<String> errorPresent = new ArrayList<String>(6); 
		errorPresent.add(eventdateError); 
		errorPresent.add(capacityError);
		errorPresent.add(durationError);
		errorPresent.add(locationError);
		errorPresent.add(numberofattendeesError);
		errorPresent.add(estattendeesError);
		errorPresent.add(starttimeError);

		

		String check;
		for(int counter = 0; counter < errorPresent.size(); counter++) {
			check = errorPresent.get(counter);
			if(check!="") {
				errorMsg = "Please correct the following errors";

			}
		}
		return errorMsg;
		
	}
	
	
	
	
	

}
