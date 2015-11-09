import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div243B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		char[][] grid = new char[n][m];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = bf.readLine().toCharArray();
		}
		lop: for (int currLen = 0; currLen < n; currLen++) {
			int curr = currLen;
			while (true) {
				int tR = 0;
				int bR = curr * 2 + 1;
				if (bR >= n)
					break;
				while (tR < bR) {
					if (!comp(grid[tR], grid[bR]))
						continue lop;
					tR++;
					bR--;
				}
				if (curr * 2 + 1 == n - 1) {
					System.out.println(currLen + 1);
					return;
				}
				curr = curr * 2 + 1;
			}
		}
		System.out.println(n);
	}

	private static boolean comp(char[] cs, char[] cs2) {
		for (int i = 0; i < cs2.length; i++) {
			if (cs[i] != cs2[i])
				return false;
		}
		return true;
	}

}
