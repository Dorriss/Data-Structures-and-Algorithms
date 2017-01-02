package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiffreentPairswithDiffK {
	
	
	 public static void main(String args[] ) throws Exception {
	      Scanner scin  = new Scanner(System.in);
	      int N = scin.nextInt();
	      int K = scin.nextInt();
	      
	      int[] arr = new int[N]; 
	      for (int i = 0; i < N; i++) {
			arr[i] = scin.nextInt();
			
		}
	      if(arr.length == 0)
	    	  System.out.println(0);
	      Arrays.sort(arr);
	      int res = diffPair(arr,K);
	      System.out.println(res);
	      
	    }
	
static int diffPair(int arr[],int k)
    {
        int size = arr.length;
        int i = 0, j = 1;
     int res = 0;
        while (i < size && j < size)
        {
            if (i != j && arr[j]-arr[i] == k)
            {
                res=res+1;
                i++;
                j++;
            }
            else if (arr[j] - arr[i] < k)
                j++;
            else
                i++;
        }
        return res;
    }

}
