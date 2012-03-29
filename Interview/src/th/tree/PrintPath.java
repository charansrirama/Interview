package th.tree;

public class PrintPath {
	private int path[];
	
	public static void printPath(Node node, int[] path, int n) {
		if(node == null) return;
		path[n++] = node.number;
		
		if(node.leftChild == null || node.rightChild == null) {
			for(int i = 0; i < n; i++)
				System.out.print(path[i] + " ");
			System.out.println();
		} else {
			printPath(node.leftChild, path, n);
			printPath(node.rightChild, path, n);
		}
	}
}
