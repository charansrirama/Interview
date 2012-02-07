package th.Backtracking;
/**
 * shijinliang
 * Feb 5, 2012
 * Interview
 **/
public class SumOfSub {
    
    private int w[];
    private int m;
    private int x[];
    
    public SumOfSub(int w[], int m, int n) {
	this.w = w;
	this.m = m;
	this.x = new int[n];
    }
    
    public void computeSumOfSub(int s, int k, int r) {
	x[k] = 1;
	if(s+w[k] == m) {
	    printResult(k);
	    System.out.println("*****************");
	} else if(s+w[k]+w[k+1]<=m) {
	    computeSumOfSub(s+w[k],k+1,r-w[k]);
	} 
	if(s+r-w[k]>=m && s+w[k+1]<=m) {
	    x[k] = 0;
	    computeSumOfSub(s,k+1,r-w[k]);
	}
    }
    
    public void printResult(int k) {
	for(int i = 0; i <= k; i++) {
	    if(x[i] == 1) {
		System.out.println(w[i]);
	    }
	}
    }
                 
    /**
     * @param args
     */
    public static void main(String[] args) {
	int w[] = new int[] {7,11,13,24};
	SumOfSub test = new SumOfSub(w,31,4);
	int r = 0;
	for(int i = 0; i < 4; i++)
	    r += w[i];
	
	test.computeSumOfSub(0, 0, r);
    }

}
