package exercise_04;

public class ExerciseE04 {

	public double calcTotal (ServerData data, boolean existingMember, boolean validDiscount, boolean validCoupon) {
		
		double discount=0.0,total;
		
		total = data.getTotal();
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