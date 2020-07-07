/**
 * 
 */
package arrays;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class FindMissingNumber {

	/**
	 * @param args
	 */
	
	public static int findMissingNumber(int[] A) {
		
		int len = A.length, expectedSum=0, actualSum=0;
		
		for(int i=0; i<len; i++)
			actualSum += A[i];
		expectedSum = (len*(len-1))/2;
		
		return (expectedSum-actualSum+A[len-1]);
	}
	
	public static int findDuplicateNumber(int[] A) {
		
		int len = A.length, expectedSum=0, actualSum=0;
		
		for(int i=0; i<len; i++)
			actualSum += A[i];
		expectedSum = (len*(len-1))/2;
		
		return (actualSum-expectedSum);
	}
	
	public static int binarySearch(int[] A, int x) {
		
		int low=0, high=A.length-1, mid, index;
		
		while(low <= high) {
			mid = (low+high)/2;
			System.out.println("Mid: "+mid);
			if(A[mid] == x) {
				index = mid;
				return index;
			}
			else if(A[mid]<x) {
				low = mid+1;
			}
			else
				high = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {1,2,3,4,5,0,7,8,9};
		System.out.println("Missing Number in Array: "+findMissingNumber(A));
		
		int[] B = {1,2,3,4,5,6,7,7};
		System.out.println("Duplicated Number in Array: "+findDuplicateNumber(B));
		
		int[] C = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int x = 15;
		System.out.println("Array Index of Number " + x +" in Array: "+binarySearch(C, x));
	}

}
