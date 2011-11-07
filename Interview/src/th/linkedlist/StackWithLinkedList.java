package th.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackWithLinkedList<Item> implements Iterable<Item> {

	private int N;
	private Node first;
	
	private class Node{
		private Item item;
		private Node next;
	}
	
	public StackWithLinkedList(){
		first = null;
		N = 0;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item item){
		Node oldFirstNode = first;
		first = new Node();
		first.item = item;
		first.next = oldFirstNode;
		N++;
	}
	
	public Item pop(){
		if (isEmpty()) throw new RuntimeException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Item peek(){
		if (isEmpty()) throw new RuntimeException("Stack underflow");
		return first.item;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		for (Item item:this) {
			s.append(item + " ");
		}
		return s.toString();
	}

	@Override
	public Iterator<Item> iterator() {
		return new LIFOIterator();
	}
	
	private class LIFOIterator implements Iterator<Item>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackWithLinkedList<String> s = new StackWithLinkedList<String>();
		s.push("string1");
		s.push("string2");
		s.push("string3");
		System.out.println(s.toString());
		s.pop();
		System.out.println(s.toString());
		System.out.println(s.peek());
	}
}
