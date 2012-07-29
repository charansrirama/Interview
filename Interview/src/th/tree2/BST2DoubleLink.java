package th.tree2;

/**
 * shijinliang Feb 4, 2012 Interview
 **/
public class BST2DoubleLink {

	lNode[] nodeList = new lNode[1000];

	int size = 0;

	public void inorderTravel(Node node) {
		if (node != null) {
			inorderTravel(node.leftChild);
			nodeList[size++].data = node.number;
			inorderTravel(node.rightChild);
		}
	}

	public void b2d(Node node) {
		inorderTravel(node);
		nodeList[0].previous = null;
		nodeList[0].next = nodeList[1];
		for (int i = 1; i < size - 1; i++) {
			nodeList[i].previous = nodeList[i - 1];
			nodeList[i].next = nodeList[i + 1];
		}
		nodeList[size - 1].next = null;
		nodeList[size - 1].previous = nodeList[size - 2];

		printList(nodeList);
	}

	public void printList(lNode[] nodeList) {
		for (int i = 0; i < nodeList.length; i++) {
			System.out.println(nodeList[i].data);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST BST = new BST();
		BST.insert(10);
		BST.insert(3);
		BST.insert(1);
		BST.insert(111);
		BST.insert(4);
		BST.insert(11);
		BST.insert(1111);
		BST.insert(11222);

		BST2DoubleLink test = new BST2DoubleLink();
		test.b2d(BST.root);
	}
}

class lNode {
	int data;
	lNode previous;
	lNode next;

	lNode() {
		this.data = 0;
		previous = null;
		next = null;
	}

	lNode(int data) {
		this.data = data;
		previous = null;
		next = null;
	}
}
