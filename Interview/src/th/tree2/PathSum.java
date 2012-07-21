package th.tree2;

public class PathSum {
	public static boolean hasPathSum(Node node, int sum) {
		if(node == null) return sum==0;
		else {
			int subSum = sum-node.number;
			return hasPathSum(node.leftChild, subSum) || 
					hasPathSum(node.rightChild, subSum);
		}
	}
}
