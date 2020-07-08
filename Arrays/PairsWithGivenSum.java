/**
 * 
 */
package arrays;

import java.util.Arrays;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class PairsWithGivenSum {

	/**
	 * @param args
	 */
	
	public static void pairsWithGivenSum(int[] A, int sum) {
		
		int low = 0, high = A.length-1, pairSum;
		
		Arrays.sort(A);
		
		while(low<=high) {

			pairSum = A[low]+A[high];
			if(pairSum == sum) {
				System.out.println("(" + A[low] + "," + A[high] + ")");
				low++;
			}
			else if(pairSum < sum)
				low++;
			else
				high--;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {7, -3, 4, 2, 6, 3, -2, 9, -5, 8, -4};
		int sum = 4;
		pairsWithGivenSum(A, sum);
	}

}
