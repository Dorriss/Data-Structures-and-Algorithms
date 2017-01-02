package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class MiceHoleProblem {

public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
       Collections.sort(a);
       Collections.sort(b);
       
       int size = a.size();
       int res =0;
       
       for(int i=0;i<size;i++)
       {
    	 res = res + Math.abs(a.get(i)-b.get(i));
       }
      
       
       return res;
    
        
    }
	
	
	
}
