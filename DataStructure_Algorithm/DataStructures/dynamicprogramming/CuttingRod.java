package dynamicprogramming;

public class CuttingRod {

	int N = 8;
	int[] b = {1,5,8,9,10,12,17,20};
	
public void	calculateMaxBenifit()
	{
		int[] L = new int[N+1];
		int temp = 0;
		L[0] = 0;
		L[1]=b[0];
		int i=0;
		for(i=2;i<=b.length;i++)
		{
			for (int j = 1; j <=i; j++) {
				
				temp = b[j-1]+ L[i-j];
				L[i]=Math.max(temp, L[i]);
			}
		}
		System.out.println(L[N]);
	}

public static void main(String args[])
{
	CuttingRod c = new CuttingRod();
	c.calculateMaxBenifit();
	
	}
	
	
}
