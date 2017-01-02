package arrays;

import java.util.ArrayList;
import java.util.List;

public class kthsmallest {
	
	
		// DO NOT MODIFY THE LIST. IT IS READ ONLY
		public static int kthsmallestvalyue(final List<Integer> a, int k) {
		    int count=0;
		    int i=0;
		    for(i=0;i<a.size()-1;i++)
		    {
		        for(int j=i+1;j<a.size();j++)
		         {
		             if(a.get(j)<=a.get(i))
		             count++;
		             
		         }
		         if(count == k-1)
		         break;
		         else if(count< k-1)
		          k--;
		         count=0;
		         
		    }
		    return a.get(i);
		}
	public static void main(String args[])
	{
		List<Integer> a = new ArrayList<Integer>();
		a.add(8);a.add(16);a.add(80);a.add(55);a.add(32);a.add(8);a.add(38);a.add(40);
		System.out.println(kthsmallestvalyue(a, 3) );
		
	}


}
