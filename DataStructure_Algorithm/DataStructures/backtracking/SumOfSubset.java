package backtracking;

public class SumOfSubset {

	int x[];
	int set[];

	public void setX(int n) {
		this.x = new int[n];
	}

	public void set(int[] set) {
		this.set = set;
	}

	public static void main(String args[]) {
		int[] set = { 1, 3, 5, 6, 7, 9, 11, 23 };
		int sum = 22;
		SumOfSubset sol = new SumOfSubset();
		sol.finsSets(set, sum);

	}

	private void finsSets(int[] set, int sum) {

		this.setX(set.length);
		this.set(set);

		sumOfSubsets(0, 0, getr(), sum);

	}

	private int getr() {
		int sum = 0;
		for (int i = 0; i < set.length; i++)
			sum = sum + set[i];
		return sum;
	}

	/*
	 * s -> current sum k ->till kth element processed r->remainder required to
	 * be m m ->sum value
	 */
	private void sumOfSubsets(int s, int k, int r, int m) {
		x[k] = 1;
		if (s + set[k] == m) {
		
			print();
		} 
		else if (s + set[k] + set[k + 1] <= m) {
			
			sumOfSubsets(s + set[k], k+1, r - set[k], m);
		}
		x[k] = 0;
		if ((s + r - set[k] >= m) && (s + set[k + 1] <= m)) {
			
			sumOfSubsets(s, k+1, r - set[k], m);
		}

	}

	private void print() {
		int sum=0;
		for (int i = 0; i < x.length; i++) {
			
			if (x[i] == 1)
			{
				System.out.print(set[i] + " ");
				sum = sum+set[i];
			}
		}
		System.out.println("=" + sum );
		

	}

}
