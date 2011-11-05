package th.array;

public class MaxConsecutiveSequence {

	public static int[] maxConsecutiveSequence(int input[]) {
		int [] result = new int[input.length];
		
		if(input.length < 2)
			result[0] = input[0];
		
		
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0; i < input.length; i++) {
			if(input[i] > maxValue)
				maxValue = input[i];
		}
		
		boolean markers[] = new boolean[maxValue+1];
		for(int i = 0; i < input.length; i++) {
			markers[input[i]] = true;
		}
		markers[maxValue] = false;
		
		int start = 0, end = 0;
		int maxSequenceStart = 0, maxSequenceEnd = 0;
		boolean inSeq = false;
		int j = 0;
		while(j < markers.length) {
			if(markers[j]) {
				if (!inSeq){
					start = j;
				}
				end++;
				inSeq = true;
			} else {
				if(end > maxSequenceEnd) {
					maxSequenceEnd = end;
					maxSequenceStart = start;
				}
				end = 0;
				inSeq = false;
			}
			j++;
		}
		int k = 0;
		for(int i = maxSequenceStart; i <= maxSequenceStart+maxSequenceEnd; i++) {
			result[k++] = i;
		}
		return result;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {1,6,10,4,7,9,5};
		for(int a : maxConsecutiveSequence(input)) 
			System.out.println(a);
	}

}
