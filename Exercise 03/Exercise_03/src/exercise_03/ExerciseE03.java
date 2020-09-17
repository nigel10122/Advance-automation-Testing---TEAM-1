package exercise_03;

public class ExerciseE03 {

	public double calcTotal (double total, boolean existingMember, boolean validDiscount, boolean validCoupon) {
		
		double discount=0.0;
		
	
		
		if (existingMember && validDiscount || validCoupon) {
			if (total > 1_000.0)
				discount = 0.15;
			else
				if (total >= 750)
					discount = 0.1;
				else
					if (total > 500)
						discount = 0.05;
					else
						discount = 0.025;
		}
		return (total * (1-discount) * 1.0825);
	}
}