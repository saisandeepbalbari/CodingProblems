/**
 * 
 */
package Stacks;
import java.util.EmptyStackException;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class Stack<T> {

	/**
	 * @param args
	 */
	
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	private StackNode<T> top;
	
	public void push(T element) {
		StackNode<T> temp = new StackNode<T>(element);
		temp.next = top;
		top = temp;
	}
	
	public T pop() {
		if(top == null)
			throw new EmptyStackException();
		T element = top.data;
		top = top.next;
		return element;
	}
	
	public T peek() {
		if(top == null)
			throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void printStackElements(Stack<T> S) {
		System.out.println("Stack Elements from top to bottom:");
		if(S.top == null)
			throw new EmptyStackException();
		StackNode<T> temp = S.top;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Stack<Integer> S = new Stack<Integer>();
		S.push(6);
		S.printStackElements(S);
		S.push(3);
		S.printStackElements(S);
		S.push(7);
		S.printStackElements(S);
		S.push(9);
		S.printStackElements(S);
		S.push(2);
		S.printStackElements(S);
		S.pop();
		S.printStackElements(S);
		S.pop();
		S.printStackElements(S);
		S.push(5);
		S.printStackElements(S);
		S.push(1);
		S.printStackElements(S);
		S.pop();
		S.printStackElements(S);
		S.pop();
		S.printStackElements(S);
	}

}
