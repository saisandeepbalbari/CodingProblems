/**
 * 
 */
package Sorting;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class HeapSort {

	/**
	 * @param args
	 */
	
	public static int[] deleteMinHeapify(int[] A, int high) {
		
		System.out.println("Deleting Min and storing at the end:");
		
		if(high==0)
			return A;
		
		int node = 0, leftChild, rightChild, temp, minChild;
		
		temp = A[0];
		A[0] = A[high];
		A[high] = temp;
		
		leftChild = (2*node)+1;
		rightChild = (2*node)+2;
		
		for(int i=0; i<=high; i++)
			System.out.print(A[i]+",");
		System.out.println();
		
		while(leftChild < high) {
			if(rightChild >= high)
				minChild = leftChild;
			else if(A[rightChild] < A[leftChild])
				minChild = rightChild;
			else
				minChild = leftChild;
			
			if(A[node] > A[minChild]) {
				temp = A[node];
				A[node] = A[minChild];
				A[minChild] = temp;
			}
			else break;
			node = minChild;
			leftChild = (2*node)+1;
			rightChild = (2*node)+2;
		}
		
		return A;
	}
	
	public static int[] createMinHeap(int[] A, int high) {
		
		if(high==0)
			return A;
		
		System.out.println("Creating Min Heap:");
		
		int node = high, parent = (int) Math.floor((node-1)/2);
		int temp;
		
		while(parent>=0) {
			if(A[parent]>A[node]) {
				temp = A[parent];
				A[parent] = A[node];
				A[node] = temp;
				node = parent;
				parent = (int) Math.floor((node-1)/2);
			}
			else break;
		}
		return A;
	}
	
	public static int[] heapSortUsingMin(int[] A) {
		
		System.out.println("Heap Sort");
		int len = A.length, i;
		
		for(i=0; i<len; i++) {
			A = createMinHeap(A, i);
		}
		
		for(i=len-1;i>=0;i--) {
			A = deleteMinHeapify(A, i);
		}
		
		return A;
	}
	
	
	public static int[] deleteMaxHeapify(int[] A, int high) {
		
		System.out.println("Deleting Max and storing at the end:");
		
		if(high==0)
			return A;
		
		int node = 0, leftChild, rightChild, temp, maxChild;
		
		temp = A[0];
		A[0] = A[high];
		A[high] = temp;
		
		leftChild = (2*node)+1;
		rightChild = (2*node)+2;
		
		for(int i=0; i<=high; i++)
			System.out.print(A[i]+",");
		System.out.println();
		
		while(leftChild < high) {
			if(rightChild >= high)
				maxChild = leftChild;
			else if(A[rightChild] > A[leftChild])
				maxChild = rightChild;
			else
				maxChild = leftChild;
			
			if(A[node] < A[maxChild]) {
				temp = A[node];
				A[node] = A[maxChild];
				A[maxChild] = temp;
			}
			else break;
			node = maxChild;
			leftChild = (2*node)+1;
			rightChild = (2*node)+2;
		}
		
		return A;
	}
	
	public static int[] createMaxHeap(int[] A, int high) {
		
		if(high==0)
			return A;
		
		System.out.println("Creating Max Heap:");
		
		int node = high, parent = (int) Math.floor((node-1)/2);
		int temp;
		
		while(parent>=0) {
			if(A[parent] < A[node]) {
				temp = A[parent];
				A[parent] = A[node];
				A[node] = temp;
				node = parent;
				parent = (int) Math.floor((node-1)/2);
			}
			else break;
		}
		return A;
	}
	
	public static int[] heapSortUsingMax(int[] A) {
		
		System.out.println("Heap Sort");
		int len = A.length, i;
		
		for(i=0; i<len; i++) {
			A = createMaxHeap(A, i);
		}
		for(i=len-1;i>=0;i--) {
			A = deleteMaxHeapify(A, i);
		}
		return A;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {4,7,2,8,5,1,6,9,3};
		
		for(int i=0; i<A.length; i++)
			System.out.print(A[i]+",");
		System.out.println();
		A = heapSortUsingMin(A);
		
		for(int i=0; i<A.length; i++)
			System.out.print(A[i]+",");
		System.out.println();
		int[] B = {4,7,2,8,5,1,6,9,3};
		
		for(int i=0; i<B.length; i++)
			System.out.print(B[i]+",");
		System.out.println();
		B = heapSortUsingMax(B);
		System.out.println();
		for(int i=0; i<B.length; i++)
			System.out.print(B[i]+",");
	}

}
