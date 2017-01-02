package bugfindingproblems;

import java.util.*;

public class Array_bug {
	public static void main (String[] args) throws java.lang.Exception
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(1);//ret.add(2);ret.add(3);ret.add(4);ret.add(5);ret.add(6);ret.add(7);
		Array_bug cf = new Array_bug();
		ret = cf.rotateArray(ret,1);
		System.out.println(ret);
	}
		public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int n = A.size();
		if(B>=n)
			B = B%n;
		for (int i = 0; i < A.size(); i++) {
		    if(i+B<n)
			ret.add(A.get(i + B));
			else
			ret.add(A.get(i+B-n));
		    
		}
		return ret;
	}
}
