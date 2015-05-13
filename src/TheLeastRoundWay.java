import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheLeastRoundWay {
	static long[][] values;
	static int n;
	static int[][][] DP;

	static int count(long p) {
		int res = 0;
		while (p != 0) {
			if (p % 10 == 0)
				res++;
			p /= 10;
		}
		return res;
	}

	static int INF = 1000000;

	static int countZeros(int x, int y, long p, int direction) {
		if (x >= n || y >= n)
			return INF;
		if (x == n - 1 && y == n - 1)
			return count(p);
		if (DP[x][y][direction] != -1)
			return DP[x][y][direction];
		int min = countZeros(x + 1, y, p * values[x][y], 1);
		min = Math.min(min, countZeros(x, y + 1, p * values[x][y], 0));
		return DP[x][y][direction] = min;
	}

	static void visit(int x, int y, long p, String path) {
		if (x >= n || y >= n)
			return;
		if (x == n - 1 && y == n - 1) {
			System.out.println(path);
			System.out.println(p);
			return;
		}
		visit(x + 1, y, p * values[x][y], path + "R");
		visit(x, y + 1, p * values[x][y], path + "D");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		values = new long[n][n];
		DP = new int[n][n][2];
		for (int i = 0; i < DP.length; i++) {
			for (int j = 0; j < DP.length; j++) {
				Arrays.fill(DP[i][j], -1);
			}
		}
		for (int i = 0; i < n; i++) {
			String l[] = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				values[i][j] = Integer.parseInt(l[j]);
			}
		}
		System.out.println(countZeros(0, 0, 1, 0));
	}
}
