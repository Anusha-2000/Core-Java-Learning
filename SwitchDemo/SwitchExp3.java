public class SwitchExp3 {
    public static void main(String[] args) {
		System.out.println("Monday: " + test("Monday"));
		System.out.println("Sunday: " + test("Sunday"));
		System.out.println("Friday: " + test("Friday"));
        System.out.println("Wednesday: " + test("Wednesday"));
	}
	
	public static int test(String day) {
	    int res;
	    
		//direct assignment of a variable using switch expression
	    res = switch(day) {
	        case "Monday" -> 1;
            case "Tuesday" -> 2;
            case "Wednesday" -> 3;
            case "Thursday" -> 4;
            case "Friday" -> 5;
	        case "Saturday" -> 6;
            case "Sunday" -> 7; 
	        default -> -1; 
	    };
	    
	    return res;
	}
}
