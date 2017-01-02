package gamedesign.boggle;
import java.util.HashSet;

public class Boggle {
	int[][] visited;
	char[][] board;
	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	int M;
	int N;
	String str;
	
	
	
	HashSet<String> output = new HashSet<>();
	HashSet<String> dictionay = new HashSet<>();
	
	public HashSet<String> getDictionay() {
		return dictionay;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public void setDictionay() {
		this.dictionay.add("GEEKS");
		this.dictionay.add("FOR");
		this.dictionay.add("QUIZ");
		this.dictionay.add("GO");
		
	}


	public int[][] getVisited() {
		return visited;
	}

public static void main(String args[])
{
	char boggle[][]   = {{'G','I','Z'},
            {'U','E','K'},
            {'Q','S','E'}};
	
	Boggle bog = new Boggle();
	  bog.setBoard(boggle);
	  bog.Solution();
	}
	
	public void setVisited(int[][] visited) {
		this.visited = visited;
		this.M = visited.length;
		this.N = visited[0].length;
	}


	public void Solution()
	{
		int[][] visited = new int[board.length][board[0].length]; 
		//this.visited = visited;
		setVisited(visited);
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if(this.visited[i][j] == 0)
				{
					check(i,j,"");
				}
			}
		}
		
	}
    public boolean contains(String str)
    {
    	if(dictionay.contains(str))
    		return true;
    	else
    		return false;
    }

	private String check(int i, int j,String str) {
		
		this.visited[i][j] = -1;
       str = str+board[i][j];
		//this.str = str;
       
		if(str.length()>2 && contains(str))
			output.add(str);
		
		 for (int row=i-1; row<=i+1 && row<M && row != i; row++)
		 {
		      for (int col=j-1; col<=j+1 && col<N && col != j; col++)
		      {
		        if (row>=0 && col>=0 && this.visited[row][col]==0)
		        {
		        	str = str+ check(row, col, str);
		        	if(contains(str))
		    			output.add(str);
		        	
		        }
		      }
		 }
		 
		 str = str.substring(0, str.length()-1);
		 visited[i][j]= 0;
		
		 return str;
		
		
	}
	
}
