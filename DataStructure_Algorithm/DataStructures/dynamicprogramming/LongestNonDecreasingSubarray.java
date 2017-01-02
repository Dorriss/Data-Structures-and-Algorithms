package dynamicprogramming;


/**
 * Longest Non-Decreasing Subarray
Given an array of Integers A , find the length of Longest sub-array whose elements are in Non-Decreasing Order.

Input:
First line of input contains N size of array A. Next line contains N space separated elements of array.

Output:
Print the length of longest sub-array whose elements are in increasing order .

Sample Input(Plaintext Link)
4
9 1 2 2
Sample Output(Plaintext Link)
3
 */


import java.util.Scanner;

public class LongestNonDecreasingSubarray {
	
	 public static void main(String args[] ) throws Exception {
	       
	        Scanner scin = new Scanner(System.in);
	        int N= scin.nextInt();
	        
	        int[] inp = new int[N];
	
	        for(int i=0;i<N;i++)
	        {
	        	inp[i] =scin.nextInt();
	        }
	       int res =  findLNDS(inp);

	        System.out.println(res);
	    }

	private static int findLNDS(int[] inp) {
		
		int[] temp = new int[inp.length];
		 for(int i=1;i<temp.length;i++){
     		 temp[i] =1;
  }
		   
		   for(int i=1;i<inp.length;i++)
		   {

				   if(inp[i-1]<= inp[i])
				   temp[i] = temp[i-1]+1;


			   
		   }
		   int max = temp[0];
		   
		   for(int i=1;i<temp.length;i++){
	          		  max = Math.max(max, temp[i]); 
		   }
		   
		   return max;
		   
 		
	}
}
