package dynamicprogramming;
import java.util.Arrays;

public class MinPaintStrokes {
	public static void main(String args[])
	{
		int[] input = {4,5,7,2,5};
		System.out.println(funct(input));
		
		
		
		
	}

	public static int funct(int[] input)
	{
		int result=0;
		int min=0;
		int max = input.length;
		
		if(max-1==min)
			result= 1;
		if(max-1<min)
			result=0;
		
		else
		{
			
			int index = findmin(input);
			int[] leftsubarray = Arrays.copyOfRange(input, min, index);
			int[] rightsubarray = Arrays.copyOfRange(input, index+1, max);
			result = 1 + funct(leftsubarray) + funct(rightsubarray);	
			
		}	
		
		return result;
	}

	private static int findmin(int[] input) {
		int index=0;
		int element=Integer.MAX_VALUE;
		for(int i=0;i<input.length;i++)
		{
			if(input[i]<element)
			{
				element=input[i];
				index=i;
			}
			
		}
		
		return index;
		
	}

}
