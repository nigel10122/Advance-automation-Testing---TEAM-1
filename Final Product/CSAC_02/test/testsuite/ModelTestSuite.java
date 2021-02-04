package testsuite;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import model.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Suite.class)
@Suite.SuiteClasses({
   ModelTC01.class,
   ModelTC02.class,
   ModelTC03.class,
   ModelTC04.class,
   ModelTC05.class,
   ModelTC06.class,
   ModelTC07.class
})
public class ModelTestSuite {   
}