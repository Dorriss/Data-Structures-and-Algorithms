package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MAXP3 {
	
	
	public static void main(String args[])
	{
		ArrayList a = new ArrayList<>();
		//[ 0, -1, 3, 100, -70, -50 ]
		
	//int[] arr = {74, -100, -28, -11, -40, 55, 22, -71, 59, 54, -61, 40, 0, -96, -48, 68, -10, 19, 2, -90, 85, -7, -41 };
//	int[] arr = {0, -1, 3, 100, -70, -50 };
		int[] arr = {0,00, 0, -0 };
	for(int i=0;i<arr.length;i++)
	{
		a.add(arr[i]);
	}
		/*a.add(1);
		a.add(2);
		a.add(-3);*/
		/*a.add(-4);
		a.add(-5);
		a.add(-6);*/
		
		/*a.add(0);
		a.add(-1);
		a.add(3);
		a.add(100);
		a.add(70);
		a.add(50);*/
		System.out.println(maxp3(a));
		
		
		}
	
	public static int maxp3(ArrayList<Integer> a) {
		
		
		if(a.size() <= 3)
		{
			List newa = new ArrayList<>();
			newa = a;
			return multiply(newa);
		}
		
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1.intValue())> Math.abs(o2.intValue()))
					return -1;
				else if(Math.abs(o1.intValue())< Math.abs(o2.intValue()))
					return 1;
				else
					return 0;
					
				
			}
		};
		
		Collections.sort(a, c);
		List<Integer> a1 = new ArrayList<>();
		List<Integer> a2 = new ArrayList<>();
		int i=0;
		boolean posadded = false;
		while(i<a.size())
		{
			if(a.get(i)<0 && a2.size()<2)
				a2.add(a.get(i));
			if(a.get(i)>0 && a1.size()<3)
				a1.add(a.get(i));
			i++;
			
			
			/*
			
			if(a1.size()==3 && a2.size() < 3)
			  return multiply(a1);
			if(a.get(i)> 0)
			{
				if(a1.size()<3)
				a1.add(a.get(i));
				if(posadded == false)
				{
					a2.add(a.get(i));
					posadded = true;
				}
					
			}
			else if(a.get(i)<0)
			{
				if(a2.size()< 3 && posadded == true)
				a2.add(a.get(i));
				if(posadded == false && a2.size()<=2)
					a2.add(a.get(i));
					
				
			}
			i++;
			
		*/}
		
		if(a1.size() == 0 && a2.size() > 0 && a.size()>3)
		{
			return multiply(a.subList(a.size()-3, a.size()));
		}
		a2.add(a1.get(0));
		return Math.max(multiply(a1), multiply(a2));
		
    }

	private static int multiply(List<Integer> a1) {
		if(a1.size()==0)
			return 0;
		int mul = a1.get(0);
		for(int i=1;i<a1.size();i++)
			mul=mul*a1.get(i);
		return mul;
	}
}
