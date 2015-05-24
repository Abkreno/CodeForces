package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IceCave {
	static int n, m, r1, c1, r2, c2, count;
	static char[][] grid;
	static boolean[][] visted;

	static void dfs(int i, int j) {
		if (visted[i][j])
			return;
		visted[i][j] = true;
		if (checkBounds(i + 1, j))
			dfs(i + 1, j);
		if (checkBounds(i, j - 1))
			dfs(i, j - 1);
		if (checkBounds(i, j + 1))
			dfs(i, j + 1);
		if (checkBounds(i - 1, j))
			dfs(i - 1, j);
	}

	static boolean checkBounds(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m
				&& (grid[i][j] != 'X' || (i == r2 && j == c2));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		grid = new char[n][m];
		visted = new boolean[n][m];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = bf.readLine().toCharArray();
		}
		l = bf.readLine().split(" ");
		r1 = Integer.parseInt(l[0]) - 1;
		c1 = Integer.parseInt(l[1]) - 1;
		l = bf.readLine().split(" ");
		r2 = Integer.parseInt(l[0]) - 1;
		c2 = Integer.parseInt(l[1]) - 1;
		if (check2(r2 + 1, c2))
			count++;
		if (check2(r2 - 1, c2))
			count++;
		if (check2(r2, c2 + 1))
			count++;
		if (check2(r2, c2 - 1))
			count++;
		dfs(r1, c1);
		if (visted[r2][c2]
				&& ((grid[r2][c2] == 'X' && (r1 != r2 || c1 != c2 || (r1 == r2
						&& c1 == c2 && count > 0))) || count > 1)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static boolean check2(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m
				&& (grid[i][j] == '.' || (i == r1 && j == c1));
	}
}
