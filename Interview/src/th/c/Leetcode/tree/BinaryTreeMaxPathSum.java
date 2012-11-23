package th.c.Leetcode.tree;

public class BinaryTreeMaxPathSum {

	public int maxContainRoot(TreeNode root, re maxSoFar) {
		if(root == null) return 0;
		int left = maxContainRoot(root.left, maxSoFar);
		int right = maxContainRoot(root.right, maxSoFar);
		int longerLeg = Math.max(left, right);
		int result = Math.max(root.val, root.val+longerLeg);
		
		int maxPath = root.val;
		maxPath = Math.max(maxPath, maxPath+left);
		maxPath = Math.max(maxPath, maxPath+right);
		maxSoFar.val = Math.max(maxPath, maxSoFar.val);
		return result;
	}
	
	public int maxPathSum(TreeNode root) {
		re maxSoFar = new re(root.val);
		maxContainRoot(root, maxSoFar);
		return maxSoFar.val;
	}
}

class re {
	int val;
	public re(int v) {
		val = v;
	}
}
