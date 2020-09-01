package com.java.model;



public class UserErrorMsgs {

	private String errorMsg;
	private String usernameError;
	private String passwordError;
	private String lastnameError;
	private String firstnameError;
	private String emailError;
	private String numberError;
	private String roomnumberError;
	private String decknumberError;
	
	
	public UserErrorMsgs() {
		this.errorMsg = "";
		this.usernameError = "";
		this.passwordError = "";
		this.lastnameError = "";
		this.firstnameError = "";
		this.emailError = "";
		this.numberError = "";
		this.roomnumberError = "";
		this.decknumberError = "";
	
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
		if (!usernameError.equals("") || !passwordError.equals("") || !lastnameError.equals("") || !firstnameError.equals("")
		||  !emailError.equals("")|| !numberError.equals("")|| !roomnumberError.equals("")|| !decknumberError.equals(""))
			this.errorMsg = "Please correct the following errors";
	}
	public String getUsernameError() {
		return usernameError;
	}
	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}

	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}

	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
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

	public String getNumberError() {
		return numberError;
	}
	public void setNumberError(String numberError) {
		this.numberError = numberError;
	}

	public String getRoomnumberError() {
		return roomnumberError;
	}
	public void setRoomnumberError(String roomnumberError) {
		this.roomnumberError = roomnumberError;
	}
	public String getDecknumberError() {
		return decknumberError;
	}
	public void setDecknumberError(String decknumberError) {
		this.decknumberError = decknumberError;
	}

}