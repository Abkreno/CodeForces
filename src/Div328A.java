import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div328A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l;
		int n = 8;
		int m = 8;
		char grid[][] = new char[n][m];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = bf.readLine().toCharArray();
		}
		int bW = 10;
		int bB = 10;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[j][i] == 'W') {
					bW = Math.min(bW, j);
				} else if (grid[j][i] == 'B')
					break;
			}
			for (int j = 7; j >= 0; j--) {
				if (grid[j][i] == 'W')
					break;
				if (grid[j][i] == 'B') {
					bB = Math.min(bB, n - j - 1);
				}
			}
		}
		System.out.println(bW <= bB ? "A" : "B");
	}

}
