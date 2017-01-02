package string;

public class CheckStringUniqueCharacters {
	
	public static void main(String args[])
	{
		String a ="abcdA";
		
		
		System.out.println(SolUsingBitInt(a));
		System.out.println(SolUsingBit(a));
		
	}
	
	public static boolean SolUsingBitInt(String a)
	{
		int checker =0;
		for(int i=0;i<a.length();i++)
		{
			int val = a.charAt(i)-'a';
			if((checker & (1<< val)) > 0)
			{
			//System.out.println(false);
			return false;
			}
			else
			 checker = checker| (1<<val);		
		}
		//System.out.println(true);
		return true;
	}
	
	public static boolean SolUsingBit(String str)
	{
		long checker=0;
		for(int i=0;i<str.length();i++)
		{
			long val =str.charAt(i)-'A';
			if((checker & (1<< val))>0)
		    // System.out.println(false);
				return false;
			else
				checker = checker | (1<< val);
			
		}
		//System.out.println(true);
		return true;
	}

}
