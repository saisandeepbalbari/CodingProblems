/**
 * 
 */
package trees;

import Queues.Queue;

/**
 * @author Sai Sandeep Balbari
 *
 */
public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int element) {
		this.data = element;
		this.left = null;
		this.right = null;
	}
	
	
	public TreeNode insert(TreeNode root, int element) {
		
		if(root == null) {
			TreeNode temp = new TreeNode(element);
			root = temp;
		}
		else if(root.data >= element) {
			root.left = insert(root.left, element);
		}
		else {
			root.right = insert(root.right, element);
		}
		return root;
	}
	
	public void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print("\t" + root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print("\t" + root.data);
		inOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print("\t" + root.data);
	}
	
	public void levelOrder(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> Q = new Queue<TreeNode>();
		Q.insert(root);
		TreeNode temp;
		while(!Q.isEmpty()) {
			temp = Q.delete();
			if(temp.left != null)
				Q.insert(temp.left);
			if(temp.right != null)
				Q.insert(temp.right);
			System.out.print("\t" + temp.data);
		}
		
	}
	
	public void search(TreeNode root, int element) {
		
		if(root == null)
			return;
		if(root.data == element) {
			System.out.println("Element " + element + " found");
			return;
		}
		else if((root.data > element) & (root.left != null)) {
			System.out.println("Going left!!");
			search(root.left, element);
		}
		else if((root.data < element) & (root.right != null)) {
			System.out.println("Going right!!");
			search(root.right, element);
		}
		else {
			System.out.println("Element " + element + " not found!");
			return;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(6);
		root = root.insert(root, 8);
		root = root.insert(root, 7);
		root = root.insert(root, 9);
		root = root.insert(root, 4);
		root = root.insert(root, 3);
		root = root.insert(root, 5);
		System.out.println();
		System.out.println("Level Order Traversal:");
		root.levelOrder(root);
		System.out.println();
		System.out.println("Pre Order Traversal:");
		root.preOrder(root);
		System.out.println();
		System.out.println("In Order Traversal:");
		root.inOrder(root);
		System.out.println();
		System.out.println("Post Order Traversal:");
		root.postOrder(root);
		System.out.println();
		root.search(root, 2);
		root.search(root, 8);
	}

}
