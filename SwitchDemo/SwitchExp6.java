public class SwitchExp6 {
    public static void main(String[] args) {
		System.out.println("Monday: " + test("Monday"));
		System.out.println("Sunday: " + test("Sunday"));
		System.out.println("Friday: " + test("Friday"));
        System.out.println("Wednesday: " + test("Wednesday"));
	}
	
	public static int test(String day) {
	    int res;
	    
	    res= switch(day) {
	        case "Monday" -> foo();
            case "Tuesday" -> 2;
            case "Wednesday" -> res = 3;
            case "Thursday" -> res = 4;
            case "Friday" -> res = 5;
	        case "Saturday" -> res = 6;
            case "Sunday" -> res = 7; 
	        default -> -1; 
	    };
	    
	    return res;
	}

    public static int foo() {
        return 5 + 10;
    }
}
