package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class UserLoginTest {
	
	UserLogin usrL;
	UserLoginErrorMsgs UerrMsgs;
	
	@Before
	public void setUp() throws Exception {
		//usrL = new UserLogin();
		UerrMsgs = new UserLoginErrorMsgs();
	}	

	@Test
	@FileParameters("src/model/Login.csv")
	public void test(int tc, String username, String password,String usernameError, String passwordError ) {
//	try {	Integer.parseInt(roomnumber); 
//		int rm = Integer.parseInt(roomnumber);
//		}
//	catch(NumberFormatException e) {
//		rm = roomnumber;
//	}
	//	int dm = Integer.parseInt(decknumber);
		UserLogin userL = new UserLogin( username, password);
		//usr.( username, password,  lastname,  firstname ,  email,  number,  roomnumber,  decknumber,  membership);
		userL.validateUser(userL, UerrMsgs);
		assertTrue(usernameError.equals(UerrMsgs.getUsernameError()));
		
		assertTrue(passwordError.equals(UerrMsgs.getPasswordError()));
		

	}
	
	
}