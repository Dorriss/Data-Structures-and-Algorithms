package lruImplementation;

public class Solution {

	public static void main(String args[])
	{
	LRUCache lc = new LRUCache(5);
	lc.set(1, 2);
	lc.set(2, 4);
	lc.set(3, 6);
	lc.set(4,8);
	lc.set(5, 10);
	System.out.println(lc.get(1)+" "+lc.get(2)+" "+ lc.get(4) +" "+lc.get(3)+" "+lc.get(5));
	lc.set(6, 12);
	System.out.println(lc.get(3));
	System.out.println(lc.get(6));
	System.out.println(lc.get(4));
	System.out.println(lc.get(1));
	}	
	
}
