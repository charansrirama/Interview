package th.tree2;

public class TreePrinter {
	public static void inorderPrint(Node node) {
		if(node == null)
			return;
		inorderPrint(node.leftChild);
		System.out.print(node.number + " ");
		inorderPrint(node.rightChild);
	}
	
	public static void preorderPrint(Node node) {
		if(node == null) return;
		
		System.out.print(node.number + " ");
		preorderPrint(node.leftChild);
		preorderPrint(node.rightChild);
	}
	
	public static void postorderPrint(Node node) {
		if(node == null) return;
		
		postorderPrint(node.leftChild);
		postorderPrint(node.rightChild);
		System.out.print(node.number + " ");
	}
}
