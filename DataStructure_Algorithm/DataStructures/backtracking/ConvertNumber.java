package backtracking;
import java.util.ArrayList;

public class ConvertNumber {

	int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	ArrayList<Integer> blacklist = new ArrayList<>();

	public void convert(int n1,int n2,int d,int n)
	{
		if(n1==n2)
			return;
		for(int i=0;i<d;i++)
		{
			int temp = converthelper(n1,n,d);
			if(temp  != -1)
			{
			//	convert(temp)
			}
		}
		
		
		
		
		
	//	return count;
		
	}

	public int converthelper(int n1, int n, int d) {

		int[] digits = new int[d];
		/*
		 * if(isBlackListed(n2)) return -1;
		 */
		for (int i = 0; i < n; i++) {
			digits[n - i - 1] = n1 % 10;
			n1 = n1 % 10;
		}
		int n2 = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			n2 = n2 + 10 ^ count + digits[d - 1];
			if (i == d - 1)
				n2 = n2 + 1;
		}
		if (!isBlackListed(n2)) {
			return -1;
		}

		else
			return n2;

	}

	private boolean isBlackListed(int n2) {
		if (this.blacklist.contains(n2))
			return true;

		return false;
	}

	public ArrayList<Integer> getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(ArrayList<Integer> blacklist) {
		this.blacklist.add(123);
		this.blacklist.add(456);
	}

}
