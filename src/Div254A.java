import java.util.Scanner;

public class Div254A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		char[][] grid = new char[n][m];
		for (int i = 0; i < n; i++) {
			grid[i] = sc.nextLine().toCharArray();
		}
		boolean wb = true;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '.')
					grid[i][j] = wb ? 'W' : 'B';
				wb = !wb;
			}
			if (m % 2 == 0)
				wb = !wb;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j <m; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
