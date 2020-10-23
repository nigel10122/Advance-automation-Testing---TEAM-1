package tests;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise10 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "c:/ChromeDriver/chromedriver.exe");
	    driver = new ChromeDriver();    baseUrl = "http://adactinhotelapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testE10() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("vratantchauhan");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Achating!20");
    driver.findElement(By.id("login")).click();
    new Select(driver.findElement(By.id("location"))).selectByVisibleText("London");
    new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("Hotel Hervey");
    driver.findElement(By.id("datepick_out")).clear();
    driver.findElement(By.id("datepick_out")).sendKeys("30/10/2020");
    driver.findElement(By.id("Submit")).click();
   for(int i=2; i<=5;i++){
	   String a = "//form[@id='select_form']/table/tbody/tr[2]/td/table/tbody/tr[";
	   String b = "]/td[2]/input";
	   String c = a + i + b;
    try {
      assertEquals("Hotel Hervey", driver.findElement(By.xpath(c)).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }}
    
      int nightlyPrice;
      String nightPrice;
      int totalPrice;
      String totalPriceAUD;
      for(int j=2; j<=5;j++){
       String a = "//form[@id='select_form']/table/tbody/tr[2]/td/table/tbody/tr[";
   	   String b = "]/td[9]/input";
   	   String c = a + j + b;
   	   String d = "]/td[10]/input";
   	   String f = a + j + d;
      nightPrice = driver.findElement(By.xpath(c)).getAttribute("value");
      nightPrice = nightPrice.replace("AUD $ ", "");
      nightlyPrice=Integer.parseInt(nightPrice);

      totalPrice = nightlyPrice * 7 + 10;
      totalPriceAUD = "AUD $ " + totalPrice;

      try {
        assertEquals(totalPriceAUD, driver.findElement(By.xpath(f)).getAttribute("value"));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }

      }
    
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText("Click here to login again")).click();
    try {
      assertEquals("Existing User Login - Build 1", driver.findElement(By.xpath("//form[@id='login_form']/table/tbody/tr/td")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
