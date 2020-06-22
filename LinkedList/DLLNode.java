/**
 * 
 */
package LinkedList;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class DLLNode {
	
	int data;
	DLLNode prev;
	DLLNode next;

	DLLNode() {
		data = 0;
		prev = null;
		next = null;
	}
	DLLNode(int x) {
		data = x;
		prev = null;
		next = null;
	}
}
