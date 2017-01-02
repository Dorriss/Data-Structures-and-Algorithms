package graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EdgesTurnOn implements Comparator<Integer>{

	public static HashMap<Integer, HashSet<Integer>> ab = new HashMap<Integer, HashSet<Integer>>();

	public static void main(String args[]) {
		Scanner scin = new Scanner(System.in);

		int n = scin.nextInt();
		for (int i = 0; i < n; i++) {
			HashSet<Integer> tmp1 = new HashSet<>();
			HashSet<Integer> tmp2 = new HashSet<>();
			int n1 = scin.nextInt();
			int n2 = scin.nextInt();
			if (ab.get(n1) != null) {
				tmp1 = ab.get(n1);
			}
			tmp1.add(n2);
			ab.put(n1, tmp1);

			if (ab.get(n2) != null) {
				tmp2 = ab.get(n2);
			}
			tmp2.add(n1);
			ab.put(n2, tmp2);

		}

		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> en : ab.entrySet()) {
			pq.offer(en.getKey());
		}
     // Collections.sort(pq,cmp);
		minset(pq);
	}

	
	  
	/*public static  Comparator<Integer> cmp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (ab.get(o1).size() >  ab.get(o2).size())
					return -1;
				else if (ab.get(o1).size() <  ab.get(o2).size())
				  return 1;
				  else			  
					return 0;
			}
		};
	 */

	public static void minset(PriorityQueue<Integer> pq) {
		// List<Integer> res =new ArrayList<Integer>();
		while (pq.isEmpty() != true) {
			int a = pq.poll();
			// res.add(a);
			System.out.println(a);
			HashSet<Integer> hs = new HashSet<Integer>();
			hs = ab.get(a);
			Iterator itr = hs.iterator();
			while (itr.hasNext()) {
				pq.remove(itr.next());
			}

		}
	}


	@Override
	public int compare(Integer o1, Integer o2) {
		if (ab.get(o1).size() >  ab.get(o2).size())
			return -1;
		else if (ab.get(o1).size() <  ab.get(o2).size())
		  return 1;
		  else			  
			return 0;
	}

}
