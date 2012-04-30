package th.facebook.tree;

public class LargestSubtree {
	public static Node largestBSTSubtree(Node root) {
		Node node = null;
		int maxNodes = Integer.MIN_VALUE;
		int min = 0;
		int max = 0;
		helper(root, min, max, maxNodes, node);
		return node;
	}
	private static int helper(Node node, int min, int max, int maxNodes, Node largestNode) {
		if(node == null) return 0;
		boolean isBST = false;
		int leftNodes = helper(node.leftChild, min, max, maxNodes, largestNode);
		int currMin = (leftNodes==0)? node.number:min;
		if(leftNodes == -1 || (leftNodes!= 0 && node.number <= max))
			isBST = false;
		
		int rightNodes = helper(node.rightChild, min, max, maxNodes, largestNode);
		int currMax = (rightNodes == 0)?node.number:max;
		if(rightNodes == -1 || (rightNodes != 0 && node.number >= min))
			isBST = false;
		
		if(isBST) {
			min = currMin;
			max = currMax;
			int totalNodes = leftNodes + rightNodes +1;
			if(totalNodes > maxNodes) {
				maxNodes = totalNodes;
				largestNode = node;
			}
			return 
					totalNodes;
		} else 
			return -1;
	}
}
