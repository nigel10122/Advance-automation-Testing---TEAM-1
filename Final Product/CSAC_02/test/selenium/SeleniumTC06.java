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
import data.UserDAO;
import functions.CSAC_02Functions;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import model.User;
import util.ConnectionPro;
import util.Conversions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class SeleniumTC06 extends CSAC_02Functions{
	
	
	private StringBuffer verificationErrors = new StringBuffer();
	public String sAppURL,sSharedUIMapPath, testDelay ;
	private String username, password, eventdate, starttime,firstname,lastname;
	
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
			eventdate = prop.getProperty("eventdate");
			starttime = prop.getProperty("starttime");
		    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
		    sAppURL = prop.getProperty("sAppURL");
			sSharedUIMapPath = prop.getProperty("SharedUIMap");
			prop.load(new FileInputStream(sSharedUIMapPath));
			testDelay=prop.getProperty("testDelay");
			UserDAO db =  new UserDAO(ConnectionPro.getConnection());
			User user = db.login(username, password);
			firstname = user.getFirstname();
			lastname = user.getLastname();
			
			
			
}
	  
	  private String [][] getTableContentsFromPage(int listSize) { // this method gets the list company table contents from the web page
		  String [][] eventArray = new String[listSize-1][6];
		  for (int i=1; i<=listSize-1; i++) {
			eventArray[i-1][0]=  driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
									prop.getProperty("listevent_EventTableEventnameCol"))).getText();
			 HighLight(driver,driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
														  prop.getProperty("listevent_EventTableEventnameCol"))));
			
			eventArray[i-1][1] = driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
									prop.getProperty("listevent_EventTableEventdateCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					  prop.getProperty("listevent_EventTableEventdateCol"))));
			
			
			eventArray[i-1][2] = driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
									prop.getProperty("listevent_EventTableEventstarttimeCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					  prop.getProperty("listevent_EventTableEventstarttimeCol"))));
			
			eventArray[i-1][3] = driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
									prop.getProperty("listevent_EventTableDurationCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					  prop.getProperty("listevent_EventTableDurationCol"))));
			
			eventArray[i-1][4] = driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					prop.getProperty("listevent_EventTableLocationCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					  prop.getProperty("listevent_EventTableLocationCol"))));
			
			eventArray[i-1][5] = driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					prop.getProperty("listevent_EventTableEstattendeesCol"))).getText();
			HighLight(driver,driver.findElement(By.xpath(prop.getProperty("listevent_prefixEventnameeventTable")+(i+1)+
					  prop.getProperty("listevent_EventTableEstattendeesCol"))));
			
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
	@FileParameters("test/excel/Selenium_TC06a_test_cases.csv")
	public void TC06A(int testcasenumber,String eventdate, String eventtime, String eventdateErrormsg, String starttimeErrormsg) throws Exception {
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
		driver.get(sAppURL);
		login_function(driver, username, password, methodName+" loginInputData TC "+testcasenumber);
		PassengerSearchReservation(driver, eventdate, eventtime, methodName+" PassengerSearchReservations TC "+testcasenumber);
		verifyPassengerReservationDateTimeErrormsgs(driver, eventdateErrormsg, starttimeErrormsg, methodName+" PassengerSearchReservationErrormsg TC "+testcasenumber);
		Thread.sleep(2_000);
	}

	  
	  @Test
	  @FileParameters("test/excel/Selenium_TC06b_test_cases.csv")
	  public void TC06B(int testCaseNumber, String header1, String header2, String header3, String header4, String header5, String header6, String header7, String header8) throws Exception {
		String methodName= new Throwable().getStackTrace()[0].getMethodName();
	    driver.get(sAppURL);
	    login_function(driver, username, password, methodName+" loginInputData TC "+testCaseNumber);
	    PassengerSearchReservation(driver, eventdate, starttime, methodName+" PassengerSearchEvents TC "+testCaseNumber);
		
		  verifyHeaders(driver,"Passenger_Available_Events_Title",header1,
		  "listevent_EventTableHeaders1",header2,
		  "listevent_EventTableHeaders2",header3,
		  "listevent_EventTableHeaders3",header4,
		  "listevent_EventTableHeaders4",header5,
		  "listevent_EventTableHeaders5",header6,
		  "listevent_EventTableHeaders6",header7,
		  "listevent_EventTableHeaders7",header8,
		  methodName+" VerifyHeadersListAllEvents TC "+testCaseNumber);
		  
		  WebElement eventTable = driver.findElement(By.xpath(prop.getProperty("listevent_EventTable"))); 
		  int rows = eventTable.findElements(By.tagName("tr")).size();
		  System.out.println(rows);
		  assertFalse(arraysDiff(getpartialReservationListFromDB(eventdate,starttime,firstname,lastname,rows),getTableContentsFromPage(rows)));
		 
	  }
	  
	  @Test
	  @FileParameters("test/excel/Selenium_TC06c_test_cases.csv")
	  public void TC06C(int testCaseNumber,String welcomepage_header_expected,String header,String label1,String label2,String label3,
				  	    String label4,String label5,String label6,String label7,String label8,String label9,String label10,String label11) throws SQLException {
		  String methodName= new Throwable().getStackTrace()[0].getMethodName();
		  driver.get(sAppURL);
		  login_function(driver, username, password, methodName+" loginInputData TC ");
     	  PassengerSearchReservation(driver, eventdate, starttime, methodName+" PassengerSearchEvents TC ");
     	  WebElement eventTable = driver.findElement(By.xpath(prop.getProperty("listevent_EventTable"))); 
     	  int rows = eventTable.findElements(By.tagName("tr")).size();
     	  verifyReservationDetailsLabelsandData(driver, eventdate,starttime,firstname,lastname,rows,welcomepage_header_expected,header,label1,label2,label3,
								     		  	label4,label5,label6,label7,label8,label9,label10,label11,methodName+"VerifyReservationDetailsLabelsandData");
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
	  