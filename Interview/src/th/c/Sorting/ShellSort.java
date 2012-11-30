package th.c.Sorting;

public class ShellSort implements Sort {

	@Override
	public void sort(int[] array) {
		if(array == null) return;
		int N = array.length;
		int h = 1;
		while(h < N/3) h = h*3+1;
		while(h >= 1) {
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h && array[j] < array[j-h]; j -= h) {
					int tmp = array[j];
					array[j] = array[j-h];
					array[j-h] = tmp;
				}
			}
			h /= 3;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {9,8,7,6,5,4,3,2,1};
		ShellSort test = new ShellSort();
		test.sort(A);
	}
}
