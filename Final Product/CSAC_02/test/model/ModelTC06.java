package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ModelTC06 { 
	
	User usr;
	UserErrorMsgs UerrMsgs; 
	
	@Before
	public void setUp() throws Exception {
		usr = new User();
		UerrMsgs = new UserErrorMsgs();
	}	

	@Test
	@FileParameters("test/excel/Model_TC06_test_cases.csv")
	public void test(int tc, String username, String lastname,String firstname, String password, String email , String number, String roomnumber, String decknumber, String membership, 
			String role, String lastnameError, String firstnameError, String passwordError, String emailError, String numberError, String roomnumberError,
			String decknumberError, String nameCombinationError, String errorMsg ) {

		User userModel = new User( username, password,  lastname,  firstname , email,  number,  roomnumber,  decknumber,  membership, role);
		
		usr.setUsername(username);
		usr.getUsername();
		usr.setLastname(lastname);
		usr.setPassword(password);
		usr.setFirstname(firstname);
		usr.setEmail(email);
		usr.setNumber(number);
	
		usr.setDecknumber(decknumber);
		usr.setRoomnumber(roomnumber);
		usr.getRole();
		usr.setRole(role);
		usr.getMembership();
		usr.setMembership(membership);

		userModel.validateUserUpdateProfile(userModel, UerrMsgs);
	
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