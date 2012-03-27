package th.pattern.factory.calculator;

public class CalculatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Operation op;
		op = OperationFactory.createOperate("+");
		op.setNumberA(5);
		op.setNumberB(10);
		System.out.println(op.getResult());
	}

}
