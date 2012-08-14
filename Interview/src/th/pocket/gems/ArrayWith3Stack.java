package th.pocket.gems;

public class ArrayWith3Stack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test Array1
		Array1 test1 = new Array1();
		test1.push(0, 3);
		test1.push(1, 3);
		test1.push(2, 3);
		System.out.println(test1);
		System.out.println(test1.isEmpty(0));
		test1.pop(0);
		test1.pop(1);
		test1.pop(2);
		System.out.println(test1);
		System.out.println(test1.isEmpty(1));
	}

}

class Array2 {
	private final int SIZE = 10;
	private int[] stackPointer = {-1,-1,-1};
	int indexUsed = 0;
	StackNode[] buffer = new StackNode[SIZE*3];
	
	public void push(int stackNum, int value) {
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;
		indexUsed++;
		buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value);
	}
	
	public int pop(int stackNum) {
		int value = buffer[stackPointer[stackNum]].value;
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = buffer[stackPointer[stackNum]].previous;
		buffer[lastIndex] = null;
		indexUsed--;
		return value;
	}
	
	public int peek(int stackNum) {
		return buffer[stackPointer[stackNum]].value;
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}
}

class StackNode {
	public int previous;
	public int value;
	
	public StackNode(int p, int v) {
		this.previous = p;
		this.value = v;
	}
}

class Array1 {
	private final int SIZE = 10;
	private int[] data = new int[SIZE*3];
	private int[] tops = {-1,-1,-1};
	
	public void push(int stackNum, int item) {
		if(tops[stackNum] == SIZE) {
			return;
		}
		tops[stackNum]++;
		data[tops[stackNum] + SIZE*stackNum] = item;
	}
	
	public int pop(int stackNum) {
		if(tops[stackNum] == -1) return -1;
		int element = data[tops[stackNum] + SIZE*stackNum];
		data[tops[stackNum] + SIZE*stackNum] = 0;
		tops[stackNum]--;
		return element;
	}
	
	public boolean isEmpty(int stackNum) {
		if(tops[stackNum] == -1) 
			return true;
		else
			return false;
	}
	
	public String toString() {
		String result = new String();
		for(int i = 0; i < data.length; i++) {
			result += data[i] + " "; 
		}
		return result;
	}
}
