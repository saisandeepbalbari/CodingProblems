package Sorting;



public class MergeSort {
	
	public static int[]  Partition(int[] arr, int low, int high) {
		
		int mid = (low+high)/2;
		
		int[] left = new int[mid-low+1];
		int[] right = new int[high-mid];
		
		if(low == high) {
			left[0] = arr[low];
			return left;
		}
		
		left = Partition(arr, low, mid);
		right = Partition(arr, mid+1, high);
		
		int[] Aux = new int[high-low+1];
		Aux = Merge(left, right, low, mid, high);
		
		return Aux;
	}
	
	public static int[] Merge(int[] left, int[] right, int low, int mid, int high) {
		
		int[] Aux = new int[high-low+1];
		int i=0, j=0, k=0;
		
		while((i < mid-low+1) & (j < high-mid)) {
			if(left[i] < right[j]) {
				Aux[k] = left[i];
				i++;
			}
			else {
				Aux[k] = right[j];
				j++;
			}
			k++;
		}
		
		while((i == mid-low+1) & (j < high-mid)) {
			Aux[k] = right[j];
			j++;
			k++;
		}
		
		while((i < mid-low+1) & (j == high-mid)) {
			Aux[k] = left[i];
			i++;
			k++;
		}
		
		System.out.println();
		System.out.println("Steps:");
		
		for(i=0;i<high-low+1;i++)
			System.out.print("\t" + Aux[i]);
		
		return Aux;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 8;
		int[] arr = {3,9,17,12,6,11,2,8};
		
		
		System.out.println("Input:");
		for(int i=0;i<n;i++)
			System.out.print("\t" + arr[i]);
		
		int[] result = Partition(arr, 0, n-1);
		
		System.out.println();
		System.out.println("Output:");
		for(int i=0;i<n;i++)
			System.out.print("\t" + result[i]);
	}

}
