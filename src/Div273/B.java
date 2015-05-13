package Div273;

import java.util.Scanner;

public class B {
	static long res = 0;

	static long nChoosek(long n, long k) {
		if (k > n)
			return 0;
		if (k * 2 > n)
			k = n - k;
		if (k == 0)
			return 1;

		long result = n;
		for (int i = 2; i <= k; ++i) {
			result *= (n - i + 1);
			result /= i;
		}
		return result;
	}

	public static long[] f(long r, long g, long mg) {
		long[] result = new long[3];
		if (g >= r) {
			res += r;
			g -= r;
			if (g < 0)
				g = 0;
			r = 0;
			mg += g % 2;
			g -= g % 2;
		} else {
			res += g;
			r = r - g;
			g = 0;
			if (r >= mg) {
				res += r;
				mg -= r;
				r = 0;
			} else {
				res += mg;
				mg = 0;
			}
		}
		if (g < 0)
			g = 0;
		if (mg < 0)
			mg = 0;
		if (r < 0)
			r = 0;
		result[0] = r;
		result[1] = g;
		result[2] = mg;
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long r = sc.nextLong();
		long g = sc.nextLong();
		long b = sc.nextLong();
		long mr = r % 2;
		long mg = g % 2;
		long mb = b % 2;
		r = (r - mr) / 2;
		g = (g - mg) / 2;
		b = (b - mb) / 2;
		long call[];
		if (r > 0) {
			call = f(r, g, mg);
			r = call[0];
			g = call[1];
			mg = call[2];
		}
		if (r > 0) {
			call = f(r, b, mb);
			r = call[0];
			b = call[1];
			mb = call[2];
		}
		if (b > 0) {
			call = f(b, r, mr);
			b = call[0];
			r = call[1];
			mr = call[2];
		}
		if (b > 0) {
			call = f(b, g, mg);
			b = call[0];
			g = call[1];
			mg = call[2];
		}
		if (g > 0) {
			call = f(g, r, mr);
			g = call[0];
			r = call[1];
			mr = call[2];
		}
		if (g > 0) {
			call = f(g, b, mb);
			g = call[0];
			b = call[1];
			mb = call[2];
		}
		System.out.println(res);
	}
}
