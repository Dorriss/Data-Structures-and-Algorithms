package string;

public class reversestring {

	public static String reverseWords(String a) {
		int beginIndex = 0;
		int endIndex = 0;
		String newstring = new String();
		a = a.trim();
		for (int i = 0; i < a.length(); i++) {
			beginIndex = i;

			while (a.charAt(i) != ' ') {
				i++;

				if (i == a.length())
					break;

			}
			endIndex = i;
			newstring = newstring.trim();

			if (endIndex == a.length()) {

				newstring = a.substring(beginIndex) + ' ' + newstring;
			} else {

				newstring = a.substring(beginIndex, endIndex) + ' ' + newstring;
			}

		}
		return newstring;
	}

	public static void main(String args[]) {
		System.out.println(reverseWords("   the   sky is blue"));
	}

}
