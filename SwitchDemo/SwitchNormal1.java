public class SwitchNormal1
{
	public static void main(String[] args) {
		System.out.println("Monday: " + test("Monday"));
		System.out.println("Sunday: " + test("Sunday"));
		System.out.println("Friday: " + test("Friday"));
	}
	
	public static int test(String day) {
	    int res;
	    
	    switch(day) {
	        case "Monday": 
	        case "Tuesday": 
	        case "Wednesday": res = 1; break; 
	        case "Thursday": 
	        case "Friday": res = 2; break; 
	        case "Saturday":  
	        case "Sunday": res = 3; break; 
	        default: res = -1; 
	    }
	    
	    return res;
	}
}

