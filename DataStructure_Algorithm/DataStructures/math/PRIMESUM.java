package math;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PRIMESUM {

	 public ArrayList<Integer> primesum(int a) {
	        
	        HashSet<Integer> primes =  new HashSet<Integer>();
	        for(int i=2;i<=a;i++)
	        {
	            primes.add(i);
	        }
	        for (int i = 0; i < primes.size() && i<= Math.sqrt(a); i++) {
				for(int j=2;i*j<a;j++)
				{
					primes.remove(i*j);
				}
			}
	        
	        ArrayList<Integer> result = new ArrayList<>();
	        for (int i = 0; i <primes.size();) {
				if(primes.contains(a-i))
				{
					result.add(i);
					result.add(a-i);
					return result;
				}
				else
					i++;
			}
	        return result;
	    }
}
