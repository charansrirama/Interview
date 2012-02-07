package th.stl;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * shijinliang Feb 6, 2012 Interview
 **/
public class Queue<E> {

    private int head = 0;
    private int tail = 0;
    private Object[] objs;
    private int capacityIncrement;

    public boolean isEmpty() {
	return head == tail;
    }

    public synchronized void enqueue(E item) {
	objs[tail] = item;
	if (tail == objs.length - 1)
	    tail = 0;
	else
	    tail++;
	if (tail == head) {
	    int oldLength = objs.length;
	    ensureCapacityHelper(objs.length + 1);
	    for (int i = tail; i < oldLength; i++) {
		objs[i + objs.length - oldLength] = objs[i];
	    }
	    head += objs.length - oldLength;
	}
    }

    public synchronized E dequeue() {
	if (isEmpty())
	    throw new NoSuchElementException();
	Object obj = objs[head];
	if (head == objs.length - 1)
	    head = 0;
	else
	    head++;
	return (E) obj;
    }

    private void ensureCapacityHelper(int minCapacity) {
	int oldCapacity = objs.length;
	if (minCapacity > oldCapacity) {
	    int newCapacity = (capacityIncrement > 0) ? (oldCapacity + capacityIncrement)
		    : (oldCapacity * 2);
	    if (newCapacity < minCapacity) {
		newCapacity = minCapacity;
	    }

	    objs = Arrays.copyOf(objs, newCapacity);
	}
    }

    public Queue() {
	this(10);
    }

    public Queue(int initialCapacity) {
	this(initialCapacity, 0);
    }

    public Queue(int initialCapacity, int capacityIncrement) {
	objs = new Object[initialCapacity];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	Queue<Integer> queue = new Queue<Integer>();
	for (int i = 0; i < 8; i++)
	    queue.enqueue(i);
	for (int i = 0; i < 4; i++)
	    System.out.print(queue.dequeue() + " ");

	for (int i = 0; i < 9; i++)
	    queue.enqueue(i + 10);

	while (!queue.isEmpty())
	    System.out.print(queue.dequeue() + " ");
    }

}
