package th.pattern.strategy;
/**
 * shijinliang
 * Feb 20, 2012
 * Interview
 **/
public class MallardDuck extends Duck {

    public MallardDuck() {
	quackBehavior = new Quack();
	flyBehavior = new FlyWithWings();
    }
    @Override
    public void display() {
	System.out.println("I'm a real Mallard duck!");
    }

}
