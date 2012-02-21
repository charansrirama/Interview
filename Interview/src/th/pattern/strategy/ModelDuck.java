package th.pattern.strategy;
/**
 * shijinliang
 * Feb 20, 2012
 * Interview
 **/
public class ModelDuck extends Duck {

    public ModelDuck() {
	quackBehavior = new Quack();
	flyBehavior = new FlyNoWay();
    }
    @Override
    public void display() {
	System.out.println("I'm a model duck!");
    }

}
