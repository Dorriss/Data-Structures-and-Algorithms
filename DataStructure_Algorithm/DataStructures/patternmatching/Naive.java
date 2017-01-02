package patternmatching;

public class Naive {
	
	public static void main(String args[])
	{
		String pattern = "ab";
		String text ="abhjashlakab";
		
		match(pattern,text);
	}

	private static void match(String pattern, String text) {
		
		int l1 = pattern.length();
		int l2 = text.length();
		if(l2<l1)
		{
			System.out.println("No pattern as text is shorter than pattern");
		  return;
		}
		for(int i=0;i<l2-l1+1;i++)
		{
			 boolean bool =true;
			 int j=0;
			 int k=0;
			while(bool && j<l1 )
			{
				if(pattern.charAt(j) == text.charAt(i+k) )
				{
				  j++;
				  k++;
				}
				else
				{
					bool = false;
					break;
				}
				
				
			}
				
			if(bool ==true)
				System.out.println("pattern at index" + i);
		}
		
		
	}

}
