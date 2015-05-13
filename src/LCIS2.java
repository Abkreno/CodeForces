import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCIS2 {
	static int n1[], n2[];
	static int DP[][][];

	static int LCIS(int c1, int c2, int prev) {
		System.out.println(1);
		if (c1 >= n1.length || c2 >= n2.length)
			return 0;

		if (prev != -1 && DP[c1][c2][prev] != -1)
			return DP[c1][c2][prev];
		int call = 0;
		if ((prev == -1 || n1[c1] > n1[prev]) && n1[c1] == n2[c2]) {
			call = 1 + LCIS(c1 + 1, c2 + 1, c1);
		}
		if (prev == -1 || n1[c1] > n1[prev]) {
			call = Math.max(call, LCIS(c1, c2 + 1, prev));
		}
		if (prev == -1 || n2[c2] > n1[prev]) {
			call = Math.max(call, LCIS(c1 + 1, c2, prev));
		}
		if (prev != -1)
			DP[c1][c2][prev] = call;
		return call;
	}

	static boolean done;
	static String res = "";

	static void print(int c1, int c2, int prev, int count) {
		if (count == 0) {
			done = true;
			System.out.println(res);
			return;
		}
		if (c1 >= n1.length || c2 >= n2.length)
			return;
		if ((prev == -1 || DP[c1][c2][prev] == count)
				&& (prev == -1 || n1[c1] > n1[prev]) && n1[c1] == n2[c2]) {
			res += n1[c1] + " ";
			print(c1 + 1, c2 + 1, c1, count - 1);
			if (done)
				return;
			res = "";
		}
		print(c1 + 1, c2 + 1, prev, count);
		if (done)
			return;
		print(c1, c2 + 1, prev, count);
		if (done)
			return;
		print(c1 + 1, c2, prev, count);
		if (done)
			return;

	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		n1 = new int[n];
		String l[] = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			n1[i] = Integer.parseInt(l[i]);
		}

		int m = Integer.parseInt(bf.readLine());
		n2 = new int[m];
		l = bf.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			n2[i] = Integer.parseInt(l[i]);
		}
		DP = new int[n][m][n];
		for (int i = 0; i < DP.length; i++) {
			for (int j = 0; j < DP[i].length; j++) {
				Arrays.fill(DP[i][j], -1);
			}
		}
		int result = LCIS(0, 0, -1);
		System.out.println(result);
		print(0, 0, -1, result);
	}
}