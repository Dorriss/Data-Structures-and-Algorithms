package bugfindingproblems;

import java.util.ArrayList;

public class prettyJson {
	
	
	public ArrayList<String> prettyJSON(String A) {
    ArrayList<String> res = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    int n = A.length();
    int tabs = 0;
    
    for (int i = 0; i < n; ) {
        
        i = skipSpace(A, i);
        
        if (i >= n)
            break;
        
        str = new StringBuilder();
        char c = A.charAt(i);
        
        if (delimiter(c)) {
            
            if (isOpenBracket(c)) {
	            for (int j = 0; j < tabs; j++)
	                str.append("\t");	                
                tabs++;
            } else if (isClosedBracket(c)) {
                tabs--;
	            for (int j = 0; j < tabs; j++)
                    str.append("\t");
            }
            
            str.append(c);
            i++;
            
	        if (i < n && canAdd(A.charAt(i))) {
	            str.append(A.charAt(i));
	            i++;
            }
            
            res.add(str.toString());
            
            continue;
        }
        
        while (i < n && !delimiter(A.charAt(i))) {
            str.append(A.charAt(i));
            i++;
        }
        
        if (i < n && canAdd(A.charAt(i))) {
            str.append(A.charAt(i));
            i++;
        }
        
        StringBuilder strB = new StringBuilder();
        
        for (int j = 0; j < tabs; j++)
            strB.append("\t");
        
        strB.append(str);
        res.add(strB.toString());
    }
    
    return res;
    
}

public boolean canAdd(char c) {
    if (c == ',' || c == ':')
        return true;
        
    return false;
}

public boolean delimiter(char c) {
    if (c == ',' || isOpenBracket(c) || isClosedBracket(c))
        return true;
    return false;
}

public boolean isOpenBracket(char c) {
    if (c == '[' || c == '{')
        return true;
    return false;
}

public boolean isClosedBracket(char c) {
    if (c == ']' || c == '}')
        return true;
    return false;
}

public int skipSpace(String A, int i) {
    int n = A.length();
    while (i < n && A.charAt(i) == ' ')
        i++;
    return i;
}
public static ArrayList<String> prettyJSON1(String a) {
	ArrayList<String> res = new ArrayList<>();
	int counttab =0;
	String current = new String();
	for (int i = 0; i < a.length(); i++) {
		
		
		switch(a.charAt(i))
		{
		case '{' :
		case '[' :
			current = current + a.charAt(i);
			res.add(current);
			current = new String();
			counttab = counttab+1;
			current = addTab(current,counttab);		
		break;	
			
		case '}':
		case ']':	
			if(!(a.charAt(i-1) == '}'))
			{
			res.add(current);
			current = new String();
			current = addTab(current, counttab);
			}
			current = current + a.charAt(i);
			counttab = counttab-1;			
			res.add(current);
			current = new String();
			current = addTab(current, counttab);
			break;
			
		case ',':
			current = current+a.charAt(i);
			res.add(current);
			current = new String();
			current = addTab(current, counttab);
			break;
			
		case ':':
			current = current+a.charAt(i);
			if(a.charAt(i+1) != '"')
			{
				res.add(current);
				current = new String();
				current = addTab(current, counttab);
			}
			
			break;
			
			default:
				current = current+a.charAt(i);
			
			
		}
		}
	return res;
		
	}

private static String addTab(String current, int counttab) {
	// TODO Auto-generated method stub
	for (int i = 0; i < counttab; i++) {
		current = " " + current;
	}
	
	return current;
}
	
public static void main(String args[])
{
	
String A = new String();
A = A + '{';
A = A + "A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
A = A + '}';

ArrayList<String> res = prettyJson.prettyJSON1(A);
for (int i = 0; i < res.size(); i++) {
	
	System.out.println(res.get(i));
	
}
}

}

