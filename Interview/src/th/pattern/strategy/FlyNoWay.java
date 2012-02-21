package th.pattern.strategy;
/**
 * shijinliang
 * Feb 20, 2012
 * Interview
 **/
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
	System.out.println("I can't fly!");
    }

}
