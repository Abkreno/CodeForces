package A2_Div2_C;

import java.util.Scanner;

public class RationalResistance {
	static long fun(long a, long b) {
		if (b == 0)
			return 0;
		return (a / b) + fun(b, a % b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println(fun(Math.max(a, b), Math.min(a, b)));
	}
}
