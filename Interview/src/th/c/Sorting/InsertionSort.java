package th.c.Sorting;

public class InsertionSort implements Sort{

	@Override
	public void sort(int[] array) {
		if(array == null || array.length <= 1) return;
		for(int i = 1; i < array.length; i++) {
			for(int j = i; j > 0; j--) {
				if(array[j] < array[j-1]) {
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}
			}
		}
	}
}
