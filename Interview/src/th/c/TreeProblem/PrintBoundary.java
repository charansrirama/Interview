package th.c.TreeProblem;

public class PrintBoundary {
	public void printBoundary(Node root) {
		Node tmp = root;
		preorderLeftOnly(tmp);
		tmp = root;
		inorderLeafOnly(tmp);
		tmp = root;
		postorderRightOnly(tmp);
	}

	public boolean isLeaf(Node node) {
		return node!=null && node.left == null && node.right == null;
	}

	public void preorderLeftOnly(Node node) {
		if(node != null && !isLeaf(node)) System.out.print(node.val + ">");
		if(node.left != null)
			preorderLeftOnly(node.left);
	}

	public void inorderLeafOnly(Node node) {
		if(node == null) return;
		if(node.left != null) inorderLeafOnly(node.left);
		if(node.left==null && node.right==null) 
			System.out.print(node.val + ">");
		if(node.right != null) inorderLeafOnly(node.right);
	}

	public void postorderRightOnly(Node node) {
		if(node.right != null) 
			postorderRightOnly(node.right);
		if(node != null && !isLeaf(node)) 
			System.out.print(node.val + ">");
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		PrintBoundary test = new PrintBoundary();
		test.printBoundary(root);
	}
}
