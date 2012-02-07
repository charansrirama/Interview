package th.sort;
/**
 * shijinliang
 * Feb 5, 2012
 * Interview
 **/
public class HeapSort {
    
    public int parent(int index) {
	return index/2;
    }
    
    public int left(int index) {
	return index*2;
    }
    
    public int right(int index) {
	return index*2+1;
    }

    public void maxHeapify(int[] input, int index, int length) {
	int l = left(index);
	int r = right(index);
	int largest = 0;
	
	if(l <= length && input[l] > input[index])
	    largest = l;
	else 
	    largest = index;
	if(r <= length && input[r] > input[largest])
	    largest = r;
	if(largest != index) {
	    int temp = input[index];
	    input[index] = input[largest];
	    input[largest] = temp;
	    maxHeapify(input, largest, length);
	}
    }
    
    public void buildMaxHeap(int[] input) {
	int length = input.length-1;
	for(int i = length/2; i > 0; i--) {
	    maxHeapify(input, i, length);
	}
    }
    
    public void heapSort(int[] input) {
	int length = input.length-1;
	buildMaxHeap(input);
	for(int i = length; i > 1; i--) {
	    input[1] ^= input[i];
	    input[i] ^= input[1];
	    input[1] ^= input[i];
	    length--;
	    maxHeapify(input, 1, length);
	}
    }
    
    public void display(int[] input, String title) {
	System.out.println(title);
	
	for(int i = 1; i < input.length; i++) {
	    System.out.print(input[i] + " ");
	}
	System.out.println();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] input = new int[] {999,16,4,10,14,7,9,3,2,8,1};
	
	HeapSort testcase = new HeapSort();
	testcase.display(input, "Original one:");
	testcase.heapSort(input);
	testcase.display(input, "After:");
	
    }
    
    
}
