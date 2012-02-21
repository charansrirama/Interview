package th.pattern.strategy;
/**
 * shijinliang
 * Feb 20, 2012
 * Interview
 **/
public class Quack implements QuackBehavior {

    @Override
    public void quack() {
	System.out.println("Quack!");
    }

}
