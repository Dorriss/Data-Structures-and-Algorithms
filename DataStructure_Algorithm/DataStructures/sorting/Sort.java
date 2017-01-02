package sorting;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort {
public void readfromfile() throws IOException
{
	int n=3;
	int[] mem = new int[n];
	int curr=0;
	File[] tempfiles;
	InputStreamReader insr = new InputStreamReader(new FileInputStream(new File("C:\\Users\\I072842\\workspace_flipkart\\ExternalMergeSorting\\src\\Input")));
	int i =insr.read();
	while(i != -1 )
	{
		while(i== 44)
		{
			i =insr.read();
		}
		if(curr <= n-1)
		{
			mem[curr]= i;
			curr++;
		}
		else
		{
			sort(mem);
		}
	    i = insr.read();
		
		
	}
	}

private void sort(int[] mem) {
	// TODO Auto-generated method stub
	
}

public static void main(String args[]) throws IOException
{
	Sort s = new Sort();
	s.readfromfile();
}
	
}
