/**
 * 
 */
package Queues;

import java.util.ArrayList;
import java.lang.Math;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class PriorityQueue {

	/**
	 * @param args
	 */
	
	ArrayList<Integer> insert(ArrayList<Integer> A, int element) {
		
		int size = A.size();
		if(size == 0) {
			A.add(element);
			return A;
		}
		
		int child = size, parent, temp;
		parent = (int) Math.floor((child-1)/2);
		A.add(element);
		
		while(child > 0) {
			if(A.get(parent) > A.get(child)) {
				System.out.println("Swapping");
				temp = A.get(parent);
				A.set(parent, A.get(child));
				A.set(child, temp);
			}
			child = parent;
			parent = (int) Math.floor((child-1)/2);
		}
		
		return A;
	}
	
	ArrayList<Integer> delete(ArrayList<Integer> A) {
		
		int size = A.size();
		if(size == 0) {
			return A;
		}
		
		int temp = A.get(0);
		A.set(0, A.get(size-1));
		A.set(size-1, temp);
		size--;
		int temp2;
		int parent = 0, leftChild = 2*parent + 1, rightChild = 2*parent + 2;
		
		while(parent <= size) {
			
			if(leftChild > size | rightChild > size ) {
				return A;
			}
			else if((leftChild < size & rightChild < size & A.get(leftChild) < A.get(rightChild)) | (leftChild < size & rightChild >= size)) {
				temp = leftChild;
			}
			else if(leftChild < size & rightChild < size & A.get(leftChild) >= A.get(rightChild)) {
				temp = rightChild;
			}
			if(A.get(parent) > A.get(temp)) {
				System.out.println("Swapping with parent");
				temp2 = A.get(parent);
				A.set(parent, A.get(temp));
				A.set(temp, temp2);
			}
			parent = temp;
			leftChild = 2*parent + 1;
			rightChild = 2*parent + 2;
			//size--;
		}
		
		return A;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		PriorityQueue PQ = new PriorityQueue();
		A = PQ.insert(A, 5);
		System.out.println(A);
		A = PQ.insert(A, 7);
		System.out.println(A);
		A = PQ.insert(A, 4);
		System.out.println(A);
		A = PQ.insert(A, 8);
		System.out.println(A);
		A = PQ.insert(A, 6);
		System.out.println(A);
		A = PQ.insert(A, 2);
		System.out.println(A);
		A = PQ.insert(A, 3);
		System.out.println(A);
		A = PQ.insert(A, 9);
		System.out.println(A);
		A = PQ.insert(A, 1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.insert(A, 4);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		A = PQ.delete(A);
		B.add(A.get(A.size()-1));
		A.remove(A.size()-1);
		System.out.println(A);
		System.out.println(B);
	}

}
