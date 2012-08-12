package interviewstreet.evernote;

import java.util.*;

public class TopFour {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		MinHeap heap = new MinHeap();
		int N = reader.nextInt();
		heap.add(reader.nextInt());
		heap.add(reader.nextInt());
		heap.add(reader.nextInt());
		heap.add(reader.nextInt());
		for(int i = 4; i < N; i++) {
			int num = reader.nextInt();
			if(num > heap.min()) {
				heap.removeMin();
				heap.add(num);
			}
			
		}
		
		Arrays.sort(heap.array);
		for(int i = 3; i >= 0; i--) {
			System.out.println(heap.array[i]);
		}
	}
}

class MinHeap {
	public int[] array;
	public int n = 0;
	
	public MinHeap() {
		array = new int[4];
	}
	
	public int min() {
		return array[0];
	}
	
	public int removeMin() {
		int min = array[0];
		array[0] = array[n-1];
		if(--n > 0)
			siftDown(0);
		return min;
	}
	
	public void add(int value) {
		array[n] = value;
		siftUp(n);
		n++;
	}
	
	private void siftUp(int index) {
		if(index > 0) {
			int parent = (index - 1)/2;
			if(array[parent] > array[index]) {
				swap(parent, index);
				siftUp(parent);
			}
		}
	}
	
	private void siftDown(int index) {
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;
		
		if(rightChild >= n && leftChild >= n) return;
		
		int smallestChild = array[rightChild] > array[leftChild] ? leftChild : rightChild;
		
		if(array[index] > array[smallestChild]) {
			swap(smallestChild, index);
			siftDown(smallestChild);
		}
	}
	
	private void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}


