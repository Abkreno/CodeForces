package ECPC2013;

import java.io.BufferedReader;
import java.io.FileReader;

public class F {
	static int N = 3024616;
	static long sumSeries[] = new long[N];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader("army.in"));
		int t = Integer.parseInt(bf.readLine());
		int i, cases = 1;
		long tmp;
		long n, res, lo, mid, hi;
		for (i = 1; i < N; i++) {
			sumSeries[i] = sum(i) + sum(i - 1) + sumSeries[i - 1];
		}
		StringBuilder ans = new StringBuilder();
		while (t-- > 0) {
			n = Long.parseLong(bf.readLine());
			lo = 0;
			hi = N - 1;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (sumSeries[(int) mid] >= n) {
					hi = mid;
				} else {
					lo = mid;
				}
			}
			res = (hi - 1) * (hi - 1);
			n -= sumSeries[(int) (hi - 1)];
			if (n > 0) {
				lo = -1;
				tmp = hi;
				while (lo + 1 < hi) {
					mid = (lo + hi) >> 1;
					if (sum(mid) >= n) {
						hi = mid;
					} else {
						lo = mid;
					}
				}
				res += hi;
				n -= sum(hi);
				if (n > 0) {
					lo = 0;
					hi = tmp;
					while (lo + 1 < hi) {
						mid = (lo + hi) >> 1;
						if (sum(tmp - 1) - sum(mid) >= n) {
							lo = mid;
						} else {
							hi = mid;
						}
					}
					res += tmp - lo- 1;
				}
			}
			ans.append("Case " + (cases++) + ": " + res + "\n");
		}
		System.out.print(ans);
		bf.close();
	}

	static long sum(long i) {
		return i * (i + 1) / 2;
	}
}
