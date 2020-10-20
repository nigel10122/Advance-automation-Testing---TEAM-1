package company_management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import company_management.model.Company;
import company_management.util.SQLConnection;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Properties;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CMFunctions {

	  static SQLConnection DBMgr = SQLConnection.getInstance();
		  public WebDriver driver;
		  public Properties prop;
		  public enum FunctionEnum {listCompanies, insertCompany, searchCompanies, searchEmployee}
		  
		  public WebDriver invokeCorrectBrowser () {
				System.setProperty("webdriver.chrome.driver", "c:/ChromeDriver/chromedriver.exe");
				return new ChromeDriver();
		  }

		  public static ArrayList<Company> ReturnMatchingCompaniesList () {
				ArrayList<Company> companyListInDB = new ArrayList<Company>();
				
				Statement stmt = null;
				Connection conn = SQLConnection.getDBConnection();  
				try {
					stmt = conn.createStatement();
					ResultSet companyList = stmt.executeQuery(" SELECT * from COMPANY ORDER BY company_name");
					while (companyList.next()) {
						Company company = new Company(); 
						company.setIdcompany(companyList.getString("idcompany"));
						company.setCompany_name(companyList.getString("company_name"));
						company.setPhone(companyList.getString("phone"));
						company.setEmail(companyList.getString("email"));  
						companyListInDB.add(company);	
					}
				} catch (SQLException e) {}
				return companyListInDB;
		  }
	
		  public String [][] getCompanyListFromDB(int listSize) throws SQLException { // this method gets the list company table contents from the DB
			    ArrayList<Company> fromDB= ReturnMatchingCompaniesList();
			    String [][] arrayDB = new String [listSize-1][4];
			    int i=0;
			    for (Company p:fromDB) {
			    	arrayDB[i][0]=p.getIdcompany();
			    	arrayDB[i][1]=p.getCompany_name();
			    	arrayDB[i][2]=p.getPhone();
			    	arrayDB[i][3]=p.getEmail();
			 		i++;
			    }
			    return arrayDB;
		  }
		  
			public String [][] getEmployeeListFromDB(int listsize, String idComp) { // this method gets the list company table contents from the DB
					Statement stmt = null;   
					Connection conn = null;
					conn = SQLConnection.getDBConnection(); 
				    String [][] arrayDB = new String [listsize][4];
					try {
						stmt = conn.createStatement();
						String searchEmployee = " SELECT * from EMPLOYEE WHERE FK_COMPANY = '"+idComp+"' ORDER BY TRIM(surname) ASC,TRIM(name) ASC,TRIM(badge) ASC, TRIM(idemployee) ASC";
						ResultSet employeeList = stmt.executeQuery(searchEmployee);
						int i=0;
						while (employeeList.next()) {
							 arrayDB[i][0] = employeeList.getString("surname");
							 arrayDB[i][1]= employeeList.getString("name");
							 arrayDB[i][2] = employeeList.getString("idemployee");
							 arrayDB[i][3] = employeeList.getString("badge");				 
							i++;
						}    
					} catch (SQLException e) {}    
				return  arrayDB;
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
//				    Change the thread value to run test files with delay
					Thread.sleep(3_000);
				} catch (InterruptedException e) {}
		  }
		  
		  public void MainApp_function (WebDriver driver, FunctionEnum function) {
			  switch (function) {
			  	case listCompanies:
				    driver.findElement(By.xpath(prop.getProperty("MainApp_ListCompanyLink"))).click(); //select List Company from homepage
				    break;
			  	case insertCompany:
			  	    driver.findElement(By.xpath(prop.getProperty("MainApp_InsertCompanyLink"))).click(); //select Insert Company from homepage
			  	    break;
			  	case searchCompanies:
			  	    driver.findElement(By.xpath(prop.getProperty("MainApp_SearchCompaniesLink"))).click(); //select Insert Company from homepage
			  	    break;
			  	case searchEmployee:
			  	    driver.findElement(By.xpath(prop.getProperty("MainApp_SearchEmployeeLink"))).click(); //select Insert Company from homepage
			  }
		  }
		  
		  public void insertCompany_function (WebDriver driver, String companyID, String companyName, String companyPhone, String companyEmail, String snapShotName) {
			    driver.findElement(By.xpath(prop.getProperty("insertCompany_companyIDValue"))).sendKeys(companyID);
			    driver.findElement(By.xpath(prop.getProperty("insertCompany_companyNameValue"))).sendKeys(companyName);
			    driver.findElement(By.xpath(prop.getProperty("insertCompany_phoneValue"))).sendKeys(companyPhone);
			    driver.findElement(By.xpath(prop.getProperty("insertCompany_emailValue"))).sendKeys(companyEmail);
			    driver.findElement(By.xpath(prop.getProperty("insertCompany_insertCompanyButton"))).click(); //click on insertCompany button
			    takeScreenShot(driver,snapShotName);
		  }
		  
		  public void verifyInsertCompanyErrorMessages (WebDriver driver, String errorMessage, String companyIDErrorMessage, 
				  										String companyNameErrorMessage, String companyPhoneErrorMessage, String companyEmailErrorMessage, String snapShotName) {
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertCompany_errMsgError"))).getAttribute("value").equals(errorMessage));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertCompany_companyIDError"))).getAttribute("value").equals(companyIDErrorMessage));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertCompany_companyNameError"))).getAttribute("value").equals(companyNameErrorMessage));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertCompany_phoneError"))).getAttribute("value").equals(companyPhoneErrorMessage));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("insertCompany_emailError"))).getAttribute("value").equals(companyEmailErrorMessage));
			    takeScreenShot(driver,snapShotName);
		  }
		  
		  public void verifyHeaders(WebDriver driver, String header1OnPage, String expectedHeader1Name,String header2OnPage, String expectedHeader2Name,
				  									String header3OnPage, String expectedHeader3Name,String header4OnPage, String expectedHeader4Name, 
				  									String header5OnPage, String expectedHeader5Name, String snapShotName) {
			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header1OnPage))).getText().equals(expectedHeader1Name));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header2OnPage))).getText().equals(expectedHeader2Name));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header3OnPage))).getText().equals(expectedHeader3Name));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty(header4OnPage))).getText().equals(expectedHeader4Name));
			    if (!header5OnPage.equals(""))
			    	assertTrue(driver.findElement(By.xpath(prop.getProperty(header5OnPage))).getText().equals(expectedHeader5Name));
			    takeScreenShot(driver,snapShotName);
		  }
		  
		  public void verifyContents(WebDriver driver, String col1ValueOnPage, String expectedcol1Value,String col2ValueOnPage, String expectedcol2Value,
												String col3ValueOnPage, String expectedcol3Value,String col4ValueOnPage, String expectedcol4Value, String snapShotName) {
			  	assertTrue(driver.findElement(By.xpath(prop.getProperty(col1ValueOnPage))).getText().equals(expectedcol1Value));
				assertTrue(driver.findElement(By.xpath(prop.getProperty(col2ValueOnPage))).getText().equals(expectedcol2Value));
				assertTrue(driver.findElement(By.xpath(prop.getProperty(col3ValueOnPage))).getText().equals(expectedcol3Value));
				assertTrue(driver.findElement(By.xpath(prop.getProperty(col4ValueOnPage))).getText().equals(expectedcol4Value));
				takeScreenShot(driver,snapShotName);
		  }
		  
		  public void insertEmployee_function (WebDriver driver, String employeeID, String firstName, String lastName, String badgeNo, String doneButton, String snapShotName) {
			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_employeeIDValue"))).sendKeys(employeeID);
			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_firstNameValue"))).sendKeys(firstName);
			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_lastNameValue"))).sendKeys(lastName);
			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_companyBadgeValue"))).sendKeys(badgeNo);
			    takeScreenShot(driver,snapShotName);
			    driver.findElement(By.xpath(prop.getProperty("insertEmployee_insertEmployeeButton"))).click(); //click insertEmployee button
			    if (!doneButton.equals(""))
			    	driver.findElement(By.xpath(prop.getProperty("insertEmployee_doneButton"))).click(); // click Done button
		  }

		  public void verifyInsertEmployeeErrorMessages (WebDriver driver, String errorMessage, String employeeIDErrorMessage, 
					String employeeFirstNameErrorMessage, String employeeLastNameErrorMessage, String employeeBadgeNumberErrorMessage, String snapShotName) {
				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_errMsgError"))).getAttribute("value").equals(errorMessage));
				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_employeeIDError"))).getAttribute("value").equals(employeeIDErrorMessage));
				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_firstNameError"))).getAttribute("value").equals(employeeFirstNameErrorMessage));
				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_lastNameError"))).getAttribute("value").equals(employeeLastNameErrorMessage));
				assertTrue(driver.findElement(By.xpath(prop.getProperty("insertEmployee_companyBadgeError"))).getAttribute("value").equals(employeeBadgeNumberErrorMessage));
			    takeScreenShot(driver,snapShotName);
		  }

		  public void searchCompany_function (WebDriver driver, String companyName, String companyID, String snapShotName) {
			    driver.findElement(By.xpath(prop.getProperty("searchCompany_companyNameValue"))).sendKeys(companyName);
			    driver.findElement(By.xpath(prop.getProperty("searchCompany_companyIDValue"))).sendKeys(companyID);
			    takeScreenShot(driver,snapShotName);
			    driver.findElement(By.xpath(prop.getProperty("searchCompany_submitButton"))).click();			    
		  }
		  
		  public void verifySearchCompanyErrorMessages (WebDriver driver, String errorMessage, String companyNameErrorMessage, String CompanyIDErrorMessage, String snapShotName) {
			  	assertTrue(driver.findElement(By.xpath(prop.getProperty("searchCompany_errMsgError"))).getAttribute("value").equals(errorMessage));
			    assertTrue(driver.findElement(By.xpath(prop.getProperty("searchCompany_companyNameError"))).getAttribute("value").equals(companyNameErrorMessage));
				assertTrue(driver.findElement(By.xpath(prop.getProperty("searchCompany_companyIDError"))).getAttribute("value").equals(CompanyIDErrorMessage));
			    takeScreenShot(driver,snapShotName);
		  }

		  public void searchEmployee_function (WebDriver driver, String companyName, String snapShotName) {
			    new Select(driver.findElement(By.name(prop.getProperty("searchEmployee_DropDown")))).selectByVisibleText(companyName);
			    takeScreenShot(driver,snapShotName);
			    driver.findElement(By.xpath(prop.getProperty("searchEmployee_submitButton"))).click();  
		  }
		  
}
