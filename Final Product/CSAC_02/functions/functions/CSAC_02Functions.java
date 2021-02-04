package functions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import data.EventDAO;
import data.ReservationDAO;
import data.UserDAO;
import model.Event;
import model.Reservation;
import model.User;
import util.ConnectionPro;
import util.GetDateTime;

public class CSAC_02Functions {

	Connection conn = ConnectionPro.getConnection();  
	
	  public WebDriver driver;
	  public Properties prop;
	  Random rand = new Random();
	  public enum FunctionEnum {Login, Register}
	  
	  public WebDriver invokeCorrectBrowser () {
			System.setProperty("webdriver.chrome.driver", "c:/ChromeDriver/chromedriver.exe");
			return new ChromeDriver();
	  }

	  public void takeScreenShot (WebDriver driver, String screenshotname) {
		  //Take screenshot and save it in source object
		  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  // Define path where Screenshots will be saved
	
		  //Copy the source file at the screenshot path
		  try {
			FileUtils.copyFile(source, new File("./ScreenShots/" + screenshotname +".png"));
		} catch (IOException e1) {}
		    try {
//			    Change the thread value to run test files with delay
				Thread.sleep(3_000);
			} catch (InterruptedException e) {}
	  }
	  
	  public void MainApp_function (WebDriver driver, FunctionEnum function) {
		  switch (function) {
		  	case Login:
			    driver.findElement(By.xpath(prop.getProperty("MainApp_loginButton"))).click(); //select List Company from homepage
			    break;
		  	case Register:
		  	    driver.findElement(By.xpath(prop.getProperty("MainApp_RegisterPageLink"))).click(); //select Insert Company from homepage
		  	    break;
		  }
	  }
	  
	  public void login_function (WebDriver driver, String username, String password, String snapShotName) {
		  try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    driver.findElement(By.xpath(prop.getProperty("MainApp_UsernameInputField"))).sendKeys(username);
		    driver.findElement(By.xpath(prop.getProperty("MainApp_PasswordInputField"))).sendKeys(password);
		    try {
				Thread.sleep(1_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    takeScreenShot(driver,snapShotName);
		    driver.findElement(By.xpath(prop.getProperty("MainApp_loginButton"))).click(); //click on insertCompany button
		   
	  }
	  
	  public void verifyLoginErrorMessages (WebDriver driver, String usernameError, String passwordError,String invalidError, String snapShotName) {
			assertTrue(driver.findElement(By.xpath(prop.getProperty("MainApp_UsernameErrorMsg"))).getText().equals(usernameError));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("MainApp_PasswordErrorMsg"))).getText().equals(passwordError));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("MainApp_invalidErrorMsg"))).getText().equals(invalidError));

			takeScreenShot(driver,snapShotName);
}
	  
	  public void verifyLoginPageLinks(WebDriver driver, String nextPageTitle,String snapShotName, int linkNumber) {
		if(linkNumber==1) {
		  driver.findElement(By.xpath(prop.getProperty("MainApp_RegisterPageLink"))).click();
		  try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_formHeader"))).getText().equals(nextPageTitle));
		  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Register_formHeader"))));
		  takeScreenShot(driver,snapShotName);
		}
		  if(linkNumber==2) {
		  driver.findElement(By.xpath(prop.getProperty("MainApp_UsernameInputField"))).sendKeys("nigel10122");
		  driver.findElement(By.xpath(prop.getProperty("MainApp_PasswordInputField"))).sendKeys("Plmqaz@098");
		  driver.findElement(By.xpath(prop.getProperty("MainApp_loginButton"))).click(); //click on insertCompany button
		  try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  String welcome_name_actual = driver.findElement(By.xpath(".//*[@id='title']")).getText();
		  UserDAO db =  new UserDAO(ConnectionPro.getConnection());
			
		   String username = "nigel10122";
		   String password = "Plmqaz@098";
	       User user = db.login(username, password);
	       
	       String welcome_name_expected = "Welcome"+" "+user.getFirstname()+" "+user.getLastname();
	       System.out.println(welcome_name_expected);
	      
	       System.out.println(welcome_name_actual);
	       assertEquals(welcome_name_expected,welcome_name_actual);
	       HighLight(driver,driver.findElement(By.xpath(".//*[@id='title']")));
	       try {
				Thread.sleep(2_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  assertTrue(driver.findElement(By.xpath(prop.getProperty("Welcome_pageHeading"))).getText().equals(nextPageTitle));
		  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Welcome_pageHeading"))));
		  
		  
		  takeScreenShot(driver,snapShotName);
		  	
		  }
	  }
	  
	  public void Register_function(WebDriver driver, String username, String lastname, String firstname, String password, String email,
			  String number, String roomnumber, String decknumber, String membershipType, String snapShotName) {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  	driver.findElement(By.xpath(prop.getProperty("Register_usernameInput"))).sendKeys(username);
		    driver.findElement(By.xpath(prop.getProperty("Register_passwordInput"))).sendKeys(password);
		    driver.findElement(By.xpath(prop.getProperty("Register_lastnameInput"))).sendKeys(lastname);
		    driver.findElement(By.xpath(prop.getProperty("Register_firstnameInput"))).sendKeys(firstname);
		    driver.findElement(By.xpath(prop.getProperty("Register_emailInput"))).sendKeys(email);
		    driver.findElement(By.xpath(prop.getProperty("Register_numberInput"))).sendKeys(number);
		    driver.findElement(By.xpath(prop.getProperty("Register_roomNumberInput"))).sendKeys(roomnumber);
		    driver.findElement(By.xpath(prop.getProperty("Register_deckNumberInput"))).sendKeys(decknumber);
		    new Select(driver.findElement(By.xpath(prop.getProperty("Register_membershipTypeDropDown")))).selectByVisibleText("Superior");
		    takeScreenShot(driver,snapShotName);
		    driver.findElement(By.xpath(prop.getProperty("Register_registerButton"))).click(); //click on insertCompany button
		    HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Register_registerButton"))));
		    /*   try {
		    		Thread.sleep(1_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		  
	  }

	  public void verifyRegisterErrorMessages(WebDriver driver, String usernameErrorMessage, String lastnameErrorMessage, String firstnameErrorMessage, 
			  String passwordErrorMessage, String emailErrorMessage, String numberErrorMessage, String RoomNumberErrorMessage, 
			  String deckNumberErrorMessage, String nameCombinationError, String errMsg, String snapShotName) {
		  
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_usernameErrorMsg"))).getText().equals(usernameErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_passwordErrorMsg"))).getText().equals(passwordErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_lastnameErrorMsg"))).getText().equals(lastnameErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_firstnameErrorMsg"))).getText().equals(firstnameErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_emailErrorMsg"))).getText().equals(emailErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_numberErrorMsg"))).getText().equals(numberErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_roomNumberErrorMsg"))).getText().equals(RoomNumberErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Register_deckNumberErrorMsg"))).getText().equals(deckNumberErrorMessage));
	//		assertTrue(driver.findElement(By.xpath(prop.getProperty("MainApp_PasswordErrorMsg"))).getText().equals(membershipTypeErrorMessage));

			takeScreenShot(driver,snapShotName);
		  
	  }
	  
	  
	  public void verifyRegisterPageLinks(WebDriver driver, String nextPageTitle,String snapShotName, int linkNumber) {
		  if(linkNumber==1) {
		  try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  driver.findElement(By.xpath(prop.getProperty("Register_loginPageLink"))).click();
		  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Register_loginPageLink"))));
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  assertTrue(driver.findElement(By.xpath(prop.getProperty("MainApp_loginFormHeader"))).getText().equals(nextPageTitle));
		  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("MainApp_loginFormHeader"))));
		  takeScreenShot(driver,snapShotName);
		  }
		  if(linkNumber==2) {
			  try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			  	int random = rand.nextInt(1000); 
			  	
			//
			  	
			  	driver.findElement(By.xpath(prop.getProperty("Register_usernameInput"))).sendKeys("robot"+random);
			    driver.findElement(By.xpath(prop.getProperty("Register_passwordInput"))).sendKeys("Qwerty!1");
			    driver.findElement(By.xpath(prop.getProperty("Register_lastnameInput"))).sendKeys("Robotic"+GetRandomCharacters());
			    driver.findElement(By.xpath(prop.getProperty("Register_firstnameInput"))).sendKeys("Robott");
			    driver.findElement(By.xpath(prop.getProperty("Register_emailInput"))).sendKeys("v@gmail.com");
			    driver.findElement(By.xpath(prop.getProperty("Register_numberInput"))).sendKeys("1234567890");
			    driver.findElement(By.xpath(prop.getProperty("Register_roomNumberInput"))).sendKeys("101");
			    driver.findElement(By.xpath(prop.getProperty("Register_deckNumberInput"))).sendKeys("2");
			    new Select(driver.findElement(By.xpath(prop.getProperty("Register_membershipTypeDropDown")))).selectByVisibleText("Superior");
			    takeScreenShot(driver,snapShotName);
			    driver.findElement(By.xpath(prop.getProperty("Register_registerButton"))).click(); //click on insertCompany button			  try {
				HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Register_registerButton"))));
			    try{ Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  assertTrue(driver.findElement(By.xpath(prop.getProperty("MainApp_afterRegistration"))).getText().equals(nextPageTitle));
			  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("MainApp_afterRegistration"))));
			  takeScreenShot(driver,snapShotName);
		  }
	  }
	  
	  
	  // COORDINATOR PART
	  
	  public void SearchAssignedEvents (WebDriver driver, String eventdate, String eventtime, String snapShotName) {
		  try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  	driver.findElement(By.xpath(prop.getProperty("Coordinator_Eventdate_InputField"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Coordinator_Eventdate_InputField"))).sendKeys(eventdate);
		    
		    driver.findElement(By.xpath(prop.getProperty("Coordinator_EventTime_InputField"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Coordinator_EventTime_InputField"))).sendKeys(eventtime);
		    try {
				Thread.sleep(1_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    takeScreenShot(driver,snapShotName);
		    driver.findElement(By.xpath(prop.getProperty("Coordinator_SearchEvent_Button"))).click(); //click on insertCompany button
		   
	  }
	  
	  public void verifyDateTimeErrormsgs(WebDriver driver, String eventdateError, String eventtimeError, String snapShotName) {
		  
		  	
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Coordinator_Eventdate_Errormsg"))).getText().equals(eventdateError));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Coordinator_EventTime_Errormsg"))).getText().equals(eventtimeError));
		

			takeScreenShot(driver,snapShotName);
}
	  
	  
	  public String [][] getCoordinatorAssignedpartialEventListFromDB(String eventdate, String starttime, String username, String password,int listSize) throws SQLException { // this method gets the list company table contents from the DB
		  	ArrayList<Event> fromDB = new ArrayList<Event>();
				UserDAO db =  new UserDAO(ConnectionPro.getConnection());
				User user = db.login(username, password);
				fromDB=EventDAO.CoordinatorAssignedevents(eventdate, starttime,user.getFirstname()+" "+user.getLastname());
		    String [][] arrayDB = new String [listSize-1][6];
		    System.out.println(Arrays.toString(arrayDB));
		    int i=0;
		    for (Event p:fromDB) {
		    	System.out.println("DATABASE DATA");
		    	arrayDB[i][0]=p.getEventname();
		    	System.out.println(arrayDB[i][0]);
		    	arrayDB[i][1]=p.getEventdate();
		    	System.out.println(arrayDB[i][1]);
		    	arrayDB[i][2]= p.getStarttime();
		    	System.out.println(arrayDB[i][2]);
		    	arrayDB[i][3]= p.getDuration();
		    	System.out.println(arrayDB[i][3]);
		    	arrayDB[i][4]= p.getLocation();
		    	System.out.println(arrayDB[i][4]);
		    	arrayDB[i][5]= p.getNumberofattendees();
		    	System.out.println(arrayDB[i][5]);
		    	
		 		i++;
		    }
		    return arrayDB;
		    
	  }
	  
	  
	  public void verifyCoordinatorAssignedEventsLinksandData(WebDriver driver,String eventdate, String starttime,String username, String password,int rows,String event_Details_Title_page,
															  String aboutevent_header_expected,String eventdetails_header_expected,String eventid_label_expected,String eventname_label_expected ,
															  String eventdate_label_expected,String starttime_label_expected ,String duration_label_expected,String location_label_expected ,
															  String numberofattendees_label_expected,String capacity_label_expected,String eventcoordinator_label_expected,String type_label_expected ,
															  String estattendees_label_expected ,String snapShotName) throws SQLException {
		  
		  	ArrayList<Event> eventindb = new ArrayList<Event>();
			UserDAO db =  new UserDAO(ConnectionPro.getConnection());
			User user = db.login(username, password);
		  	eventindb=EventDAO.CoordinatorAssignedevents(eventdate, starttime,user.getFirstname()+" "+user.getLastname());

	
		 
		 for(int i = 1;i<rows;i++) {
			  
			  
			  HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
					  prop.getProperty("Coordinator_Events_Summary_View_Details_Col"))));
			  driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
										  prop.getProperty("Coordinator_Events_Summary_View_Details_Col"))).click();
	
			  // Verify Header
			  assertEquals(event_Details_Title_page,driver.findElement(By.xpath(prop.getProperty("Coordinator_Assigned_Event_Details_Title"))).getText());
			  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Coordinator_Assigned_Event_Details_Title"))));
			  //Verify Labels							 					
	  			assertEquals(aboutevent_header_expected,driver.findElement(By.xpath(prop.getProperty("aboutevent_header_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("aboutevent_header_actual"))));
	  			assertEquals(eventdetails_header_expected,driver.findElement(By.xpath(prop.getProperty("eventdetails_header_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventdetails_header_actual"))));
	  			assertEquals(eventid_label_expected,driver.findElement(By.xpath(prop.getProperty("eventid_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventid_label_actual"))));
	  			assertEquals(eventname_label_expected,driver.findElement(By.xpath(prop.getProperty("eventname_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventname_label_actual"))));
	  			assertEquals(eventdate_label_expected,driver.findElement(By.xpath(prop.getProperty("eventdate_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventdate_label_actual"))));
	  			assertEquals(starttime_label_expected,driver.findElement(By.xpath(prop.getProperty("starttime_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("starttime_label_actual"))));
	  			assertEquals(duration_label_expected,driver.findElement(By.xpath(prop.getProperty("duration_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("duration_label_actual"))));
	  			assertEquals(location_label_expected,driver.findElement(By.xpath(prop.getProperty("location_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("location_label_actual"))));
	  			assertEquals(numberofattendees_label_expected,driver.findElement(By.xpath(prop.getProperty("numberofattendees_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("numberofattendees_label_actual"))));
	  			assertEquals(capacity_label_expected,driver.findElement(By.xpath(prop.getProperty("capacity_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("capacity_label_actual"))));
	  			assertEquals(eventcoordinator_label_expected,driver.findElement(By.xpath(prop.getProperty("eventcoordinator_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventcoordinator_label_actual"))));
	  			assertEquals(type_label_expected,driver.findElement(By.xpath(prop.getProperty("type_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("type_label_actual"))));
	  			assertEquals(estattendees_label_expected,driver.findElement(By.xpath(prop.getProperty("estattendees_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("estattendees_label_actual"))));
	  			//Get Expected Data
	  			int data_1 =    eventindb.get(i-1).getEventid();
	  			String data1 = Integer.toString(data_1);
		  		String data2 = eventindb.get(i-1).getEventname();
		  		String data3 = eventindb.get(i-1).getEventdate();
		  		String data4 = eventindb.get(i-1).getStarttime();
		  		String data5 = eventindb.get(i-1).getDuration();	
		  		String data6 = eventindb.get(i-1).getLocation();
		  		String data7 = eventindb.get(i-1).getNumberofattendees();
		  		String data8 = eventindb.get(i-1).getCapacity();
		  		String data9 = eventindb.get(i-1).getEventcoordinator();
		  		String data10 = eventindb.get(i-1).getType();
		  		String data11 = eventindb.get(i-1).getEstattendees();
		  		
		  	
		  		
		  		
		  
	  			//Verify Data
	  			assertEquals(data1,driver.findElement(By.xpath(prop.getProperty("eventid_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventid_actual"))));
	  			assertEquals(data2,driver.findElement(By.xpath(prop.getProperty("eventname_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventname_actual"))));
	  			assertEquals(data3,driver.findElement(By.xpath(prop.getProperty("eventdate_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventdate_actual"))));
	  			assertEquals(data4,driver.findElement(By.xpath(prop.getProperty("startime_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("startime_actual"))));
	  			assertEquals(data5,driver.findElement(By.xpath(prop.getProperty("duration_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("duration_actual"))));
	  			assertEquals(data6,driver.findElement(By.xpath(prop.getProperty("location_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("location_actual"))));
	  			assertEquals(data7,driver.findElement(By.xpath(prop.getProperty("numberofattendees_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("numberofattendees_actual"))));
	  			assertEquals(data8,driver.findElement(By.xpath(prop.getProperty("capacity_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("capacity_actual"))));
	  			assertEquals(data9,driver.findElement(By.xpath(prop.getProperty("eventcoordinator_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("eventcoordinator_actual"))));
	  			assertEquals(data10,driver.findElement(By.xpath(prop.getProperty("type_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("type_actual"))));
	  			assertEquals(data11,driver.findElement(By.xpath(prop.getProperty("estattendees_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("estattendees_actual"))));
	  		
	  			 
	  			 System.out.println("Welcome"+" "+user.getFirstname()+" "+user.getLastname());
	  			 System.out.println(driver.findElement(By.xpath(prop.getProperty("Coordinator_homePageTitle"))).getText());
	  			
		  		
		  		assertEquals("Welcome"+" "+user.getFirstname()+" "+user.getLastname(),driver.findElement(By.xpath(prop.getProperty("Coordinator_homePageTitle"))).getText());
	  			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_homePageTitle")))); 
	  			//Goback
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Coordinator_GO_BACK_1"))));
	  			driver.findElement(By.xpath(prop.getProperty("Coordinator_GO_BACK_1"))).click();
	  			
	  			
	  			
		 }

		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Coordinator_GO_BACK_1"))));
		 		driver.findElement(By.xpath(prop.getProperty("Coordinator_GO_BACK_1"))).click();
		 		assertEquals("Welcome"+" "+user.getFirstname()+" "+user.getLastname(),driver.findElement(By.xpath(prop.getProperty("Coordinator_homePageTitle"))).getText());
		 		HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_homePageTitle")))); 
		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Coordinator_Logout_Link"))));
		 		driver.findElement(By.xpath(prop.getProperty("Coordinator_Logout_Link"))).click();
		 		assertEquals("WELCOME",driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))).getText());
		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))));
	
}
	  
	  
	  
	  
 //------------------------------------------------------ USER --> Passenger Part-------------------------------------------------//
	  
	  
// Passenger Events	  
	  public void PassengerSearchEvents (WebDriver driver, String eventdate, String eventtime, String eventtype, String snapShotName) {
	
		  	driver.findElement(By.xpath(prop.getProperty("Passenger_ListAllEvents_Link"))).click();
		  	driver.findElement(By.xpath(prop.getProperty("Passenger_EventDate_InputField"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Passenger_EventDate_InputField"))).sendKeys(eventdate);
		    driver.findElement(By.xpath(prop.getProperty("Passenger_EventTime_InputField"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Passenger_EventTime_InputField"))).sendKeys(eventtime);
		    new Select(driver.findElement(By.xpath(prop.getProperty("Passenger_EvntType_SelectField")))).selectByVisibleText(eventtype);
		    takeScreenShot(driver,snapShotName);
		    driver.findElement(By.xpath(prop.getProperty("Passenger_ListAllEvents_Submit_Button"))).click(); //click on insertCompany button
		   
}

	  
	  public String [][] getpartialEventListFromDB(String eventdate, String starttime, String type, int listSize) throws SQLException { // this method gets the list company table contents from the DB
		    ArrayList<Event> fromDB= EventDAO.geteventsbasedonshowtype(eventdate, starttime, type);
		    String [][] arrayDB = new String [listSize-1][6];
		    int i=0;
		    for (Event p:fromDB) {
		    	arrayDB[i][0]=p.getEventname();
		    	arrayDB[i][1]=p.getEventdate();
		    	arrayDB[i][2]= p.getStarttime();
		    	arrayDB[i][3]= p.getDuration();
		    	arrayDB[i][4]= p.getLocation();
		    	arrayDB[i][5]= p.getEstattendees();
		    	
		 		i++;
		    }
		    return arrayDB;
	  }
	  
	  
	
	  
	  
	  public void verify_Passenger_Welcome_Title(WebDriver driver, String username, String password,String snapShotName) {
		  
		 String welcome_name_expected =  driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))).getText();
		 UserDAO db =  new UserDAO(ConnectionPro.getConnection());
		 User user = db.login(username, password);
	     String welcome_name_actual = "Welcome,"+" "+user.getFirstname();
	     assertEquals(welcome_name_expected,welcome_name_actual);
	     HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))));
	    
		 
  }
	  
	  public void verifyHeaders(WebDriver driver, 
			  					String actual_header1, String exp_header1,
			  					String actual_header2,String exp_header2,
			  					String actual_header3,String exp_header3,
			  					String actual_header4,String exp_header4, 
			  					String actual_header5,String exp_header5, 
			  					String actual_header6,String exp_header6, 
			  					String actual_header7,String exp_header7, 
			  					String actual_header8,String exp_header8, 
			  					String snapShotName) {
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header1))).getText().equals(exp_header1));
		  	HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header1))));
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header2))).getText().equals(exp_header2));
		  	HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header2))));
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header3))).getText().equals(exp_header3));
		  	HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header3))));
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header4))).getText().equals(exp_header4));
		  	HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header4))));
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header5))).getText().equals(exp_header5));
		  	HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header5))));
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header6))).getText().equals(exp_header6));
		  	HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header6))));
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header7))).getText().equals(exp_header7));
		  	HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header7))));
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header8))).getText().equals(exp_header8));
		  	HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header8))));
		  ;
		  	takeScreenShot(driver,snapShotName);
}

	  
	  public void verifyMakeReservationLinksandData(WebDriver driver,String eventdate,String starttime,String type,String username,String password,int rows,
													String welcomepage_header_expected,String header,String label1,String label2,String label3 ,String label4 ,
												  	String label5 ,String label6 ,String label7 ,String label8 ,String label9 ,String label10 ,
												  	String label11 ,String label12 ,String label13 ,String label14 ,String snapShotName) throws SQLException {
		  
		  	ArrayList<Event> eventindb = new ArrayList<Event>();
		  	eventindb=EventDAO.geteventsbasedonshowtype(eventdate, starttime, type);
			UserDAO db =  new UserDAO(ConnectionPro.getConnection());
			User user = db.login(username, password);

		 
		 for(int i = 1;i<rows;i++) {
			  
			  
			  HighLight(driver,driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					  prop.getProperty("listevent_View_Link"))));
			  driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
										  prop.getProperty("listevent_View_Link"))).click();
	
			  // Verify Header
			  assertEquals(header,driver.findElement(By.xpath(prop.getProperty("Make_Reservation_Form_Header"))).getText());
			  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Make_Reservation_Form_Header"))));
			  //Verify Labels							 					
			    assertEquals(label1,driver.findElement(By.xpath(prop.getProperty("Event_Name_Label"))).getText());
			    HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Name_Label"))));
	  			assertEquals(label2,driver.findElement(By.xpath(prop.getProperty("Event_Date_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Date_Label"))));
	  			assertEquals(label3,driver.findElement(By.xpath(prop.getProperty("Event_Duration_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Duration_Label"))));
	  			assertEquals(label4,driver.findElement(By.xpath(prop.getProperty("Event_Start_Time_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Start_Time_Label"))));
	  			assertEquals(label5,driver.findElement(By.xpath(prop.getProperty("Event_Location_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Location_Label"))));
	  			assertEquals(label6,driver.findElement(By.xpath(prop.getProperty("Event_NumberofAttendees_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_NumberofAttendees_Label"))));
	  			assertEquals(label7,driver.findElement(By.xpath(prop.getProperty("Event_Capacity_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Capacity_Label"))));
	  			assertEquals(label8,driver.findElement(By.xpath(prop.getProperty("Event_Coordinator_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Coordinator_Label"))));
	  			assertEquals(label9,driver.findElement(By.xpath(prop.getProperty("Event_Type_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Type_Label"))));
	  			assertEquals(label10,driver.findElement(By.xpath(prop.getProperty("Event_Estattendees_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Estattendees_Label"))));
	  			assertEquals(label11,driver.findElement(By.xpath(prop.getProperty("Users_Firstname_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Users_Firstname_Label"))));
	  			assertEquals(label12,driver.findElement(By.xpath(prop.getProperty("Users_Lastname_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Users_Lastname_Label"))));
	  			assertEquals(label13,driver.findElement(By.xpath(prop.getProperty("Users_Email_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Users_Email_Label"))));
	  			assertEquals(label14,driver.findElement(By.xpath(prop.getProperty("Users_Phone_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Users_Phone_Label"))));
	  			//Get Expected Data
		  		String data1 = eventindb.get(i-1).getEventname();
		  		String data2 = eventindb.get(i-1).getEventdate();
		  		String data3 = eventindb.get(i-1).getDuration();
		  		String data4 = eventindb.get(i-1).getStarttime();
		  		String data5 = eventindb.get(i-1).getLocation();
		  		String data6 = eventindb.get(i-1).getNumberofattendees();
		  		String data7 = eventindb.get(i-1).getCapacity();
		  		String data8 = eventindb.get(i-1).getEventcoordinator();
		  		String data9 = eventindb.get(i-1).getType();
		  		String data10 = eventindb.get(i-1).getEstattendees();
		  		String data11 = user.getFirstname();
		  		String data12 = user.getLastname();
		  		String data13 = user.getEmail();
		  		String data14 = user.getNumber();
	  			//Verify Data
	  			assertEquals(data1,driver.findElement(By.xpath(prop.getProperty("Event_Name"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Name"))));
	  			assertEquals(data2,driver.findElement(By.xpath(prop.getProperty("Event_Date"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Date"))));
	  			assertEquals(data3,driver.findElement(By.xpath(prop.getProperty("Event_Duration"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Duration"))));
	  			assertEquals(data4,driver.findElement(By.xpath(prop.getProperty("Event_Start_Time"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Start_Time"))));
	  			assertEquals(data5,driver.findElement(By.xpath(prop.getProperty("Event_Location"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Location"))));
	  			assertEquals(data6,driver.findElement(By.xpath(prop.getProperty("Event_NumberofAttendees"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_NumberofAttendees"))));
	  			assertEquals(data7,driver.findElement(By.xpath(prop.getProperty("Event_Capacity"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Capacity"))));
	  			assertEquals(data8,driver.findElement(By.xpath(prop.getProperty("Event_Coordinator"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Coordinator"))));
	  			assertEquals(data9,driver.findElement(By.xpath(prop.getProperty("Event_Type"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Type"))));
	  			assertEquals(data10,driver.findElement(By.xpath(prop.getProperty("Event_Estattendees"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Event_Estattendees"))));
	  			assertEquals(data11,driver.findElement(By.xpath(prop.getProperty("Users_Firstname"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Users_Firstname"))));
	  			assertEquals(data12,driver.findElement(By.xpath(prop.getProperty("Users_Lastname"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Users_Lastname"))));
	  			assertEquals(data13,driver.findElement(By.xpath(prop.getProperty("Users_Email"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Users_Email"))));
	  			assertEquals(data14,driver.findElement(By.xpath(prop.getProperty("Users_Phone"))).getAttribute("value"));
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Users_Phone"))));
	  			//Goback
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Go_Back_From_Reservation_Form"))));
	  			driver.findElement(By.xpath(prop.getProperty("Go_Back_From_Reservation_Form"))).click();
	  			
		 }

		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("goback_link"))));
		 		driver.findElement(By.xpath(prop.getProperty("goback_link"))).click();
		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Logout_Link"))));
		 		driver.findElement(By.xpath(prop.getProperty("Logout_Link"))).click();
		 		assertEquals(welcomepage_header_expected, driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))).getText());
		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))));
}
	  
	  public void verifyPassengerEventDateTimeErrormsgs(WebDriver driver, String eventdateError, String eventtimeError, String snapShotName) {
		  
		  	
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Passenger_EventDate_Error_Msg"))).getText().equals(eventdateError));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Passenger_EventTime_Error_Msg"))).getText().equals(eventtimeError));
		

			takeScreenShot(driver,snapShotName);
}

	  
	  
	  
// PASSENGER RESERVATION // 	  
	  
		  
	  
	  
	  public void PassengerSearchReservation(WebDriver driver, String eventdate, String eventtime, String snapShotName) {
		  try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  	
		  	driver.findElement(By.xpath(prop.getProperty("Passenger_Reservation_EventDate_InputField"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Passenger_Reservation_EventDate_InputField"))).sendKeys(eventdate);
		    
		    driver.findElement(By.xpath(prop.getProperty("Passenger_Reservation_EventTime_InputField"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Passenger_Reservation_EventTime_InputField"))).sendKeys(eventtime);
	
		
		    
		    try {
				Thread.sleep(1_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    takeScreenShot(driver,snapShotName);
		    driver.findElement(By.xpath(prop.getProperty("Passneger_Reservation_Search_Button"))).click(); //click on insertCompany button
		   
	  }
	  
	  
	  
	
	  public void verifyPassengerReservationDateTimeErrormsgs(WebDriver driver, String eventdateError, String eventtimeError, String snapShotName) {
		  
		  	
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Passenger_Reservation_EventDate_Errormsg"))).getText().equals(eventdateError));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Passenger_Reservation_EventTime_Errormsg"))).getText().equals(eventtimeError));
		

			takeScreenShot(driver,snapShotName);
}
	  

	  
	  public String [][] getpartialReservationListFromDB(String eventdate, String starttime, String firstname, String lastname, int listSize) throws SQLException { // this method gets the list company table contents from the DB
		    ArrayList<Reservation> fromDB= ReservationDAO.getPassengerEvents(eventdate, starttime, firstname,lastname);
		    String [][] arrayDB = new String [listSize-1][6];
		    int i=0;
		    for (Reservation p:fromDB) {
		    	arrayDB[i][0]=p.getEventname();
		    	arrayDB[i][1]=p.getEventdate();
		    	arrayDB[i][2]= p.getStarttime();
		    	arrayDB[i][3]= p.getDuration();
		    	arrayDB[i][4]= p.getLocation();
		    	arrayDB[i][5]= p.getEstattendees();
		    	
		 		i++;
		    }
		    return arrayDB;
	  }
	  
	  
	  public void verifyReservationDetailsLabelsandData(WebDriver driver,String eventdate, String starttime, String firstname, String lastname,int rows,
				String welcomepage_header_expected,
		 String header,
		String label1, 
		String label2,
	  	String label3,
	  	String label4,
	  	String label5,
	  	String label6,
	  	String label7,
	  	String label8,
	  	String label9,
	  	String label10,
	  	String label11,String snapShotName) throws SQLException {
		  
		  	ArrayList<Reservation> eventindb = new ArrayList<Reservation>();
		  	eventindb=ReservationDAO.getPassengerEvents(eventdate, starttime, firstname, lastname);
		
//		
//			String welcomepage_header_expected = "WELCOME";
//			 String header = "Selected Event Details";
//			String label1 = "Event ID:"; 
//			String label2 =  "Event Name :";
//		  	String label3 =  "Event Date :";
//		  	String label4 =  "Start Time:";
//		  	String label5 =  "Duration:";
//		  	String label6 =  "Location:";
//		  	String label7 =  "Number of Attendees :";
//		  	String label8 =  "Capacity :";
//		  	String label9 =  "Event Coordinator :";
//		  	String label10 =  "Event Type :";
//		  	String label11 = "Estimated Attendees :";

		 
		 for(int i = 1;i<rows;i++) {
			  
			  
			  HighLight(driver,driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					  prop.getProperty("listevent_View_Link"))));
			  driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
										  prop.getProperty("listevent_View_Link"))).click();
	
			  // Verify Header
			  assertEquals(header,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_Header"))).getText());
			  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_Header"))));
			  //Verify Labels							 					
			    assertEquals(label1,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventId_Label"))).getText());
			    HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventId_Label"))));
	  			assertEquals(label2,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_Eventname_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_Eventname_Label"))));
	  			assertEquals(label3,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventDate_Label_"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventDate_Label_"))));
	  			assertEquals(label4,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventTime_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventTime_Label"))));
	  			assertEquals(label5,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventDuration_Label_"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventDuration_Label_"))));
	  			assertEquals(label6,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventLocation_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventLocation_Label"))));
	  			assertEquals(label7,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventNoofattendees_Labels"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventNoofattendees_Labels"))));
	  			assertEquals(label8,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventCapacity_Label"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventCapacity_Label"))));
	  			assertEquals(label9,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventCoordinator_Labels"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventCoordinator_Labels"))));
	  			assertEquals(label10,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventType_Labels"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventType_Labels"))));
	  			assertEquals(label11,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventEstAttendees_Labels"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventEstAttendees_Labels"))));
	  	
	  			//Get Expected Data
	  			int data_1 = eventindb.get(i-1).getEventid();
	  			String data1 = Integer.toString(data_1);
		  		String data2 = eventindb.get(i-1).getEventname();
		  		String data3 = eventindb.get(i-1).getEventdate();
		  		String data5 = eventindb.get(i-1).getDuration();
		  		String data4 = eventindb.get(i-1).getStarttime();
		  		String data6 = eventindb.get(i-1).getLocation();
		  		String data7 = eventindb.get(i-1).getNumberofattendees();
		  		String data8 = eventindb.get(i-1).getCapacity();
		  		String data9 = eventindb.get(i-1).getEventcoordinator();
		  		String data10 = eventindb.get(i-1).getType();
		  		String data11 = eventindb.get(i-1).getEstattendees();
		  		

	  			//Verify Data
	  			assertEquals(data1,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventId_Data"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventId_Data"))));
	  			assertEquals(data2,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_Eventname_Data"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_Eventname_Data"))));
	  			assertEquals(data3,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventDate_Data_"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventDate_Data_"))));
	  			assertEquals(data4,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventTime_Data"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventTime_Data"))));
	  			assertEquals(data5,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventDuration_Data_"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventDuration_Data_"))));
	  			assertEquals(data6,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventLocation_Data"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventLocation_Data"))));
	  			assertEquals(data7,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventNoofattendees_Data_"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventNoofattendees_Data_"))));
	  			assertEquals(data8,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventCapacity_Data"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventCapacity_Data"))));
	  			assertEquals(data9,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventCoordinator_Data"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventCoordinator_Data"))));
	  			assertEquals(data10,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventType_Data"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventType_Data"))));
	  			assertEquals(data11,driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventEstAttendees_Data"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Event_Details_EventEstAttendees_Data"))));
   
	  			//Goback
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Go_Back_from_Reservation_Details_Page"))));
	  			driver.findElement(By.xpath(prop.getProperty("Go_Back_from_Reservation_Details_Page"))).click();
	  			
		 }

		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Go_Back_from_Reservation_Summarry_Page"))));
		 		driver.findElement(By.xpath(prop.getProperty("Go_Back_from_Reservation_Summarry_Page"))).click();
		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Logout_Link"))));
		 		driver.findElement(By.xpath(prop.getProperty("Logout_Link"))).click();
		 		assertEquals(welcomepage_header_expected, driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))).getText());
		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))));
}
	  
	  
	  //Passenger Profile
	  
	  public void verifyViewProfilePageLabels(WebDriver driver, 
				String actual_header1, String exp_header1,
				String actual_header2,String exp_header2,
				String actual_header3,String exp_header3,
				String actual_header4,String exp_header4, 
				String actual_header5,String exp_header5, 
				String actual_header6,String exp_header6, 
				String actual_header7,String exp_header7, 
				String actual_header8,String exp_header8, 
				String actual_header9,String exp_header9,
				String actual_header10,String exp_header10,
				String snapShotName) {
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header1))).getText().equals(exp_header1));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header1))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header2))).getText().equals(exp_header2));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header2))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header3))).getText().equals(exp_header3));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header3))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header4))).getText().equals(exp_header4));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header4))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header5))).getText().equals(exp_header5));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header5))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header6))).getText().equals(exp_header6));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header6))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header7))).getText().equals(exp_header7));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header7))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header8))).getText().equals(exp_header8));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header8))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header9))).getText().equals(exp_header9));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header9))));
assertTrue(driver.findElement(By.xpath(prop.getProperty(actual_header10))).getText().equals(exp_header10));
HighLight(driver,driver.findElement(By.xpath(prop.getProperty(actual_header10))));
takeScreenShot(driver,snapShotName);
}
	  
	  public void verifyUserProfileData(WebDriver driver, String username, String password,String snapShotName) {
		  
			UserDAO db =  new UserDAO(ConnectionPro.getConnection());
			User user = db.login(username, password);
			
			String username_actual = user.getUsername();
			String password_actual = user.getPassword();
			String lastname_actual = user.getLastname();
			String firstname_actual = user.getFirstname();
			String email_actual = user.getEmail();
			String number_actual = user.getNumber();
			String roomnumber_actual = user.getRoomnumber();
			String decknumber_actual = user.getDecknumber();
			String membership = user.getMembership();
		  
			assertEquals(username_actual,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Username_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Username_Data"))));
 			assertEquals(password_actual,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Password_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Password_Data"))));
 			assertEquals(lastname_actual,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Lname_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Lname_Data"))));
 			assertEquals(firstname_actual,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Fname_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Fname_Data"))));
 			assertEquals(email_actual,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Email_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Email_Data"))));
 			assertEquals(number_actual,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Number_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Number_Data"))));
 			assertEquals(roomnumber_actual,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Roomnumber_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Roomnumber_Data"))));
 			assertEquals(decknumber_actual,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Decknumber_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Decknumber_Data"))));
  			assertEquals(membership,driver.findElement(By.xpath(prop.getProperty("Profile_Page_Membership_Data"))).getAttribute("value"));
			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Profile_Page_Membership_Data"))));
			
		  
		  
	  }
	  
	  
	  public void verifyUpdateProfilePageFinalData(WebDriver driver, String username, String password,String snapShotName) {
		  
			UserDAO db =  new UserDAO(ConnectionPro.getConnection());
			User user = db.login(username, password);
			
			String username_actual = user.getUsername();
			String password_actual = user.getPassword();
			String lastname_actual = user.getLastname();
			String firstname_actual = user.getFirstname();
			String email_actual = user.getEmail();
			String number_actual = user.getNumber();
			String roomnumber_actual = user.getRoomnumber();
			String decknumber_actual = user.getDecknumber();
			String membership = user.getMembership();
			String selectedOption = new Select(driver.findElement(By.xpath(prop.getProperty(("Update_Profile_Page_Membership_Data"))))).getFirstSelectedOption().getText();
			
			System.out.println(membership);
			System.out.println(selectedOption);
		  
			assertEquals(username_actual,driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Username_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Username_Data"))));
 			assertEquals(password_actual,driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Password_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Password_Data"))));
 			assertEquals(lastname_actual,driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Lname_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Lname_Data"))));
 			assertEquals(firstname_actual,driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Fname_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Fname_Data"))));
 			assertEquals(email_actual,driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Email_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Email_Data"))));
 			assertEquals(number_actual,driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Number_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Number_Data"))));
 			assertEquals(roomnumber_actual,driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Roomnumber_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Roomnumber_Data"))));
 			assertEquals(decknumber_actual,driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Decknumber_Data"))).getAttribute("value"));
 			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Decknumber_Data"))));
  			assertEquals(membership,selectedOption);
			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Membership_Data"))));
			
		  
		  
	  }

	  
	  public void Update_Profile_function(WebDriver driver, String lastname, String firstname, String password, String email,
			  String number, String roomnumber, String decknumber, String membershipType, String snapShotName) throws InterruptedException {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  	driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Password_Data"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Password_Data"))).sendKeys(password);
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Lname_Data"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Lname_Data"))).sendKeys(lastname);
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Fname_Data"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Fname_Data"))).sendKeys(firstname);
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Email_Data"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Email_Data"))).sendKeys(email);
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Number_Data"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Number_Data"))).sendKeys(number);
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Roomnumber_Data"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Roomnumber_Data"))).sendKeys(roomnumber);
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Decknumber_Data"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Decknumber_Data"))).sendKeys(decknumber);
		    new Select(driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Membership_Data")))).selectByVisibleText("Superior");
		    takeScreenShot(driver,snapShotName);
		    HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Modify_Profile_Button"))));
		    driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Modify_Profile_Button"))).click(); //click on insertCompany button
		    Alert alertPopUp = driver.switchTo().alert();
		    assertEquals("Are you sure you want to Update your Profie ?",alertPopUp.getText());
		    Thread.sleep(2_000);
		    alertPopUp.accept();

		  
	  }


	  public void verifyUpdate_ProfileErrorMessages(WebDriver driver, String lastnameErrorMessage, String firstnameErrorMessage, 
			  String passwordErrorMessage, String emailErrorMessage, String numberErrorMessage, String RoomNumberErrorMessage, 
			  String deckNumberErrorMessage, String snapShotName) {
		  
		  
		  
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Password_Errormsg"))).getText().equals(passwordErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Lname_Errormsg"))).getText().equals(lastnameErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Fname_Errormsg"))).getText().equals(firstnameErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Email_Errormsg"))).getText().equals(emailErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Number_Errormsg"))).getText().equals(numberErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Roomnumber_Errormsg"))).getText().equals(RoomNumberErrorMessage));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Update_Profile_Page_Decknumber_Errormsg"))).getText().equals(deckNumberErrorMessage));
	

			takeScreenShot(driver,snapShotName);
		  
	  }
	  
	  
	  // Manager Part
	  
	  public void VerifyCurrentDateTime(WebDriver driver,String snapShotName) {
		  
		  GetDateTime datetime = new GetDateTime();
		  System.out.println(datetime.getCurrentDate());
		  System.out.println(datetime.getCurrentTime());
		  System.out.println("--------");
		  System.out.println( driver.findElement(By.xpath(prop.getProperty("Manager_eventDate_input_field"))).getAttribute("value"));
		  System.out.println( driver.findElement(By.xpath(prop.getProperty("Manager_eventTime_input_field"))).getAttribute("value"));
		  assertEquals(datetime.getCurrentDate(), driver.findElement(By.xpath(prop.getProperty("Manager_eventDate_input_field"))).getAttribute("value"));
		  HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_eventTime_input_field"))));
		  HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_eventTime_input_field"))));
	  }
	  
	  
	  public void ManagerSearchAllEvents (WebDriver driver, String eventdate, String eventtime, String snapShotName) {
	
		  	driver.findElement(By.xpath(prop.getProperty("Manager_eventDate_input_field"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Manager_eventDate_input_field"))).sendKeys(eventdate);
		    
		    driver.findElement(By.xpath(prop.getProperty("Manager_eventTime_input_field"))).clear();
		    driver.findElement(By.xpath(prop.getProperty("Manager_eventTime_input_field"))).sendKeys(eventtime);
		  
		    takeScreenShot(driver,snapShotName);
		    driver.findElement(By.xpath(prop.getProperty("Manager_EventSearch_Submit_Button"))).click(); //click on insertCompany button
		   
	  }
	  
	  
	  public void verifyManagereDateTimeErrormsgs(WebDriver driver, String eventdateError, String eventtimeError, String snapShotName) {
		  
		  	
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_Eventdate_errormsg"))).getText().equals(eventdateError));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_Eventtime_errormsg"))).getText().equals(eventtimeError));
		

			takeScreenShot(driver,snapShotName);
}

	  
	  public String [][] getManagerEventListFromDB(String eventdate, String starttime, int listSize) throws SQLException { // this method gets the list company table contents from the DB
		    ArrayList<Event> fromDB= EventDAO.getAllevents(eventdate, starttime);
		    String [][] arrayDB = new String [listSize-1][6];
		    int i=0;
		    for (Event p:fromDB) {
		    	arrayDB[i][0]=p.getEventname();
		    	arrayDB[i][1]=p.getEventdate();
		    	arrayDB[i][2]= p.getStarttime();
		    	arrayDB[i][3]= p.getDuration();
		    	arrayDB[i][4]= p.getLocation();
		    	arrayDB[i][5]= p.getNumberofattendees();
		    	
		 		i++;
		    }
		    return arrayDB;
	  }
	  
	  public void verifyManagerLabelsandData(WebDriver driver,String eventdate, String starttime,int rows,String welcomepage_header_expected,String header,String header1,
											 String header2,String header3,String label1,String label2,String label3,String label4,String label5,String label6,
											 String label7,String label8,String label9,String label10,String label11,String snapShotName) throws SQLException, InterruptedException {
		  
		  	ArrayList<Event> eventindb = new ArrayList<Event>();
		  	eventindb=EventDAO.getAllevents(eventdate, starttime);
		
		


		 
		 for(int i = 1;i<rows;i++) {
			  
			  
			  HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
					  prop.getProperty("Manager_View_Link"))));
			  driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
										  prop.getProperty("Manager_View_Link"))).click();
	
			  // Verify Header
			  assertEquals(header,driver.findElement(By.xpath(prop.getProperty("Manager_aboutevent_header_actual"))).getText());
			  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_aboutevent_header_actual"))));
			  
			  assertEquals(header1,driver.findElement(By.xpath(prop.getProperty("Manager_eventdetails_header_actual"))).getText());
			  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventdetails_header_actual"))));
			  
			  //Verify Labels							 					
			    assertEquals(label1,driver.findElement(By.xpath(prop.getProperty("Manager_eventid_label_actual"))).getText());
			    HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventid_label_actual"))));
	  			assertEquals(label2,driver.findElement(By.xpath(prop.getProperty("Manager_eventname_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventname_label_actual"))));
	  			assertEquals(label3,driver.findElement(By.xpath(prop.getProperty("Manager_eventdate_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventdate_label_actual"))));
	  			assertEquals(label4,driver.findElement(By.xpath(prop.getProperty("Manager_starttime_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_starttime_label_actual"))));
	  			assertEquals(label5,driver.findElement(By.xpath(prop.getProperty("Manager_duration_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_duration_label_actual"))));
	  			assertEquals(label6,driver.findElement(By.xpath(prop.getProperty("Manager_location_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_location_label_actual"))));
	  			assertEquals(label7,driver.findElement(By.xpath(prop.getProperty("Manager_numberofattendees_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_numberofattendees_label_actual"))));
	  			assertEquals(label8,driver.findElement(By.xpath(prop.getProperty("Manager_capacity_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_capacity_label_actual"))));
	  			assertEquals(label9,driver.findElement(By.xpath(prop.getProperty("Manager_eventcoordinator_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventcoordinator_label_actual"))));
	  			assertEquals(label10,driver.findElement(By.xpath(prop.getProperty("Manager_type_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_type_label_actual"))));
	  			assertEquals(label11,driver.findElement(By.xpath(prop.getProperty("Manager_estattendees_label_actual"))).getText());
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_estattendees_label_actual"))));
	  	
	  			//Get Expected Data
	  			int data_1 = eventindb.get(i-1).getEventid();
	  			String data1 = Integer.toString(data_1);
		  		String data2 = eventindb.get(i-1).getEventname();
		  		String data3 = eventindb.get(i-1).getEventdate();
		  		String data5 = eventindb.get(i-1).getDuration();
		  		String data4 = eventindb.get(i-1).getStarttime();
		  		String data6 = eventindb.get(i-1).getLocation();
		  		String data7 = eventindb.get(i-1).getNumberofattendees();
		  		String data8 = eventindb.get(i-1).getCapacity();
		  		String data9 = eventindb.get(i-1).getEventcoordinator();
		  		String data10 = eventindb.get(i-1).getType();
		  		String data11 = eventindb.get(i-1).getEstattendees();
		  		

	  			//Verify Data
	  			assertEquals(data1,driver.findElement(By.xpath(prop.getProperty("Manager_eventid_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventid_actual"))));
	  			assertEquals(data2,driver.findElement(By.xpath(prop.getProperty("Manager_eventname_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventname_actual"))));
	  			assertEquals(data3,driver.findElement(By.xpath(prop.getProperty("Manager_eventdate_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventdate_actual"))));
	  			assertEquals(data4,driver.findElement(By.xpath(prop.getProperty("Manager_startime_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_startime_actual"))));
	  			assertEquals(data5,driver.findElement(By.xpath(prop.getProperty("Manager_duration_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_duration_actual"))));
	  			assertEquals(data6,driver.findElement(By.xpath(prop.getProperty("Manager_location_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_location_actual"))));
	  			assertEquals(data7,driver.findElement(By.xpath(prop.getProperty("Manager_numberofattendees_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_numberofattendees_actual"))));
	  			assertEquals(data8,driver.findElement(By.xpath(prop.getProperty("Manager_capacity_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_capacity_actual"))));
	  			assertEquals(data9,driver.findElement(By.xpath(prop.getProperty("Manager_eventcoordinator_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_eventcoordinator_actual"))));
	  			assertEquals(data10,driver.findElement(By.xpath(prop.getProperty("Manager_type_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_type_actual"))));
	  			assertEquals(data11,driver.findElement(By.xpath(prop.getProperty("Manager_estattendees_actual"))).getText());
	  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_estattendees_actual"))));
	  			 
	  		// Click on Modify Event Button	 
	  		
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Modify_Event_Button"))));
	  			Thread.sleep(2_000);
	  			driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Modify_Event_Button"))).click();
	  			 
	  		  // Verify Header
				  assertEquals(header2,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_title"))).getText());
				  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_title"))));
				  //Verify Labels							 					
				    assertEquals(label2,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_eventname_label"))).getText());
				    HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_eventname_label"))));
		  			assertEquals(label3,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_eventdate_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_eventdate_label"))));
		  			assertEquals(label4,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_startime_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_startime_label"))));
		  			assertEquals(label5,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_duration_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_duration_label"))));
		  			assertEquals(label6,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_location_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_location_label"))));
		  			assertEquals(label7,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_numberofattendees_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_numberofattendees_label"))));
		  			assertEquals(label8,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_capacity_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_capacity_label"))));
		  			assertEquals(label9,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_eventcoordinator_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_eventcoordinator_label"))));
		  			assertEquals(label10,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_type_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_type_label"))));
		  			assertEquals(label11,driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_estattendees_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_estattendees_label"))));
		  	
		  			
		  			//Verify Data  Manager_modify_duration_input_field Manager_modify_eventcoordinator_input_field Manager_modify_type_input_field
		 
		  			assertEquals(data2,new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_modify_eventname_input_field"))))).getFirstSelectedOption().getText());
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_eventname_input_field"))));
		  			assertEquals(data3,driver.findElement(By.xpath(prop.getProperty("Manager_modify_eventdate_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_eventdate_input_field"))));
		  			assertEquals(data4,driver.findElement(By.xpath(prop.getProperty("Manager_modify_startime_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_startime_input_field"))));
		  			assertEquals(data5,new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_modify_duration_input_field"))))).getFirstSelectedOption().getText());
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_duration_input_field"))));
		  			assertEquals(data6,driver.findElement(By.xpath(prop.getProperty("Manager_modify_location_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_location_input_field"))));
		  			assertEquals(data7,driver.findElement(By.xpath(prop.getProperty("Manager_modify_numberofattendees_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_numberofattendees_input_field"))));
		  			assertEquals(data8,driver.findElement(By.xpath(prop.getProperty("Manager_modify_capacity_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_capacity_input_field"))));
		  			assertEquals(data9,new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_modify_eventcoordinator_input_field"))))).getFirstSelectedOption().getText());
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_eventcoordinator_input_field"))));
		  			assertEquals(data10,new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_modify_type_input_field"))))).getFirstSelectedOption().getText());
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_type_input_field"))));
		  			assertEquals(data11,driver.findElement(By.xpath(prop.getProperty("Manager_modify_estattendees_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_estattendees_input_field"))));
	  			 
		  		//Goback
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Modify_Event_Back_Button"))));
	  			Thread.sleep(2_000);
	  			driver.findElement(By.xpath(prop.getProperty("Manager_Modify_Event_Back_Button"))).click();
	  			
	  			// Click on Assign Event Coordinator Button
	  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Assign_Coordinator_Button"))));
	  			driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Assign_Coordinator_Button"))).click();
	  			 
	  			
	  		  // Verify Header
				  assertEquals(header3,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_title"))).getText());
				  HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_title"))));
				  //Verify Labels							 					
			
		  			assertEquals(label2,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_eventname_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_eventname_label"))));
		  			assertEquals(label3,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_eventdate_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_eventdate_label"))));
		  			assertEquals(label4,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_startime_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_startime_label"))));
		  			assertEquals(label5,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_duration_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_duration_label"))));
		  			assertEquals(label6,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_location_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_location_label"))));
		  			assertEquals(label7,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_numberofattendees_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_numberofattendees_label"))));
		  			assertEquals(label8,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_capacity_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_capacity_label"))));
		  			assertEquals(label9,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_EventCoordinator_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_EventCoordinator_label"))));
		  			assertEquals(label10,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_type_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_type_label"))));
		  			assertEquals(label11,driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_estattendees_label"))).getText());
		  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_estattendees_label"))));
		  			
		  			//Verify Data 
		  		
		  			assertEquals(data2,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_eventname_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_eventname_input_field"))));
		  			assertEquals(data3,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_eventdate_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_eventdate_input_field"))));
		  			assertEquals(data4,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_startime_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_startime_input_field"))));
		  			assertEquals(data5,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_duration_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_duration_input_field"))));
		  			assertEquals(data6,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_location_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_location_input_field"))));
		  			assertEquals(data7,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_numberofattendees_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_numberofattendees_input_field"))));
		  			assertEquals(data8,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_capacity_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_capacity_input_field"))));
		  			assertEquals(data9,new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_AssignCoordinator_eventcoordinator_input_field"))))).getFirstSelectedOption().getText());
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_eventcoordinator_input_field"))));
		  			assertEquals(data10,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_type_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_type_input_field"))));
		  			assertEquals(data11,driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_estattendees_input_field"))).getAttribute("value"));
		  			 HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_estattendees_input_field"))));
		  			
		  			//Goback
			  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_Back_Button"))));
			  			Thread.sleep(2_000);
			  			driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_Back_Button"))).click();
			  			
			  			//Goback
			  			HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Go_Back"))));
			  			driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Go_Back"))).click();
		  			 
	  			
		 }

		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_goback_link_for_events_summary"))));
		 		driver.findElement(By.xpath(prop.getProperty("Manager_goback_link_for_events_summary"))).click();
		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_Logout"))));
		 		driver.findElement(By.xpath(prop.getProperty("Manager_Logout"))).click();
		 		assertEquals(welcomepage_header_expected, driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))).getText());
		 		HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Passenger_Welcome_Title"))));
		 		Thread.sleep(2_000);
}
	  
	  
	  public void Manager_Modify_Event(WebDriver driver, String eventname, String eventdate, String eventtime, String duration,
			  String location, String numberofattendees, String capacity, String eventcoordinator,String eventtype, String estattendees, String snapShotName) throws InterruptedException {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		    
		  	new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_modify_eventname_input_field"))))).selectByVisibleText(eventname);
		  	driver.findElement(By.xpath(prop.getProperty("Manager_modify_eventdate_input_field"))).clear();
		  	driver.findElement(By.xpath(prop.getProperty("Manager_modify_eventdate_input_field"))).sendKeys(eventdate);
		  	driver.findElement(By.xpath(prop.getProperty("Manager_modify_startime_input_field"))).clear();
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_startime_input_field"))).sendKeys(eventtime);
  			new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_modify_duration_input_field"))))).selectByVisibleText(duration);
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_location_input_field"))).clear();
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_location_input_field"))).sendKeys(location);
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_numberofattendees_input_field"))).clear();
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_numberofattendees_input_field"))).sendKeys(numberofattendees);
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_capacity_input_field"))).clear();
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_capacity_input_field"))).sendKeys(capacity);
  			new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_modify_eventcoordinator_input_field"))))).selectByVisibleText(eventcoordinator);
  			new Select(driver.findElement(By.xpath(prop.getProperty(("Manager_modify_type_input_field"))))).selectByVisibleText(eventtype);
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_estattendees_input_field"))).clear();
  			driver.findElement(By.xpath(prop.getProperty("Manager_modify_estattendees_input_field"))).sendKeys(estattendees);
  			takeScreenShot(driver,snapShotName);
		    HighLight(driver, driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_submit_button"))));
		    driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_submit_button"))).click(); //click on insertCompany button
		    Alert alertPopUp = driver.switchTo().alert();
		    assertEquals("Are you sure you want to Modify the Event?",alertPopUp.getText());
		    Thread.sleep(2_000);
		    alertPopUp.accept();
		    Thread.sleep(10_000);

		  
	}


	  public void Manager_Modify_Error_Msgs(WebDriver driver,  String eventdateerrormsg, String eventtimeerrormsg, String durationerrormsg,
			  String locationerrormsg, String numberofattendeeserrormsg, String capacityerrormsg, String estattendeeserrormsg, String snapShotName) {
		  System.out.println("WebErromsgs");
		
		  System.out.println(eventdateerrormsg);
		  System.out.println(eventtimeerrormsg);
		  System.out.println(durationerrormsg);
		  System.out.println(numberofattendeeserrormsg);
		  System.out.println(capacityerrormsg);
		  System.out.println(estattendeeserrormsg);
		  
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_eventdate_errormsgs"))).getText().equals(eventdateerrormsg));
		  	assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_eventtime_errormsgs"))).getText().equals(eventtimeerrormsg));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_duration_errormsgs"))).getText().equals(durationerrormsg));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_location_errormsgs"))).getText().equals(locationerrormsg));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_Numberofattendees_errormsgs"))).getText().equals(numberofattendeeserrormsg));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_Capacity_errormsgs"))).getText().equals(capacityerrormsg));
			assertTrue(driver.findElement(By.xpath(prop.getProperty("Manager_modify_event_estattandees_errormsgs"))).getText().equals(estattendeeserrormsg));
			
	

			takeScreenShot(driver,snapShotName);
		
		  
	  }
	  
	  // Custom Methods
	  	public char GetRandomCharacters()
	  	{
	  		char random = 0 ;
	    String alphabet = "abcdefghijklmnopqrstxyz";
	    for (int i = 0; i < 50; i++) {
	         random = alphabet.charAt(rand.nextInt(alphabet.length()));
	    } 
	    
	    return random;
	    
}
		public void HighLight(WebDriver driver, WebElement element){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: #00FF00;');", element);
			//Thread.sleep((long) 0.8_000);
			
//			try {
//				Thread.sleep((long) 1_000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		

		
	
		
		public void RemoveHighLight(WebDriver driver, WebElement element){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].removeAttribute('style', 'background: #00FF00;');", element);
		}  
}

