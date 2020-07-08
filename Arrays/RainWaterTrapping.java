/**
 * 
 */

/**
 * @author Sai Sandeep Balbari
 *
 */
public class RainWaterTrapping {

	/**
	 * @param args
	 */
	
	public static void rainWaterTrap(int[] A) {
		
		int[] leftHighest = new int[A.length];
		int[] rightHighest = new int[A.length];
		
		leftHighest[0] = 0;
		rightHighest[A.length-1] = 0;
		
		int highestSofar = A[0];
		
		for(int i=1; i<A.length; i++) {
			
			if(highestSofar < A[i])
				highestSofar = A[i];
			
			leftHighest[i] = highestSofar;
		}
		
		highestSofar = A[A.length-1];
		
		for(int i=A.length-2; i>=0; i--) {
			
			if(highestSofar < A[i])
				highestSofar = A[i];
			
			rightHighest[i] = highestSofar;
		}
		
		int trappedWater = 0;
		for(int i=1; i<A.length-1; i++) {
			if(leftHighest[i] < rightHighest[i])
				trappedWater = trappedWater + leftHighest[i] - A[i];
			else
				trappedWater = trappedWater + rightHighest[i] - A[i];
		}
		
		System.out.println("Total water trapped: "+ trappedWater);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {2, 0, 2};
		int[] B = {3, 0, 2, 0, 4};
		int[] C = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		rainWaterTrap(A);
		rainWaterTrap(B);
		rainWaterTrap(C);

	}

}
