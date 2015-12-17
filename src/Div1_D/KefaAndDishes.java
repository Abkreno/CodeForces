package Div1_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KefaAndDishes {
	static int n, m, nums[] = new int[18], g[][] = new int[20][20];
	static long dp[][] = new long[19][(1 << 18) + 1];

	static long getMax(int prev, int mask) {
		if (Integer.bitCount(mask) >= m)
			return 0;
		if (dp[prev][mask] != -1)
			return dp[prev][mask];
		long max = 0, c;
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) == 0) {
				c = nums[i] + g[prev][i + 1] + getMax(i + 1, mask | (1 << i));
				max = Math.max(max, c);
			}
		}
		return dp[prev][mask] = max;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		int k = Integer.parseInt(l[2]);
		l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		for (int i = 0; i < k; i++) {
			l = bf.readLine().split(" ");
			g[Integer.parseInt(l[0])][Integer.parseInt(l[1])] = Integer
					.parseInt(l[2]);
		}
		System.out.println(getMax(0, 0));
	}
}
