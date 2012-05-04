package th.facebook.tree;

public class PathSum {

	public int depth(Node node) {
		if(node == null) return 0;
		return Math.max(depth(node.leftChild), depth(node.rightChild))+1;
	}
	
	public void print(int[] A, int start, int end) {
		for(int i = start; i <= end; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public void findSum(Node node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	public void findSum(Node node, int sum, int[] path, int level) {
		if(node == null) return;
		path[level] = node.number;
		int t = 0; 
		for(int i = level; i >= 0; i--) {
			t+= path[i];
			if(t == sum) {
				print(path, i, level);
			}
		}
		
		findSum(node.leftChild, sum, path, level+1);
		findSum(node.rightChild, sum, path, level+1);
		path[level] = Integer.MIN_VALUE;
	}
}
