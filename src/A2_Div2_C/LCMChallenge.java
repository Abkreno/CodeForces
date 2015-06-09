package A2_Div2_C;

import java.util.Scanner;

public class LCMChallenge {
	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		if (n <= 2)
			System.out.println(n);
		else {
			long res = n * (n - 1) * (n - 2);
			if (n % 2 == 0) {
				res = 0;
				long start = Math.max(1, n - 50);
				for (long i = n; i >= start; i--) {
					for (long j = i; j >= start; j--) {
						long temp = lcm(i, j);
						for (long k = j; k >= start; k--) {
							long temp2 = lcm(temp, k);
							res = Math.max(res, temp2);
						}
					}
				}
			}
			System.out.println(res);
		}
	}
}
