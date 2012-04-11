package th.hard;

public class Permutation {

	public static void swap(char[] array, int i, int j) {
		char temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void perm(char[] list, int k, int m) {
		int i;
		if(k > m) {
			for(i = 0; i <= m; i++) {
				System.out.print(list[i]);
			}
			System.out.println();
		} else {
			for(i = k; i <= m; i++) {
				swap(list, k, i);
				perm(list, k+1, m);
				swap(list, k, i);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] list = new char[]{'a', 'b', 'c'};
		perm(list, 0, 2);
	}

}
