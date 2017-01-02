package greedy;

import java.util.ArrayList;
import java.util.Arrays;


public class MeetingRoomAllotment {
	
	public static void main(String args[])
	{
	//	int M=10;
		double[] start = {9.00,10.00,11.00,11.30};//new double[M];
		double[] finish = {9.30,11.40,11.30,12.30};//new double[M];
		

		
	int n =	roomRequired(start,finish);
	System.out.println(n);
	}

	private static int roomRequired(double[] start, double[] finish) {
		
		int number =0;
		double[] sorted_finish =finish;
		ArrayList<Double> tempList = new ArrayList<Double>();
	
				Arrays.sort(sorted_finish);
		if(sorted_finish.length ==  0)
			return 0;
		if(sorted_finish.length ==  1)
			return 1;
		number =1;
		//temp[tempindex] = sorted_finish[0];
		tempList.add(sorted_finish[0]);
		for(int i=1;i<sorted_finish.length;i++)
		{

			int starttimeindex = findstart(sorted_finish[i],finish);
			boolean emptyrooomfound =false;
			for(int j=0;j<tempList.size() & !tempList.isEmpty();j++)
			{
				if(start[starttimeindex]>= tempList.get(j))
				{
					tempList.remove(j);
					//tempList.add(sorted_finish[i])
					emptyrooomfound = true;
				}
			}
			if(emptyrooomfound == false)
			{
				number = number+1;				
			}
			
			tempList.add(sorted_finish[i]);
			
		}
		 		
				
		
		
		return number;
	}

	private static int findstart(double d,double[] finish) {
		
		for(int i =0;i<finish.length;i++)
		{
			if(d == finish[i] )
			{
				return i;
			}
		}
		
		
		return -1;
	}
	
	
}
