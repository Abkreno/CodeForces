package Div2_D;

import java.util.Arrays;
import java.util.Scanner;

public class Zuma {
	static char[] s; // original string
	static int N;
	static int DP[][];

	static int minMoves(int l, int r) {
		if (DP[l][r] != -1)
			return DP[l][r];
		if (l >= r)
			return DP[l][r] = 1;
		int i;
		int ans = N;
		if (s[l] == s[r])
			ans = minMoves(l + 1, r - 1);
		for (i = l; i < r; i++) {
			ans = Math.min(ans, minMoves(l, i) + minMoves(i + 1, r));
		}
		return DP[l][r] = ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DP = new int[N][N];

		for (int i = 0; i < DP.length; i++) {
			Arrays.fill(DP[i], -1);
		}
		s = new char[N];
		for (int i = 0; i < s.length; i++) {
			s[i] = (char) (sc.nextInt() + '0');
		}

		System.out.println(minMoves(0, N - 1));
	}
}
