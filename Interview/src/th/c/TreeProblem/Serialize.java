package th.c.TreeProblem;

public class Serialize {
	
	public void serialize(Node node) {
		if(node == null) 
			System.out.print("()");
		else {
			System.out.print("(");
			System.out.print(node.val + " ");
			serialize(node.left);
			serialize(node.right);
			System.out.print(")");
		}
	}
	
	public Node deserialize(String line) {
		int i = 0;
		while(i<line.length()) {
			char c = line.charAt(i++);
			if(c == '(') {
				if(i < line.length()) {
					c = line.charAt(i++);
					if(c == ')') return null;
					
					StringBuilder result = new StringBuilder();
					while(c!=')' && c!='(') {
						result.append(c);
						if(i < line.length()) {
							c = line.charAt(i++);
						} else 
							break;
					}
					Node newNode = new Node(Integer.parseInt(result.toString()));
					if(c == '(') {
						i--;
						newNode.left = deserialize(line.substring(i));
						newNode.right = deserialize(line.substring(i));
					} 
					if(i < line.length()) {
						c = line.charAt(i++);
						if(c != ')')
							i--;
					}
					return newNode;
				}
			}
		}
		return null;
	}
}
