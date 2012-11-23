package th.c.company.amzn;

public class Unival {

	public int getUnival(TreeNode root) {
		Result result = new Result();
		helper(root, result);
		return result.val;
	}
	
	private boolean helper(TreeNode node, Result result) {
		if(node == null) 
			return true;
		boolean l = helper(node.left, result);
		boolean r = helper(node.right, result);
		
		if(l && r && (node.left == null || node.left.val == node.val) && (node.right == null || node.right.val == node.val)) {
			result.val++;
			return true;
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Result {
	int val;
	public Result() {
		this.val = 0;
	}
}