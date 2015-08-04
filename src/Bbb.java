import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bbb {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int max = (n / 2 + n % 2) * (n / 2 + n % 2);
		max += (n / 2) * (n / 2);
		if (k > max) {
			System.out.println("NO");
			return;
		}
		char[][] grid = new char[n][n];
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(grid[i], 'S');
		}
		int count = 0;
		loop: for (int i = 0; i < n; i++) {
			for (int j = i % 2; j < n; j += 2) {
				if (count == k)
					break loop;
				grid[i][j] = 'L';
				count++;
			}
		}
		System.out.println("YES");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}
