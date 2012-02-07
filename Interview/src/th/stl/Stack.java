package th.stl;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * shijinliang
 * Feb 6, 2012
 * Interview
 **/
public class Stack<E> {

    private int count;
    private Object[] objs;
    private int capacityIncrement;
    
    private int top() {
	return count;
    }
    
    private void ensureCapacityHelper(int minCapacity) {
	int oldCapacity = objs.length;
	if(minCapacity > oldCapacity) {
	    int newCapacity = (capacityIncrement > 0) ? (oldCapacity + capacityIncrement):(oldCapacity*2);
	    if(newCapacity <minCapacity) 
		newCapacity = minCapacity;
	    objs = Arrays.copyOf(objs, newCapacity);
	}
    }
    
    public boolean isEmpty() {
	return top() == 0;
    }
    
    public synchronized E push(E item) {
	ensureCapacityHelper(count+1);
	objs[count++] = item;
	return item;
    }
    
    public synchronized E pop() {
	if(isEmpty())
	    throw new EmptyStackException();
	else {
	    Object obj = (E) objs[count-1];
	    count--;
	    objs[count] = null;
	    return (E) obj;
	}
    }
    
    public Stack() {
	this(10);
    }
    
    public Stack(int initialCapacity) {
	this(initialCapacity, 0);
    }
    public Stack(int initialCapacity, int capacityIncrement) {
	objs = new Object[initialCapacity];
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	Stack<Integer> stack = new Stack<Integer>();
	for(int i = 0; i < 11; i++) 
	    stack.push(i);
	while(!stack.isEmpty())
	    System.out.print(stack.pop() + " ");
    }

}
