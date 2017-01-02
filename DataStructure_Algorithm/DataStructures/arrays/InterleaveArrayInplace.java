package arrays;

public class InterleaveArrayInplace {
	
	public static void main(String args[])
	{
		InterleaveArrayInplace sol = new InterleaveArrayInplace();
		int[] a= {1,2,3,4,5,6,7,8,9};
		int length =a.length;
		int start =0;
		sol.interleave(a, length, start);
	}

	public void  Sol(int[] a)
	{
	int	length =a.length;
	a = interleave(a,length,(length/2)+1);
	
	
	}

	private int[] interleave(int[] a,int length,int start) {
		
		/*if(length <= 2){
			return a;
		}
		if(length == 4)
		{
			int temp = a[start+1];
			a[start+1]=a[start+2];
			a[start+2]=temp;			
		}
		
		else
		{
			a = interleave(a,length/2,(start+length)/2 );
			a = interleave(a,length/2,3*(start+length)/2);
		}*/
		
		
		for(int i=0; i<a.length/2-1; i++) {
			int m = a.length/2 - i;
			for(int j=0; j<i+1; j++) {
				int temp = a[m];
				a[m] = a[m-1];
				a[m-1] = temp;
				m = m+2;
			}
		}
		return a;
	}
}
