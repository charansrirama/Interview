package th.DP;
/**
 * shijinliang
 * Mar 11, 2012
 * Interview
 **/
public class RobCutting {
    
    public static void robCutting(int revenue[], int length) {
	int r[] = new int[length+1];
	int s[] = new int[length+1];
	
	r[0] = 0;
	
	for(int j = 1; j < length+1; j++) {
	    int q = Integer.MIN_VALUE;
	    for(int i = 1; i <= j; i++) {
		if(q < revenue[i] + r[j-i]) {
		    q = revenue[i] + r[j-i];
		    s[j] = i;
		}
	    }
	    r[j] = q;
	}
	
	printArray(s);
	printSolution(s, 7);
    }
    
    public static void printSolution(int s[], int length) {
	while(length > 0) {
	    System.out.print(s[length] + " ");
	    length = length-s[length];
	}
	System.out.println();
    }
    
    public static void printArray(int array[]) {
	for(int i = 0; i < array.length; i++)
	    System.out.print(array[i] + " ");
	System.out.println();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	int revenue[] = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
	robCutting(revenue, 10);
    }

}
