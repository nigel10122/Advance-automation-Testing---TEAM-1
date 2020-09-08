package cruiseShipActivityCoordinationSystem.model;



public class UserErrorMsgs {

	private String errorMsg;
	private String usernameError;
	private String phoneError;
	private String roomnumberError;
	private String lastnameError;
	private String firstnameError;
	private String emailError;
	private String decknumberError;
	private String passwordError;
	private String nameCombinationError;

	
	
	public UserErrorMsgs() {
		this.errorMsg = "";
		this.usernameError = "";
		this.phoneError = "";
		this.roomnumberError = "";
		this.lastnameError = "";
		this.firstnameError = "";
		this.emailError = "";
		this.decknumberError = "";
		this.passwordError = "";
		this.nameCombinationError = "";

		
	}

	public String getErrorMsg() {
		return errorMsg;
	}
//
//  NOTE: 	The following code is not representative of how this would be coded in an industrial application.
//			We are using this code to maximize the ability of Pit to mutate the code to determine how
//			good the developed test cases are. This course is using this Java backend code as an application
//			of the principles learned in CSE 5321 only.
//	
public void setErrorMsg() {
		if (!usernameError.equals("") || !phoneError.equals("") || !roomnumberError.equals("") || !lastnameError.equals("") 
			|| !firstnameError.equals("") || !emailError.equals("") || !decknumberError.equals("") || !passwordError.equals("")
			|| !nameCombinationError.equals(""))
			this.errorMsg = "Please correct the following errors";
	}
	public String getUsernameError() {
		return usernameError;
	}
	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}
	public String getPhoneError() {
		return phoneError;
	}
	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}
	public String getRoomnumberError() {
		return roomnumberError;
	}
	public void setRoomnumberError(String roomnumberError) {
		this.roomnumberError = roomnumberError;
	}
	public String getLastnameError() {
		return lastnameError;
	}
	public void setLastnameError(String lastnameError) {
		this.lastnameError = lastnameError;
	}
	public String getFirstnameError() {
		return firstnameError;
	}
	public void setFirstnameError(String firstnameError) {
		this.firstnameError = firstnameError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public String getDecknumberError() {
		return decknumberError;
	}
	public void setDecknumberError(String decknumberError) {
		this.decknumberError = decknumberError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getNameCombinationError() {
		return nameCombinationError;
	}
	public void setNameCombinationError(String nameCombinationError) {
		this.nameCombinationError = nameCombinationError;
	}
	
}