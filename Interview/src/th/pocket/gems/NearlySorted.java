package th.pocket.gems;

public class NearlySorted {
	
	public static int[] nearlySort(int[] array, int k) {
		if(k > array.length) return null;
		int[] result = new int[array.length];
		MinHeap heap = new MinHeap(k);
		for(int i = 0; i < k; i++) {
			heap.add(array[i]);
		}
		int count = 0;
		for(int i = k; i < array.length; i++) {
			if(array[i] > heap.min()) {
				result[count++] = heap.removeMin();
				heap.add(array[i]);
			}
		}
		
		for(int i = 0; i < k; i++) {
			result[count++] = heap.removeMin();
		}	
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {3,4,1,2,7,5,8,6};
		array = nearlySort(array, 3);
		th.util.Printer.arrayPrinter(array);
	}

}

class MinHeap {
	public int[] array;
	public int n;
	public int size;
	
	public MinHeap(int k) {
		size = k;
		n = 0;
		array = new int[k];
	}
	
	public int min() {
		return array[0];
	}
	
	public int removeMin() {
		int min = array[0];
		array[0] = array[n-1];
//		array[n-1] = 0;
		if(--n > 0) 
			siftDown(0);
		return min;
		
	}
	
	public void add(int v) {
		array[n] = v;
		siftUp(n);
		n++;
	}
	
	public void siftUp(int index) {
		if(index > 0) {
			int parent = (index-1)/2;
			if(array[parent] > array[index]) {
				swap(parent, index);
				siftUp(parent);
			}
		}
	}
	
	public void siftDown(int index) {
		int left = 2*index+1;
		int right = 2*index+2;
		
		if(right >= n && left >= n) return;
		int small = array[right] > array[left] ? left : right;
		if(array[index] > array[small]) {
			swap(index, small);
			siftDown(small);
		}
	}
	
	public void swap(int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}