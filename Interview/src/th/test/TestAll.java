package th.test;

import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * shijinliang
 * Nov 15, 2011
 * Interview
 **/
public class TestAll {
    public static Test suite() {
	TestSuite suite = new TestSuite("Testsuit suit");
	suite.addTestSuite(HelloCalculatorCase.class);
	return suite;
    }
}
