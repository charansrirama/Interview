package th.pattern.factory.calculator;

public class Add extends Operation {

	@Override
	public double getResult() {
		double result = 0;
		result = getNumberA() + getNumberB();
		return result;
	}

}
