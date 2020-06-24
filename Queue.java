/**
 * 
 */
package Queues;
import java.util.NoSuchElementException;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class Queue<T> {
	
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> front;
	private QueueNode<T> rear;

	/**
	 * @param args
	 */
	
	public void insert(T element) {
		
		QueueNode<T> temp = new QueueNode<T>(element);
		
		if(rear != null) {
			rear.next = temp;
		}
		
		rear = temp;
		
		if(front == null) {
			front = rear;
		}
	}
	
	public T delete() {
		
		if(front == null)
			throw new NoSuchElementException("Queue is empty");
		
		T element = front.data;
		front = front.next;
		if(front == rear.next) {
			front = null;
			rear = null;
		}
		return element;
	}
	
	public T seek() {
		if(front == null)
			throw new NoSuchElementException("Queue is empty");
		return front.data;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public void printQueueElements(Queue<T> Q) {
		
		System.out.println("Printing the elements in Queue from front to rear");
		if(front == null)
			throw new NoSuchElementException("Queue is empty");
		
		QueueNode<T> temp = front;
		
		while(temp != null) {
			System.out.print("\t" + temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> Q = new Queue<Integer>();
		Q.insert(6);
		Q.printQueueElements(Q);
		Q.insert(3);
		Q.printQueueElements(Q);
		Q.insert(9);
		Q.printQueueElements(Q);
		Q.insert(8);
		Q.printQueueElements(Q);
		Q.delete();
		Q.printQueueElements(Q);
		Q.delete();
		Q.printQueueElements(Q);
		Q.delete();
		Q.printQueueElements(Q);
		Q.insert(5);
		Q.printQueueElements(Q);
		Q.delete();
		Q.printQueueElements(Q);
		
	}

}
