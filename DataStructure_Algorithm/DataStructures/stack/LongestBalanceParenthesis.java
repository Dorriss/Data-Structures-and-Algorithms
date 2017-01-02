package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author I072842
 * 
 * Longest Parentheses Substring
You are given a string containing characters '(' and ')'. Print the length of longest valid parentheses substring.

Example:
Longest valid parentheses substring for "(()" is "()" which has length 2.
Longest valid parentheses substring for ")()())" is "()()" which has length 4.

Input:
The only line of input consists of a string containing parentheses.

Output:
Print the length of longest valid parentheses substring.

Sample Input(Plaintext Link)
(((()))))
Sample Output(Plaintext Link)
8
 *
 */

public class LongestBalanceParenthesis {

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

		Stack<Integer> st = new Stack<>();
		st.push(-1);

	//	int i = 0;
		int maxlength = 0;
	//	int currlength = 0;
		for(int i=0;i<N.length();i++) {
			if (N.charAt(i) == '(') {
				st.push(i);
				
			}
			if (N.charAt(i) == ')') {
				
				int k = st.pop();
				
				if(!st.isEmpty())
				{
					maxlength = Math.max(maxlength, i-st.peek());
				}
				else
					st.push(i);
				
			}

		}

		System.out.println(maxlength);
	}

}
