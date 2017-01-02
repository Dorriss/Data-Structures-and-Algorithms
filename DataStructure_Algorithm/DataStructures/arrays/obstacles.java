package arrays;

public class obstacles {
	static int[][] mat ={{0,1},{1,0}};
	
	public static int findpaths(int r,int c)
	{
		
		int a=0;
		int b=0,d=0;
		if(mat[0][0] == 1)
			return 0;
		if(r==0 && c==0 && mat[r][c] ==0)
			return 1;
		else
		{
			if(r>0 & c>=0)
			{
				if(mat[r-1][c] == 0)
				 a = findpaths(r-1,c);
			   
			}
			if(r>=0 & c>0)
			{
				if(mat[r][c-1] == 0)
				b=findpaths(r,c-1);
			
			}
			if(r>0 & c>0)
			{
				if(mat[r-1][c-1] == 0)
				 d = findpaths(r-1,c-1);
		
			}
			
			return a+b+d;
			
			
		}	
	}
	public static void main(String args[])
	{
		System.out.println(findpaths(1,1));
	}
	

}
