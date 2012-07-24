package th.c.TreeProblem;

public class GetHeight {
	public int getHeight(Node node) {
		if(node == null) return 0;
		else 
			return Math.max(getHeight(node.left), getHeight(node.right))+1;
	}
}
