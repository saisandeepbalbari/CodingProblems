package Sorting;

import java.lang.reflect.Array;

public class QuickSort {
	
	public static int[] QuickSortMethod(int[] arr, int low, int high) {
		
		int[] left;
		int[] right;
		
		if(low == high) {
			left = new int[1];
			left[0] = arr[low];
			System.out.print("\t" + arr[low]);
			System.out.println();
			return left;
		}
		
		int[] A = new int[high-low+2];
		for(int i=low; i<=high;i++) {
			A[i-low] = arr[i];
		}
		A[high-low+1] = 9999;
		
		int i=1, j=high-low+1;
		int pivot = A[0];
		int temp;

		
		while(i<j) {
				while((A[i] < pivot))
					i++;
				while((A[j] > pivot))
					j--;
			if(i<j) {
			temp = A[i];
			A[i] = A[j];
			A[j] = temp;
			i++;
			j--;
			}
		}
		A[0] = A[i-1];
		A[i-1] = pivot;
		
		left = QuickSortMethod(A, 0, i-1);
		right = QuickSortMethod(A, i, high-low);
		
		i=0;
		j=0;
		while(i < Array.getLength(left)-1) {
			A[j] = left[i];
			i++;
			j++;
		}
		i=0;
		while(i < Array.getLength(right)-1) {
			A[j] = right[i];
			i++;
			j++;
		}
		for(int k=0; k<high-low+1;k++)
			System.out.print("\t" + A[k]);
		System.out.println();
		
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 8;
		int[] arr = {6,9,17,12,3,11,2,8};
		int i;
		
		System.out.println("Input:");
		for(i=0;i<n;i++)
			System.out.print("\t" + arr[i]);
		System.out.println();
		System.out.println("Steps:");
		
		arr = QuickSortMethod(arr, 0, n-1);
		
		System.out.println("Output:");
		for(i=0;i<n;i++)
			System.out.print("\t" + arr[i]);
	}

}
