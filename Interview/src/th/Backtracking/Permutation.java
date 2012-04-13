package th.Backtracking;

public class Permutation {

	public static void swap(char[] array, int i, int j) {
		char temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp;
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
	
	public static void getNextPerm(int[] list) {
		
		for(int i = list.length-2; i >= 0; i--) {
			if(list[i] < list[i+1]) {
				for(int j = list.length-1; j > i; j--) {
					if(list[j] > list[i]){
						swap(list, i, j);
						int start = i+1;
						int end = list.length-1;
						while(end >= start) {
							swap(list, start, end);
							start++; end--;
						}
					}
				}
				break;
			}
		}
		th.util.Printer.arrayPrinter(list);
	}
	
	public static boolean isOk(int[] list, int low, int high) {
		if(low < high) {
			for(int i = low; i < high; i++) {
				if(list[i] == list[high]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void permWithDuplicate(int[] list, int low, int high) {
		if(low > high) {
			th.util.Printer.arrayPrinter(list);
		} else {
			for(int i = low; i <= high; i++) {
				if(isOk(list, low, i)){
					swap(list, low, i);
					permWithDuplicate(list, low+1, high);
					swap(list, low, i);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		char[] list = new char[]{'1', '2', '3'};
//		perm(list, 0, 2);
//		
//		int[] list2 = new int[]{1,2,3};
//		getNextPerm(list2);
		
		int[] list3 = new int[]{1,1,2,3};
		permWithDuplicate(list3, 0, 3);
	}

}
