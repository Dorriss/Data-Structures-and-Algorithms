package string;

public class ReverseVowelsInString {

	public static void main(String args[]) {
		StringBuilder input = new StringBuilder("checkiaechick");
		int index = 0;
		char[] vow = new char[input.length()];
		for (int i = 0,j=input.length()-1; i <=j; i++,j--) {
			
			while(!(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o'
					|| input.charAt(i) == 'u'))
				
			{
				i++;
			}

			while(!(input.charAt(j) == 'a' || input.charAt(j) == 'e' || input.charAt(j) == 'i' || input.charAt(j) == 'o'
					|| input.charAt(j) == 'u'))
				
			{
			  j--;
			}
			char temp =  input.charAt(i);
			input.setCharAt(i,input.charAt(j));
			input.setCharAt(j,temp);
			
			/*if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o'
					|| input.charAt(i) == 'u') {
				vow[index] = input.charAt(i);
				index++;
			}*/
		}

		/*for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o'
					|| input.charAt(i) == 'u') {
				input.setCharAt(i, vow[index-1]);
				index--;
			}
		}*/
System.out.println(input);
	}

}
