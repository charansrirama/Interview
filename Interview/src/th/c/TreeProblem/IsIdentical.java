package th.c.TreeProblem;

public class IsIdentical {
	public boolean isIdentical(Node a, Node b) {
		if(a==null && b==null) return true;
		else if(a!=null && b!=null) {
			return (a.val == b.val)&&isIdentical(a.left, b.left)&&isIdentical(a.right, b.right);
		} else 
			return false;
	}
}
