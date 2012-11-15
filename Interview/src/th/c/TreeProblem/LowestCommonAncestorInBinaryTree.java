package th.c.TreeProblem;

import java.util.*;

public class LowestCommonAncestorInBinaryTree {
	public Node LCAinBT(Node root, Node p, Node q) {
		if(root == null) return null;
		if(root == p || root == q) return root;
		Node l = LCAinBT(root.left, p, q);
		Node r = LCAinBT(root.right, p, q);
		
		if(l!=null && r!=null) return root; // p and q is on both sides
		return (l == null) ? r : l;
	}
	
	// O(logn) method
	public static boolean getPath(Node root, Node a, LinkedList<Node> path) {
		if(root == null) return false;
		if(root == a) 
			return true;
		path.addLast(root);
		boolean found = false;
		found = getPath(root.left, a, path);
		if(!found) 
			found = getPath(root.right, a, path);
		if(!found)
			path.removeLast();
		return found;
	}
	
	public static Node findCommon(LinkedList<Node> p1, LinkedList<Node> p2) {
		Iterator iter1 = p1.iterator();
		Iterator iter2 = p2.iterator();
		Node re = null;
		while(iter1.hasNext() && iter2.hasNext()) {
			Node t1 = (Node) iter1.next();
			Node t2 = (Node) iter2.next();
			if(t1 == t2)
				re = t1;
		}
		return re;
	}
	
	public static Node findLCA(Node root, Node a, Node b) {
		if(root == null || a == null || b == null) return null;
		LinkedList<Node> p1 = new LinkedList<Node>();
		LinkedList<Node> p2 = new LinkedList<Node>();
		boolean f1 = getPath(root, a, p1);
		boolean f2 = getPath(root, b, p2);
		if(f1 && f2) {
			return findCommon(p1, p2);
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(8);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right.left = new Node(7);
		root.right.right = new Node(9);
		
		Node re = findLCA(root, root.left.left, root.right.right);
		System.out.println(re.val);
	}
}
