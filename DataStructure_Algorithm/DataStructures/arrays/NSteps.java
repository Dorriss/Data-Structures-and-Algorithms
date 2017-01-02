package arrays;
import java.util.Scanner;

public class NSteps {
	
	public static void main(String args[])
	{
		Scanner scin = new Scanner(System.in);
		int j = scin.nextInt();
		int n = scin.nextInt();
		
		int[] dp = new int[n+1];
		
		dp[0]=0;
		dp[1]=1;
		dp[j]=1;
		
		for(int i=2;i<=n;i++)
		{
			int ans=0;
			if(i-1>=0)
				ans +=dp[i-1];
			if(i-j>=0)
				ans += dp[i-j];
			
			dp[i] += ans;
				
		}
		
		System.out.println(dp[n]);
		
		
	}

}
