package patternmatching;

public class KMP {
	
	
	public static int[] getprefixArray(char[] pattern)
	{
		int[] pa = new int[pattern.length];
		int index=0;
		//int i=0;
		pa[0]=0;
		for (int i = 0; i < pattern.length; i++) {
			if(pattern[i]==pattern[index])
			{
				pa[i] = pa[index]+1;
			}
			else
			{
				if(index!=0)
				{
					index=pa[index-1];
				}
				else
				{
					pa[i]=0;
					i++;
				}
			}
		}
		
		return pa;
		
	}
	
	
	public static boolean KMP(char[] text,char[] pattern)
	{
		int[] lps = getprefixArray(pattern);
	 int i=0;
	 int j=0;
	 
	 while(i<text.length && j<pattern.length)
	 {
		 if(text[i] == pattern[j])
		 {
			 i++;
			 j++;
		 }
		 else{
			 if(j!=0)
			 {
				 j=lps[j-1];
			 }
			 else
				 i++;
		 }
	 }
	 
	 if(j== pattern.length)
		 return true;
	 
	 return false;
	 
	}

}
