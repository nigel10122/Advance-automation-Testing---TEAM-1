package selenium;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import java.io.FileInputStream;
import java.sql.SQLException;
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
import org.openqa.selenium.WebElement;
import data.EventDAO;
import functions.CSAC_02Functions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import util.ConnectionPro;
import util.Conversions;

//--------------------------------------------------------- SELENIUM COORINATOR TEST---------------------------------------------------------------------------------------------------------// 

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class SeleniumTC03 extends CSAC_02Functions{
	
	
	private StringBuffer verificationErrors = new StringBuffer();
	public String sAppURL,sSharedUIMapPath, testDelay ;
	private String username, password, eventdate, starttime;
	
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
		    prop.load(new FileInputStream("./User/Coordinator.properties"));
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			eventdate = prop.getProperty("eventdate");
			starttime = prop.getProperty("starttime");
		    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
		    sAppURL = prop.getProperty("sAppURL");
			sSharedUIMapPath = prop.getProperty("SharedUIMap");
			prop.load(new FileInputStream(sSharedUIMapPath));
			testDelay=prop.getProperty("testDelay");
}

	  
	  private String [][] getTableContentsFromPage(int listSize) { // this method gets the list company table contents from the web page
		  String [][] eventArray = new String[listSize-1][6];
		
		  for (int i=1; i<=listSize-1; i++) {
			System.out.println("WEBPAGE DATA");  
			eventArray[i-1][0]=  driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
									prop.getProperty("Coordinator_Events_Summary_EventName_Col"))).getText();
			 HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
														  prop.getProperty("Coordinator_Events_Summary_EventName_Col"))));
			System.out.println(eventArray[i-1][0]);
			eventArray[i-1][1] = driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
									prop.getProperty("Coordinator_Events_Summary_EventDate_Col"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
					  prop.getProperty("Coordinator_Events_Summary_EventDate_Col"))));
			
			System.out.println(eventArray[i-1][1]);
			eventArray[i-1][2] = driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
									prop.getProperty("Coordinator_Events_Summary_EventTime_Col"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
					  prop.getProperty("Coordinator_Events_Summary_EventTime_Col"))));
			System.out.println(eventArray[i-1][2]);
			eventArray[i-1][3] = driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
									prop.getProperty("Coordinator_Events_Summary_EventDuration_Col"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
					  prop.getProperty("Coordinator_Events_Summary_EventDuration_Col"))));
			System.out.println(eventArray[i-1][3]);
			eventArray[i-1][4] = driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
					prop.getProperty("Coordinator_Events_Summary_EventLocation_Col"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
					  prop.getProperty("Coordinator_Events_Summary_EventLocation_Col"))));
			System.out.println(eventArray[i-1][4]);
			eventArray[i-1][5] = driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
					prop.getProperty("Coordinator_Events_Summary_EventEstattendees_Col"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Prefix_Col")+(i+1)+
					  prop.getProperty("Coordinator_Events_Summary_EventEstattendees_Col"))));
			System.out.println(eventArray[i-1][5]);
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
	@FileParameters("test/excel/Selenium_TC03a_test_cases.csv")
	public void TC03A(int testcasenumber,String eventdate, String eventtime, String eventdateErrormsg, String starttimeErrormsg) throws Exception {
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		login_function(driver, username, password, methodName+" loginCoordinator TC "+testcasenumber);
		SearchAssignedEvents(driver, eventdate, eventtime, methodName+" CoordinatorAssignedEvents TC "+testcasenumber);
		verifyDateTimeErrormsgs(driver, eventdateErrormsg, starttimeErrormsg, methodName+" CoordinatorSearchEventErrorMsgs TC "+testcasenumber);
		Thread.sleep(2_000);
	}

	  
	  @Test
	  @FileParameters("test/excel/Selenium_TC03b_test_cases.csv")
	  public void TC03B(int testCaseNumber, String header1, String header2, String header3, String header4, String header5, String header6, String header7, String header8) throws Exception {
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
	    driver.get(sAppURL);
	    login_function(driver, username, password, methodName+" loginCoordinaor_2 TC "+testCaseNumber);
	    SearchAssignedEvents(driver, eventdate, starttime, methodName+" CoordinatorSearchAssignedEvents TC "+testCaseNumber);
		
		  verifyHeaders(driver,"Coorinator_Events_Summary_Title",header1,
		  "Coordinator_Events_Summary_Eventname_header",header2,
		  "Coordinator_Events_Summary_EventDate_header",header3,
		  "Coordinator_Events_Summary_EventTime_header",header4,
		  "Coordinator_Events_Summary_EventDuration_header",header5,
		  "Coordinator_Events_Summary_EventLocation_header",header6,
		  "Coordinator_Events_Summary_EventNumberofattendees_header",header7,
		  "Coordinator_Events_Summary_ViewDetails_header",header8,
		  methodName+" VerifyHeadersCMAssignedEvent TC "+testCaseNumber);
		  
		  WebElement eventTable = driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Table"))); 
		  int rows = eventTable.findElements(By.tagName("tr")).size();
		  System.out.println(rows);
		  assertFalse(arraysDiff(getCoordinatorAssignedpartialEventListFromDB(eventdate,starttime,username,password,rows),getTableContentsFromPage(rows)));
		 
	  }
	  
	  @Test
	  @FileParameters("test/excel/Selenium_TC03c_test_cases.csv")
	  public void TC03C(int testCaseNumber,String event_Details_Title_page,	String aboutevent_header_expected,String eventdetails_header_expected,
			  			String eventid_label_expected,String eventname_label_expected ,String eventdate_label_expected ,String starttime_label_expected ,
			  			String duration_label_expected ,String location_label_expected ,String numberofattendees_label_expected ,String capacity_label_expected ,
			  			String eventcoordinator_label_expected ,String type_label_expected ,String estattendees_label_expected) throws SQLException {
		  String methodName= new Throwable().getStackTrace()[0].getMethodName();
		  driver.get(sAppURL);
		  login_function(driver, username, password, methodName+" loginInputData TC ");
		  SearchAssignedEvents(driver, eventdate, starttime, methodName+" PassengerSearchEvents TC ");
     	  WebElement eventTable = driver.findElement(By.xpath(prop.getProperty("Coordinator_Events_Summary_Table"))); 
     	  int rows = eventTable.findElements(By.tagName("tr")).size();
     	  verifyCoordinatorAssignedEventsLinksandData(driver, eventdate,starttime,username,password,rows,event_Details_Title_page, aboutevent_header_expected,
												  	  eventdetails_header_expected,eventid_label_expected,eventname_label_expected ,eventdate_label_expected ,
												  	  starttime_label_expected , duration_label_expected ,location_label_expected ,numberofattendees_label_expected ,
												  	  capacity_label_expected ,eventcoordinator_label_expected ,type_label_expected ,estattendees_label_expected ,										
								     			      methodName+"VerifyCoordinatorAssignedEventsLinksandData");
  
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
	  