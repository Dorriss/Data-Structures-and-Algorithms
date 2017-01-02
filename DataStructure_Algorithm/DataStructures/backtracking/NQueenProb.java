package backtracking;

public class NQueenProb {
	
	int dimension = 5;
	int x[] = new int[dimension];
	
	
	public boolean place(int k,int i)
	{
		for(int j=0;j<=k-1;j++)
		{
		if(x[j] == i || Math.abs(x[j]-i) == Math.abs(j-k) )
		return false;
		}
		return true;
		
	}
	
	public boolean Nqueen(int k)
	{
		int n =dimension;
		for(int i=0;i<n;i++)
		{
			if(place(k,i))
			{
				x[k] = i;
				if(k==n-1)
					return true;
				else
				{
					if(Nqueen(k+1))
					  return true;
				}
			}
			x[k]=-1;
		}
		
		return false;
	}
	
	public static void main(String args[])
	{
		
		NQueenProb nqp = new NQueenProb();
		
		for(int i=0;i<nqp.dimension;i++)
			nqp.x[i] = -1;
	 
		nqp.Nqueen(0);
		for(int i=0;i<nqp.dimension;i++)
			System.out.println(nqp.x[i]);
		
	}

}
