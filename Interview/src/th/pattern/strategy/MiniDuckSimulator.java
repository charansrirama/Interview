package th.pattern.strategy;
/**
 * shijinliang
 * Feb 20, 2012
 * Interview
 **/
public class MiniDuckSimulator {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Duck mallard = new MallardDuck();
	mallard.performQuack();
	mallard.performFly();
	
	Duck model = new ModelDuck();
	model.performFly();
	model.setFlyBehavior(new FlyRocketPowered());
	model.performFly();
    }

}
