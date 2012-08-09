package th.c.TreeProblem;

public class BinarySearchTree {
	Node root = null;
	Node curr = root;
	
	public boolean isEmpty() {
		if(root == null) 
			return true;
		else 
			return false;
	}
	
	Node create(int number) {
		return new Node(number);
	}
	
	// Get Size
	public int size() {
		return size(root);
	}
	
	public int size(Node node) {
		if(node == null) return 0;
		else 
			return size(node.left) + 1 + size(node.right);
	}
	
	// Get Height
	public int getHeight() {
		return getHeight(root);
	}
	
	public int getHeight(Node node) {
		if(node == null) return 0;
		else 
			return Math.max(getHeight(node.left), getHeight(node.right))+1;
	}
	
	// Get Min node
	public Node getMin(Node node) {
		if(node == null) return null;
		Node curr = node;
		while(curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}
	
	public Node getNext(Node node) {
		if(node == null) return null;
		Node curr = node;
		if(curr.parent == null || curr.right != null) {
			return getMin(curr.right);
		}
		Node p = curr.parent;
		while(p != null && p != node.left){
			curr = p;
			p = p.parent;
		}
		return p;
	}
	
	// Add a new node
	Node add(Node node, int num) {
		if(node == null) {
			node = create(num);
			return node;
		} else if(num < node.val) {
			if(node.left != null)
				add(node.left, num);
			else 
				node.left = create(num);
		} else if(num >= node.val) {
			if(node.right != null) 
				add(node.right, num);
			else 
				node.right = create(num);
		}
		return null;
	}
	
	public void insert(int num) {
		curr = add(root, num);
		if(isEmpty() == true && curr != null) 
			root = curr;
		curr = root;
	}
	
	// new insert method
	public Node insert2(Node node, int num) {
		if(node == null) {
			node = new Node(num);
			return node;
		} else if(node.val > num) {
			node.left = insert2(node.left, num);
		} else if(node.val < num) {
			node.right = insert2(node.right, num);
		}
		return node;
	}
	
	public 
	
	// Find a node
	Node find(Node node, int num) {
		while(node != null && node.val != num) {
			if(num < node.val){
				node = node.left;
			} else if(num > node.val) {
				node = node.right;
			} 
		}
		return node;
	}
	
	public Node find(int num) {
		if(isEmpty()) return null;
		return find(root, num);
	}
	
	// Delete a node
	Node delete(Node node, int num) {
		if(node == null) return null;
		if(num < node.val) 
			node.left = delete(node.left, num);
		else if(num > node.val) 
			node.right = delete(node.right, num);
		else if(node.left != null && node.right != null) {
			node.val = getMin(node.right).val;
			node.right = removeMin(node.right);
		} else 
			node = (node.left != null) ? node.left : node.right;
		return node;
	}
	
	public Node removeMin(Node node) {
		if(node == null) return null;
		else if(node.left != null) {
			node.left = removeMin(node.left);
			return node;
		} else {
			return node.right;
		}
	}
	
	public void delete(int val){
		delete(root, val);
	}
	
	// Is Binary Search Tree
	public boolean isBST(Node node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST(Node node, int min, int max) {
		if(node == null) return true;
		if(node.val < min || node.val > max) return false;
		return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
	}
}
