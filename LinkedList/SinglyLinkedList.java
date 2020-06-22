package LinkedList;
//import LinkedList.SLLNode;

public class SinglyLinkedList {
	
	SLLNode head;
	
	SinglyLinkedList() {
		head = null;
	}
	
	static int length(SLLNode head) {
		int i = 0;
		while(head != null) {
			head = head.next;
			i++;
		}
		return i;
	}
	
	static void printList(SLLNode head) {
		
		while(head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println(head);
	}
	
	static SLLNode insert(SLLNode head, int x, int position) {
		
		printList(head);
		int size = length(head), i = 0;
		if((position < 0) | (position > size))
			return null;
		
		SLLNode temp = new SLLNode(x);
		SLLNode iterator = head;
		
		if(position == 0) {
			temp.next = head;
			head = temp;
			return head;
		}
		else if(position == size) {
			while(i<size-1) {
				iterator = iterator.next;
				i++;
			}
			iterator.next = temp;
			return head;
		}
		i=0;
		iterator = head;
			while(i<position-1) {
				iterator = iterator.next;
				i++;
			}
			temp.next = iterator.next;
			iterator.next = temp;
			return head;
		
	}
	
	static SLLNode delete(SLLNode head, int position) {
		
		int length = length(head);
		
		if((position < 0) | (position > length))
			return null;
		
		SLLNode temp = head;
		SLLNode iterator = head;
		
		if(position == 0) {
			head = head.next;
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
		iterator.next = null;
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
