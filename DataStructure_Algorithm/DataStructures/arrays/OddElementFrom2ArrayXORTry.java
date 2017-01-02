package arrays;
/**
 * 
 * @author I072842
 *
 *
 *         Given two arrays of length n and n-1, all elements of both the arrays
 *         are same except one. Find the odd element out, giving O (1) solution.
 *
 *
 */
public class OddElementFrom2ArrayXORTry {
	
	static void find(char[] a1,char[] b1)
	{
		int XORa=0;
		int XORb=0;
		for(int i=0;i<a1.length;i++)
		{
			XORa = XORa ^ a1[i];
		}
		for(int i=0;i<b1.length;i++)
		{
			XORb = XORb ^ b1[i];
		}
		
		int result = XORa ^ XORb;
		System.out.println((char)result);
	}
	
	public static void main(String args[])
	{
		int[] a = {1,2,3,5,6,7,4,8};
		int[] b = {1,4,5,3,2,7,6};
		
		char[] a1 ={'a','c'};
		char[] b1 ={'a','b','c'};
	//	find(a,b);
		find(a1, b1);
	}

}
