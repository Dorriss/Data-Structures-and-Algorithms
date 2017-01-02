package arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationsListofIntegers {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    
	    ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
	returnList.add(new ArrayList<Integer>());
 
	for (int i = 0; i < a.size(); i++) {
		Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
		for (ArrayList<Integer> l : returnList) {
			for (int j = 0; j < l.size() + 1; j++) {
				l.add(j, a.get(i));	
				ArrayList<Integer> T = new ArrayList<Integer>(l);
				l.remove(j);
				currentSet.add(T);
			}
		}
		returnList = new ArrayList<ArrayList<Integer>>(currentSet);
	}
 
	return returnList;
	}
	
	public static void main(String args[])
	{
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		ar.add(2);
		ar.add(1);
		new PermutationsListofIntegers().permute(ar);
		
	}
}
	