package th.bit;
/**
 * shijinliang
 * Feb 2, 2012
 * Interview
 * Write a function that determind the number of 1 bits 
 * in the compute's internal representation of a given integer.
 **/
public class NumOnesInBinary {

    public int numOnesInBinary(int number) {
	int numOnes = 0;
	while(number != 0) {
	    if((number & 1) == 1){
		numOnes++;
	    }
	    number = number >>> 1;
	}
	return numOnes;
    }
    
    // Better solution.
    public int numOnesInBinary2(int number) {
	int numOnes = 0;
	while(number != 0) {
	    number = number&(number-1);
	    numOnes++;
	}
	return numOnes;
    }
    
    public boolean twoOrNot(int number) {
	boolean result = false;
	number = number&(number-1);
	if(number == 0) result = true;
	return result;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	NumOnesInBinary test = new NumOnesInBinary();
	System.out.println(test.numOnesInBinary(10));
	System.out.println(test.numOnesInBinary2(10));
	
	System.out.println(test.twoOrNot(8));
    }

}
