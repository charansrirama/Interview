package th.leetcode;

import java.util.ArrayList;
import java.util.Iterator;

public class InsertInterval {

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> results = new ArrayList<Interval>();
		Iterator<Interval> iterator = intervals.iterator();
		while(iterator.hasNext()) {
			Interval interval = iterator.next();
			
			if(newInterval.end < interval.start) {
				results.add(newInterval);
				results.add(interval);
				while(iterator.hasNext()) {
					results.add(iterator.next());
				}
				return results;
			}
			if(newInterval.start > interval.end) {
				results.add(interval);
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		results.add(newInterval);
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}