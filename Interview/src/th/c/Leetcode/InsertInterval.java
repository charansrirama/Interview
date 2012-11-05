package th.c.Leetcode;

import java.util.*;

public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> results = new ArrayList<Interval>();
		for(int i = 0; i < intervals.size(); i++) {
			Interval tmp = intervals.get(i);
			if(tmp.start > newInterval.end) {
				results.add(newInterval);
				results.add(tmp);
				for(i = i+1; i < intervals.size(); i++) {
					results.add(intervals.get(i));
				}
				return results;
			} else if(tmp.end < newInterval.start) {
				results.add(tmp);
			} else {
				newInterval.start = Math.min(newInterval.start, tmp.start);
				newInterval.end = Math.max(newInterval.end, tmp.end);
			}
		}
		results.add(newInterval);
		return results;
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