/**
 * 
 */
package LinkedList;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class DoublyLinkedList {

	/**
	 * @param args
	 */
	
	DLLNode head;
	
	DoublyLinkedList() {
		head = null;
	}
	
	static int length(DLLNode head) {
		
		int i = 0;
		while(head != null) {
			head = head.next;
			i++;
		}
		return i;
	}
	
	static void printList(DLLNode head) {
		
		if(head == null) {
			System.out.println(head);
			return;
		}
		
		System.out.print("null<-");
		while(head != null) {
			System.out.print(head.data);
			if(head.next != null)
				System.out.print("<=>");
			else
				System.out.print("->");
			head = head.next;
		}
		System.out.println(head);
	}
	
	static DLLNode insert(DLLNode head, int x, int position) {
		
		printList(head);
		int size = length(head), i = 0;
		if((position < 0) | (position > size))
			return null;
		
		DLLNode temp = new DLLNode(x);
		DLLNode iterator = head;
		
		if(size == 0) {
			head = temp;
			return head;
		}
		
		if(position == 0) {
			temp.prev = null;
			temp.next = head;
			temp.next.prev = temp;
			head = temp;
			return head;
		}
		else if(position == size) {
			while(i<size-1) {
				iterator = iterator.next;
				i++;
			}
			iterator.next = temp;
			temp.prev = iterator;
			return head;
		}
		i=0;
		iterator = head;
			while(i<position-1) {
				iterator = iterator.next;
				i++;
			}
			temp.next = iterator.next;
			temp.prev = iterator;
			iterator.next.prev = temp;
			iterator.next = temp;
			return head;
		
	}
	
	static DLLNode delete(DLLNode head, int position) {
		
		int length = length(head);
		
		if((position < 0) | (position > length))
			return null;
		
		DLLNode temp = head;
		DLLNode iterator = head;
		
		if(length == 1) {
			head = null;
			return head;
		}
		
		if(position == 0) {
			head = head.next;
			head.prev = null;
			return head;
		}
		if(position == length-1) {
			while(iterator.next != null) {
				temp = iterator;
				iterator = iterator.next;
			}
			temp.next = null;
			return head;
		}
		int i=0;
		while(i<position-1) {
			temp = iterator;
			iterator = iterator.next;
			i++;
		}
		temp.next = iterator.next;
		iterator.next.prev = temp;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList list = new DoublyLinkedList();
		list.head = insert(list.head,4,0);
		list.head = insert(list.head,5,1);
		list.head = insert(list.head,7,2);
		list.head = insert(list.head,9,0);
		list.head = insert(list.head,3,1);
		printList(list.head);
		list.head = delete(list.head, 3);
		printList(list.head);
		list.head = insert(list.head,10,length(list.head)-1);
		printList(list.head);
		list.head = delete(list.head, 2);
		printList(list.head);
		list.head = delete(list.head, 0);
		printList(list.head);
		list.head = delete(list.head, length(list.head)-1);
		printList(list.head);

	}

}
