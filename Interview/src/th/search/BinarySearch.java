package th.search;

public class BinarySearch {
	public static int binarySearch(int[] input, int target){
		int low = 0;
		int high = input.length - 1;
		while(low <= high){
			int middle = (low + high)/2;
			if(target == input[middle]){
				while(target == input[middle])
					middle--;
				return (middle + 1) ;
			}else{
				if(target < input[middle]){
					high = middle - 1;
				}else{
					low = middle + 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] input = new int[]{1,2,3,3,3,5,6,7,8,9,11,12,13,144,1111};
		System.out.println("---Binary Search---");
		long st = System.nanoTime();
		System.out.println("Positoin: " + binarySearch(input, 3));
		long et = System.nanoTime();
		System.out.println("Total time is: " + (et - st) + "ns");
	}
}
