package Div1_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IgorInTheMuseum {
	static int n, m;
	static char[][] grid = new char[1000][];
	static int[][] DP = new int[1000][1000];
	static int moveI[] = new int[] { 1, -1, 0, 0 };
	static int moveJ[] = new int[] { 0, 0, 1, -1 };
	static int value[] = new int[100005];
	static int currIndex;
	static boolean first;

	static int dfs(int i, int j) {
		grid[i][j] = '0';
		if (DP[i][j] != -1)
			return value[DP[i][j]];
		int nI, nJ, ans = 0;
		for (int x = 0; x < moveI.length; x++) {
			nI = i + moveI[x];
			nJ = j + moveJ[x];
			if (!inBounds(nI, nJ))
				continue;
			if (grid[nI][nJ] == '*') {
				ans++;
			}
			if (grid[nI][nJ] == '.')
				ans += dfs(nI, nJ);
		}
		DP[i][j] = currIndex;
		return ans;
	}

	private static boolean inBounds(int nI, int nJ) {
		return nI < n && nI >= 0 && nJ < m && nJ >= 0;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < DP.length; i++) {
			Arrays.fill(DP[i], -1);
		}
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		for (int i = 0; i < n; i++) {
			grid[i] = bf.readLine().toCharArray();
		}
		int k = Integer.parseInt(l[2]);
		int a, b, t;
		currIndex = 0;
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < k; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			if (DP[a][b] == -1) {
				t = value[currIndex] = dfs(a, b);
				currIndex++;
			} else
				t = value[DP[a][b]];
			ans.append(t + "\n");
		}
		System.out.print(ans);
	}
}
