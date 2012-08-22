package th.pocket.gems.design;

import java.util.*;

enum Status {RUNNING, IDLE, MAINTANCE}

public class Elevator {
	private int direction; // 0 : down; 1 : up
	private List<Integer> stopList;
	private int current;
	private Status status;
	
	public Elevator() {
		direction = 1;
		stopList = new LinkedList<Integer>();
		current = 1;
		status = Status.IDLE;
	}
	
	public void push(int floor) {
		if(floor < current) {
			System.out.println("Invalid floor");
		} else {
			stopList.add(floor);
			Collections.sort(stopList);
			if(status == Status.IDLE) {
				status = Status.RUNNING;
			}
		}
	}
	
	public void stop() {
		current = stopList.remove(0);
		System.out.println("Stop at " + current);
		if(stopList.size() == 0) {
			status = Status.IDLE;
			current = 1;
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

class Scheduler {
	Elevator[] elevator;
	
	public Scheduler(int n) {
		elevator = new Elevator[n];
	}
	
	public void setMaintance(int n) {
		elevator[n].setStatus(Status.MAINTANCE);
	}
	
	public void resetMaintance(int n) {
		elevator[n].setStatus(Status.MAINTANCE);
	}
}
