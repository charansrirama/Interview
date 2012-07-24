package th.c.cracking;

public class BiNodeToDoublyLinkedList {
	public void concat(BiNode x, BiNode y) {
		x.node2 = y;
		y.node1 = x;
	}
	
	public BiNode getTail(BiNode node) {
		if(node == null) return null;
		while(node.node2 != null) 
			node = node.node2;
		return node;
	}
	
	public BiNode convert(BiNode root) {
		if(root == null) return null;
		BiNode part1 = convert(root.node1);
		BiNode part2 = convert(root.node2);
		
		if(part1 != null) 
			concat(getTail(part1), root);
		if(part2 != null) 
			concat(getTail(part2), root);
		return part1 == null?root:part1;
	}
}

class BiNode {
	BiNode node1;
	BiNode node2;
	
	public BiNode() {
		node1 = new BiNode();
		node2 = new BiNode();
	}
}