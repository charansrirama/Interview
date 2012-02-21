package th.pattern.strategy;
/**
 * shijinliang
 * Feb 20, 2012
 * Interview
 **/
public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
	System.out.println("Squeak!");
    }

}
