package string;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharactersInString {
	
	public static void main(String args[])
	{
		String input = "abcdfbfrggcdrkkkknaiuiouagaojkjnnlklz";
		
		Map<Character,Integer> mp = new LinkedHashMap<Character,Integer>();
		
		for(int i =0;i<input.length();i++)
		{
			if(mp.containsKey(input.charAt(i)))
				mp.put(input.charAt(i), mp.get(input.charAt(i))+1);
			else
				mp.put(input.charAt(i),1);
				
		}
		
		for(Map.Entry<Character,Integer> en:mp.entrySet())
		{
			if(en.getValue() == 1)
			{
				System.out.println(en.getKey());
				break;
			}
			
				
		}
			
		
	}

	
	
}
