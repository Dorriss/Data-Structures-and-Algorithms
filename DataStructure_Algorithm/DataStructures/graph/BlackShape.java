package graph;
import java.util.ArrayList;

public class BlackShape {

	public static void main(String args[])
	{
		ArrayList<String> a = new ArrayList<>();
		a.add("OOOXOOO");
		a.add("OOXXOXO");
		a.add("OXOOOXO");
		
		BlackShape bl  = new BlackShape();
		System.out.println(bl.black(a));
		
	}

	public int black(ArrayList<String> a) {

		int count = 0;

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).length(); j++) {
				if (a.get(i).charAt(j) == 'X') {

					String newstr = replacechar(a.get(i), j);
					a.set(i, newstr);
					count = count + 1;
					a = check(a, i, j);
				}

			}
		}
		return count;
	}

	private ArrayList<String> check(ArrayList<String> a, int i, int j) {
		
		
		if (j + 1 < a.get(i).length() && a.get(i).charAt(j + 1) == 'X') {
			String newstr = replacechar(a.get(i), j + 1);
			a.set(i, newstr);
			a = check(a,i,j+1);
		}

		if (i + 1 < a.size() && a.get(i + 1).charAt(j) == 'X') {
			String newstr = replacechar(a.get(i + 1), j);
			a.set(i + 1, newstr);
			a = check(a, i+1, j);
		}
		
		if(j>0 && a.get(i).charAt(j-1) == 'X')
		{
			String newstr = replacechar(a.get(i), j - 1);
			a.set(i, newstr);
			a = check(a,i,j-1);
		}

		if(i>0 && a.get(i-1).charAt(j) == 'X')
		{
			String newstr = replacechar(a.get(i-1), j);
			a.set(i-1, newstr);
			a = check(a,i-1,j);
		}
		
		return a;

	}

	private String replacechar(String string, int j) {
		StringBuilder sb = new StringBuilder(string);
		sb.setCharAt(j, 'O');
		return sb.toString();
	}

}
