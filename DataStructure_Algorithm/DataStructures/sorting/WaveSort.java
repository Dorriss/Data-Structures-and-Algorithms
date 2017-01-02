package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class WaveSort {

	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {
		
		String result = "";
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			
			if(a.get(i) ==0)
				count++;
		}
		
		if(count == a.size())
			return result+'0';

		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				ArrayList<Integer> n1 = new ArrayList<Integer>();
				ArrayList<Integer> n2 = new ArrayList<Integer>();
				int temp=0;

				while (o1 / 10 != 0) {
					n1.add(0, o1 % 10);
					o1 = o1 / 10;
				}
				n1.add(0,o1);
				while (o2 / 10 != 0) {
					n2.add(0, o2 % 10);
					o2 = o2 / 10;
				}
				n2.add(0,o2);
				if (n1.size() == n2.size()) {
					int i=0;
					while(i<n1.size())
					{
					if (n1.get(i) >n2.get(i))
						return 1;
					else if(n1.get(i) <n2.get(i))
						return -1;
					else
						i++;
					}
					return 0;
				}

				
				else {
					boolean bool = false;
					int n = Math.min(n1.size(),n2.size());
					while (n > 0) {
						if (n1.get(0) > n2.get(0))
							return 1;
						if (n1.get(0) < n2.get(0))
							return -1;
						if (n1.get(0) == n2.get(0)) {
							temp = n1.get(0);
							n1.remove(0);
							n2.remove(0);
							n--;

						}
					}
					if(n1.size() == 0 && n2.get(0)<=temp)
						return 1;
					if(n1.size() == 0 && n2.get(0)>temp)
						return -1;
					
					if(n2.size() == 0 && n1.get(0)<= temp)
						return -1;
					if(n2.size() == 0 && n1.get(0) >temp)
						return 1;
					
				}

				return 0;
			}
		};

		Collections.sort(a, c);
		
		for (Iterator iterator = a.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			  result = integer + result ;
			
		}

		System.out.println(result);
		return result;
	}

	public ArrayList<ArrayList<Integer>> generate(int a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> res = new ArrayList<>();
		res.add(1);
		result.add(res);
		if (a == 0) {
			return result;
		}
		res.add(1);
		if (a == 1) {
			result.add(res);
			return result;
		}

		while (res.size() < a) {

			ArrayList<Integer> temp = null;
			temp = new ArrayList<Integer>();
			temp.add(1);
			for (int i = 1; i < res.size(); i++) {

				temp.add(res.get(i - 1) + res.get(i));

				// res.add(a+1-i,temp.get(a+i)+temp.get(a+1-i));
			}
			temp.add(1);
			res = temp;

			result.add(res);

		}

		return result;

	}

	public ArrayList<Integer> getRow(int a) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(1);
		if (a == 0)
			return res;
		res.add(1);
		if (a == 1)
			return res;

		while (res.size() < a) {

			ArrayList<Integer> temp = null;
			temp = new ArrayList<Integer>();
			temp.add(1);
			for (int i = 1; i < res.size(); i++) {

				temp.add(res.get(i - 1) + res.get(i));

				// res.add(a+1-i,temp.get(a+i)+temp.get(a+1-i));
			}
			temp.add(1);
			res = temp;

		}

		return res;

	}

	public ArrayList<Integer> flip(String A) {

		int[] in = new int[A.length()];
		int sum = 0;
		int left = 0, right = 0, x = 0;

		ArrayList<Integer> a = new ArrayList<Integer>();

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '1')
				sum = sum + 1;

			in[i] = A.charAt(i) == '1' ? -1 : 1;
		}

		if (sum == A.length())
			return a;

		int lefttemp = 0, y = 0;

		for (int j = 0; j < in.length; j++) {

			if (y + in[j] >= 0) {
				y = y + in[j];
			} else {
				lefttemp = j + 1;
				y = 0;

			}

			if (y > x) {
				left = lefttemp;
				right = j;
				x = y;
			}

		}

		a.add(left + 1);
		a.add(right + 1);

		return a;

	}

	public static void main(String args[]) {

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(3);
		a1.add(30);
		a1.add(34);
		a1.add(5);
		a1.add(9);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		/*a2.add(12);
		a2.add(121);*/
		
		a2.add(9);
		a2.add(99);
		a2.add(98);
		

		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(a1);
		a.add(a2);

		WaveSort sol = new WaveSort();
		// sol.setZeroes(a);
		//sol.getRow(3);
		
		sol.largestNumber(a2);

	}

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {

		int row = a.size();
		int col = a.get(0).size();

		int[] rows = new int[row];
		int[] cols = new int[col];

		for (int k = 0; k < row; k++) {
			rows[k] = 1;
		}
		for (int k = 0; k < col; k++) {
			cols[k] = 1;
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (a.get(i).get(j) == 0) {
					rows[i] = 0;
					cols[j] = 0;
				}
			}
		}

		for (int i = 0; i < row; i++) {
			if (rows[i] == 0)
				a.set(i, setrow0(a.get(i).size()));

		}
		for (int i = 0; i < col; i++) {
			if (cols[i] == 0) {
				for (int j = 0; j < row; j++) {
					a.get(j).set(i, 0);
				}
			}
		}

	}

	private ArrayList<Integer> setrow0(int i) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int j = 0; j < i; j++)
			a.add(0);

		return a;
	}

	private ArrayList<ArrayList<Integer>> resetcolrow(
			ArrayList<ArrayList<Integer>> a, int i, int j) {

		for (int k = j + 1; k < a.get(i).size(); k++) {
			if (a.get(i).get(k) == 1)
				a.get(i).set(k, 0);
			if (a.get(i).get(k) == 0)
				a = resetcolrow(a, i, k);

		}

		for (int k = i + 1; k < a.size(); k++) {
			if (a.get(k).get(j) == 1)
				a.get(k).set(j, 0);
			if (a.get(k).get(j) == 0)
				a = resetcolrow(a, k, j);

		}

		return a;

	}

	public ArrayList<Integer> wave(ArrayList<Integer> a) {

		Collections.sort(a);
		for (int i = 0; i < a.size() - 1; i = i + 2) {
			int temp = a.get(i);
			a.set(i, a.get(i + 1));
			a.set(i + 1, temp);

		}

		return a;

	}
}
