package math;

public class gcd {
	public static int gcd(int a, int b) {

		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a == 1)
			return b;
		if (b == 1)
			return a;
		if (a == b)
			return a;
		if (a > b)
			return gcd(a%b, b);
		else
			return gcd(b%a, a);

	}

	public static void main(String args[]) {
		System.out.println(gcd(2, 3));
	}
}
