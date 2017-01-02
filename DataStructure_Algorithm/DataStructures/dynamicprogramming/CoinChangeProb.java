package dynamicprogramming;

import java.util.ArrayList;

public class CoinChangeProb {
	
	    public int coinchange2(ArrayList<Integer> a, int b) {
	    	
	    	if(b<=0)
	    		return 0;
	        
	    	int result =0;
	    
	        for (int i = 0; i < a.size(); i++) {
	        	int val =0 ;
	        	if(a.get(i)<=b)
	        	{
	        	 val = 1+ coinchange2(a, b-a.get(i));
	        	}
	        	result = Math.max(result, val);
				
			}
			return result;
	    }
	    
 public int coinchange21(ArrayList<Integer> a, int b) {
	 
	 ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	 
	 for (int i = 0; i < a.size()+1; i++) {
		 ArrayList<Integer> t = new ArrayList<Integer>();
		 for (int j = 0; j < b+1; j++) {
			t.add(0);
			
		}
		 temp.add(t);
		
	}
	 
	 for(int i=0; i <= a.size(); i++){
        // temp[i][0] = 1;
         temp.get(i).set(0, 1);
     }
	 
	 for(int i=1; i <= a.size(); i++){
         for(int j=1; j <= b ; j++){
             if(a.get(i-1)> j){
                // temp[i][j] = temp[i-1][j];
            	 
            	 temp.get(i).set(j, temp.get(i-1).get(j));
             }
             else{
               //  temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                 
                 temp.get(i).set(j, temp.get(i).get(j-a.get(i-1))+temp.get(i-1).get(j));
             }
         }
     }
	 return temp.get(a.size()).get(b);
	 
 }
	    
	   
	   /* public int numberOfSolutions(int b, int coins[]){
	        int temp[][] = new int[a.length+1][b+1];
	        for(int i=0; i <= a.length; i++){
	            temp[i][0] = 1;
	        }
	        for(int i=1; i <= a.length; i++){
	            for(int j=1; j <= b ; j++){
	                if(coins[i-1] > j){
	                    temp[i][j] = temp[i-1][j];
	                }
	                else{
	                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
	                }
	            }
	        }
	        return temp[a.length][b];
	    }
*/
	    
	}



