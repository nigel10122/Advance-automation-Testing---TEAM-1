package selenium;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Dimension;
import functions.CSAC_02Functions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

// --------------------------------------------------------- SELENIUM REGISTER TEST---------------------------------------------------------------------------------------------------------// 

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class SeleniumTC01 extends CSAC_02Functions{

	private StringBuffer verificationErrors = new StringBuffer();
	public String sAppURL, sSharedUIMapPath, testDelay;
	  
	  @Before
	  public void setUp() throws Exception {
//		MAGIC CODE GOES HERE 
		    driver = invokeCorrectBrowser();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Dimension d = new Dimension(1280,1280);
		   
		    driver.manage().window().setSize(d);;
		    prop = new Properties();	  
		    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
			sAppURL = prop.getProperty("sAppURL");
			sSharedUIMapPath = prop.getProperty("SharedUIMap");
			testDelay=prop.getProperty("testDelay");
			prop.load(new FileInputStream(sSharedUIMapPath));
	  }
	  
	  @Test
	  @FileParameters("test/excel/Selenium_TC01_test_cases.csv")
	  public void TC01A(int testCaseNumber, String username, String lastname, String firstname, String password, String email,
			  					   String number, String roomNumber, String deckNumber, String membershipType,String usernameErrorMessage,
			  					   String lastnameErrorMessage, String firstnameErrorMessage,  String passwordErrorMessage, String emailErrorMessage, 
			  					   String numberErrorMessage, String roomNumberErrorMessage, String deckNumberErrorMessage, String nameCombinationError, 
			  					   String errMsg) throws Exception {
		  
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
	    driver.get(sAppURL);
	    MainApp_function(driver,FunctionEnum.Register); 
	    Register_function(driver, username, lastname, firstname, password, email, number, roomNumber, deckNumber, membershipType, methodName+" registerInputData TC "+testCaseNumber);
	    // verify error messages
	    verifyRegisterErrorMessages(driver, usernameErrorMessage, lastnameErrorMessage, firstnameErrorMessage, passwordErrorMessage, emailErrorMessage, 
	    		numberErrorMessage, roomNumberErrorMessage, deckNumberErrorMessage, nameCombinationError, errMsg, methodName+" verifyRegisterInputDataRespectiveErrorMessages TC "+testCaseNumber);
	  }
	  
	  @Test
	  public void TC01B() {
		String loginPageFormHeader = "Login Account";
		String afterRegistrationPageHeader= "User registered successfully";
		int linkNumber=1;
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
	    MainApp_function(driver,FunctionEnum.Register); 
	    verifyRegisterPageLinks(driver, loginPageFormHeader,methodName+" verifyRegisterLinkedPageTitle TC 1 ",linkNumber);
	    linkNumber++;
		driver.get(sAppURL);
		MainApp_function(driver,FunctionEnum.Register); 
	    verifyRegisterPageLinks(driver, afterRegistrationPageHeader,methodName+" verifyRegisterLinkedPageTitle TC "+linkNumber,linkNumber);
		driver.get(sAppURL); // to reach the happy state


	  }
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

}
