package th.c.TreeProblem;

public class BST2DoubleLinkedlist {
	public Node treeToList(Node root) {
		Node head = helper(root);
		while(head.left!=null) head = head.left;
		return head;
	}
	
	private Node helper(Node node) {
		if(node == null) return null;
		Node left = helper(node.left);
		Node right = helper(node.right);
		
		if(left != null) {
			while(left.right!=null)
				left = left.right;
			left.right = node;
		}
		node.left = left;
		if(right != null) {
			while(right.left!=null) 
				right = right.left;
			right.left = node;
		}
		node.right = right;
		
		return node;
	}
}
