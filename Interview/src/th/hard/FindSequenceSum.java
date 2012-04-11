package th.hard;

public class FindSequenceSum {

	public static int[] findSequenceSum(int a[]) {
		int result[] = new int[2];
		int maxSum = 0;
		int start = 0, end = 0;
		int runningStart = 0, runningEnd = 0;
		int runningSum = 0;
		for(int i = 0; i < a.length; i++) {
			runningSum += a[i];
			runningEnd = i;
			if(maxSum < runningSum) {
				maxSum = runningSum;
				start = runningStart;
				end   = runningEnd;
			}
			
			if(runningSum < 0) {
				runningSum = 0;
				if(i != a.length-1) {
					runningStart = i+1;
					runningEnd = i+1;
				}
			}
		}
		result[0] = start;
		result[1] = end;
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[]{2,3,-8,-1,2,4,-2,3,-9};
		int result[] = findSequenceSum(a);
		th.util.Printer.arrayPrinter(a);
		for(int i = result[0]; i <= result[1]; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		int a2[] = new int[] {1,2,3,4,5,6,7};
		th.util.Printer.arrayPrinter(a2);
		result = findSequenceSum(a2);
		for(int i = result[0]; i <= result[1]; i++) {
			System.out.print(a2[i] + " ");
		}
		System.out.println();
	}

}
