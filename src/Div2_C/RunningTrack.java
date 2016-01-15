package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RunningTrack {
	static char[] s, sR, t;
	static int INF = 1000000;
	static int n, m;
	static int table1[][] = new int[2105][2105];
	static int table2[][] = new int[2105][2105];
	static int DP[] = new int[2105];
	static StringBuilder sb = new StringBuilder();
	static int getMin(int curr) {
		if (curr >= n)
			return 0;
		if (DP[curr] != -1)
			return DP[curr];
		int min = INF;
		for (int i = 0; i < m; i++) {
			if (table1[curr][i] != 0) {
				min = Math.min(min, 1 + getMin(curr + table1[curr][i]));
			}
			if (table2[curr][i] != 0) {
				min = Math.min(min, 1 + getMin(curr + table2[curr][i]));
			}
		}
		return DP[curr] = min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s = bf.readLine().toCharArray();
		t = bf.readLine().toCharArray();
		m = s.length;
		n = t.length;
		sR = new char[m];
		Arrays.fill(DP, -1);
		for (int i = 0; i < m; i++) {
			sR[i] = s[m - i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				if (t[i] == s[j]) {
					table1[i][j] = 1 + table1[i + 1][j + 1];
				}
				if (t[i] == sR[j]) {
					table2[i][j] = 1 + table2[i + 1][j + 1];
				}
			}
		}
		int min = getMin(0);
		if (min == INF)
			System.out.println(-1);
		else {
			System.out.println(min);
			printSol(0);
			System.out.print(sb);
		}
	}

	private static void printSol(int curr) {
		int min = INF;
		for (int i = 0; i < m; i++) {
			if (table1[curr][i] != 0) {
				min = Math.min(min, 1 + getMin(curr + table1[curr][i]));
				if (min == DP[curr]) {
					sb.append((i + 1) + " " + (i + table1[curr][i]));
					sb.append("\n");
					printSol(curr + table1[curr][i]);
					return;
				}
			}
			if (table2[curr][i] != 0) {
				min = Math.min(min, 1 + getMin(curr + table2[curr][i]));
				if (min == DP[curr]) {
					sb.append((m - i) + " "
							+ (m - i - table2[curr][i] + 1));
					sb.append("\n");
					printSol(curr + table2[curr][i]);
					return;
				}
			}
		}
	}
}
