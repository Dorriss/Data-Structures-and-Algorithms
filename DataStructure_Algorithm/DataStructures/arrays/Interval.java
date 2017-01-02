package arrays;

import java.util.ArrayList;

// Definition for an interval.
class Intervalrange {
	int start;
	int end;

	Intervalrange() {
		start = 0;
		end = 0;
	}

	Intervalrange(int s, int e) {
		start = s;
		end = e;
	}
}

public class Interval {

	public static void main(String args[]) {
		ArrayList<Intervalrange> intervals = new ArrayList<Intervalrange>();
		/*
		 * intervals.add(new Intervalrange(1,3)); intervals.add(new
		 * Intervalrange(6,9));
		 */

		/*intervals.add(new Intervalrange(1, 2));
		intervals.add(new Intervalrange(3, 5));
		intervals.add(new Intervalrange(6, 7));
		intervals.add(new Intervalrange(8, 10));
		intervals.add(new Intervalrange(12, 16));
		// intervals.add(new Intervalrange(1,3));
*/
		
		intervals.add(new Intervalrange(1, 2));
		intervals.add(new Intervalrange(8, 10));
		
		
		Interval inte = new Interval();
		inte.insert(intervals, new Intervalrange(3, 6));

	}

	public ArrayList<Intervalrange> insert(ArrayList<Intervalrange> intervals, Intervalrange newInterval) {
		

		ArrayList<Intervalrange> res = new ArrayList<Intervalrange>();
		int start = 0, end = 0;
		boolean t = false;
		
		if(intervals.size()==0)
		{
			intervals.add(newInterval);
			return intervals;
		}
		
		if(intervals.get(0).start>newInterval.end)
		{
		   intervals.add(0,newInterval);
		   return intervals;
		}
		
		if(intervals.get(intervals.size()-1).end<newInterval.start)
		{
			intervals.add(newInterval);
			return intervals;
		}
		
		
		for (int i = 0; i < intervals.size(); i++) {
			
			start = intervals.get(i).start;
			end = intervals.get(i).end;
			
			if(intervals.get(i).end < newInterval.start && newInterval.end<intervals.get(i+1).start )
			{
				res.add(intervals.get(i));
				res.add(i+1,newInterval);
				//intervals.add(i+1,newInterval);
				//return intervals;
				
				res.addAll(intervals.subList(i+1, intervals.size()));
				return res;
				
			}
			
			if (!(Math.max(intervals.get(i).start, newInterval.start) > Math.min(intervals.get(i).end,
					newInterval.end))) {
				t = true;
				start = Math.min(intervals.get(i).start, newInterval.start);
				end = Math.max(intervals.get(i).end, newInterval.end);

			}
			if (t == true) {
				newInterval.start = start;
				newInterval.end = end;
				t = false;
			}
			// compare res
			if (res.size() > 0) {
				if (!(Math.max(res.get(res.size() - 1).start, start) > Math.min(res.get(res.size() - 1).end, end))) {
					start = Math.min(res.get(res.size() - 1).start, start);
					end = Math.max(res.get(res.size() - 1).end, end);
					res.remove(res.get(res.size() - 1));
				}
			}
			res.add(new Intervalrange(start, end));
			
			
		}
		return res;

	}
}
