package Sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 8;
		int[] arr = {3,9,17,12,6,11,2,8};
		int i, j, temp;
		
		System.out.println("Input:");
		for(i=0;i<n;i++)
			System.out.print("\t" + arr[i]);
		System.out.println();
		System.out.println("Steps:");
		
		for(i=1;i<n-1;i++) {
			for(j=0;j<=n-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			for(int k=0; k<n;k++)
				System.out.print("\t" + arr[k]);
			System.out.println();
		}
		
		System.out.println("Output:");
		for(i=0;i<n;i++)
			System.out.print("\t" + arr[i]);

	}

}
