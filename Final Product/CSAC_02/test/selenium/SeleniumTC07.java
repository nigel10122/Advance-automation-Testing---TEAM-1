package selenium;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import data.EventDAO;
import functions.CSAC_02Functions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import model.Event;
import util.ConnectionPro;
import util.Conversions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class SeleniumTC07 extends CSAC_02Functions{
	
	
	private StringBuffer verificationErrors = new StringBuffer();
	public String sAppURL,sSharedUIMapPath, testDelay ;
	private String username, password, eventname, eventdate, starttime,duration,location,numberofattendees,capacity,eventcoordinator,type,estattendees;
	
	EventDAO eventmodel = new EventDAO(ConnectionPro.getConnection());

	Conversions conversions = new Conversions();
	  
	  @Before
	  public void setUp() throws Exception {
		  	// Drivers
		    driver = invokeCorrectBrowser();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Dimension d = new Dimension(1280,1000);
		    driver.manage().window().setSize(d);;
		    // Load Properties
		    prop = new Properties();	
		    prop.load(new FileInputStream("./User/Manager.properties"));
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			eventdate = prop.getProperty("eventdate");
			starttime = prop.getProperty("starttime");
		    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
		    sAppURL = prop.getProperty("sAppURL");
			sSharedUIMapPath = prop.getProperty("SharedUIMap");
			prop.load(new FileInputStream(sSharedUIMapPath));
			testDelay=prop.getProperty("testDelay");
			ArrayList<Event> eventindb = new ArrayList<Event>();
		  	eventindb=EventDAO.getAllevents(eventdate, starttime);
		  	eventname = eventindb.get(0).getEventname();
	  		duration = eventindb.get(0).getDuration();
	  		location = eventindb.get(0).getLocation();
	  		numberofattendees = eventindb.get(0).getNumberofattendees();
	  		capacity = eventindb.get(0).getCapacity();
	  		eventcoordinator = eventindb.get(0).getEventcoordinator();
	  		type = eventindb.get(0).getType();
	  		estattendees = eventindb.get(0).getEstattendees();
			
			
}
	  
	  private String [][] getTableContentsFromPage(int listSize) { // this method gets the list company table contents from the web page
		  String [][] eventArray = new String[listSize-1][6];
		  for (int i=1; i<=listSize-1; i++) {
			eventArray[i-1][0]=  driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
									prop.getProperty("Manager_EventTableEventnameCol"))).getText();
			 HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
														  prop.getProperty("Manager_EventTableEventnameCol"))));
			
			eventArray[i-1][1] = driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
									prop.getProperty("Manager_EventTableEventdateCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
					  prop.getProperty("Manager_EventTableEventdateCol"))));
			
			
			eventArray[i-1][2] = driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
									prop.getProperty("Manager_EventTableEventstarttimeCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
					  prop.getProperty("Manager_EventTableEventstarttimeCol"))));
			
			eventArray[i-1][3] = driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
									prop.getProperty("Manager_EventTableDurationCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
					  prop.getProperty("Manager_EventTableDurationCol"))));
			
			eventArray[i-1][4] = driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
					prop.getProperty("Manager_EventTableLocationCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
					  prop.getProperty("Manager_EventTableLocationCol"))));
			
			eventArray[i-1][5] = driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
					prop.getProperty("Manager_EventTableEstattendeesCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(i+1)+
					  prop.getProperty("Manager_EventTableEstattendeesCol"))));
			
		  }
		  return eventArray;
	  }
	  

	  
	  private Boolean arraysDiff (String [][] array1, String [][] array2) { // this method compares the contents of the two tables
		  Boolean diff=false || (array1.length!=array2.length);
		  for (int i=0;i<array1.length && !diff;i++) {
			 diff  = !array1[i][0].equals(array2[i][0]) || !array1[i][1].equals(array2[i][1]) || 
					 !array1[i][2].equals(array2[i][2]) || !array1[i][3].equals(array2[i][3]) ||
					 !array1[i][4].equals(array2[i][4]) || !array1[i][5].equals(array2[i][5]);
		  }
		  return diff;
	  }
	  
	  
	  
	  
	@Test
	@FileParameters("test/excel/Selenium_TC07a_test_cases.csv")
	public void TC07A(int testcasenumber,String eventdate, String eventtime, String eventdateErrormsg, String starttimeErrormsg) throws Exception {
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		login_function(driver, username, password, methodName+" loginInputData TC "+testcasenumber);
		ManagerSearchAllEvents(driver, eventdate, eventtime, methodName+" PassengerSearchReservations TC "+testcasenumber);
		verifyManagereDateTimeErrormsgs(driver, eventdateErrormsg, starttimeErrormsg, methodName+" PassengerSearchReservationErrormsg TC "+testcasenumber);
		Thread.sleep(2_000);
	}


	  
	  @Test
	  @FileParameters("test/excel/Selenium_TC07b_test_cases.csv")
	  public void TC07B(int testCaseNumber, String header1, String header2, String header3, String header4, String header5, String header6, String header7, String header8) throws Exception {
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
	    driver.get(sAppURL);
	    login_function(driver, username, password, methodName+" loginInputData TC "+testCaseNumber);
	    ManagerSearchAllEvents(driver, eventdate, starttime, methodName+" PassengerSearchEvents TC "+testCaseNumber);
		
		  verifyHeaders(driver,"Manager_events_summary_title",header1,
		  "Manager_Events_Summary_Eventname_header",header2,
		  "Manager_Events_Summary_EventDate_header",header3,
		  "Manager_Events_Summary_EventTime_header",header4,
		  "Manager_Events_Summary_EventDuration_header",header5,
		  "Manager_Events_Summary_EventLocation_header",header6,
		  "Manager_Events_Summary_EventNumberofattendees_header",header7,
		  "Manager_Events_Summary_ViewDetails_header",header8,
		  methodName+" VerifyHeadersListAllEvents TC "+testCaseNumber);
		  
		  WebElement eventTable = driver.findElement(By.xpath(prop.getProperty("Manager_Event_Summary_Table"))); 
		  int rows = eventTable.findElements(By.tagName("tr")).size();
		  System.out.println(rows);
		  assertFalse(arraysDiff(getManagerEventListFromDB(eventdate,starttime,rows),getTableContentsFromPage(rows)));
		 
	 }
	  
		  
	  @Test
	  @FileParameters("test/excel/Selenium_TC07c_test_cases.csv")
	  public void TC07C(int testCaseNumber,String welcomepage_header_expected,String header,String header1,String header2,String header3,String label1,String label2,
			  			String label3,String label4,String label5,String label6,String label7,String label8,String label9,String label10,String label11) throws SQLException, InterruptedException {
		  String methodName= new Throwable().getStackTrace()[0].getMethodName();
		  driver.get(sAppURL);
		  login_function(driver, username, password, methodName+" loginInputData TC ");
		  ManagerSearchAllEvents(driver, eventdate, starttime, methodName+" PassengerSearchEvents TC ");
     	  WebElement eventTable = driver.findElement(By.xpath(prop.getProperty("Manager_Event_Summary_Table"))); 
     	  int rows = eventTable.findElements(By.tagName("tr")).size();
     	  verifyManagerLabelsandData(driver, eventdate,starttime,rows,welcomepage_header_expected,header,header1,header2,header3,
     			  					 label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,methodName+"VerifyManagerLabelsandData");
   }

	  
	  
	  @Test
	  @FileParameters("test/excel/Selenium_TC07d_test_cases.csv")
	  public void TC07D(int testcasenumber, String eventname, String event_date, String eventtime, String duration, 
			             String location, String numberofattendees, String capacity, String eventcoordinator,
			             String eventtype, String estattendees, String eventdateerrormsg, String eventtimeerrormsg, String durationerrormsg,
						 String locationerrormsg, String numberofattendeeserrormsg, String capacityerrormsg, String estattendeeserrormsg) throws SQLException, InterruptedException {
		  String methodName= new Throwable().getStackTrace()[0].getMethodName();
		  driver.get(sAppURL);
		  login_function(driver, username, password, methodName+" loginInputData TC ");
		  ManagerSearchAllEvents(driver, eventdate, starttime, methodName+" PassengerSearchEvents TC ");
     	  driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(2)+prop.getProperty("Manager_View_Link"))).click();
     	  driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Modify_Event_Button"))).click();
     	  Manager_Modify_Event(driver,eventname,event_date, eventtime,  duration, location,  numberofattendees,  capacity,  eventcoordinator, eventtype, estattendees,methodName);
     	  Manager_Modify_Error_Msgs(driver,eventdateerrormsg, eventtimeerrormsg,  durationerrormsg, locationerrormsg,  numberofattendeeserrormsg,  capacityerrormsg, estattendeeserrormsg,methodName);

     }
  
	  @Test
	  @FileParameters("test/excel/Selenium_TC07e_test_cases.csv")
	  public void TC07E(int testcaseNumber,String modifySuccessMssg, String alertMssg, String coordinatorSuccessmsg) throws SQLException, InterruptedException {
		  String methodName= new Throwable().getStackTrace()[0].getMethodName();
		  driver.get(sAppURL);
		  login_function(driver, username, password, methodName+" loginInputData TC ");
		  ManagerSearchAllEvents(driver, eventdate, starttime, methodName+" PassengerSearchEvents TC ");
     	  driver.findElement(By.xpath(prop.getProperty("Manager_events_summary_prefix")+(2)+
				  prop.getProperty("Manager_View_Link"))).click();
     	  driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Modify_Event_Button"))).click();
     	  Manager_Modify_Event(driver,eventname,eventdate, starttime,  duration, location,  numberofattendees,  capacity,  eventcoordinator,type, estattendees,methodName);
     	  assertEquals(modifySuccessMssg, driver.findElement(By.xpath(prop.getProperty("Manager_Modify_Event_Success_Message"))).getText());
     	  driver.findElement(By.xpath(prop.getProperty("Manager_Success_Message_Go_Back"))).click();
     	  driver.findElement(By.xpath(prop.getProperty("Manager_Modify_Event_Back_Button"))).click();
     	  driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Assign_Coordinator_Button"))).click();
     	  driver.findElement(By.xpath(prop.getProperty("Manager_AssignCoordinator_Submit_Button"))).click();
     	  Alert alertPopUp = driver.switchTo().alert();
     	  assertEquals(alertMssg,alertPopUp.getText());
		  Thread.sleep(2_000);
		  alertPopUp.accept();
     	 assertEquals(coordinatorSuccessmsg, driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_Success_Message"))).getText());
     	 driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_Back_Button"))).click();
     	 driver.findElement(By.xpath(prop.getProperty("Manager_Assign_Coordinator_Back_Button"))).click();
   	  	 driver.findElement(By.xpath(prop.getProperty("Manager_Event_Details_Go_Back"))).click();
   	  	 driver.findElement(By.xpath(prop.getProperty("Manager_goback_link_for_events_summary"))).click();
   	  	 driver.findElement(By.xpath(prop.getProperty("Manager_Logout"))).click();
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
	  