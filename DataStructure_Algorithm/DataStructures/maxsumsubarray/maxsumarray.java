package maxsumsubarray;

import java.util.ArrayList;
import java.util.List;

public class maxsumarray {
	
	
	public static void main(String args[])
	{
		List<Integer> lst = new ArrayList<Integer>();
		//lst.add(-1);lst.add(-2);lst.add(3);lst.add(4);lst.add(-5);lst.add(6);
		lst.add(0);lst.add(0);lst.add(-1);lst.add(0);//lst.add(-5);lst.add(6);
		maxsumarray a = new maxsumarray();
		a.maxset(lst);
	}
	
	public ArrayList<Integer> maxset(List<Integer> a) {
	    int min=0;
	    int max=0;
	    int maxsum=0;
	    int sum=0;
	    
	    
	    
	    for(int i=0;i<a.size();i++)
	    {
	       
	        if( a.get(i)>0)
	        {
	            sum =  sum + a.get(i);
	            if(sum>maxsum)
	            {
	                maxsum = sum;
	                max=i;
	            }
	            else
	            	min =i;
	        }
	        else
	        {
	         sum =0;
	         min = i+1;
	        
	        }
	    }
	 ArrayList<Integer> res = new ArrayList<Integer>();
	    for(int i=min;i<=max;i++)
	    {
	    	res.add(a.get(i));
	    }
	   return res ;
	    
	}
}
