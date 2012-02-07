package th.sort;

import th.Heap.Heap;

/**
 * shijinliang
 * Feb 5, 2012
 * Interview
 **/
public class PriorityQueue {

    public int Maximum(Heap heap) {
	return heap.data[1];
    }
    
    public int extractMax(Heap heap) {
	if(heap.data.length < 1) {
	    System.out.println("Queue underflow.");
	    return -1;
	}
	int max = heap.data[1];
	heap.data[1] = heap.data[heap.heapsize];
	heap.setHeapsize(heap.heapsize-1);
	heap.maxHeapify(1);
	return max;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] input = new int[] {16,14,10,8,7,9,3,2,4,1};
	PriorityQueue pq = new PriorityQueue();
	Heap heap = new Heap(input);
	heap.buildMaxHeap();
	System.out.println(pq.extractMax(heap));
	
    }

}
