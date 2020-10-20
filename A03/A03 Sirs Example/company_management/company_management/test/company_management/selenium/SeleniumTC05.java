package company_management.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import company_management.CMFunctions;
import company_management.model.Company;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // the test methods in this test file can run in any order but I prefer a fixed order
public class SeleniumTC05 extends CMFunctions {
  private StringBuffer verificationErrors = new StringBuffer();
  public String sAppURL, sSharedUIMapPath, testDelay;

@Before
  public void setUp() throws Exception {
//	MAGIC CODE GOES HERE 
    driver = invokeCorrectBrowser();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    prop = new Properties();	  
    prop.load(new FileInputStream("./Configuration/CM_Configuration.properties"));
	sAppURL = prop.getProperty("sAppURL");
	sSharedUIMapPath = prop.getProperty("SharedUIMap");
	testDelay=prop.getProperty("testDelay");
	prop.load(new FileInputStream(sSharedUIMapPath));
  }

  private boolean verifyDropDownList (WebDriver driver) throws SQLException {
    boolean failed=false;
	ArrayList<Company> fromDB= ReturnMatchingCompaniesList();
	String [][] companyArray = getCompanyListFromDB(fromDB.size()+1);
	Select dropdown = new Select(driver.findElement(By.name(prop.getProperty("searchEmployee_DropDown"))));
	List<WebElement> dropDownVals=dropdown.getOptions();
	for (int i=0;i<fromDB.size() && !failed;i++) {
		String s = dropDownVals.get(i).getText();
    	if (!companyArray[i][1].equals(s.trim()))
    		failed=true;
	}
	return failed;
  }
    
  private String [][] getTableContentsFromPage(int listSize) { // this method gets the employee table contents from the web page
	  String [][] employeeArray = new String[listSize][4];
	  for (int i=0; i<listSize; i++) {
								prop.getProperty("listEmployee_EmployeeTableLastNameCol");
		employeeArray[i][0]=  driver.findElement(By.xpath(prop.getProperty("searchEmployeeResults_employeeTablePartial")+(i+2)+
								prop.getProperty("listEmployee_EmployeeTableLastNameCol"))).getText();
		employeeArray[i][1] = driver.findElement(By.xpath(prop.getProperty("searchEmployeeResults_employeeTablePartial")+(i+2)+
								prop.getProperty("listEmployee_EmployeeTableFirstNameCol"))).getText();
		employeeArray[i][2] = driver.findElement(By.xpath(prop.getProperty("searchEmployeeResults_employeeTablePartial")+(i+2)+
								prop.getProperty("listEmployee_EmployeeTableEmployeeIDCol"))).getText();
		employeeArray[i][3] = driver.findElement(By.xpath(prop.getProperty("searchEmployeeResults_employeeTablePartial")+(i+2)+
								prop.getProperty("listEmployee_EmployeeTableEmployeeBadgeCol"))).getText();
	  }
	  return employeeArray;
  }
  
  private Boolean arraysDiff (String [][] array1, String [][] array2) { // this method compares the contents of the two tables
	  Boolean diff=false || (array1.length!=array2.length);
	  for (int i=0;i<array1.length && !diff;i++) {
		  diff  = !array1[i][0].equals(array2[i][0]) || !array1[i][1].equals(array2[i][1]) || 
				 !array1[i][2].equals(array2[i][2]) || !array1[i][3].equals(array2[i][3]);
	  }
	  return diff;
  }

@Test // This test doesn't need parameters as it compares the dropdown list values with a DB queryhtml/body/table/tbody/tr[
public void TC05a() throws Exception {
	driver.get(sAppURL);
    MainApp_function(driver,FunctionEnum.searchEmployee); //select Search Employee from homepage
    assertEquals(verifyDropDownList(driver),false);
	}

@Test
@FileParameters("test/company_management/selenium/TC05b_test_cases.csv")
public void TC05b(int testCaseNumber, String companyName, String companyID) throws Exception {
	String methodName= new Throwable().getStackTrace()[0].getMethodName();
	driver.get(sAppURL);
    MainApp_function(driver,FunctionEnum.searchEmployee); //select Search Employee from homepage
    searchEmployee_function(driver,companyName,methodName+" searchEmployeeFunction test case "+testCaseNumber);
	verifyHeaders(driver,"searchEmployeeResults_lastNameTitle","Last Name","searchEmployeeResults_FirstNameTitle","First Name",
			"searchEmployeeResults_EmployeeIDTitle","Employee ID","searchEmployeeResults_BadgeTitle","Badge","","",methodName+" verifyHeaders test case "+testCaseNumber);
		// Verify contents for Employee Search table results
	WebElement employeeTable = driver.findElement(By.xpath(prop.getProperty("searchEmployeeResults_employeeTable")));
	int rows = employeeTable.findElements(By.tagName("tr")).size()-1; //find the number of rows in the table including the header
	assertFalse(arraysDiff(getEmployeeListFromDB(rows,companyID),getTableContentsFromPage(rows)));
	driver.findElement(By.xpath(prop.getProperty("searchEmployeeResults_companyMgtAppLink"))).click(); //return to homepage	    
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
