package th.tree2;

public class FindMaxSubtree {
	public static int maxSum = Integer.MIN_VALUE;
	public static Node maxTree = null;
	
	public static int find(Node node) {
		if(node == null) {
			return 0;
		}
		
		int l = find(node.leftChild);
		int r = find(node.rightChild);
		int sum = l + r + node.number;
		if(sum > maxSum) {
			maxTree = node;
			maxSum = sum;
		}
		return sum;
	}
}
