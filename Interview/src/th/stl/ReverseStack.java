package th.stl;

import java.util.Stack;

public class ReverseStack {
	public static void main(String[] args){
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
//		while(!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		
		for(int i=1;i<stack.size();i++){
			Object obj = reverseStack(stack,i,0);
			stack.push(obj);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	public static Object reverseStack(Stack stack, int toBeReversed, int current){
		Object obj = stack.pop();
		if(current == toBeReversed){
			return obj;
		}else{
			Object obj2 = reverseStack(stack, toBeReversed, current+1);
			stack.push(obj);
			return obj2;
		}
	}
}
