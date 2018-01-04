package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeInterval tt = new MergeInterval();
		tt.sendRequest();

	}
	
	public void sendRequest()
	{
		MergeInterval t = new MergeInterval();
		Interval a = new Interval(5735878,14055448);
/*		Interval b = new Interval(3,5);
		Interval c = new Interval(6,7);
		Interval d = new Interval(8,10);
		Interval da = new Interval(12,16);
*/		Interval e = new Interval(45639660,84793834);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(a);
		/*intervals.add(b);
		intervals.add(c);
		intervals.add(d);
		intervals.add(da);*/
		ArrayList<Interval> res = t.insert(intervals,e);
		for(Interval tem : res)
		{
			System.out.println(tem.start+" "+tem.end);
		}
	}
	
	 
	  public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	 
	
	public  ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) 
	{
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() < 1)
		{
			result.add(newInterval);
			return result;
		}
		intervals.add(newInterval);
		Collections.sort(intervals, new IntervalSorter());
		
		Interval previousInterval = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) 
		{
			Interval currentInterval = intervals.get(i);
			if (previousInterval.end >= currentInterval.start)
			{
				Interval merged = new Interval(previousInterval.start, Math.max(previousInterval.end, currentInterval.end));
				previousInterval = merged;
			} 
			else
			{
				result.add(previousInterval);
				previousInterval = currentInterval;
			}
		}
		result.add(previousInterval);
		return result;
	}

	
	class IntervalSorter implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	

}}
