/* Name: Georges Hatem
 * 
 * Assignment: CS590 Hw1 Analysis Application Exercises
 * 
 * Description: An efficient algorith for reversing an Array A. The running time algorith is O(n).
 * 
 * Due Date: January 30, 2022
 * 
 */

public class hw1_G_Hatem {

	public static void main(String[] args) {
		
		int [] A = {3, 4, 1, 5};
		int temp;
		
		for(int i = 0; i < (A.length/2); i++) {
			
			temp = A[i];
			A[i] = A[(A.length - 1) - i];
			A[(A.length - 1) - i] = temp;
			
		}
		
		
		for(int i =0; i < A.length; i++) {
			
			System.out.print("" + A[i]);
			
		}
		
		System.out.println("");
		
	}

}
