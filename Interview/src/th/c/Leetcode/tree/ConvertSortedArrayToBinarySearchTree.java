package th.c.Leetcode.tree;

// AC
public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] num) {
		return helper(num, 0, num.length-1);
    }
	
	public TreeNode helper(int[] num, int low, int end) {
		if(low > end) return null;
		if(low == end) {
			return new TreeNode(num[low]);
		} else {
			int mid = (low+end)/2;
			TreeNode root = new TreeNode(num[mid]);
			root.left = helper(num, low, mid-1);
			root.right = helper(num, mid+1, end);
			return root;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
