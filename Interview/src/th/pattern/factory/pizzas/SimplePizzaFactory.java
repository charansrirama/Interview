package th.pattern.factory.pizzas;
/**
 * shijinliang
 * Feb 23, 2012
 * Interview
 **/
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
	Pizza pizza = null;

	if (type.equals("cheese")) {
	    pizza = new CheesePizza();
	} else if (type.equals("pepperoni")) {
	    pizza = new PepperoniPizza();
	} else if (type.equals("clam")) {
	    pizza = new ClamPizza();
	} else if (type.equals("veggie")) {
	    pizza = new VeggiePizza();
	}
	return pizza;
    }
}
