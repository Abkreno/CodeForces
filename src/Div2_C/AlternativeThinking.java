package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlternativeThinking {
	static int n;
	static char[] s;
	static int DP[][][] = new int[3][3][100003];

	static int getMax(int curr, int alter, int prev) {
		if (curr >= n)
			return 0;
		if (DP[alter][prev][curr] != -1)
			return DP[alter][prev][curr];
		int ans = getMax(curr + 1, alter == 0 ? 0 : 2, prev);
		if (alter > 0) {
			if (alter == 1) {
				// can swap curr
				if (s[curr] == '1') {
					if (prev == 0) {
						ans = max(ans, 1 + getMax(curr + 1, 2, 1));
					} else {
						ans = max(ans, 1 + getMax(curr + 1, 1, 0)); // swap me
					}
				} else {
					if (prev == 0) {
						ans = max(ans, 1 + getMax(curr + 1, 1, 1));
					} else {
						ans = max(ans, 1 + getMax(curr + 1, 2, 0)); // swap
						// 10111101 // me
					}
				}
			} else {
				// can't swap curr
				if (s[curr] == '1') {
					if (prev == 0) {
						ans = max(ans, 1 + getMax(curr + 1, alter, 1));
					}
				} else {
					if (prev == 1) {
						ans = max(ans, 1 + getMax(curr + 1, alter, 0));
					}
				}
			}
		} else {
			if (prev == 2) {
				if (s[curr] == '1') {
					ans = max(ans, 1 + getMax(curr + 1, alter, 1));
					ans = max(ans, 1 + getMax(curr + 1, 1, 0));
				} else {
					ans = max(ans, 1 + getMax(curr + 1, alter, 0));
					ans = max(ans, 1 + getMax(curr + 1, 1, 1));
				}
			} else {
				if (s[curr] == '1') {
					if (prev == 0) {
						ans = max(ans, 1 + getMax(curr + 1, alter, 1));
					} else {
						ans = max(ans, 1 + getMax(curr + 1, 1, 0));
					}
				} else {
					if (prev == 0) {
						ans = max(ans, 1 + getMax(curr + 1, 1, 1));
					} else {
						ans = max(ans, 1 + getMax(curr + 1, alter, 0));
					}
				}
			}
		}
		return DP[alter][prev][curr] = ans;
	}

	private static int max(int ans, int i) {

		return Math.max(ans, i);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		s = bf.readLine().toCharArray();
		for (int i = 0; i < DP.length; i++) {
			for (int j = 0; j < DP[i].length; j++) {
				Arrays.fill(DP[i][j], -1);
			}
		}
		System.out.println(getMax(0, 0, 2));
	}
}
