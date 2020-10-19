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
    System.setProperty("webdriver.chrome.driver", "c:/ChromeDriver/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://adactinhotelapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testE09ErrorMsgValidationAndBooking() throws Exception {
    driver.get(baseUrl + "/");
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
    try {
      assertEquals("Please Select a Location", driver.findElement(By.id("location_span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Please Select Check-In Date", driver.findElement(By.id("checkin_span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Please Select Check-Out Date", driver.findElement(By.id("checkout_span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Please Select Adults per Room", driver.findElement(By.id("adults_room_span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    Thread.sleep(10000);
    driver.findElement(By.id("datepick_in")).clear();
    driver.findElement(By.id("datepick_in")).sendKeys("15/10/2020");
    driver.findElement(By.id("datepick_out")).clear();
    driver.findElement(By.id("datepick_out")).sendKeys("16/10/2020");
    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
    new Select(driver.findElement(By.id("adult_room"))).selectByVisibleText("2 - Two");
    driver.findElement(By.id("Submit")).click();
    driver.findElement(By.id("radiobutton_4")).click();
    try {
      assertEquals("AUD $ 185", driver.findElement(By.id("total_price_4")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("AUD $ 175", driver.findElement(By.id("price_night_4")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("first_name")).clear();
    driver.findElement(By.id("first_name")).sendKeys("Nigel");
    driver.findElement(By.id("last_name")).clear();
    driver.findElement(By.id("last_name")).sendKeys("Dsouza");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("1225 South Pecan St");
    driver.findElement(By.id("cc_num")).clear();
    driver.findElement(By.id("cc_num")).sendKeys("1001759444000000");
    new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("American Express");
    new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("December");
    new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2020");
    driver.findElement(By.id("cc_cvv")).clear();
    driver.findElement(By.id("cc_cvv")).sendKeys("09444");
    try {
      assertEquals("AUD $ 175", driver.findElement(By.id("price_night_dis")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("AUD $ 185", driver.findElement(By.id("total_price_dis")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("AUD $ 18.5", driver.findElement(By.id("gst_dis")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("AUD $ 203.5", driver.findElement(By.id("final_price_dis")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("book_now")).click();
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText("Click here to login again")).click();
    try {
      assertEquals("Existing User Login - Build 1", driver.findElement(By.cssSelector("td.login_title")).getText());
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
