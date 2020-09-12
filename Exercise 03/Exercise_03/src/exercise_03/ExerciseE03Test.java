package exercise_03;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class ExerciseE03Test {

	ExerciseE03 prb3;
	
	@Before
	public void setUp() throws Exception {
		prb3 = new ExerciseE03();
	}

	
	
	@FileParameters("src/exercise_03/exercise_03.csv")
	@Test
	public void testExercise03(int testcaseNumber, double total, boolean existingMember, boolean validDiscount, 
										boolean validCoupon, double discount) {
		
		
		assertEquals(discount,prb3.calcTotal(total, existingMember, validDiscount, validCoupon),0.01);
	
	}
}