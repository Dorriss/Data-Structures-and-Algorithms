package arrays;

public class BuySellStocksProblem {
	
	public static void main(String args[])
	{
		int[] input ={100, 180};//, 260, 310, 40, 535, 695,896,30,70};
		
		
		int amount = getmax(input);
		System.out.println(amount);
		
	}

	private static int getmax(int[] input) {
		
		int n = input.length;
		int[] res = new int[n];
		int j=-1;
		int i=0;
		while(i< n)
		{
			while(i<n-1 && input[i+1]<input[i] )
			{
				i++;
			}
			/*if(i==n-1)
			{
				System.out.println("no solution");
			    return 0;
			}*/
			
			
			System.out.println("buy at index " + i + "price" + input[i]);
			j=j+1;
			res[j]=input[i];
			
			
			
			while(i<n-1 && input[i+1]>input[i]){
				i++;
				
			}
			
				System.out.println("sell at index i" + (i)+ "price" + input[i]);
				j=j+1;
				res[j]=input[i];
				
				
				i++;
			
			
		}
		
		/*if(j%2 == 0)
			j=j-1;*/
		int profit =0;
		
		for(int k=0;k<j;k++)
		{
			profit = profit + res[k+1]-res[k];
			k++;
		}
			
		return profit;
	}

}
