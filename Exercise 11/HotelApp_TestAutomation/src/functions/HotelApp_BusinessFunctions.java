package functions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Properties;
import java.io.File;
import java.io.IOException;

public class HotelApp_BusinessFunctions {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public void takeScreenshot(WebDriver driver, String screenshotname) {
		try
		{
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,  new File("./ScreenShots/" + screenshotname +".png"));
		}
		catch(IOException e) {}
		try {
			Thread.sleep(0);
		}catch(InterruptedException e) {}
	}
		
	public void HA_BF_Login(WebDriver driver, String sUserName, String sPassword) {
		
		
		
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);
		
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);
		
		driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click();
		
}
		
		public void searchHotel(WebDriver driver, String sLocation, String sHotels, String sRoomType, String NumRooms, String checkIn, String checkOut, String adultsRoom, String childRoom) {
			
			String titles [] = {null,"1 - One","2 - Two","3 - Three","4 - Four","5 - Five","6 - Six","7 - Seven","8 - Eight","9 - Nine","10 - Ten"};
			if(sLocation.length()!=0)
				new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Location")))).selectByVisibleText(sLocation);
			if(sHotels.length()!=0)
				new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Hotels")))).selectByVisibleText(sHotels);
			if(sRoomType.length()!=0)
				new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Room_Type")))).selectByVisibleText(sRoomType);
			if(NumRooms.length()!=0)
				new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Room_Nos")))).selectByVisibleText(titles[Integer.valueOf(NumRooms)]);
			if(checkIn.length()!=0)
				driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Check_In_Date"))).clear();
				driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Check_In_Date"))).sendKeys(checkIn);
			if(checkOut.length()!=0)
				driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Check_Out_Date"))).clear();
				driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Check_Out_Date"))).sendKeys(checkOut);	
			if(adultsRoom.length()!=0)
				new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Adult_Room")))).selectByVisibleText(titles[Integer.valueOf(adultsRoom)]);	
			if(childRoom.length()!=0)
				new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Child_Room")))).selectByVisibleText(titles[Integer.valueOf(childRoom)]);
			driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Search"))).click();
			
		}
		
		
		
		public void bookHotel(WebDriver driver, String lastName, String firstName, String Address, String CCNumber, String CCType, String CCExpMonth, String CCExpYear, String ccvNumber) {
			
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).sendKeys(firstName);
			
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).sendKeys(lastName);
			
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).sendKeys(Address);
			
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).sendKeys(CCNumber);
			
			new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCType")))).selectByVisibleText(CCType);
			
			new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpMonth")))).selectByVisibleText(CCExpMonth);
			
			new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpYear")))).selectByVisibleText(CCExpYear);
			
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).sendKeys(ccvNumber);
			
			driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_BookNow"))).click();
			
}
				
		
		public void HA_GF_WaitForElementPresent(WebDriver driver, By by, int iTimeOut) throws InterruptedException{
			
			int iTotal = 0;
			int iSleepTime = 5000;
			while(iTotal < iTimeOut)
			{
				List<WebElement> oWebElements = driver.findElements(by);
				if(oWebElements.size()>0)
					return;
				else
				{
					Thread.sleep(iSleepTime);
					iTotal = iTotal + iSleepTime;
					System.out.println(String.format("Waited for %d millisecconds.[%s]", iTotal, by));
				}
				
			}
			
			
			
		}
		
	
}