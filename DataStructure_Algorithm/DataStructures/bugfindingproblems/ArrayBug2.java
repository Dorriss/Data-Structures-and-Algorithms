package bugfindingproblems;

import java.util.*;

public class ArrayBug2 {
	
	ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
                B.set(i, A.get(i));
                B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
}
	public static void main (String[] args) throws java.lang.Exception
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(5);ret.add(10);ret.add(2);ret.add(1);//ret.add(5);ret.add(6);ret.add(7);
		ArrayBug2 cf = new ArrayBug2();
		ret = cf.performOps(ret);
		System.out.println(ret);
	}

}
