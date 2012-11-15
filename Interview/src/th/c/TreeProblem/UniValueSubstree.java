package th.c.TreeProblem;

public class UniValueSubstree {

	public boolean unival(Node node, Result re) {
		if(node == null) 
			return true;
		boolean l = unival(node.left, re);
		boolean r = unival(node.right, re);
		if(l && r && (node.left == null || node.left.val == node.val) && 
				(node.right == null || node.right.val == node.val)) {
			re.result++;
			return true;
		}
		return false;
	}
	
	public int unival(Node root) {
		Result result = new Result();
		unival(root, result);
		return result.result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Result {
	int result;
	public Result() {
		result = 0;
	}
}