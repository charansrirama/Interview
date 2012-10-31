package th.c.TreeProblem;

import java.util.*;

public class TraverseTree {
	public void inorder(Node node) {
		if(node == null) return;
		inorder(node.left);
		System.out.println(node.val);
		inorder(node.right);
	}
	
	public void preorder(Node node) {
		if(node == null) return;
		System.out.println(node.val);
		preorder(node.left);
		preorder(node.right);
	}
	
	public void postorder(Node node) {
		if(node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.val);
	}
	
	public void pre(Node node) {
		if(node == null) return;
		Stack<Node> s = new Stack<Node>();
		s.push(node);
		while(!s.isEmpty()) {
			Node curr = s.pop();
			System.out.println(curr.val);
			if(curr.right != null) 
				s.push(curr.right);
			if(curr.left != null) 
				s.push(curr.left);
		}
	}
	
	public void in(Node node) {
		if(node == null) return;
		Stack<Node> s = new Stack<Node>();
		while(node != null) {
			s.push(node);
			node = node.left;
		}
		
		while(!s.isEmpty()) {
			Node curr = s.pop();
			System.out.println(curr.val);
			curr = curr.right;
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
		}
	}
	
	public void post(Node node) {
		if(node == null) return;
		Stack<Node> s = new Stack<Node>();
		s.push(node);
		Node prev = null;
		while(!s.isEmpty()) {
			Node curr = s.peek();
			if(prev == null || prev.left == curr || prev.right == curr) {
				if(curr.right != null) {
					s.push(curr.right);
				} else if(curr.left != null) {
					s.push(curr.left);
				}
			} else if(curr.left == prev) {
				if(curr.right != null) 
					s.push(curr.right);
			} else {
				System.out.println(curr.val);
				s.pop();
			}
			prev = curr;
		}
	}
}
