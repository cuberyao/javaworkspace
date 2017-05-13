package test;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
/*    public static int[] findRightInterval(Interval[] intervals) {
        int[] ret = new int[intervals.length];
        for (int i = 0; i < ret.length; i++) {
        	int j = 0;
        	int dis = Integer.MAX_VALUE;
        	int idx = -1;
        	while (j < ret.length) {
        		if (j != i && intervals[i].end <= intervals[j].start) {
        			if (intervals[j].start - intervals[i].end < dis) {
        				dis = intervals[j].start - intervals[i].end;
        				idx = j;
        			}
        			
        		}
        		j++;
        	}
       		ret[i] = idx;
        }
        return ret;
    }*/
	
	public int[] findRightInterval(Interval[] intervals) {
		int len = intervals.length;
		int[] ret = new int[len];
		Interval[] tintervals = new Interval[len];
		for (int i = 0; i < len; i++) {
			tintervals[i] = new Interval(intervals[i].start, i);
		}
		Arrays.sort(tintervals, new MyComparator());
		
		for (int i = 0; i < len; i++) {
			int key = intervals[i].end;
			int high = len - 1;
			int low = 0;
			int mid = (high + low) / 2;
			int idx = -1;
			while (low <= high) {
				if (tintervals[mid].start == key) {
				    idx = tintervals[mid].end;
					break;
				} else if (tintervals[mid].start < key) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			if (idx == -1 && low < len && tintervals[low].start > key) {
				idx = low;
			}
			ret[i] = idx;
		}
		return ret;
	}
	
	class MyComparator implements Comparator<Interval> {
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	}

}
class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }