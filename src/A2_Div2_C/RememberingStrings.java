package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RememberingStrings {
	static char[][] c;
	static boolean[][] changed;
	static int n, m;
	static int MASK;
	static int INF = 1000000000;
	static int[][] cost;
	static int[][] DP;

	static int getMin(int col, int mask) {
		if (mask == MASK)
			return 0;
		if (col >= m)
			return INF;
		if (DP[col][mask] != -1)
			return DP[col][mask];
		int min = getMin(col + 1, mask);
		for (int i = 0; i < n; i++) {
			if (!changed[i][col]) {
				changed[i][col] = true;
				int or = getMarked(col, c[i][col]);
				min = Math.min(min,
						cost[i][col] + getMin(col, mask | or | (1 << i)));
				min = Math.min(min,
						cost[i][col] + getMin(col + 1, mask | or | (1 << i)));
				changed[i][col] = false;
			}
		}
		return DP[col][mask] = min;
	}

	private static int getMarked(int col, char d) {
		int ind = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (c[i][col] == d && !changed[i][col]) {
				ind = i;
				count++;
			}
		}
		return count == 1 ? (1 << ind) : 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		MASK = (1 << n) - 1;
		m = Integer.parseInt(l[1]);
		c = new char[n][m];
		cost = new int[n][m];
		changed = new boolean[n][m];
		DP = new int[m][MASK];
		for (int i = 0; i < m; i++) {
			Arrays.fill(DP[i], -1);
		}
		for (int i = 0; i < n; i++) {
			c[i] = bf.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			for (int j = 0; j < l.length; j++) {
				cost[i][j] = Integer.parseInt(l[j]);
			}
		}
		int good = 0;
		for (int i = 0; i < n; i++) {
			int currBit = getState(0, i);
			good |= (currBit << i);
		}
		System.out.println(getMin(0, good));
	}

	private static int getState(int mask, int row) {
		for (int col = 0; col < m; col++) {
			boolean f = false;
			for (int i = 0; i < n; i++) {
				if ((mask & (1 << i)) == 0 && row != i
						&& c[i][col] == c[row][col]) {
					f = true;
					break;
				}
			}
			if (!f)
				return 1;
		}
		return 0;
	}
}
