package th.pattern.strategy;
/**
 * shijinliang
 * Feb 20, 2012
 * Interview
 **/
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
	System.out.println("I'm flying!");
    }

}
