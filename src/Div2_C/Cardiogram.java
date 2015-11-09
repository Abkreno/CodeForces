package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cardiogram {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int x[] = new int[n];
		int y[] = new int[n];
		int sumX = 0;
		int sumY = 0;
		int z = 1, curr;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < y.length; i++) {
			curr = Integer.parseInt(l[i]);
			sumX += curr;
			sumY += z * curr;
			z *= -1;
			x[i] = sumX;
			y[i] = sumY + 1000;
			max = Math.max(max, y[i]);
			min = Math.min(min, y[i]);
		}
		char[][] grid = new char[2001][2001];
		int currHeight = 1000;
		int currWidth = 0;
		int minH = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (currHeight < y[i]) {
				while (currHeight < y[i]) {
					grid[currHeight][currWidth] = '/';
					currHeight++;
					currWidth++;
				}
				currHeight--;
			} else {
				while (currHeight >= y[i]) {
					grid[currHeight][currWidth] = '\\';
					currHeight--;
					currWidth++;
				}
				currHeight++;
			}
			maxH = Math.max(maxH, currHeight);
			minH = Math.min(minH, currHeight);

		}
		StringBuffer ans = new StringBuffer();
		for (int i = grid.length - 1; i >= 0; i--) {
			if (good(grid[i])){
				for (int j = 0; j < currWidth; j++) {
					if (grid[i][j] == '\\' || grid[i][j] == '/')
						ans.append(grid[i][j]);
					else
						ans.append(' ');
				}
			ans.append("\n");}
		}
		System.out.print(ans);
	}

	private static boolean good(char[] cs) {
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '\\' || cs[i] == '/')
				return true;
		}
		return false;
	}
}
