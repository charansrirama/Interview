package th.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class GetMedian {
	
	private Comparator<Integer> maxHeapComparator;
	private Comparator<Integer> minHeapComparator;
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(), minHeap = new PriorityQueue<Integer>();
	
	public PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
	
	public void addNewNumber(int randomNumber) {
		if(minHeap.size() == maxHeap.size()) {
			if((minHeap.peek()!=null) && (randomNumber > minHeap.peek())) {
				maxHeap.offer(minHeap.poll());
				maxHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		} else {
			if(randomNumber < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			} else {
				minHeap.offer(randomNumber);
			}
		}
	}
	
	public double getMedian() {
		if(maxHeap.isEmpty()) {
			return 0;
		}
		
		if(maxHeap.size() == minHeap.size()) {
			return ((double) minHeap.peek() + (double) maxHeap.peek())/2;
		} else {
			return maxHeap.peek();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		GetMedian test = new GetMedian();
		for(int i = 0; i < 9; i++) {
			int k = (int)Math.random()*100;
			test.addNewNumber(k);
			System.out.println(test.getMedian());
		}
	}

}
