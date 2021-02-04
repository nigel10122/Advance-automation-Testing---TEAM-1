package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ModelTC01 { 
	
	User usr;
	UserErrorMsgs UerrMsgs; 
	
	@Before
	public void setUp() throws Exception {
		usr = new User();
		UerrMsgs = new UserErrorMsgs();
	}	

	@Test
	@FileParameters("test/excel/Model_TC01_test_cases.csv")
	public void test(int tc, String username, String lastname,String firstname, String password, String email , String number, String roomnumber, String decknumber, String membership, 
			String role, String usernameError, String lastnameError, String firstnameError, String passwordError, String emailError, String numberError, String roomnumberError,
			String decknumberError, String nameCombinationError, String errorMsg, String membershipError, String roleError ) {

		User userModel = new User( username, password,  lastname,  firstname , email,  number,  roomnumber,  decknumber,  membership, role);
		
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
		assertTrue(membershipError.equals(UerrMsgs.getMembershipError()));
		assertTrue(roleError.equals(UerrMsgs.getRoleError()));
		
		assertTrue(errorMsg.equals(UerrMsgs.getErrorMsg()));

	}
}