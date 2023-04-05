import java.util.ArrayList;
import java.util.Scanner;

public class NUA_Upgrade_System {
	
	public static int searchHeapTree(ArrayList<statuse> key, int k, int priority, String namet, double timee) {
		
		
		
		if((key.get(k).getPriority()) > priority) {
			
			return 0;
			
			
		}
		
		else {
		
			if(k == 0) {
				
				searchHeapTree(key, 1, priority, namet, timee);
				
				
			}
			
			else {
			
				if(priority == key.get(k).getPriority()) {
					
					if((timee == key.get(k).getTime()) && (namet == key.get(k).getName())) {
						
						return k;
						
						
					}
					
					else {
						
						return 0;
						
						
					}
					
				
				}
				
				else {
				
					searchHeapTree(key, 2*k, priority, namet, timee);
					searchHeapTree(key, (2*k)+1, priority, namet, timee);
					
					
				}
			}	
		}
		
		return k;
		
	}

	public static void main(String[] args) {
		
		int choice = 1;
		int priority_status, priority_status_provided;
		String flyer_name, flyer_name_provided;
		double waited_time, waited_time_provided;
		ArrayList<statuse> flyers_status = new ArrayList<statuse>();
		statuse currentStatus = new statuse();
		int i,j;
		statuse tmp = new statuse();
		
		while(choice != 4) {
		
			System.out.println("\nPlease choose from the following Menu:\n");
			System.out.println("1. Request Upgrade");
			System.out.println("2. Cancel Upgrade");
			System.out.println("3. Print Seating Chart");
			System.out.println("4. Quit");
			System.out.println();
			
			Scanner scnr2 = new Scanner(System.in);
			choice = scnr2.nextInt();
			
			if(choice == 1) {
				
				Scanner scnr = new Scanner(System.in);
				
				System.out.print("Please enter your priority status: ");
				priority_status = scnr.nextInt();
				System.out.println("" + priority_status);
				
				Scanner scnr1 = new Scanner(System.in);
				
				System.out.print("Please enter your name: ");
				flyer_name = scnr1.next();
				System.out.println("" + flyer_name);
				
				Scanner scnr3 = new Scanner(System.in);
				
				System.out.print("Please enter the time you waited in the waiting list:");
				waited_time = scnr3.nextDouble();
				System.out.println("" + waited_time);
				
				currentStatus.setNameandPriority(priority_status, flyer_name, waited_time);
				flyers_status.add(currentStatus);
				
				i = flyers_status.size();
				
				while((i > 1) && ((flyers_status.get((i/2)-1).getPriority()) >= (flyers_status.get(i-1).getPriority()))) {
					
					if((flyers_status.get((i/2)-1).getPriority()) == (flyers_status.get(i-1).getPriority())) {
						
						if(Double.compare((flyers_status.get((i/2)-1).getTime()), (flyers_status.get(i-1).getTime())) > 0) {
							
							tmp = flyers_status.get((i/2)-1);
							flyers_status.set((i/2)-1, flyers_status.get(i-1));
							flyers_status.set(i-1, tmp);
							
							
						}
						
						else {
							
							break;
							
						}
						
						
					}
					
					else {
					
						tmp = flyers_status.get((i/2)-1);
						flyers_status.set((i/2)-1, flyers_status.get(i-1));
						flyers_status.set(i-1, tmp);
						
					}
					
					i = i/2;
					
			
				}
				
				
			}
			
			else if(choice == 4) {
				
				for(i = 0; i < (flyers_status.size()); i++) {
					
					System.out.print("" + flyers_status.get(i).getPriority());
					System.out.print("" + flyers_status.get(i).getName());
					System.out.print("" + flyers_status.get(i).getTime());
					System.out.println();
					
				}
				
				
				/*
				Scanner scnr4 = new Scanner(System.in);
				System.out.print("Please provide your priority for removal: ");
				
				priority_status_provided = scnr4.nextInt();
				
				Scanner scnr5 = new Scanner(System.in);
				System.out.print("\n Please provide your name for removal: ");
				
				flyer_name_provided = scnr5.next();
				
				Scanner scnr6 = new Scanner(System.in);
				System.out.print("\n Please provide your wait time for removal: ");
				
				waited_time_provided = scnr6.nextDouble();
				
				i = 0;
				
				j = searchHeapTree(flyers_status, i, priority_status_provided, flyer_name_provided, waited_time_provided);
				
				System.out.println(j);
				
			}
				
				
		}
	*/	
		
			}
		
		}
		
	}
}
