public class SwitchNoraml
{
	public static void main(String[] args) {
		System.out.println("Monday: " + test("Monday"));
		System.out.println("Sunday: " + test("Sunday"));
		System.out.println("Friday: " + test("Friday"));
	}
	
	public static int test(String day) {
	    int res;
	    
	    switch(day) {
	        case "Monday": res = 1; break; 
	        case "Tuesday": res = 2;  break; 
	        case "Wednesday": res = 3; break; 
	        case "Thursday": res = 4; break; 
	        case "Friday": res = 5; break; 
	        case "Saturday": res = 6; break; 
	        case "Sunday": res = 7; break; 
	        default: res = -1; 
	    }
	    
	    return res;
	}
}

