package interviewstreet.evernote;

import java.util.*;

public class CircularBuffer {
	
	private int capacity;
	private int size;
	private Queue<String> buffer;
	
	public CircularBuffer(int c) {
		this.capacity = c;
		this.size = 0;
		buffer = new LinkedList<String>();
	}
	
	

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capaticy) {
		this.capacity = capaticy;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Queue<String> getBuffer() {
		return buffer;
	}

	public void setBuffer(Queue<String> buffer) {
		this.buffer = buffer;
	}
	
	public void add(String[] contents) {
		for(int i = 0; i < contents.length; i++) {
			if(size < capacity) {
				buffer.offer(contents[i]);
				size++;
			} else {
				buffer.poll();
				buffer.offer(contents[i]);
			}
		}
	}
	
	public void remove(int n) {
		for(int i = 0; i < n; i++) {
			if(buffer.size() > 0) {
				buffer.poll();
				size--;
			} else {
				System.out.println("Overflow: buffer is emptied!");
				break;
			}
		}
	}
	
	public void list() {
		for(String content: buffer) {
			System.out.println(content);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String input;
		int capacity = Integer.parseInt(reader.nextLine());
		CircularBuffer cBuffer = new CircularBuffer(capacity);
		while(!(input = reader.nextLine()).equals("Q")) {
			//System.out.println("Input: " + input);
			if(input.charAt(0) == 'A') {
				int num = Integer.parseInt(input.substring(2));
				String[] in = new String[num];
				for(int i = 0; i < num; i++) {
					in[i] = reader.nextLine();
				}
				cBuffer.add(in);
			} else if(input.charAt(0) == 'R') {
				int num = Integer.parseInt(input.substring(2));
				cBuffer.remove(num);
			} else if(input.charAt(0) == 'L') {
				cBuffer.list();
			} else {
				System.out.println("Invalid input!");
			}
		}
	}
}
