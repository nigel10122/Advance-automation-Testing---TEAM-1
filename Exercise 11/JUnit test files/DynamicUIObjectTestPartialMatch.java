package tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import functions.HotelApp_BusinessFunctions;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class DynamicUIObjectTestPartialMatch extends HotelApp_BusinessFunctions {
  private WebDriver driver;
  private String username,password;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL, sSharedUIMapPath;


 @BeforeClass
	public static void setUpBeforeClass() throws Exception {
	    Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);	  
 }

  @Before
  public void setUp() throws Exception {

	    System.setProperty("webdriver.chrome.driver", "c:/ChromeDriver/chromedriver.exe");
	    driver = new ChromeDriver();

	    prop = new Properties();	  
	    prop.load(new FileInputStream("./Login/Login.properties"));
		username = prop.getProperty("username");
		password = prop.getProperty("password");

	    prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
		sAppURL = prop.getProperty("sAppURL");
		sSharedUIMapPath = prop.getProperty("SharedUIMap");	  
		

		prop.load(new FileInputStream(sSharedUIMapPath));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  @FileParameters("src/Excel/Search Hotel1.csv")
  public void testMyFirstWebDriver(int testCaseNo, String location, String hotelName, String roomType, String numberRooms, String checkIn, 
		  String checkOut, String noAdults, String noChild, double ExpPriceNight, double totalPrice) throws Exception {
    driver.get(sAppURL);
    HA_BF_Login(driver, username,password);
	searchHotel(driver, location, hotelName, roomType, numberRooms, checkIn, checkOut, noAdults, noChild);
	
	
	driver.findElement(By.id(prop.getProperty("Rad_SelectHotel_RadioButton_0"))).click();
    driver.findElement(By.id(prop.getProperty("Btn_SelectHotel_Continue"))).click();
    bookHotel(driver,"Dsouza", "Nigel", "1225 S Pecan St\nThe Heights on Pecan, Arlington","1001759444000000","Master Card","January","2022","9444");
    String strOrderNo = driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_OrderNo"))).getAttribute("value");
    System.out.println("Order Number Generated is " + strOrderNo);
    
    driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_MyItinerary"))).click();
    driver.findElement(By.id(prop.getProperty("Txt_BookedItinerary_SearchOrderid"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_BookedItinerary_SearchOrderid"))).sendKeys(strOrderNo);
    driver.findElement(By.id(prop.getProperty("Btn_BookedItinerary_Go"))).click();
    Thread.sleep(3_000);
    
    //Exercise 11 Using Partial Match
    driver.findElement(By.xpath(".//*[contains(@id, 'btn_id_')]")).click();
    
    Thread.sleep(5_000);
    Alert javascriptAlert = driver.switchTo().alert();
    System.out.println(javascriptAlert.getText());
    assertEquals("Are you sure, you want to cancel the booking with Order no. "+strOrderNo+"?",javascriptAlert.getText());
    javascriptAlert.accept();
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText("Click here to login again")).click();
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