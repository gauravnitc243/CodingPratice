package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class MergeOverlappingIntervals {
	public class Interval
	  {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }

	public static void main(String[] args) {
		MergeOverlappingIntervals tt = new MergeOverlappingIntervals();
		tt.sendRequest();

	}
	
	public void sendRequest()
	{
		MergeOverlappingIntervals t = new MergeOverlappingIntervals();
		Interval a = new Interval(1,10);
		Interval b = new Interval(2,9);
		Interval c = new Interval(3,8);
		Interval d = new Interval(4,7);
		Interval e = new Interval(5,6);
		Interval f = new Interval(6,6);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(a);
		intervals.add(b);
		intervals.add(c);
		intervals.add(d);
		intervals.add(e);
		intervals.add(f);
		ArrayList<Interval> res = t.merge(intervals);
		for(Interval tem : res)
		{
			System.out.println(tem.start+" "+tem.end);
		}
	}
  
	  
  public ArrayList<Interval> merge(ArrayList<Interval> intervals)
  {
		if (intervals == null || intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, new IntervalSorter());
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++)
		{
			Interval curr = intervals.get(i);
			if (prev.end >= curr.start) 
			{
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			}
			else
			{
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		return result;
}
  class IntervalSorter implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
  }
}
