public class SwitchExp2 {
    public static void main(String[] args) {
		System.out.println("Monday: " + test("Monday"));
		System.out.println("Sunday: " + test("Sunday"));
		System.out.println("Friday: " + test("Friday"));
        System.out.println("Wednesday: " + test("Wednesday"));
	}
	
	public static int test(String day) {
	    int res;
	    
		//Using arrow label inside switch exp removes the necessity if using "break"
	    switch(day) {
	        case "Monday" -> res = 1;
            case "Tuesday" -> res = 2;
            case "Wednesday" -> res = 3;
            case "Thursday" -> res = 4;
            case "Friday" -> res = 5;
	        case "Saturday" -> res = 6;
            case "Sunday" -> res = 7; 
	        default -> res = -1; 
	    };
	    
	    return res;
	}
}
