package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KyokaAndColoredBalls {
	static long dp[][] = new long[1001][1001];
	static long mod = 1000000007;

	static long count(int len, int k) {
		if (k == 0)
			return 1;
		if (len == 0 && k == 0)
			return 1;
		if (len <= 0)
			return 0;
		if (dp[len][k] != -1)
			return dp[len][k];
		long ans = 0;
		for (int i = 0; i <= k; i++) {
			ans += count(len - 1, k - i);
			ans %= mod;
		}
		return dp[len][k] = ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int num[] = new int[n];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(bf.readLine());
		}
		long ans = 1;
		int prevLen = num[0];
		for (int i = 1; i < n; i++) {
			int m = num[i] - 1;
			ans = ans * count(prevLen + 1, m);
			ans %= mod;
			prevLen += num[i];
		}
		System.out.println(ans);
	}

}
