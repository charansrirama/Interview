package th.hard;

import java.util.HashSet;
import java.util.Set;

public class GetInterval {

	/*
	 * Q: giving lots of intervals [ai, bi], find a point intersect with the most 
	 * number of intervals
	 * A: 把所有ai, bi合起来排序每点保留记号标明是a还是b,2nlog(2n)(还算O(nlogn)吧),然
	 * 后从头扫描到尾,碰到a计数加一,碰到b减一,假设计数最大的点在位置k,那么要找的点 
	 * 就在k与k+1之间.
	 */
	
	public static int partition(Point[] array, int left, int right) {
		int i = left;
		int j = right;
		
		Point temp;
		double pivot = array[(left + right)/2].val;
		
		while(i <= j) {
			while(array[i].val < pivot) i++;
			while(array[j].val > pivot) j--;
			if(i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++; j--;
			}
		}
		
		return i;
	}
	
	public static void quickSort(Point[] array, int left, int right) {
		int index = partition(array, left, right);
		if(left < index-1) quickSort(array, left, index-1);
		if(index < right) quickSort(array, index, right);
	}
	
	public static void getMostInterval(Set<Interval> intervals) {
		Point[] array = new Point[intervals.size()*2];
		int i = 0;
		for(Interval interval: intervals) {
			array[i++] = new Point(interval.getA(), 'A');
			array[i++] = new Point(interval.getB(), 'B');
		}
		
		quickSort(array, 0, array.length-1);
		for(i = 0; i < array.length; i++) 
			System.out.print(array[i].val + " ");
		System.out.println();
		int runningScore = 0;
		int maxScore = Integer.MIN_VALUE;
		double position = 0.0;
		int temp = 0;
		for(i = 0; i < array.length; i++) {
			if(array[i].pos == 'A') runningScore++;
			else if(array[i].pos == 'B') runningScore--;
			if(runningScore > maxScore) {
				maxScore = runningScore;
				position = array[i].val;
				temp = i;
			}
		}
		
		if(temp != array.length-1) {
			temp = temp+1;
		}
		System.out.println("[" + position + " " + array[temp].val + "]");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Interval> intervals = new HashSet<Interval>();
		intervals.add(new Interval(1.1, 3.2));
		intervals.add(new Interval(2.2, 2.4));
		intervals.add(new Interval(0.3, 2.3));
		
		getMostInterval(intervals);
	}

}

class Interval {
	double a;
	double b;
	
	public Interval(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}

class Point {
	double val;
	char pos;
	
	public Point(double val, char pos) {
		this.val = val;
		this.pos = pos;
	}
}
