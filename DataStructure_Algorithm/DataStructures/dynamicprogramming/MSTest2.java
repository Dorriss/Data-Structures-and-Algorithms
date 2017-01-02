package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MSTest2 {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = 2;//Integer.parseInt(reader.readLine());
        int[] A = new int[T];
	        int[] B = new int[T];
        /* for(int i=0;i<T;i++)
	            {
	              A[i] = Integer.parseInt(reader.read());
	               B[i] = Integer.parseInt(reader.read());
	               
	               A[i] = 3
	               B[i] = reader.read();
         }*/
        A[0] = 3;B[0]=9;
        A[1] =17;B[1]=37;
	        
        for(int i =0;i<T;i++)
        {
        int a = (int) Math.ceil(Math.sqrt(A[i]));
        int b = (int) Math.floor(Math.sqrt(B[i]));
        
        System.out.println(b-a+1);
        		
        }
        
        
        
    }

}
