package th.pattern.strategy;
/**
 * shijinliang
 * Feb 20, 2012
 * Interview
 **/
public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
	System.out.println("<<Silence>>");
    }

}
