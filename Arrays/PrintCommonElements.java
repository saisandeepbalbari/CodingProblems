/**
 * 
 */
package arrays;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class PrintCommonElements {

	/**
	 * @param args
	 */
	
	public static int[] printCommonAmongTwoSortedArrays(int[] A, int[] B) {

		int lenA = A.length, lenB = B.length;
		int i=0, j=0;
		int[] temp;
		if(lenA > lenB) {
			temp = new int[lenA];
			i=0;
			j=0;
			while((i<lenA) & (j<lenB)) {
				if(A[i] == B[j]) {
					temp[i] = B[j];
					i++;
					j++;
				}
				else if(A[i] < B[j]) {
					temp[i] = 0;
					i++;
				}
				else {
					temp[i] = 0;
					j++;
				}
			}
		}
		else {
			temp = new int[lenB];
			i=0;
			j=0;
			while((i<lenB) & (j<lenA)) {
				if(B[i] == A[j]) {
					temp[i] = A[j];
					i++;
					j++;
				}
				else if(B[i] < A[j]) {
					temp[i] = 0;
					i++;
				}
				else {
					temp[i] = 0;
					j++;
				}
			}
		}
		
		return temp;
	}
	
	public static int[] printCommonAmongThreeSortedArrays(int[] A, int[] B, int[] C) {
		
		int[] result = printCommonAmongTwoSortedArrays(A, B);
		int[] result2 = printCommonAmongTwoSortedArrays(result, C);
		
		return result2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {13, 16, 20, 24, 29, 35, 42, 55, 65};
		int[] B = {2, 8, 20, 35, 41, 56, 65};
		int[] C = {16, 20, 35, 39, 41};
		
		int[] result = printCommonAmongTwoSortedArrays(A, B);
		int[] result2 = printCommonAmongThreeSortedArrays(A, B, C);
		
		System.out.println("Common between A and B:");
		for(int i=0; i<result.length; i++) {
			if(result[i] != 0)
				System.out.print("\t"+result[i]);
		}
		System.out.println();
		
		result = printCommonAmongTwoSortedArrays(B, C);
		System.out.println("Common between B and C:");
		for(int i=0; i<result.length; i++) {
			if(result[i] != 0)
				System.out.print("\t"+result[i]);
		}
		System.out.println();
		
		result = printCommonAmongTwoSortedArrays(C, A);
		System.out.println("Common between C and A:");
		for(int i=0; i<result.length; i++) {
			if(result[i] != 0)
				System.out.print("\t"+result[i]);
		}
		System.out.println();
		
		System.out.println("Common between A, B and C:");
		for(int i=0; i<result2.length; i++) {
			if(result2[i] != 0)
				System.out.print("\t"+result2[i]);
		}
	}

}
