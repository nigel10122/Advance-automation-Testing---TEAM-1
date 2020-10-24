package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class UserTest { 
	
	User usr;
	UserErrorMsgs UerrMsgs; 
	
	@Before
	public void setUp() throws Exception {
		usr = new User();
		UerrMsgs = new UserErrorMsgs();
	}	

	@Test
	@FileParameters("src/model/Registration.csv")
	public void test(int tc, String username, String lastname,String firstname, String password, String email , String number, String roomnumber, String decknumber, String membership, 
			String role, String usernameError, String lastnameError, String firstnameError, String passwordError, String emailError, String numberError, String roomnumberError,
			String decknumberError, String nameCombinationError, String errorMsg ) {
//	try {	Integer.parseInt(roomnumber); 
//		int rm = Integer.parseInt(roomnumber);
//		}
//	catch(NumberFormatException e) {
//		rm = roomnumber;
//	}
	//	int dm = Integer.parseInt(decknumber);
		User userModel = new User( username, password,  lastname,  firstname , email,  number,  roomnumber,  decknumber,  membership, role);
		//usr.( username, password,  lastname,  firstname ,  email,  number,  roomnumber,  decknumber,  membership);
		userModel.validateUser(userModel, UerrMsgs);
		assertTrue(usernameError.equals(UerrMsgs.getUsernameError()));
		assertTrue(lastnameError.equals(UerrMsgs.getLastnameError()));
		assertTrue(firstnameError.equals(UerrMsgs.getFirstnameError()));
		assertTrue(passwordError.equals(UerrMsgs.getPasswordError()));
		assertTrue(emailError.equals(UerrMsgs.getEmailError()));
		assertTrue(numberError.equals(UerrMsgs.getNumberError()));
		assertTrue(roomnumberError.equals(UerrMsgs.getRoomnumberError()));
		assertTrue(decknumberError.equals(UerrMsgs.getDecknumberError()));
		assertTrue(nameCombinationError.equals(UerrMsgs.getNameCombinationError()));
		assertTrue(errorMsg.equals(UerrMsgs.getErrorMsg()));

	}
}