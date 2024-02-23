public class SwitchExp1
{
	public static void main(String[] args) {
		System.out.println("Monday: " + test("Monday"));
		System.out.println("Sunday: " + test("Sunday"));
		System.out.println("Friday: " + test("Friday"));
        System.out.println("Wednesday: " + test("Wednesday"));
	}
	
	public static int test(String day) {
	    int res;
	    
	    res= switch(day) {
	        case "Monday", "Tuesday", "Wednesday": {
                if(day.equals("Monday")) {
                    yield 1;
                } else {
                   yield 10; //breaks from the switch statement not from the method
                }
            }  
	        case "Thursday", "Friday": yield 2;
	        case "Saturday", "Sunday": res = 3; //as break is not allowed in switch exp, 
												//fall-through happens and evaluation continues 
	        default: yield -1; 
	    };
	    
	    return res;
	}
}
