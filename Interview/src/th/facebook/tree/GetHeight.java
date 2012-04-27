package th.facebook.tree;

public class GetHeight {

	public static int getHeight(Node root) {
		if(root == null) return 0;
		else {
			return Math.max(getHeight(root.leftChild), getHeight(root.rightChild))+1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
