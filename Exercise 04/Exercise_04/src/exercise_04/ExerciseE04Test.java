package exercise_04;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ExerciseE04Test {

	ExerciseE04 prb4;
	ServerData mockobj;
	
	@Before
	public void setUp() throws Exception {
		prb4 = new ExerciseE04();
		mockobj = EasyMock.strictMock(ServerData.class);
		
	}
	
	@FileParameters("src/exercise_04/exercise_04.csv")
	@Test
	public void testE04(int testcaseNumber, double total, boolean existingMember, boolean validDiscount, 
										boolean validCoupon, double expected_discount, String BasisPath, String MCDC) {
		EasyMock.expect(mockobj.getTotal()).andReturn(total);
		EasyMock.replay(mockobj);
		double actual_discount = prb4.calcTotal(mockobj, existingMember, validDiscount, validCoupon);
		assertEquals(expected_discount,actual_discount,0.01);
	}
}