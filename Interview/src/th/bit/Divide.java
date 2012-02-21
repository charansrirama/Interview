package th.bit;

/**
 * shijinliang Feb 20, 2012 Interview
 **/
public class Divide {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
//	System.out.println(divide(2147483648L, 2));
	long a[] = divide2(9, 2);
	System.out.println(a[0] + " " + a[1]);
    }

    // Division with minus
    public static long[] divide2(long dividend, long divisor) {
	long quotient[] = new long[2];
	
	if(0 == divisor) {
	    System.out.println("Divisor could not be zero!");
	    return null;
	}
	
	quotient[0] = 0;
	quotient[1] = dividend;
	while((quotient[1] - divisor) >= 0) {
	    quotient[1] -= divisor;
	    ++quotient[0];
	}
	
	return quotient;
    }
    
    // Division with bit operator
    public static long divide(long dividend, long divisor) {
	long quotient = 0;
	
	boolean sign= false;
	
	if(0 == divisor) {
	    System.out.println("Divisor could not be zero!");
	    return -1;
	}
	
	if(dividend < 0) {
	    dividend *= (-1);
	    sign = sign?false:true;
	}
	
	if(dividend < 0) {
	    dividend *= (-1);
	    sign = sign?false:true;
	}
	
	for(int i = 0; i < 64; i++) {
	    int temp = (int) (dividend >> (63-i));
	    quotient = quotient << 1;
	    if(temp >= divisor) {
		dividend -= divisor << (63-i);
		quotient += 1;
	    }
	}
	
	if(sign) {
	    quotient *= (-1);
	}
	return quotient;
    }
}
