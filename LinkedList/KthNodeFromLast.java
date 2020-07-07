/**
 * 
 */
package LinkedList;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class KthNodeFromLast extends SinglyLinkedList {

	/**
	 * @param args
	 */
	
	public static int kthFromLast(SLLNode head, int k) {
		
		SLLNode back = head, front = head;
		int i=0;
		
		int len = length(head);
		if(k<1 | k >len)
			return -1;
		
		while(i<k) {
			front = front.next;
			i++;
		}
		
		while(front != null) {
			back = back.next;
			front = front.next;
		}
		System.out.println(k + " th element from the end is " + back.data);
		return back.data;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList list = new SinglyLinkedList();
		list.head = insert(list.head,4,0);
		list.head = insert(list.head,5,1);
		list.head = insert(list.head,7,2);
		list.head = insert(list.head,9,0);
		list.head = insert(list.head,3,1);
		list.head = insert(list.head,2,1);
		printList(list.head);
		int ele;
		ele = kthFromLast(list.head, 0);
		ele = kthFromLast(list.head, 7);
		ele = kthFromLast(list.head, 3);
		ele = kthFromLast(list.head, 5);
	}

}
