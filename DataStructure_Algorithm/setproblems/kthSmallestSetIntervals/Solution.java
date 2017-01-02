package kthSmallestSetIntervals;

import java.util.ArrayList;

class range {
	int lb;
	int ub;
}

public class Solution {

	public void getKthSmallest(int k, ArrayList<range> input) {
		// int value = 1;
		int index = 0;
		int initial = input.get(0).lb;
		/*
		 * while (true) { if (index % 2 == 0) { if (value + (input.get(index /
		 * 2).ub - input.get(index / 2).lb) >= k) {
		 * System.out.println((input.get(index / 2).ub - input.get(index /
		 * 2).lb) + k - value); return; } else value = value + (input.get(index
		 * / 2).ub - input.get(index / 2).lb); } else if (index % 2 != 0) { if
		 * (value + (input.get((index / 2) + 1).lb - input.get(index / 2).ub) >=
		 * k) { System.out.println(input.get((index / 2) + 1).lb -
		 * input.get(index / 2).ub + k - value); return; } else { value = value
		 * + (input.get((index / 2) + 1).lb - input.get(index / 2).ub);
		 * 
		 * } }
		 * 
		 * index++;
		 * 
		 * }
		 */
		boolean lb = false;
		while (index < input.size()) {


			if(lb== false)
			{
				if (k <= input.get(index).ub - initial) {
					System.out.println(k + initial - 1);
					return;
				} else {
					lb = true;
					index = index + 1;
				}

			}
			
			if (lb == true) {

				if (k <= input.get(index).lb - initial) {
					System.out.println(k + initial - 1);
					return;
				} else {
					lb = false;
				}
			}

		}
		System.out.println("number out of range");

	}
	
	Object getKthSmallestNumber(ArrayList<range> I, int k){
		int max = 0;

		for(range i: I)
			if (max< i.ub)
				max=i.ub;

		int []A=new int[max+1];
		for(range i : I){
			int x = i.lb;
			int y = i.ub;
			for(;x<=y; x++)
				A[x]++;
		}
		for(int i=0; i<=max; i++){
			if(k<=A[i])
				return i;
			k=k-A[i];
		}
		return null;
	}

	public static void main(String args[]) {
		ArrayList<range> lst = new ArrayList<>();
		range rn = new range();
		rn.lb = 5;
		rn.ub = 10;

		lst.add(rn);

		range rn1 = new range();
		rn1.lb = 8;
		rn1.ub = 10;

		lst.add(rn1);
		range rn2 = new range();
		rn2.lb = 25;
		rn2.ub = 30;

		lst.add(rn2);

		Solution sol = new Solution();
		//sol.getKthSmallest(7, lst);
		sol.getKthSmallestNumber(lst, 7);

	}

}
