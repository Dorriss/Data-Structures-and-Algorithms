package math;
import java.util.ArrayList;

public class REARRANGEARRAY {
	
	//Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
public void arrange(ArrayList<Integer> a) {
	    for(int i=0;i<a.size();i++)
	    {
	    	a.set(i, a.get(a.get(i)));
	    }
	}
}
