package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewYearAncientProphecy {
	static int n;
	static char[] seq;
	static long MOD = 1000000000 + 7;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		char[] tmp = bf.readLine().toCharArray();

		seq = new char[n + 1];
		for (int i = 0; i < n; i++) {
			seq[i + 1] = tmp[i];
		}
		if (seq[1] == '0') {
			System.out.println(0);
			return;
		}
		int[][] DP = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			DP[1][i] = 1;
		}
		int[][] G = new int[n + 1][n + 1];
		for (int i = n; i > 0; i--) {
			for (int j = i - 1; j > 0; j--) {
				if (seq[i] > seq[j]) {
					G[i][j] = i;
				} else if (seq[i] == seq[j] && j + 1 < i && i < n) {
					G[i][j] = G[i + 1][j + 1];
				}
			}
		}
		int sums[] = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			if (seq[i] == '0')
				continue;
			for (int j = 1; j <= i - 1; j++) {
				sums[j] = 0;
				sums[j] += sums[j - 1] + DP[j][i - 1];
				sums[j] %= MOD;
			}
			for (int j = i; j <= n; j++) {
				int start = 2 * i - j - 1;
				int end = i - 1;
				if (start > 0 && G[i][start] != 0 && G[i][start] <= j) {
					int t = sums[end] - sums[start - 1];
					if (t < 0)
						t += MOD;
					DP[i][j] += t;
					DP[i][j] %= MOD;
				} else {
					start = Math.max(start, 0);
					int t = sums[end] - sums[start];
					if (t < 0)
						t += MOD;
					DP[i][j] += t;
					DP[i][j] %= MOD;
				}
				DP[i][j] %= MOD;
			}
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += DP[i][n];
			sum %= MOD;
		}
		System.out.println(sum);
	}
}
