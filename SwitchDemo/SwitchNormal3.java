public class SwitchNormal3
{
	public static void main(String[] args) {
		System.out.println("Monday: " + test("Monday"));
		System.out.println("Sunday: " + test("Sunday"));
		System.out.println("Friday: " + test("Friday"));
	}
	
	public static int test(String day) {
	    int res;
	    
	    switch(day) {
	        case "Monday", "Tuesday", "Wednesday": res = 1;  
	        case "Thursday", "Friday": res = 2; break; 
	        case "Saturday", "Sunday": res = 3; 
	        default: res = -1; 
	    }
	    
	    return res;
	}
}

