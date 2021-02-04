package model;

import java.util.ArrayList;
import java.util.List;

public class UserLoginErrorMsgs {

	private String usernameError;
	private String passwordError;
	
	public UserLoginErrorMsgs() {
		
		this.usernameError = "";
		this.passwordError = "";

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
		
}
