package ECPC2015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class K {
	static int n, p;
	static int res[] = new int[1000005];

	static int[] numAfterDecPoint(long a, long b, int n) {
		a %= b;
		for (int i = 1; i <= n; i++) {
			a *= 10;
			res[i] = (int) (a / b);
			a %= b;
		}
		return res;
	}

	static long DP[][] = new long[2][201];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		long a, b;
		String[] l;
		while (t-- > 0) {
			l = bf.readLine().split(" ");
			a = Long.parseLong(l[0]);
			b = Long.parseLong(l[1]);
			n = Integer.parseInt(l[2]);
			p = Integer.parseInt(l[3]);
			numAfterDecPoint(a, b, n);
			Arrays.fill(DP[0], 0);
			Arrays.fill(DP[1], 0);
			long ans = 0;
			for (int i = 1; i <= n; i++) {
				DP[1][res[i] % p]++;
				for (int j = 0; j < p; j++) {
					DP[1][(j * 10 + res[i]) % p] += DP[0][j];
				}
				ans += DP[1][0];
				for (int j = 0; j < p; j++) {
					DP[0][j] = DP[1][j];
					DP[1][j] = 0;
				}
			}

			System.out.println(ans);
		}
	}
}
