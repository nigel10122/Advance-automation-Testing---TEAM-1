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


public class Exercise09 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
 
  
  @Before
  public void setUp() throws Exception {
	// MAGIC CODE GOES HERE  
	// System.setProperty("webdriver.firefox.marionette", "c:/GeckoSelenium/geckodriver.exe");
	System.setProperty("webdriver.chrome.driver", "c:/ChromeDriver/chromedriver.exe");  
	driver = new ChromeDriver();
    baseUrl = "http://adactinhotelapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  }

  @Test
  public void testExercise09() throws Exception {
    driver.get(baseUrl + "/index.php");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("nigel10122");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Plmqaz@098");
    driver.findElement(By.id("login")).click();
    driver.findElement(By.id("datepick_in")).clear();
    driver.findElement(By.id("datepick_in")).sendKeys("");
    driver.findElement(By.id("datepick_out")).clear();
    driver.findElement(By.id("datepick_out")).sendKeys("");
    new Select(driver.findElement(By.id("adult_room"))).selectByVisibleText("- Select Adults per Room -");
    driver.findElement(By.id("Submit")).click();
    Thread.sleep(10_000);
    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
    driver.findElement(By.id("datepick_in")).clear();
    driver.findElement(By.id("datepick_in")).sendKeys("16/10/2020");
    driver.findElement(By.id("datepick_out")).clear();
    driver.findElement(By.id("datepick_out")).sendKeys("19/10/2020");
    new Select(driver.findElement(By.id("room_nos"))).selectByVisibleText("2 - Two");
    new Select(driver.findElement(By.id("adult_room"))).selectByVisibleText("2 - Two");
    driver.findElement(By.id("Submit")).click();
    driver.findElement(By.id("radiobutton_1")).click();
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("first_name")).clear();
    driver.findElement(By.id("first_name")).sendKeys("Nigel");
    driver.findElement(By.id("last_name")).clear();
    driver.findElement(By.id("last_name")).sendKeys("Dsouza");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("1225 S PECAN ST");
    driver.findElement(By.id("cc_num")).clear();
    driver.findElement(By.id("cc_num")).sendKeys("1001759444000000");
    new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("VISA");
    new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("December");
    new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2022");
    driver.findElement(By.id("cc_cvv")).clear();
    driver.findElement(By.id("cc_cvv")).sendKeys("0944");
    driver.findElement(By.id("book_now")).click();
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
