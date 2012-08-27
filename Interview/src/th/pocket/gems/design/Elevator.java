package th.pocket.gems.design;

import java.util.*;

enum Status {
	RUNNING, IDLE, MAINTANCE
}

public class Elevator implements Runnable {
	private int direction; // 0 : down; 1 : up
	private static List<Integer> currRequest;
	private static List<Integer> nextRequest;
	private int current;
	private Status status;
	private int floors;
	
	Thread t;

	public Elevator(int floors) {
		direction = 1;
		currRequest = new LinkedList<Integer>();
		nextRequest = new LinkedList<Integer>();
		current = 1;
		status = Status.IDLE;
		this.floors = floors;
		t = new Thread(this, "Elevator");
	}

	public void push(int floor) {
		System.out.println("Push at " + floor);
		if (status == Status.IDLE) {
			status = Status.RUNNING;
			currRequest.add(floor);
			direction = 1;
		} else {
			if (direction == 1) {
				if (floor < current) {
					nextRequest.add(floor);
				} else {
					currRequest.add(floor);
					Collections.sort(currRequest);
				}
			} else {
				if (floor > current) {
					nextRequest.add(floor);
				} else {
					currRequest.add(floor);
					Collections.sort(currRequest);
				}
			}
		}
	}

	public void run() {
		while (true) {
			if (status == Status.RUNNING) {
				if (direction == 1) {
					for (; current <= floors; current++) {
						if (current == currRequest.get(0)) {
							System.out.println("Stop at " + current);
							currRequest.remove(0);
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (currRequest.size() == 0 && nextRequest.size() != 0) {
							direction = 0;
							currRequest.addAll(nextRequest);
							nextRequest.removeAll(nextRequest);
							break;
						} else if (currRequest.size() == 0
								&& nextRequest.size() == 0) {
							status = Status.IDLE;
							current = 0;
							break;
						}
					}
				} else if (direction == 0) {
					for (; current >= 1; current--) {
						if (current == currRequest
								.remove(currRequest.size() - 1)) {
							System.out.println("Stop at " + current);
							currRequest.remove(currRequest.size() - 1);
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if (currRequest.size() == 0 && nextRequest.size() != 0) {
							direction = 1;
							currRequest.addAll(nextRequest);
							nextRequest.removeAll(nextRequest);
							break;
						} else if (currRequest.size() == 0
								&& nextRequest.size() == 0) {
							status = Status.IDLE;
							current = 0;
							break;
						}
					}
				}
			}
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

	public static void main(String[] args) {
		System.out.println("Start...");
		Elevator elevator = new Elevator(10);
		elevator.run();
		Elevator elevator2 = new Elevator(10);
		for(int i = 0; i < 5; i++) {
			elevator2.push(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
