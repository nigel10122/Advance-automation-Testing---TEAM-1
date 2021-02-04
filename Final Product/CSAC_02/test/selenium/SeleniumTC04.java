package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import data.EventDAO;
import data.UserDAO;
import functions.CSAC_02Functions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import model.User;
import util.ConnectionPro;
import util.Conversions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class SeleniumTC04 extends CSAC_02Functions{
	
	
	private StringBuffer verificationErrors = new StringBuffer();
	public String sAppURL,sSharedUIMapPath, testDelay ;
	private String username, password,firstname,lastname,email,number,roomnumber,decknumber,membership;
	
	EventDAO eventmodel = new EventDAO(ConnectionPro.getConnection());

	Conversions conversions = new Conversions();
	  
	  @Before
	  public void setUp() throws Exception {
		  	// Drivers
		    driver = invokeCorrectBrowser();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Dimension d = new Dimension(1280,1280);
		    driver.manage().window().setSize(d);;
		    // Load Properties
		    prop = new Properties();	
		    prop.load(new FileInputStream("./User/Passenger.properties"));
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
		    sAppURL = prop.getProperty("sAppURL");
			sSharedUIMapPath = prop.getProperty("SharedUIMap");
			prop.load(new FileInputStream(sSharedUIMapPath));
			testDelay=prop.getProperty("testDelay");
			UserDAO db =  new UserDAO(ConnectionPro.getConnection());
			User user = db.login(username, password);
			firstname = user.getFirstname();
			lastname = user.getLastname();
			email = user.getEmail();
			number=user.getNumber();
			roomnumber = user.getRoomnumber();
			decknumber = user.getDecknumber();
			membership = user.getMembership();
			
			
			
}
	  
	  	@Test
	    @FileParameters("test/excel/Selenium_TC04a_test_cases.csv")
	  	public void TC04A(int testCaseNumber, 
	  			          String profile_page_tittle, String update_profile_page_title, 
	  			          String username_label, String password_label, String lastname_label, String firstname_label, String email_label, String number_label, 
	  			          String roomnumber_label, String decknumber_label,String membership_label) throws InterruptedException {
	  		String methodName= new Throwable().getStackTrace()[0].getMethodName();
			driver.get(sAppURL);
			login_function(driver, username, password, methodName+" loginInputData TC "+testCaseNumber);
			Thread.sleep(1_000);
			driver.findElement(By.xpath(prop.getProperty("Passenger_View_Profile_Link"))).click();
			Thread.sleep(1_000);
			verifyViewProfilePageLabels(driver,"View_Profile_Page_Title_",profile_page_tittle,
					  "Profile_Page_Username_Label",username_label,
					  "Profile_Page_Password_label",password_label,
					  "Profile_Page_Lname_label",lastname_label,
					  "Profile_Page_Fname_label",firstname_label,
					  "Profile_Page_Email_label",email_label,
					  "Profile_Page_Number_label",number_label,
					  "Profile_Page_RoomNumber_label",roomnumber_label,
					  "Profile_Page_Decknumber_label",decknumber_label,
					  "Profile_Page_Membership_label",membership_label,
					  methodName+" VerifyHeadersListAllEvents TC "+testCaseNumber);
			verifyUserProfileData(driver,username,password,methodName+"VerifyUserProfileData");
			driver.findElement(By.xpath(prop.getProperty("Profile_Page_Update_Profile_Button"))).click();
			verifyViewProfilePageLabels(driver,"Update_Profile_Page_Title",update_profile_page_title,
					  "Update_Profile_Page_Username_Label",username_label,
					  "Update_Profile_Page_Password_label",password_label,
					  "Update_Profile_Page_Lname_label",lastname_label,
					  "Update_Profile_Page_Fname_label",firstname_label,
					  "Update_Profile_Page_Email_label",email_label,
					  "Update_Profile_Page_Number_label",number_label,
					  "Update_Profile_Page_RoomNumber_label",roomnumber_label,
					  "Update_Profile_Page_Decknumber_label",decknumber_label,
					  "Update_Profile_Page_Membership_label",membership_label,
					  methodName+" VerifyHeadersListAllEvents TC "+testCaseNumber);
			verifyUpdateProfilePageFinalData(driver,username,password,methodName+"VerifyUpdateProfilePageFinalData");		   
	  	}
	  	
	  	
	  	
	  	@Test
	  	@FileParameters("test/excel/Selenium_TC04b_test_cases.csv")
	  	public void TC04B(int testCaseNumber, String username,
	  			          String lastname_erroneous_data, String firstname_erroneous_data, String password_erroneous_data, String email_erroneous_data, String number_erroneous_data, String roomnumber_erroneous_data, String decknumber_erroneous_data,String membership,
	  			 		  String lastnameErrorMessage, String firstnameErrorMessage, String passwordErrorMessage, String emailErrorMessage, String numberErrorMessage, String RoomNumberErrorMessage, String deckNumberErrorMessage) throws InterruptedException {
	  		String methodName= new Throwable().getStackTrace()[0].getMethodName();
			driver.get(sAppURL);
			login_function(driver, username, password, methodName+" loginInputData TC "+testCaseNumber);
			driver.findElement(By.xpath(prop.getProperty("Passenger_View_Profile_Link"))).click();
			driver.findElement(By.xpath(prop.getProperty("Profile_Page_Update_Profile_Button"))).click();
			Update_Profile_function( driver, lastname_erroneous_data, firstname_erroneous_data, password_erroneous_data, email_erroneous_data,
					number_erroneous_data, roomnumber_erroneous_data, decknumber_erroneous_data, membership, methodName+" UpdateProfileErrormsgs TC "+testCaseNumber);
			verifyUpdate_ProfileErrorMessages(driver,  lastnameErrorMessage,  firstnameErrorMessage, 
					   passwordErrorMessage,  emailErrorMessage,  numberErrorMessage,  RoomNumberErrorMessage, 
					   deckNumberErrorMessage, methodName+" VerifyProfileErrormsgs TC "+testCaseNumber);		   
	  	}
  
	  	
	  	@Test
		@FileParameters("test/excel/Selenium_TC04c_test_cases.csv")
	  	public void TC04C(int testCaseNumber, String usersuccessmessage, String welcome ) throws InterruptedException {
	  		String methodName= new Throwable().getStackTrace()[0].getMethodName();
			driver.get(sAppURL);
			login_function(driver, username, password, methodName+" loginInputData TC ");
			driver.findElement(By.xpath(prop.getProperty("Passenger_View_Profile_Link"))).click();
			driver.findElement(By.xpath(prop.getProperty("Profile_Page_Update_Profile_Button"))).click();
			Update_Profile_function( driver, lastname, firstname, password, email,
					number, roomnumber, decknumber, membership, methodName+" UpdateProfile TC ");
			assertEquals(usersuccessmessage,driver.findElement(By.xpath(prop.getProperty("Update_successfull_message"))).getText());
			verify_Passenger_Welcome_Title(driver,username,password,methodName+"VerifyWelcomeTitle"+"1");
			driver.findElement(By.xpath(prop.getProperty("Passenger_Go_Back_1"))).click();
			verify_Passenger_Welcome_Title(driver,username,password,methodName+"VerifyWelcomeTitle"+"2");
			driver.findElement(By.xpath(prop.getProperty("Passenger_Go_Back_2"))).click();
			verify_Passenger_Welcome_Title(driver,username,password,methodName+"VerifyWelcomeTitle"+"3");
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Logout_Link"))));
			driver.findElement(By.xpath(prop.getProperty("Logout_Link"))).click();
			assertEquals(welcome,driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))).getText());
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))));
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
	  