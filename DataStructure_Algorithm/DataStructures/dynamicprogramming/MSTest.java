package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MSTest {
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		/* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(reader.readLine());
	        int[] a = new int[T];
	        int[] b = new int[T];
	        int[] N = new int[T];
	        for(int i=0;i<T;i++)
	            {
	              a[i] = Integer.parseInt(reader.readLine());
	               b[i] = Integer.parseInt(reader.readLine());
	            N[i] = Integer.parseInt(reader.readLine());
	        }*/
		
		int number = (int) Math.pow(2, 2);
		int[] n = new int[number]; 
		n = findtermlist(2, 1, 2);
		System.out.println(n);
	        

	}
	
	public static int[] findtermlist(int N, int a,int b)
	{
		if(N==0)
		{
			int[] n = {0};
			return n;
		}
		int number = (int) Math.pow(2, N);
		int[] n = new int[number]; 
			
		if(N==1)
		{
			
			n[0]=a;
			n[1]=b;
		}   
		
			
		else{
			int numberaux = (int) Math.pow(2,N-1);
			int[] auxn = new int[numberaux];
			auxn = findtermlist(N-1, a, b);
			int j=0;
			for(int i =0;i<numberaux;i++)
			{
				n[j]=auxn[i]+a;
				j=j+1;
				n[j]=auxn[i]+b;
				j=j+1;
				
			}
			
		}
			
		
		return n;
	}

}
