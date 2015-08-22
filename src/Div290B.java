import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div290B {
	static char[][] grid;
	static int nI[] = new int[] { -1, 1, 0, 0 };
	static int nJ[] = new int[] { 0, 0, -1, 1 };
	static int visited[][];
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		grid = new char[n][];
		for (int i = 0; i < n; i++) {
			grid[i] = bf.readLine().toCharArray();
		}
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0) {
					if (dfs(i, j, -1, -1)) {
						System.out.println("Yes");
						return;
					}
					i = -1;
					break;
				}
			}
		}
		System.out.println("No");
	}

	static boolean inBounds(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}

	static boolean dfs(int i, int j, int pI, int pJ) {
		visited[i][j]++;
		if (visited[i][j] == 2)
			return true;
		int ni, nj;
		for (int k = 0; k < 4; k++) {
			if (inBounds(i + nI[k], j + nJ[k])) {
				ni = i + nI[k];
				nj = j + nJ[k];
				if (ni == pI && nj == pJ)
					continue;
				if (grid[ni][nj] == grid[i][j]) {
					if (dfs(ni, nj, i, j))
						return true;
				}
			}
		}
		return false;
	}
}
