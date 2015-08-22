package Div2_D;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DrazilAndTiles {
	static int n, m;

	static boolean inBounds(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		char[][] grid = new char[n][];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = bf.readLine().toCharArray();
		}
		int counts[][] = new int[n][m];
		int nI[] = new int[] { -1, 1, 0, 0 };
		int nJ[] = new int[] { 0, 0, -1, 1 };
		LinkedList<Point> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '*')
					continue;
				for (int k = 0; k < 4; k++) {
					if (inBounds(i + nI[k], j + nJ[k])
							&& grid[i + nI[k]][j + nJ[k]] == '.') {
						counts[i][j]++;
					}
				}
				if (counts[i][j] == 0) {
					System.out.println("Not unique");
					return;
				}
				if (counts[i][j] == 1) {
					list.add(new Point(i, j));
				}

			}
		}
		int ni, nj;
		Point curr;
		int i, j;
		while (!list.isEmpty()) {
			curr = list.pop();
			i = curr.x;
			j = curr.y;
			if (grid[i][j] != '.')
				continue;
			if (counts[i][j] < 1) {
				System.out.println("Not unique");
				return;
			}
			ni = 0;
			nj = 0;
			for (int k = 0; k < 4; k++) {
				if (inBounds(i + nI[k], j + nJ[k])
						&& grid[i + nI[k]][j + nJ[k]] == '.') {
					ni = i + nI[k];
					nj = j + nJ[k];
					break;
				}
			}
			grid[i][j] = getChar(i, j, ni, nj);
			grid[ni][nj] = getChar(ni, nj, i, j);
			for (int k = 0; k < 4; k++) {
				if (inBounds(ni + nI[k], nj + nJ[k])
						&& grid[ni + nI[k]][nj + nJ[k]] == '.') {
					counts[ni + nI[k]][nj + nJ[k]]--;
					if (counts[ni + nI[k]][nj + nJ[k]] == 1) {
						list.add(new Point(ni + nI[k], nj + nJ[k]));
					}
				}
			}
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (grid[i][j] == '.') {
					System.out.println("Not unique");
					return;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				sb.append(grid[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static char getChar(int i, int j, int i2, int j2) {
		if (i == i2) {
			return j < j2 ? '<' : '>';
		}
		if (j == j2) {
			return i < i2 ? '^' : 'v';
		}
		return 0;
	}
}
