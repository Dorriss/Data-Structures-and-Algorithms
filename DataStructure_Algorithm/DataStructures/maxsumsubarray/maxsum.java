package maxsumsubarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class maxsum {
	static int N = 10;
	static int[] a = {-1,-2,3,4,-5,6};
	
	/*public int calMaxSum()
	{
		int max= Integer.MIN_VALUE;
		int max_curr = Integer.MIN_VALUE;
		int result = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++)
		{
			if(max_curr)
		}
		
		
		
		return result;
		
	}*/
	
//	public static void main(String args[])
//	{
//		List<Integer> lst = new ArrayList<Integer>();
//		lst.add(-1);lst.add(-2);lst.add(3);lst.add(4);lst.add(-5);lst.add(6);
//		maxSubArray(lst);
//	}
	
	
	public static void main(String args[])
	{
		Scanner scin = new Scanner(System.in);
		int N  = scin.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			a.add(scin.nextInt());
		}
		
		System.out.println(maxSubArray(a));
		
	}

	public static int maxSubArray(final List<Integer> A) {
	     int sum = A.get(0);
	    int ans = A.get(0);
	    for(int i=0;i<A.size();i++)
	    {
	    	if(A.get(i)<0)
	    	{
	    	  ans =	Math.max(ans,A.get(i));
	    	  if(i==A.size()-1)
	    	  return ans;
	    	}
	    	else
	    	break;	
	    }
	    ans=sum=0;
	    for(int i =0;i<A.size();i++)
	    {
	    	if(sum+A.get(i)>=0)
	    		sum = sum+A.get(i);
	    	else
	    		sum=0;
	    	
	    	ans = Math.max(sum, ans);
	    }
	    
	    
	    return ans;
	}
	
	
}
