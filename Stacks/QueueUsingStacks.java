/**
 * 
 */
package Stacks;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class QueueUsingStacks<T> {

	/**
	 * @param args
	 */
	
	private class StackNode {
		
		T data;
		StackNode next;
		
		StackNode(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
	
	private class Stack {
		int top;
		StackNode topPointer;
		
		Stack() {
			this.top = -1;
			this.topPointer = null;
		}
		
		private Stack push(T data) {
			
			System.out.println("Push");
			
			StackNode temp = new StackNode(data);
			
			if(this.top == -1) {
				this.top++;
				this.topPointer = temp;
				return this;
			}
			
			temp.next = this.topPointer;
			this.top++;
			this.topPointer = temp;
			
			return this;
		}
		
		private boolean isEmpty() {
			if(this.top == -1)
				return true;
			else
				return false;
		}
		
		private T pop() {
			
			System.out.println("Pop");
			
			if(this.isEmpty() == true)
				return null;
			
			T data = this.topPointer.data;
			this.top--;
			this.topPointer = this.topPointer.next;
			
			return data;
		}
	}
	
	private Stack insertionStack;
	private Stack deletionStack;
	
	
	
	QueueUsingStacks() {
		
		this.insertionStack = new Stack();
		this.deletionStack = new Stack();
	}
	
	QueueUsingStacks<T> insert(T data) {
		
		System.out.println("Inserted " + data + " into the Queue");
		this.insertionStack.push(data);
		
		return this;
	}
	
	T delete() {
		
		T data;
		
		if(this.deletionStack.isEmpty() == false) {
			data = this.deletionStack.pop();
			System.out.println("Deleted " + data + " from the Queue");
			return data;
		}
		
		while(this.insertionStack.isEmpty() == false) {
			this.deletionStack.push(this.insertionStack.pop());
		}
		
		data = this.deletionStack.pop();
		
		System.out.println("Deleted " + data + " from the Queue");
		
		return data;
	}
	
	int length() {
		
		System.out.println("Length of Queue is:");
		
		if((this.insertionStack.top == -1) & (this.deletionStack.top == -1))
			return 0;
		else if((this.insertionStack.top != -1) & (this.deletionStack.top == -1))
			return this.insertionStack.top + 1;
		else if((this.insertionStack.top == -1) & (this.deletionStack.top != -1))
			return this.deletionStack.top + 1;
		else
			return this.insertionStack.top + this.deletionStack.top + 2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueUsingStacks<Integer> Q = new QueueUsingStacks<Integer>();
		
		Q.insert(5);
		Q.insert(3);
		Q.insert(8);
		System.out.println(Q.length());
		System.out.println(Q.delete());
		Q.insert(9);
		Q.insert(2);
		System.out.println(Q.delete());
		System.out.println(Q.delete());
		System.out.println(Q.delete());
		System.out.println(Q.delete());
		
	}

}
