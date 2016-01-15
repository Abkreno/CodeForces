package Div1_C_Div2_E;

import java.io.IOException;
import java.util.Scanner;

public class SumOfRemainders {
	static long MOD = 1000000000 + 7;
	static long twoInv = mul_inv(2, MOD);

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		long sum = divisionSum(n, Math.min(n, m));
		long a = n % MOD;
		a *= (Math.min(n, m) % MOD);
		a %= MOD;
		sum = a - sum;
		if (sum < 0)
			sum += MOD;
		sum %= MOD;
		if (m > n) {
			a = (m - n) % MOD;
			a *= (n % MOD);
			a %= MOD;
			sum += a;
			sum %= MOD;
		}

		System.out.println(sum % MOD);
	}

	static long mul_inv(long a, long b) {
		long b0 = b, t, q;
		long x0 = 0, x1 = 1;
		if (b == 1)
			return 1;
		while (a > 1) {
			q = a / b;
			t = b;
			b = a % b;
			a = t;
			t = x0;
			x0 = x1 - q * x0;
			x1 = t;
		}
		if (x1 < 0)
			x1 += b0;
		return x1;
	}

	static long divisionSum(long n, long m) {
		long res = 0;
		long c = n;
		long end, start, sum;
		for (long i = 1; i <= n; i++) {
			start = (n / (i + 1)) + 1;
			end = n / i;
			if (end <= start) {
				c = end;
				break;
			}
			end = Math.min(m, end);
			if (start > m || start > end)
				continue;
			sum = sum(end);
			sum -= sum(start - 1);
			if (sum < 0)
				sum += MOD;
			// sum = sum2(end, end - start + 1);
			sum %= MOD;
			sum *= (i % MOD);
			sum %= MOD;
			res += sum;
			res %= MOD;
		}
		c = Math.min(c, m);
		long a;
		for (long j = 1; j <= c; j++) {
			a = (n / j) % MOD;
			a *= (j % MOD);
			a %= MOD;
			res += a;
			res %= MOD;
		}
		return res % MOD;
	}

	static long sum(long n) {
		long a = n % MOD;
		a *= ((n + 1) % MOD);
		a %= MOD;
		a *= twoInv;
		return a % MOD;
	}

	static long sum2(long n, long x) {
		return x * n - (x * x) / 2 + x / 2;
	}
}