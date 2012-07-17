package amazon;

import java.util.ArrayList;

// AC 
public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		intervals = sort(intervals);
		ArrayList<Interval> result = new ArrayList<Interval>();
		if(intervals.size() <= 0) {
			return result;
		}
		Interval inte = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++) {
			Interval tmp = intervals.get(i);
			if(tmp.start <= inte.end) {
				inte.end = Math.max(tmp.end, inte.end);
			} else {
				result.add(inte);
				inte = tmp;
			}
		}
		result.add(inte);
		return result;
	}
	
	public ArrayList<Interval> sort(ArrayList<Interval> intervals) {
		Interval[] array = new Interval[intervals.size()];
		int count = 0;
		for(Interval i : intervals){
			array[count++] = i;
		}
		mergesort(array, 0, array.length);
		ArrayList<Interval> sorted = new ArrayList<Interval>();
		for(Interval i : array) {
			sorted.add(i);
		}
		return sorted;
	}
	
	public void merge(Interval[] array, int low, int mid, int high) {
		Interval[] tmp = new Interval[high-low];
		int copied = 0, copied1 = low, copied2 = mid;
		while(copied1<mid&&copied2<high) {
			if(array[copied1].start < array[copied2].start){
				tmp[copied++] = array[copied1++];
			} else {
				tmp[copied++] = array[copied2++];
			}
		}
		while(copied1<mid) tmp[copied++] = array[copied1++];
		while(copied2<high)tmp[copied++] = array[copied2++];
		for(int i = low; i < high; i++) {
			array[i] = tmp[i-low];
		}
	}
	
	public void mergesort(Interval[] array, int low, int high) {
		if(low >= high-1) return;
		int mid = (low+high)/2;
		mergesort(array, low, mid);
		mergesort(array, mid, high);
		merge(array, low, mid, high);
	}
	
	public static void main(String[] args) {
		ArrayList<Interval> test = new ArrayList<Interval>();
		test.add(new Interval(1, 5));
		test.add(new Interval(2, 4));
		test.add(new Interval(6, 9));
		test.add(new Interval(3, 7));
		test.add(new Interval(2, 9));
		MergeIntervals te = new MergeIntervals();
		test = te.merge(test);
		for(Interval i: test) {
			System.out.println("[" + i.start + ", " + i.end + "]");
		}
	}
}
