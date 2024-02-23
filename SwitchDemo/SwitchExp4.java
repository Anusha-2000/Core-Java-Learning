public class SwitchExp4 {
    public static void main(String[] args) {
		System.out.println("Monday: " + test("Monday"));
		System.out.println("Sunday: " + test("Sunday"));
		System.out.println("Friday: " + test("Friday"));
        System.out.println("Wednesday: " + test("Wednesday"));
	}
	
	public static int test(String day) {
	    int res;
	    
	    res= switch(day) {
	        case "Monday", "Tuesday", "Wednesday"-> {
                if(day.equals("Monday")) {
                    yield 1;
                } else {
                   yield 10;
                }
            }  
	        case "Thursday", "Friday"-> 2;
	        case "Saturday", "Sunday" -> {yield 3;}
	        default -> -1; 
	    };
	    
	    return res;
	}
}
