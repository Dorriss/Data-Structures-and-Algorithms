package dynamicprogramming;

import java.util.Collections;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Stack;

public class CoinsSum {
	
	int a =3,b=5;
	CoinsSum(int a,int b)
	{
		this.a = a;
		this.b = b;
		
	}
	
	public CoinsSum() {
		
	}

	public boolean find(int N)
	{
		
		
		if(N%a == 0 && N>0)
		{   
			return true;
		}
		if(N%b == 0 && N>0)
		{
			return true;
		}
		if(N<a || N< b)
			return false;
		
		if(find(N-a) || find(N-b))
			return true;
			
		
		return false;
	}
	
	public static void main(String args[])
	{
		CoinsSum cs = new CoinsSum();
		System.out.println(cs.find(-10));
		
	}

}
