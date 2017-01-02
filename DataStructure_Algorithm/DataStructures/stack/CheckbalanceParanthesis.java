package stack;
import java.util.Stack;

public class CheckbalanceParanthesis {
	
	
	
static String[] Braces(String[] values) {
	
        String[] result = new String[values.length];
        
        
        for (int i = 0; i < values.length; i++) {
        	
              Boolean a = 	check(values[i]);
              
              if(a== true)
            	  result[i]="YES";
              else
            	  result[i]="NO";
		}
        
        return result;
        


    }

private static Boolean check(String string) {
	
	if(string.length() == 0 || string.length()%2 !=0)
		return false;
	
	Stack<Character> st = new Stack<>();
	for (int i = 0; i < string.length(); i++) {
		if(string.charAt(i)=='{' || string.charAt(i)== '[' || string.charAt(i) == '(')
		{
			st.push(string.charAt(i));
		}
		else
		{
			if(st.isEmpty())
				return false;
			char c = st.pop();
			if(string.charAt(i)== '}' && c != '{')
				return false;
			if(string.charAt(i)== ']' && c != '[')
				return false;
			if(string.charAt(i)== ')' && c != '(')
				return false;
			
			
				
		}
		
	}
	return true;
}

}
