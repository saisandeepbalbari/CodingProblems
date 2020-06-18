package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 8;
		int[] arr = {3,9,17,12,6,11,2,8};
		int i, j, minLoc, temp;
		
		System.out.println("Input:");
		for(i=0;i<n;i++)
			System.out.print("\t" + arr[i]);
		System.out.println();
		System.out.println("Steps:");
		
		for(i=0;i<n-1;i++) {
			minLoc = i;
			for(j=i+1;j<=n-1;j++) {
				if(arr[j] < arr[minLoc])
					minLoc = j;
			}
			temp = arr[i];
			arr[i] = arr[minLoc];
			arr[minLoc] = temp;
			
			for(int k=0; k<n;k++)
				System.out.print("\t" + arr[k]);
			System.out.println();
		}
		System.out.println("Output:");
		for(i=0;i<n;i++)
			System.out.print("\t" + arr[i]);
	}

}
