package th.Tread;

import java.util.Random;

/**
 * shijinliang
 * Feb 2, 2012
 * Interview
 **/
public class IntBuffer {
    private int index;
    private int[] buffer = new int[8];
    
    public synchronized void add(int num) {
	while(index == buffer.length - 1) {
	    try {
		wait();
	    } catch(InterruptedException e) {
	    }
	}
	
	buffer[index++] = num;
	notifyAll();
    }
    
    public synchronized int remove() {
	while( index == 0) {
	    try {
		wait();
	    } catch(InterruptedException e) {
		
	    }
	}
	
	int ret = buffer[--index];
	notifyAll();
	return ret;
    }
    
    public static void main(String[] args) {
	IntBuffer b = new IntBuffer();
	Producer p = new Producer(b);
	Consumer c = new Consumer(b);
	
	p.start();
	c.start();
    }
}

class Producer extends Thread {
    private IntBuffer buffer;
    
    public Producer(IntBuffer buffer) {
	this.buffer = buffer;
    }
    
    public void run() {
	Random r = new Random();
	while(true) {
	    int num = r.nextInt()%10;
	    buffer.add(num);
	    System.out.println("Produced "  + num);
	}
    }
}

class Consumer extends Thread {
    private IntBuffer buffer;
    
    public Consumer(IntBuffer buffer) {
	this.buffer = buffer;
    }
    
    public void run() {
	while(true) {
	    int num = buffer.remove();
	    System.out.println("Consumed " + num);
	}
    }
}