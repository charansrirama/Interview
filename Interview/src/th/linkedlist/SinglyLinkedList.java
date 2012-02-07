package th.linkedlist;

public class SinglyLinkedList {

    private Node head;
    private int listCount;

    public SinglyLinkedList() {
	head = new Node(null);
	// head = null;
	listCount = 0;
    }

    public void add(Object data) {
	Node temp = new Node(data);
	Node current = head;
	while (current.getNext() != null) {
	    current = current.getNext();
	}
	current.setNext(temp);
	listCount++;

    }

    public void add(Object data, int index) {
	Node temp = new Node(data);
	Node current = head.getNext();
	for (int i = 0; i < index && current.getNext() != null; i++) {
	    current = current.getNext();
	}
	temp.setNext(current.getNext());
	current.setNext(temp);
	listCount++;
    }

    public Object get(int index) {
	if (index <= 0) {
	    return null;
	}
	Node current = head.getNext();
	for (int i = 1; i < index; i++) {
	    if (current.getNext() == null) {
		return null;
	    }
	    current = current.getNext();
	}
	return current.getData();

    }

    public boolean remove(int index) {
	if (index < 1 || index > size()) {
	    return false;
	}
	Node current = head;
	for (int i = 1; i < index; i++) {
	    if (current.getNext() == null)
		return false;
	    current = current.getNext();
	}
	current.setNext(current.getNext().getNext());
	listCount--;
	return true;
    }

    public int size() {
	return listCount;
    }

    public String toString() {
	Node current = head.getNext();
	String output = "";
	while (current != null) {
	    output += "[" + current.getData().toString() + "]";
	    current = current.getNext();
	}
	return output;
    }

    public void reverse() {
	Node current, next, loop;
	if (head.next == null) {
	    System.out.println("OOPS");
	    return;
	}

	current = head.next;
	next = current.next;
	loop = null;

	while (next != null) {
	    current.next = loop;
	    loop = current;
	    current = next;
	    next = next.next;
	}

	head.next = current;
	head.next.next = loop;
    }

    public Node findNthLastNode(int N) {
	int i = 0;
	Node current, behind;
	current = head.next;
	for (i = 1; i < N; i++) {
	    if (current.next != null) {
		current = current.next;
	    } else
		return null;
	}
	behind = head.next;
	while (current.next != null) {
	    current = current.next;
	    behind = behind.next;
	}
	return behind;
    }

    public boolean detectLoop(Node node) {
	if(head.next == null) {
	    return true;
	}
	Node slow = head.next;
	Node fast = head.next;
	
	while(slow != null && fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    
	    if(slow == fast) {
		return true;
	    }
	}
	
	return false;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	SinglyLinkedList test = new SinglyLinkedList();
	test.add(23);
	test.add(333);
	test.add("test");
	test.add(222222);
	test.add(909090);
	test.add(4312333);
	test.add(13123123);
	System.out.println(test.toString());
	System.out.println(test.findNthLastNode(1).data);
	System.out.println(test.get(2));
	// System.out.println(test.head.getNext().data);
	// test.reverse();
	// System.out.println("After reverse: " + test.toString());
    }

    private class Node {
	Object data;
	Node next;

	public Node(Object _data) {
	    next = null;
	    data = _data;
	}

	public Node(Object _data, Node _next) {
	    next = _next;
	    data = _data;
	}

	public Object getData() {
	    return data;
	}

	public void setData(Object _data) {
	    data = _data;
	}

	public Node getNext() {
	    return next;
	}

	public void setNext(Node _next) {
	    next = _next;
	}
    }
}
