import java.util.Arrays;
import java.util.Scanner;

public class Div290A {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] grid = new char[n][m];
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(grid[i], '.');
		}
		boolean f = true;
		for (int i = 0; i < grid.length; i += 2) {
			if (i + 1 != n)
				grid[i + 1][f ? m - 1 : 0] = '#';
			Arrays.fill(grid[i], '#');
			f = !f;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
