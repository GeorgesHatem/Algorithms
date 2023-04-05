
public class statuse {

	private int priority;
	String name;
	double wait_time;
		
	public void setNameandPriority (int flyer_priority, String flyer_name, double flyer_waitedtime) {
			
	
		priority = flyer_priority;
		name = flyer_name;
		wait_time = flyer_waitedtime;
			
		}
		
	public int getPriority(){
			
		return priority;
		
	}
		
	public String getName() {
			
		return name;
			
	}
		
	public double getTime() {
			
		return wait_time;
		

	}
		
	
}
