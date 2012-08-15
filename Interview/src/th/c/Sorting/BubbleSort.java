package th.c.Sorting;

public class BubbleSort implements Sort {

	@Override
	public void sort(int[] array) {
		if(array == null) return;
		if(array.length == 0) return;
		for(int i = array.length-1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(array[j] > array[i]) {
					int tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
	}
}
