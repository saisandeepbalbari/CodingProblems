/**
 * 
 */
package LinkedList;
//import LinkedList.SinglyLinkedList;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class RemoveDuplicates extends SinglyLinkedList {

	/**
	 * @param args
	 */
	
	public static SLLNode removeDups(SLLNode head) {
		
		System.out.println("Removing Duplicates from an unsorted linkedlist:");
		SLLNode temp = head;
		SLLNode duplicate;
		SLLNode prev;
		printList(head);
		int operations = 0;
		while(temp.next != null) {
			prev = temp;
			duplicate = temp.next;
			
			while(duplicate != null) {
				//System.out.println("List Before Deletion");
				//printList(head);
				if(temp.data == duplicate.data)
					prev.next = duplicate.next;
				else
					prev = duplicate;
				
				duplicate = duplicate.next;
				//System.out.println("List After Deletion");
				//printList(head);
				operations++;
			}
			if(temp.next != null)
				temp = temp.next;
		}
		printList(head);
		System.out.println("Total Steps: "+operations);
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		SinglyLinkedList list = new SinglyLinkedList();
		list.head = insert(list.head,4,0);
		list.head = insert(list.head,5,1);
		list.head = insert(list.head,7,2);
		list.head = insert(list.head,9,0);
		list.head = insert(list.head,3,1);
		list.head = insert(list.head,4,3);
		list.head = insert(list.head,5,0);
		list.head = insert(list.head,7,2);
		list.head = insert(list.head,9,0);
		list.head = insert(list.head,3,1);
		list.head = insert(list.head,4,7);
		list.head = insert(list.head,5,5);
		list.head = insert(list.head,7,0);
		list.head = insert(list.head,2,8);
		printList(list.head);
		list.head = removeDups(list.head);
		printList(list.head);
	}
}
