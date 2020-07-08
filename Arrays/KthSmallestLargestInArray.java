/**
 * 
 */
package arrays;


/**
 * @author Sai Sandeep Balbari
 *
 */
public class KthSmallestLargestInArray {

	/**
	 * @param args
	 */
	
public static int[] heapifyMin(int[] A, int high) {
		
		if(A.length == 1)
			return A;
		
		System.out.println("Heapify Min");
		
		int node = 0;
		int leftChild = (2*node)+1;
		int rightChild = (2*node)+2;
		int temp, minChild;
		
		while((leftChild<=high)) {
			
			if(rightChild>high)
				minChild = leftChild;
			else if(A[leftChild] < A[rightChild])
				minChild = leftChild;
			else
				minChild = rightChild;
			
			if(A[node] > A[minChild]) {
				temp = A[node];
				A[node] = A[minChild];
				A[minChild] = temp;
				node = minChild;
				leftChild = (2*node)+1;
				rightChild = (2*node)+2;
			}
			else
				break;
		}
		return A;
	}
	
	public static int[] createMinHeap(int[] K) {
		
		System.out.println("Create Min Heap:");
		int len = K.length;
		int[] temp = new int[len];
		int parent, t2, node;
		
		for(int i=0; i<len; i++) {
			temp[i] = K[i];
			
			node = i;
			parent = (int) Math.floor((node-1)/2);
			while(parent>=0) {
				if(temp[parent] > temp[node]) {
					t2 = temp[parent];
					temp[parent] = temp[node];
					temp[node] = t2;
					node = parent;
					parent = (int) Math.floor((node-1)/2);
				}
				else break;
			}
		}
		
		return temp;
	}
	
	public static int[] kLargest(int[] A, int sizeK) {
		
		System.out.println("kLargest:");
		int[] kArray = new int[sizeK];
		int i, temp;
		
		for(i=0; i<sizeK; i++) {
			kArray[i] = A[i];
		}
		
		kArray = createMinHeap(kArray);
		
		
		for(i=sizeK; i<A.length; i++) {
			if(kArray[0] < A[i]) {
				temp = kArray[0];
				kArray[0] = A[i];
				A[i] = temp;
				kArray = heapifyMin(kArray, sizeK-1);
			}
		}
		System.out.println(sizeK + "th Largest number is: " + kArray[0]);
		return kArray;
	}
	
	
	public static int[] heapifyMax(int[] A, int high) {
		
		if(A.length == 1)
			return A;
		
		System.out.println("Heapify Max");
		
		int node = 0;
		int leftChild = (2*node)+1;
		int rightChild = (2*node)+2;
		int temp, maxChild;
		
		while((leftChild<=high)) {
			
			if(rightChild>high)
				maxChild = leftChild;
			else if(A[leftChild] > A[rightChild])
				maxChild = leftChild;
			else
				maxChild = rightChild;
			
			if(A[node] < A[maxChild]) {
				temp = A[node];
				A[node] = A[maxChild];
				A[maxChild] = temp;
				node = maxChild;
				leftChild = (2*node)+1;
				rightChild = (2*node)+2;
			}
			else
				break;
		}
		return A;
	}
	
	public static int[] createMaxHeap(int[] K) {
		
		System.out.println("Create Max Heap:");
		int len = K.length;
		int[] temp = new int[len];
		int parent, t2, node;
		
		for(int i=0; i<len; i++) {
			temp[i] = K[i];
			
			node = i;
			parent = (int) Math.floor((node-1)/2);
			while(parent>=0) {
				if(temp[parent] < temp[node]) {
					t2 = temp[parent];
					temp[parent] = temp[node];
					temp[node] = t2;
					node = parent;
					parent = (int) Math.floor((node-1)/2);
				}
				else break;
			}
		}
		
		return temp;
	}
	
	public static int[] kSmallest(int[] A, int sizeK) {
		
		System.out.println("kSmallest:");
		int[] kArray = new int[sizeK];
		int i, temp;
		
		for(i=0; i<sizeK; i++) {
			kArray[i] = A[i];
		}
		
		kArray = createMaxHeap(kArray);
		
		
		for(i=sizeK; i<A.length; i++) {
			if(kArray[0] > A[i]) {
				temp = kArray[0];
				kArray[0] = A[i];
				A[i] = temp;
				kArray = heapifyMax(kArray, sizeK-1);
			}
		}
		System.out.println(sizeK + "th Smallest number is: " + kArray[0]);
		return kArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {4, 6, 2, 7, 3, -6, -3, 56, 0, 9, 1, 5, 8, -10,-11,-12,-13,-14,-15,-16};
		int k = 6;
		int[] result = kSmallest(A, k);
		
		for(int i=0; i<k; i++) {
			System.out.print("\t" + result[i]);
		}
		System.out.println();
		int[] B = {4, 6, 2, 7, 3, -6, -3, 56, 0, 9, 1, 5, 8, -10,-11,-12,-13,-14,-15,-16};
		result = kLargest(B, k);
		
		for(int i=0; i<k; i++) {
			System.out.print("\t" + result[i]);
		}
		
	}

}
