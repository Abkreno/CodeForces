package Div2_D;

import java.util.Scanner;

public class RandomTask {
	static long m;
	static int k;
	static int c = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextLong();
		k = sc.nextInt();
		long lo = 1;
		long hi = 1000000000000000000L;
		long mid;
		long count;
		while (lo + 1 < hi) {
			mid = (lo + hi) >> 1;
			count = count(mid << 1) - count(mid);
			if (count == m) {
				System.out.println(mid);
				return;
			}
			if (count > m) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		System.out.println(lo);
	}

	private static long count(long n) {
		int prev = 0;
		long res = 0;
		int curr = countBits(n);
		while (curr > 0 && prev < k) {
			if (((1L << curr) & n) > 0) {
				res += nCk(curr, k - prev);
				prev++;
			}
			curr--;
		}
		return res;
	}

	private static int countBits(long n) {
		int res = 0;
		while (n > 0) {
			res++;
			n >>= 1;
		}
		return res;
	}

	static long nCk(long n, long k) {
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

}
