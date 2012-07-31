package amazon.leetcode;

import java.util.*;

public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		Iterator<Interval> iterator = intervals.iterator();
		while(iterator.hasNext()) {
			Interval interval = iterator.next();
			if(newInterval.end < interval.start) {
				result.add(newInterval);
				result.add(interval);
				while(iterator.hasNext()) {
					result.add(iterator.next());
				}
				return result;
			}
			
			if(interval.end < newInterval.start) {
				result.add(interval);
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		result.add(newInterval);
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
