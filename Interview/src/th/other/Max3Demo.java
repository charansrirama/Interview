package th.other;

import java.io.*;

/**
 * shijinliang
 * Dec 5, 2011
 * Interview
 **/
public class Max3Demo {
    static int inp = 0;
    static boolean loop = true;
    /**
     * @param args
     */
    public static void main(String[] args) {
	int max1 = 0, max2 = 0, max3 = 0;
	int sum= 0, ctr = 0;
	
	while(loop) {
	    System.out.println("Enter number:");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try {
		inp = Integer.parseInt(br.readLine());
		
	    } catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    if(inp >= max1) {
		int temp1 = max1;
		int temp2 = max2;
		max1 = inp;
		max2 = temp1;
		max3 = temp2;
	    } else if(max1 > inp && inp >= max2) {
		int temp;
		temp = max2;
		max2 = inp;
		max3 = temp;
	    } else if(max2 > inp && inp >= max3)
		max3 = inp;
	    sum = sum + inp;
	    ctr++;
	    if(inp == 0) loop = false;   
	}
	System.out.println(max1+", "+max2+", "+max3);
        System.out.println("sum: "+ (sum-(max1+max2+max3)));
        System.out.println("ctr: "+ (ctr-4));
        System.out.println("Avrage: "+ (sum-(max1+max2+max3))/(ctr-4));
    }

}
