package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Definition for an interval.
class Interval1 {
	int start;
	int end;

	Interval1() {
		start = 0;
		end = 0;
	}

	Interval1(int s, int e) {
		start = s;
		end = e;
	}
}
public class interval2 {
	
	
	
	public static void main(String args[]) {
		ArrayList<Interval1> intervals = new ArrayList<Interval1>();
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
		//[ (4, 100), (48, 94), (16, 21), (58, 71), (36, 53), (49, 68), (18, 42), (37, 90), (68, 75), (6, 57), (25, 78), (58, 79), (18, 29), (69, 94), (5, 31), (10, 87), (21, 35), (1, 32), (7, 24), (17, 85), (30, 95), (5, 63), (1, 17), (67, 100), (53, 55), (30, 63), (7, 76), (33, 51), (62, 68), (78, 83), (12, 24), (31, 73), (64, 74), (33, 40), (51, 63), (17, 31), (14, 29), (9, 15), (39, 70), (13, 67), (27, 100), (10, 71), (18, 47), (48, 79), (70, 73), (44, 59), (68, 78), (24, 67), (32, 70), (29, 94), (45, 90), (10, 76), (12, 28), (31, 78), (9, 44), (29, 83), (21, 35), (46, 93), (66, 83), (21, 72), (29, 37), (6, 11), (56, 87), (10, 26), (11, 12), (15, 88), (3, 13), (56, 70), (40, 73), (25, 62), (63, 73), (47, 74), (8, 36) ]
		intervals.add(new Interval1(4, 100));
		intervals.add(new Interval1(48, 94));
		intervals.add(new Interval1(16, 21));
		intervals.add(new Interval1(58, 71));
		intervals.add(new Interval1(36, 53));
		intervals.add(new Interval1(49, 68));
		intervals.add(new Interval1(18, 42));
		intervals.add(new Interval1(37, 90));
		intervals.add(new Interval1(68, 75));
		intervals.add(new Interval1(1, 94));
		/*intervals.add(new Interval1(58, 71));
		intervals.add(new Interval1(58, 71));*/
		
	//	intervals.add(new Interval1(58, 71));
		
		
		interval2 inte = new interval2();
		inte.merge(intervals);

	}
	
    public ArrayList<Interval1> merge(ArrayList<Interval1> intervals) {
    	
    	
    intervals =	sort(intervals);
    	
    	if(intervals.size() == 0)
    		return intervals;
    	
    	ArrayList<Interval1> res = new ArrayList<Interval1>();
    	
    	Interval1 a = intervals.get(0);
    	
    	for(int i=1;i<intervals.size();i++)
    	{
    		// ae I-------I I------------------I
    		if(a.start<intervals.get(i).start && a.end<intervals.get(i).end && a.end<intervals.get(i).start )
    		{
    			res.add(a);
    			a = intervals.get(i);
    		}
    		// a I-------------I
    		// e    I--------------I
    		if(a.start < intervals.get(i).start && a.end>intervals.get(i).start && a.end<intervals.get(i).end)
    		{
    			a.end = intervals.get(i).end;
    		}
    		//a       I------------------I
    		//e   I-------------------------------I
    		if(a.start>intervals.get(i).start && a.end<intervals.get(i).end)
    		{
    			a.start = intervals.get(i).start;
    			a.end = intervals.get(i).end;
    		}
    		
    		//a      I------------------I
    		//e         I---------I
    		if(a.start<intervals.get(i).start && a.end>intervals.get(i).end)
    		{
    			//do nothing a remains a;
    			a =a;
    		}
    		
    	}
    	
    	res.add(a);
    	
    	
		return res;

    }

	private ArrayList<Interval1> sort(ArrayList<Interval1> intervals) {
		
		Comparator<Interval1> c = new Comparator<Interval1>() {

			@Override
			public int compare(Interval1 arg0, Interval1 arg1) {
				if(arg0.start<arg1.start && arg0.end<arg1.end)
				return -1;
				
				if(arg0.start==arg1.start)
				{
					if(arg0.end<arg1.end)
						return -1;
					else
					return	1;
				}
				
				if(arg0.start>arg1.start)
					return 1;
				
				return -1;
			}
		};
		
			Collections.sort(intervals, c);
		return intervals;
	}
}
