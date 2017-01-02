package arrays;

public class MinRangeKArrays {
	
	public static void main(String args[])
	{
		MinRangeKArrays sol = new MinRangeKArrays();
		int[] a1 = {-1};
		int[] a2 ={0,9,15,23};
		int[] a3 ={1,24,25,31};
		
		sol.findMinRange(a1, a2, a3);
	}

	public void findMinRange(int[] a1,int[] a2,int[] a3)
	{
		int i=a1.length;
		int j =a2.length;
		int k = a3.length;
		int min=0,max=0,mid=0;
		int range = Integer.MAX_VALUE;
		int[] result = new int[3];
		
		while(i!=0 && j!=0 && k!=0)
		{
			if(a1[a1.length-i]<a2[a2.length-j]&& a1[a1.length-i]<a3[a3.length-k])
			{
				min = a1[a1.length-i];
				if(a2[a2.length-j]<a3[a3.length-k])
				{
					max=a3[a3.length-k];
					mid = a2[a2.length-j];
				}
				else
				{
					mid=a3[a3.length-k];
					max = a2[a2.length-j];
				}
				i--;
			}
			
			else if(a2[a2.length-j]<a1[a1.length-i]&& a2[a2.length-j]<a3[a3.length-k])
			{
				min = a2[a2.length-j];				
				if(a1[a1.length-i]<a3[a3.length-k])
				{
					max=a3[a3.length-k];
					mid = a1[a1.length-i];
				}
				else
				{
					mid=a3[a3.length-k];
					max = a1[a1.length-i];
				}
				j--;
			}
			
			else //(a3[a3.length-k]<a1[a1.length-i]&& a3[a3.length-k]<a2[a2.length-j])
			{
				min = a3[a3.length-k];
				if(a1[a1.length-i]<a2[a2.length-j])
				{
					max=a2[a2.length-j];
					mid = a1[a1.length-i];
				}
				else
				{
					mid=a2[a2.length-j];
					max = a1[a1.length-i];
				}
				k--;
			}
			
			if(max-min<range)
			{
				range = max-min;
				result[0]=min;
				result[1]=mid;
				result[2]= max;
			}
		}
		
	}
	
}
