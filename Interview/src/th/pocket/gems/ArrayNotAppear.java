package th.pocket.gems;

public class ArrayNotAppear {
	
	public static int[] findDiff(int[] array1, int[] array2) {
		int[] flag = new int[10];
		for(int i = 0; i < array1.length; i++) {
			flag[array1[i]]++;
		}
		for(int i = 0; i < array2.length; i++) {
			if(flag[array2[i]] > 0) 
				flag[array2[i]] = 0;
		}
		
		// result size
		int size = 0;
		for(int i = 0; i < flag.length; i++) {
			if(flag[i] > 0) {
				size += flag[i];
			}
		}
		int[] result = new int[size];
		int cur = 0;
		for(int i = 0; i < flag.length;) {
			if(flag[i] > 0) {
				result[cur++] = i;
				flag[i]--;
			} else {
				i++;
			}
		}
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = new int[] {1,4,5,3,1,6,8,7,6};
		int[] array2 = new int[] {4,7,6};
		th.util.Printer.arrayPrinter(findDiff(array1, array2));
	}

}
