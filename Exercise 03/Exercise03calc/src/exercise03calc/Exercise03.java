package exercise03calc;

import java.util.Scanner;

public class Exercise03 {

	public double calcTotal (double total, boolean existingMember, boolean validDiscount, boolean validCoupon) {
		
		double discount=0.0;
		
		if (existingMember && validDiscount || validCoupon) {
			if (total > 1000.0)
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
    
	
	
    public static void main(String[] args)
    {

     
       Scanner sc = new Scanner(System.in);  
       System.out.print("Enter Total ");  
       double total = sc.nextDouble();
       System.out.print("Are you an existing member :  ");  
       boolean existingMember = sc.nextBoolean();
       System.out.print("Do you have a valid discount :  ");  
       boolean validDiscount = sc.nextBoolean();
       System.out.print("Do you have a valid coupon ");  
       boolean validCoupon = sc.nextBoolean();  

        Exercise03 calculate = new Exercise03();
        
        double calculateTotal = calculate.calcTotal(total, existingMember, validDiscount, validCoupon);
        System.out.println("Discount is : " +calculateTotal);

        

    }

}

