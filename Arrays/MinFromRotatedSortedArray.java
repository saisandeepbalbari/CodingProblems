/**
 * 
 */
package arrays;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class MinFromRotatedSortedArray {

	/**
	 * @param args
	 */
	
	public static int linearMin(int[] A) {
		int i, min=A[0];
		System.out.println("Called Linear Min");
		for(i=0; i<A.length;i++) {
			if(A[i] < min)
				min = A[i];
		}
		return min;
	}
	
	public static int binaryMin(int[] A, int low, int high) {
		
		int mid = (high+low)/2;
		System.out.print("Called Binary Min:::");
		System.out.println("\tMid element: "+ A[mid]);
		if(low==high)
			return A[low];
		if(low+1==high) {
			if(A[low] < A[high])
				return A[low];
			else
				return A[high];
		}
		
		if(A[mid] < A[high])
			return binaryMin(A, low, mid);
		else
			return binaryMin(A, mid+1, high);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {4,5,6,7,8,9,1,2,3};
		
		System.out.println(linearMin(A));
		System.out.println("Minimum element: "+binaryMin(A,0,8));

	}

}
