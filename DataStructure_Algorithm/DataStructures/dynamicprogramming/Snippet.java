package dynamicprogramming;

public class Snippet {

	public static int LCS(String A, String B, int lengthA, int lengthB) {

		if (lengthA == 0 || lengthB == 0)
			return 0;
		if (A.charAt(lengthA - 1) == B.charAt(lengthB - 1))
			return (1 + LCS(A.substring(0, lengthA - 1),
					B.substring(0, lengthB - 1), lengthA - 1, lengthB - 1));

		if (A.charAt(lengthA - 1) != B.charAt(lengthB - 1))
			return (Math.max(
					LCS(A.substring(0, lengthA - 1), B, lengthA - 1, lengthB),
					LCS(A, B.substring(0, lengthB - 1), lengthA, lengthB - 1)));

		return -1;

	}
	
	
	public static void main(String args[])
	{
		String A = "abcdefghi";
		String B = "acadfasf";
		
		System.out.println(LCS(A,B,A.length(),B.length()));
	}

}
