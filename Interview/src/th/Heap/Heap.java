package th.Heap;
/**
 * shijinliang
 * Feb 5, 2012
 * Interview
 **/
public class Heap {
    
    public int heapsize;
    public int[] data;
    
    public int getHeapsize() {
        return heapsize;
    }

    public void setHeapsize(int heapsize) {
        this.heapsize = heapsize;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public Heap(int[] input) {
	this.data = new int[input.length+1];
	this.data[0] = -1;
	for(int i = 0; i < input.length; i++)
	    this.data[i+1] = input[i];
	this.heapsize = input.length;
    }
    
    public int parent(int index) {
	return index/2;
    }
    
    public int left(int index) {
	return index*2;
    }
    
    public int right(int index) {
	return index*2+1;
    }
    
    public void buildMaxHeap() {
	this.heapsize = this.data.length-1;
	for(int i = this.heapsize/2; i > 0; i--) 
	    maxHeapify(i);
    }
    
    public void maxHeapify(int index) {
	int l = left(index);
	int r = right(index);
	int largest = 0;
	
	if(l <= this.heapsize && this.data[l] > this.data[index])
	    largest = l;
	else 
	    largest = index;
	if(r <= this.heapsize && this.data[r] > this.data[largest])
	    largest = r;
	if(largest != index) {
	    int temp = this.data[index];
	    this.data[index] = this.data[largest];
	    this.data[largest] = temp;
	    maxHeapify(largest);
	}
    }
    
    public void display(int[] input, String title) {
	System.out.println(title);
	
	for(int i = 1; i < input.length; i++) {
	    System.out.print(input[i] + " ");
	}
	System.out.println();
    }
    
    public static void heapSort(int[] input) {
	Heap heap = new Heap(input);
	heap.buildMaxHeap();
	int length = heap.heapsize;
	for(int i = length; i > 1; i--) {
	    heap.data[1] ^= heap.data[i];
	    heap.data[i] ^= heap.data[1];
	    heap.data[1] ^= heap.data[i];
	    heap.heapsize--;
	    heap.maxHeapify(1);
	}
	heap.display(heap.data, "HAHA");
    }
    
    public static void main(String[] args) {
	int[] input = new int[] {16,4,10,14,7,9,3,2,8,1};
	
	heapSort(input);
	
    }
}
