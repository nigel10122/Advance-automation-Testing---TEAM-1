package testsuite;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import selenium.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Suite.class)
@Suite.SuiteClasses({
   SeleniumTC01.class,
   SeleniumTC02.class,
   SeleniumTC03.class,
   SeleniumTC04.class,
   SeleniumTC05.class,
   SeleniumTC06.class,
   SeleniumTC07.class
   

})
public class SeleniumTestSuite {   
}