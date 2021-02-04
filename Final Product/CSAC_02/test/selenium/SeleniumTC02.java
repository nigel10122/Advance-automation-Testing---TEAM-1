package selenium;

import static org.junit.Assert.fail;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import functions.CSAC_02Functions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

//--------------------------------------------------------- SELENIUM LOGIN TEST---------------------------------------------------------------------------------------------------------// 

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC02 extends CSAC_02Functions{
	
	
	private StringBuffer verificationErrors = new StringBuffer();
	public String sAppURL, sSharedUIMapPath, testDelay;
	@SuppressWarnings("unused")
	private String username,password;
 
  
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
			prop.load(new FileInputStream("./User/Coordinator.properties"));
			username = prop.getProperty("username");
			password = prop.getProperty("password");
}
	  
	
	  
	  @Test
	  @FileParameters("test/excel/Selenium_TC02_test_cases.csv")
	  public void TC02A(int testCaseNumber, String username, String password, String usernameErrorMessage, String passwordErrorMessage, String invalidErrorMsg) throws Exception {
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
	    driver.get(sAppURL);
	 //   MainApp_function(driver,FunctionEnum.Login); 
	    login_function(driver, username, password, methodName+" loginInputData TC "+testCaseNumber);
	   
	    // verify error messages
	    verifyLoginErrorMessages(driver, usernameErrorMessage, passwordErrorMessage, invalidErrorMsg, 
	    		methodName+" verifyInputLoginRespectiveErrorMessages TC "+testCaseNumber);
	  }
	  
	  @Test
	  public void TC02B() {
		String registerPageFormHeader = "Register Account";
		int linkNumber=1;
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		verifyLoginPageLinks(driver, registerPageFormHeader, methodName+" verifyNextPageTitle TC 1",linkNumber);
		linkNumber++;
		driver.get(sAppURL);
		String welcomePageLink = "MANAGER HOME PAGE";
		verifyLoginPageLinks(driver, welcomePageLink, methodName+" verifyNextPageTitle TC "+linkNumber,linkNumber);
		VerifyCurrentDateTime(driver,methodName+"VerifyCurrentDateTime");
		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Logout_Link"))));
		driver.findElement(By.xpath(prop.getProperty("Manager_Logout_Link"))).click();
		
		
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
