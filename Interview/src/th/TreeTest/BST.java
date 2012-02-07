package th.TreeTest;

/**
 * shijinliang Feb 4, 2012 Interview
 **/
public class BST {

    public Node root = null;
    Node currentNode = root;

    public boolean isEmpty() {
	if(root == null) return true;
	else return false;
    }

    public Node create(int data) {
	Node node = new Node(data);
	node.parent = null;
	node.leftChild = null;
	node.rightChild = null;
	return node;
    }

    public int size() {
	return size(root);
    }

    public int size(Node node) {
	if(node == null) {
	    return 0;
	} else 
	    return (size(node.leftChild) + 1 + size(node.rightChild));
    }

    public void insert(int data) {
	currentNode = add(root, data);
	if(isEmpty() == true && currentNode != null)
	    root = currentNode;
	currentNode = root;
    }

    Node add(Node node, int data) {
	if(node == null) {
	    node = create(data);
	    return node;
	} else if(node.data > data) {
	    if(node.leftChild != null) 
		add(node.leftChild, data);
	    else 
		node.leftChild = create(data);
	} else if(node.data < data) {
	    if(node.rightChild != null)
		add(node.rightChild, data);
	    else 
		node.rightChild = create(data);
	}
	return null;
    }

    public void find(int data) {
	if(isEmpty() == true) {
	    System.out.println("The tree is empty.");
	}
	find(root, data);
	
	System.out.println("Search returned Node: " + currentNode.data);
	System.out.println("Node's left child: "    + currentNode.leftChild);
	System.out.println("Node's right child: "   + currentNode.rightChild);
    }

    Node find(Node currentNode, int data) {
	if(currentNode.data == data) 
	    return currentNode;
	else if(currentNode.data > data) 
	    return find(currentNode.leftChild, data);
	else if(currentNode.data < data) 
	    return find(currentNode.rightChild, data);
	else {
	    System.out.println("Wrong input.");
	    return null;
	}
	
    }

    public Node getRoot() {
	return this.root;
    }

    public void display() {
	display(root);
    }

    private void display(Node node) {
	if(node == null) return;
	
	display(node.leftChild);
	System.out.println(node.data);
	display(node.rightChild);
    }

    public static boolean isBST(Node node) {
	if(null == node) 
	    return false;
	else if(node.leftChild == null && node.rightChild == null)
	    return true;
	else if(node.leftChild != null && node.rightChild == null) {
	    if(node.leftChild.data > node.data)
		return false;
	    else 
		return isBST(node.leftChild);
	} else if(node.rightChild != null && node.leftChild == null) {
	    if(node.rightChild.data < node.data)
		return false;
	    else 
		return isBST(node.rightChild);
	} else {
	    if(node.leftChild.data > node.data || node.rightChild.data < node.data)
		return false;
	    else 
		return isBST(node.leftChild) && isBST(node.rightChild);
	}
    }

    public void delete(int data) {
	root = delete(root, data);
    }

    private Node delete(Node node, int data) {
	if(null == node) return null;
	if(data < node.data)
	    node.leftChild = delete(node.leftChild, data);
	else if(data > node.data)
	    node.rightChild = delete(node.rightChild, data);
	else if(node.leftChild != null && node.rightChild != null) {
	    node.data = minValue(node.rightChild);
	    node.rightChild = removeMin(node.rightChild);
	} else 
	    node = (node.leftChild != null) ? node.leftChild : node.rightChild;
	return node;
    }

    private Node removeMin(Node node) {
	if(node == null) return null;
	else if(node.leftChild != null) {
	    node.leftChild = removeMin(node.leftChild);
	    return node;
	} else 
	    return node.rightChild;
    }

    public int maxDepth() {
	return maxDepth(root);
    }
    
    private int maxDepth(Node node) {
	int lDepth, rDepth;
	if(null == null) return 0;
	lDepth = maxDepth(node.leftChild);
	rDepth = maxDepth(node.rightChild);
	return (lDepth > rDepth ? lDepth : rDepth) + 1;
    }
    
    public int minValue() {
	return minValue(root);
    }

    private int minValue(Node node) {
	if(node == null) return 0;
	Node current = node;
	while(current.leftChild != null) 
	    current = current.leftChild;
	return current.data;
    }

    public void inorderWalk() {
	inorderWalk(root);
    }

    private void inorderWalk(Node node) {
	if(node != null) {
	    inorderWalk(node.leftChild);
	    System.out.println(node.data);
	    inorderWalk(node.rightChild);
	}
    }

    public void preorderWalk() {
	preorderWalk(root);
    }

    private void preorderWalk(Node node) {
	if(node != null) {
	    System.out.println(node.data);
	    preorderWalk(node.leftChild);
	    preorderWalk(node.rightChild);
	}
    }

    public void postorderWalk() {
	postorderWalk(root);
    }

    private void postorderWalk(Node node) {
	if(node != null) {
	    postorderWalk(node.leftChild);
	    postorderWalk(node.rightChild);
	    System.out.println(node.data);
	}
    }
    
    public boolean hasPathSum(int sum) {
	return hasPathSum(root, sum);
    }
    
    private boolean hasPathSum(Node node, int sum) {
	if(node == null) 
	    return sum == 0;
	else {
	    int subSum = sum - node.data;
	    return hasPathSum(node.leftChild, subSum)
	    		||hasPathSum(node.rightChild, subSum);
	}
    }
    
    public void printPaths() {
	int[] path = new int[1000];
	printPaths(root, path, 0);
    }
    
    private void printPaths(Node node, int[] path, int pathLen) {
	if(node == null) return;
	path[pathLen] = node.data;
	pathLen++;
	
	if(node.leftChild == null && node.rightChild == null)
	    printArray(path, pathLen);
	else {
	    printPaths(node.leftChild, path, pathLen);
	    printPaths(node.rightChild, path, pathLen);
	}
    }
    
    private void printArray(int[] ints, int len) {
	for(int i = 0; i < ints.length; i++) {
	    System.out.print(ints[i] + " ");
	}
	System.out.println();
    }
    
    public void mirror() {
	mirror(root);
    }
    
    private void mirror(Node node) {
	if(node != null) {
	    mirror(node.leftChild);
	    mirror(node.rightChild);
	    
	    Node temp = node.leftChild;
	    node.leftChild = node.rightChild;
	    node.rightChild = temp;
	}
    }
    
    public void doubleTree() {
	doubleTree(root);
    }
    
    private void doubleTree(Node node) {
	Node oldLeft;
	if(node == null) return;
	
	doubleTree(node.leftChild);
	doubleTree(node.rightChild);
	
	oldLeft = node.leftChild;
	node.leftChild = new Node(node.data);
	node.leftChild.leftChild = oldLeft;
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
	
	BST.inorderWalk();
	BST.postorderWalk();
    }

}

class Node {
    int data;
    Node parent;
    Node leftChild;
    Node rightChild;

    Node() {
	this.data = 0;
	leftChild = null;
	rightChild = null;
    }

    Node(int data) {
	this.data = data;
	leftChild = null;
	rightChild = null;
    }
}