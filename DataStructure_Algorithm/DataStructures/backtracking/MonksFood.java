package backtracking;

import java.util.Scanner;
/**
 * 
 * @author I072842
 * 
 * 
 * Eat Or Not?
Our friend Monk has decided to go on a diet in order to improve his Eating Habits. One of his friends told him that Monk should eat a fixed amount of Vitamins, Carbs, Fats and Proteins daily in order to loose weight. Monk wants to strictly follow this regime.

There are 
N
N fruits kept in Monk's Fridge. Each fruit contains a fixed amount of Vitamins, Carbs, Fats and Proteins. Now, Monk wants to know if upon selecting any subset of fruits from the fridge, the sum of their Vitamins, Carbs, Fats and Proteins is individually equal to their corresponding equivalent amount that Monk desires to eat. For example, if Monk selects Fruits 
i
i, 
j
j and 
k
k, then the sum of the vitamins of these 
3
3 fruits should be equal to the amount of vitamins Monk wants to eat and so on for Carbs, Fats and Protiens as well.

If there exists such a subset to satisfy Monk's demands, print "YES"(without quotes), else print "NO"(without quotes).

Input Format:

The First line contains 
4
4 space separated integers denoting the amount of Vitamins, Carbs, Fats and Protiens that Monk desires to eat. The next line contains a single integer 
N
N denoting the number of Fruits in Monk's Fridge. Each of the next 
N
N lines contains 
4
4 space separated integers, where the 
i
t
h
ith line denotes the number of VItamins, Carbs, Fats and Proteins in the
i
t
h
ith fruit.

Output Format:

Print the required answer on a single line
V[i],C[i],F[i],P[i] denote the number of VItamins, Carbs,Fats and Proteins in the 
i
t
h
ith fruit respectively .

Sample Input(Plaintext Link)
100 100 100 100
4
50 50 50 50
50 50 50 50
50 50 50 50
50 50 50 50
Sample Output(Plaintext Link)
YES
Explanation
Here, selecting any two pairs of fruits shall lead to satisfaction of Monk's demands.
 *
 */

public class MonksFood {

	 public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running
	         * Use either of these methods for input

	        //BufferedReader
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
    */
	        //Scanner
	        Scanner s = new Scanner(System.in);
	        int[] monkreq = new int[4];
	        

	        for (int i = 0; i < 4; i++) {
	           monkreq[i] =  s.nextInt();
	        }
	        
	        int N = s.nextInt();
	        int[][] fruits = new int[N][4];
	       
	        for (int j = 0; j < N; j++) {
	        for (int i = 0; i < 4; i++) {
	        	fruits[j][i] =  s.nextInt();
		        }
	        }
	    
	      boolean res =  find(monkreq,fruits,0);

	      if(res == true)
	        System.out.println("YES");
	      else
	    	  System.out.println("NO");
	    	  
	    }
	

	private static boolean find(int[] monkreq, int[][] fruits, int i) {
		

		if(check0(monkreq) == true)
		{
			//System.out.println("Yes");
			return true;
		}
		
		if(i == fruits.length)
			return false;
		
		int[] tempreq = new int[4];
		
		//select ith row and check for rest intake left
		for (int k = 0; k < 4; k++) {
			tempreq[k] =  monkreq[k] - fruits[i][k];
	        }
		
		if(find(tempreq,fruits,i+1) == true)
			return true;
		
		//dont select ith row and check rest intake
		
		if(find(monkreq,fruits,i+1) == true)
			return true;
		
		return false;
	
	}

	private static boolean check0(int[] monkreq) {
		for (int i = 0; i < 4; i++) {
	           if(monkreq[i] !=0)
	        	   return false;
	        }
		return true;
	}
}
     
