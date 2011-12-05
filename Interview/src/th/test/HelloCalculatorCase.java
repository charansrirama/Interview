package th.test;

import org.junit.Test;

import junit.framework.TestCase;


/**
 * shijinliang
 * Nov 15, 2011
 * Interview
 **/
public class HelloCalculatorCase extends TestCase {
    private HelloCalculator test;
    
    protected void setUp() throws Exception {
	super.setUp();
	test = new HelloCalculator();
    }
    
    protected void tearDown() throws Exception {
	super.tearDown();
    }
    
    @Test
    public void testAbs() {
	assertEquals(test.abs(14), 14);
	assertEquals(test.abs(14), 14);
    }
    
    public static void main(String args[]){ 

        junit.textui.TestRunner.run(HelloCalculatorCase.class);    
    } 
}
