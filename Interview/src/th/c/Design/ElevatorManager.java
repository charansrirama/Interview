package th.c.Design;

import java.util.*;

enum STATE{ MAINTENANCE, STAND, UP, DOWN};

public class ElevatorManager {
	public ArrayList<Elevator> elevators;
	
	public ElevatorManager(int num) {
		for(int i = 1; i <= num; i++) {
			Elevator e = new Elevator(STATE.STAND);
			elevators.add(e);
			e.run();
		}
	}
	
	public void addRequest(int floor, STATE dir) {
		while(true) {
			for(int i = 0; i < elevators.size(); i++) {
				Elevator e = elevators.get(i);
				if(e.currFloor == floor && e.state == STATE.STAND) {
					elevators.get(i).addFloorRequest(floor);
					elevators.get(i).setState(dir);
					return;
				} 
			}
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < elevators.size(); i++) {
				Elevator e = elevators.get(i);
				if(dir == STATE.DOWN && e.state == STATE.DOWN && e.currFloor >= floor) {
					min = e.currFloor < min ? i : min;
				} 
			}
			if(min != Integer.MAX_VALUE) {
				elevators.get(min).addFloorRequest(floor);
				return;
			}
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < elevators.size(); i++) {
				Elevator e = elevators.get(i);
				if(dir == STATE.UP && e.state == STATE.UP && e.currFloor <= floor) 
					max = e.currFloor > max ? i : max;
			}
			if(max != Integer.MIN_VALUE) {
				elevators.get(max).addFloorRequest(floor);
				return;
			}
		}
	}
}

class Elevator {
	STATE state;
	int currFloor;
	int direction; // 1 for up; 0 for down
	
	PriorityQueue<Integer> upRequest; // Small value at the top;
	PriorityQueue<Integer> downRequest; // Big value at the top;
	
	public Elevator(STATE st) {
		this.state = st;
		this.currFloor = 1;
		
		this.upRequest = new PriorityQueue<Integer>();
		this.downRequest = new PriorityQueue<Integer>();
	}

	public STATE getState() {
		return state;
	}

	public void setState(STATE state) {
		this.state = state;
	}

	public int getCurrFloor() {
		return currFloor;
	}

	public void setCurrFloor(int currFloor) {
		this.currFloor = currFloor;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void addFloorRequest(int floor) {
		if(floor > currFloor) upRequest.add(floor);
		else downRequest.add(floor);
	}
	
	// Policeman method
	public void moveToFloor(int floor) {
		this.currFloor = floor;
	}
	
	public void run() {
		int targetFloor;
		while(true) {
			while(this.state == STATE.UP || this.state == STATE.DOWN) {
				if(this.state == STATE.UP) {
					if(!upRequest.isEmpty()) {
						targetFloor = upRequest.poll();
						moveToFloor(targetFloor);
					} else if(!downRequest.isEmpty()) {
						this.state = STATE.DOWN;
					} else {
						this.state = STATE.STAND;
					}
				} else {
					if(!downRequest.isEmpty()) {
						targetFloor = downRequest.poll();
						moveToFloor(targetFloor);
					} else if(!upRequest.isEmpty()) {
						this.state = STATE.UP;
					} else {
						this.state = STATE.STAND;
					}
				}
				
			}
		}
	}
	
}
