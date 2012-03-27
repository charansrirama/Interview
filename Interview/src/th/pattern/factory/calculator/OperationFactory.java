package th.pattern.factory.calculator;

public class OperationFactory {
	public static Operation createOperate(String op) {
		Operation oper = null;
		if(op == "+") {
			return new Add();
		} else if(op == "-") {
			return new Minus();
		} else if(op == "*") {
			return new Multipy();
		} else if(op == "/") {
			return new Divide();
		}
		return oper;
	}
}
