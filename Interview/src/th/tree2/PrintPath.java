package th.tree2;

public class PrintPath {
	public static int path[] = new int[1000];
	
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
