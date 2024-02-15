package RestaurantService;

public class RestaurantBillCalculator {
	public static double generateOrderBill(int foodChoice, int drinkChoice, int dessertChoice, String couponCode) {
		
		double bill = 0.00;
		
		if(foodChoice >= 0 && foodChoice <= 6) {
		    bill += getMenuItemPrice(foodChoice);
		}
		
		if(drinkChoice == 0 || (drinkChoice >= 7 && drinkChoice <= 8)) {
		    bill += getMenuItemPrice(drinkChoice);
		}
		
		if(dessertChoice == 0 || (dessertChoice >= 9 && dessertChoice <= 10)) {
		    bill += getMenuItemPrice(dessertChoice);
		}
		
		double discount = applyCoupon(couponCode);
		
		bill -= discount;
		
		return bill;
		
	}
	
	public static double getMenuItemPrice(int choice) { 
		double itemPrice = 0.0;
		
		double[] menu = {0.0, 12.00, 8.00, 10.00, 15.00, 7.00, 9.00, 3.00, 3.00, 5.00, 6.00};
		
		if(choice < 0 || choice > 10) {
		    return -1;
		} else {
		    itemPrice = menu[choice];
		}
		
		return itemPrice;
	}
	
	public static double applyCoupon(String couponCode) { 
		double discount = 0.00;
		
		switch(couponCode) {
		    case "SAVE4": discount = 4.00;
		                  break;
		                    
		    case "HAPPYHOUR": discount = 5.00;
		                      break;
		                        
		    case "SPECIAL3OFF": discount = 3.00;
		                        break;
		                        
		    case "SUNDAY2OFF": discount = 2.00;
		                        break;
		                        
		    case "GOODSTUDENT": discount = 2.00;
		                        break;
		                        
		    default: discount = 0.00;
		                    
		}
		
		return discount; 
	}	
	
	public static void main(String[] args) {
		int foodChoice = 3; // Example choice: 1 for Pizza
		int drinkChoice = 0; // Example choice: 8 for Coffee
		int dessertChoice = 9; // Example choice: 9 for Cake
		String couponCode = "HAPPYHOUR"; // Example coupon code

		double totalBill = generateOrderBill(foodChoice, drinkChoice, dessertChoice, couponCode);
		System.out.println("Total order bill: $" + totalBill);
	}
	
}