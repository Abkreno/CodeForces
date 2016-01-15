package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NewYearDomino {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int h = Integer.parseInt(l[0]);
		int w = Integer.parseInt(l[1]);
		char[][] grid = new char[h + 1][w + 1];
		char[] tmp;
		for (int i = 1; i < grid.length; i++) {
			tmp = bf.readLine().toCharArray();
			for (int j = 1; j <= w; j++) {
				grid[i][j] = tmp[j - 1];
			}
		}
		int hor[][] = new int[h + 1][w + 1];
		int ver[][] = new int[h + 1][w + 1];
		for (int c = 1; c <= w; c++) {
			for (int r = 1; r <= h; r++) {
				ver[r][c] += ver[r - 1][c];
				ver[r][c] += grid[r][c] == '.' && grid[r - 1][c] == '.' ? 1 : 0;
			}
		}
		for (int r = 1; r <= h; r++) {
			for (int c = 1; c <= w; c++) {
				ver[r][c] += ver[r][c - 1];
			}
		}
		for (int r = 1; r <= h; r++) {
			for (int c = 1; c <= w; c++) {
				hor[r][c] += hor[r][c - 1];
				hor[r][c] += grid[r][c] == '.' && grid[r][c - 1] == '.' ? 1 : 0;
			}
		}
		for (int c = 1; c <= w; c++) {
			for (int r = 1; r <= h; r++) {
				hor[r][c] += hor[r - 1][c];
			}
		}
		StringBuffer sb = new StringBuffer();
		int r1, r2, c1, c2, q = Integer.parseInt(bf.readLine());
		long ans;
		for (int i = 0; i < q; i++) {
			l = bf.readLine().split(" ");
			r1 = Integer.parseInt(l[0]);
			c1 = Integer.parseInt(l[1]);
			r2 = Integer.parseInt(l[2]);
			c2 = Integer.parseInt(l[3]);
			ans = ver[r2][c2] - ver[r1][c2];
			ans -= (ver[r2][c1 - 1] - ver[r1][c1 - 1]);
			ans += hor[r2][c2] - hor[r2][c1];
			ans -= (hor[r1 - 1][c2] - hor[r1 - 1][c1]);
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}
}
