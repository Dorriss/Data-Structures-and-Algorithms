package math;

import java.util.Scanner;

public class fibchanged {
	
	static int A = 0;
	static int B = 0;
	

	/*public static void main(String[] args) {
		int N = 0;
		int count =0;
        Scanner scin = new Scanner(System.in);
        while(scin.hasNext() && count<3)
        {
        	if(count==0)
        		{
        		A = scin.nextInt();
        		count++;
        		}
        	if(count==1)
    		{
    		B = scin.nextInt();
    		count++;
    		}
        	if(count==2)
    		{
    		N = scin.nextInt();
    		count++;
    		}
        }
        scin.close();
        double n =fibmod(N);
       
        System.out.println(n);
        
        
    }
	*/
	
	public static double fibmod(int N)
    {
		if(N==1)
			return A ;
		if(N==2)
			return B;
		else
		{
			
			return ( Math.pow(fibmod(N-1),2) + fibmod(N-2));
		}
		
    
}
}
