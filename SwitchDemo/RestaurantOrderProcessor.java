public class RestaurantOrderProcessor {
    
	public static double generateOrderBill(int foodChoice, int drinkChoice, boolean largeDrink, int dessertChoice, String couponCode) {
		
		double foodPrice = getMenuItemPrice(foodChoice, largeDrink);
		double drinkPrice = getMenuItemPrice(drinkChoice, largeDrink);
		double dessertPrice = getMenuItemPrice(dessertChoice, largeDrink);
		
		double orderAmount = foodPrice + drinkPrice + dessertPrice;
		
		if (orderAmount > 10.00) {
			orderAmount -= applyCoupon(couponCode);
		}
		
		return orderAmount;
	}
	
	public static double getMenuItemPrice(int choice, boolean largeDrink) { 
		double itemPrice = 0.0;
		
		return switch (choice) {
			case 0 -> 0.00;
			case 1 -> 12.00;
			case 2 -> 8.00;
			case 3 -> 10.00;
			case 4 -> 15.00;
			case 5 -> 7.00;
			case 6 ->  9.00;
			case 7 -> {
                        itemPrice = 3.00;
			            if(largeDrink) { itemPrice += 1.00;}
                        yield itemPrice;
                      }

			case 8 -> {
                        itemPrice = 3.00;
                        if(largeDrink) { itemPrice += 2.00;}
                        yield itemPrice;
                      }
			case 9 -> 5.00;
			case 10 -> 6.00;
			default -> -1.00;
		};
		
		//return itemPrice;
	}
	
	public static double applyCoupon(String couponCode) { 
		double discount = 0.00;
		
		discount = switch (couponCode) {
			case "SAVE4" -> discount = 4.00;
			case "HAPPYHOUR" -> discount = 5.00;
			case "SPECIAL3OFF" -> discount = 3.00;
			case "SUNDAY2OFF", "GOODSTUDENT" -> discount = 2.00;

			default -> discount = 0.00;
		};
		
		return discount; 
	}
	
	public static void main(String[] args) {
		int foodChoice = 1; // Example choice: 1 for Pizza
		int drinkChoice = 8; // Example choice: 8 for Coffee
		int dessertChoice = 9; // Example choice: 9 for Cake
		String couponCode = "HAPPYHOUR"; // Example coupon code

		double totalBill = generateOrderBill(foodChoice, drinkChoice, true, dessertChoice, couponCode);
		System.out.println("Total order bill: $" + totalBill);
	}
}
