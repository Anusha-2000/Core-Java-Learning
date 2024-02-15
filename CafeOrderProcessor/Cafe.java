package CafeOrderProcessor;

public class Cafe {
	String name = "Duke's Coffee Hut";
	
	public static void main(String[] args) {
		// First Order (Creating object)
		CustomerOrder order1 = new CustomerOrder();
		
		// Order details (Setting state for order1 object)
		order1.quantity = 2;
		order1.seniorCitizen = true;
		
		// Computing order amount for order1
		order1.generateOrderBill();
		
		// Bill Generation
		System.out.println("Order Number: " + CustomerOrder.orderNumber);
		System.out.println("Quantity: " + order1.quantity);
		System.out.println("Total Amount: " + order1.orderAmount);
		
		// Second Order (Creating object)
		CustomerOrder order2 = new CustomerOrder();
				
		// Order details (Setting state for order2 object)
		order2.quantity = 3;
				
		// Computing order amount for order2
		order2.generateOrderBill();
				
		// Bill Generation
		System.out.println("\nOrder Number: " + CustomerOrder.orderNumber);
		System.out.println("Quantity: " + order2.quantity);
		System.out.println("Total Amount: " + order2.orderAmount);
		
		// Third Order (Creating object)
		CustomerOrder order3 = new CustomerOrder();
						
		// Order details (Setting state for order3 object)
		order3.seniorCitizen = true;
						
		// Computing order amount for order3
		order3.generateOrderBill();
						
		// Bill Generation
		System.out.println("\nOrder Number: " + CustomerOrder.orderNumber);
		System.out.println("Quantity: " + order3.quantity);
		System.out.println("Total Amount: " + order3.orderAmount);
	}
}
