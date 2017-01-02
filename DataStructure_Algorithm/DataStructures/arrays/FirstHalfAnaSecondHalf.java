package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FirstHalfAnaSecondHalf {
	
	public static void main(String args[])
	{
		System.out.println(checkAna("iamhdfmai"));
	}
	
	
public static boolean	checkAna(String str)
{
	
	boolean odd;
	int len = str.length();
    if(len%2 == 0)
    {
    	len=len/2;
    	 odd = false;
    }
    else
    {
    	odd=true;
    len=(len+1)/2;
    }
    
    List<Character> lst = str.chars().mapToObj(e->(char)e).collect(Collectors.toList());
    List<Character> lst1 = new ArrayList<Character>();
    List<Character> lst2 = new ArrayList<Character>();
    if(odd==false)
    {
     lst1 = lst.subList(0, len);
     lst2 = lst.subList(len,str.length());
    }
    else
    {
    	lst1 = lst.subList(0, len-1);
        lst2 = lst.subList(len,str.length());
    }
   // Arrays.sort(lst1);
    	
    Collections.sort(lst2);
    Collections.sort(lst1);
    for(int i=0;i<len-1;i++)
    {
    	if(lst1.get(i).compareTo(lst2.get(i))!= 0)
    	return false;		
    }
    return true;
}


}
