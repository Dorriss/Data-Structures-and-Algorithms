package string;

import java.util.Scanner;

public class CyclicRotate {

	public static void main(String args[]) throws Exception {

		Scanner scin = new Scanner(System.in);
		int input = scin.nextInt();
		int[] inlen = new int[input];
		String[] instring = new String[input];

		for (int i = 0; i < input; i++) {
			inlen[i] = scin.nextInt();
			instring[i] = scin.next();

		}

		for (int i = 0; i < input; i++) {
			String str = cyclicrotate(instring[i], inlen[i]);
			System.out.println(str);
		}

	}

	private static String cyclicrotate(String string, int i) {
		String result = "";
		int[] chararray = new int[26];

		for (int j = 0; j < i; j++) {

			if (chararray[string.charAt(j) - 'a'] != 0) {
				int a = string.charAt(j) + chararray[string.charAt(j) - 'a'];
				if (a > 122)
					a = a - 26;

				result = result + (char) a;

			} else {

				result = result + string.charAt(j);
			}

			chararray[string.charAt(j) - 'a'] = chararray[string.charAt(j) - 'a'] + 1;

		}

		return result;
	}

}
