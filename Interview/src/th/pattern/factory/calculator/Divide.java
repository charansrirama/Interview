package th.pattern.factory.calculator;

public class Divide extends Operation {

	@Override
	public double getResult() {
		double result = 0;
		if(getNumberB() == 0) {
			System.out.println("Divider could not be 0.");
		} else {
			result = getNumberA()/getNumberB();
		}
		
		return result;
	}

}
