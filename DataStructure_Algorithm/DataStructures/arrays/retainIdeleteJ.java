package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author I072842
 *
 *Modify the Array
Given an array and two integers 
I
I and 
J
J, modify the array such that you retain 
I
I nodes, then delete 
J
J nodes. Do this till end of the array. See the sample input and output for clarity.

Input:
First line consists of comma separated values of integers.
Second line contains the value of 
I
I.
Third line contains the value of 
J
J.

Output:
SIngle line containing comma separated values of integers.

Sample Input(Plaintext Link)
1,2,3,4,5,6,10,8
3
1
Sample Output(Plaintext Link)
1,2,3,5,6,10
Explanation
We retain 1,2,3; then delete 4. Then we retain 5,6,10 and delete 8.


 */

public class retainIdeleteJ {

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running Use either of
		 * these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line);
		 */
		// Scanner
		Scanner s = new Scanner(System.in);
		String N = s.nextLine();

		String[] inp = N.split(",");

		int[] integers = new int[inp.length];

		for (int i = 0; i < inp.length; i++) {
			integers[i] = Integer.parseInt(inp[i]);

		}

		int I = s.nextInt();
		int J = s.nextInt();
		int k = 0;
		boolean found = true;
		while (found) {
			k = k + I ;
			for (int l = k; l < k + J; l++) {
				integers[l] = -1;
			}
			k = k + J;

			if (k >= integers.length)
				found = false;

		}

		String a = "";
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] != -1)
			a = a + integers[i] + ',';
		}
		
		System.out.println(a.substring(0, a.length()-1));

	}

}
