package th.pocket.gems;

public class LNode {
	int val;
	LNode next;
	
	public LNode(int v) {
		this.val = v;
		next = null;
	}
	
	public String toString() {
		if(next == null) return val +"";
		else 
			return val + " " + next;
	}
}