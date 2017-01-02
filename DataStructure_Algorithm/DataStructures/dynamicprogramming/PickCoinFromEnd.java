package dynamicprogramming;

import java.util.ArrayList;

public class PickCoinFromEnd {
	
	public static void main(String args[])
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		maxcoin(a);
	}

	private static int maxcoin(ArrayList<Integer> a) {
		
		int[][] mem = new int[a.size()][a.size()];
		int max =0;
		
		for(int x=0;x<a.size();x++)
		{
			for(int y=x;y<a.size();y++)
			{
				if(x==y)
					mem[x][y] = a.get(x);
				else if(y == x+1)
					mem[x][y] = Math.max(a.get(x),a.get(y));
				else
					mem[x][y] = Math.max(a.get(x) +Math.min(a.get(x+2), a.get(y)), a.get(y)+ Math.min(a.get(x+1),a.get(y-1)));
				
				if(max<mem[x][y])
				{
					max = mem[x][y];
				}
			}
		}
			
		return max;
	}
	
	/*public static int maxcoin(ArrayList<Integer> a) {
		boolean turn = true;

		int res = pickCoin(turn,0,0, 0, a.size() - 1, a);
		return res;
	}

	private static  int pickCoin(boolean turn,int mysum,int oppsum, int start, int end, ArrayList<Integer> a) {
		if(start>end)
		{
			return 0;
		}

//		else if (start == end) {
//			return a.get(start);
//		}

		else{ //(start < end) {
			if (turn == true) {
				int a1 =  pickCoin(false,mysum+ a.get(start),oppsum ,start + 1, end, a);
				int a2 =   pickCoin(false,a.get(end) +mysum ,oppsum, start, end - 1, a);
				return Math.max(a1,a2);
			} else {	
				int b1 = pickCoin(true,mysum,oppsum+a.get(start),start + 1, end, a);
				int b2 = pickCoin(true,mysum,oppsum+ a.get(end) , start, end - 1, a);
				return Math.min(b1,b2);
			}
		}
	//	return end;

		
	}*/

}
