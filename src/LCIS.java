import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCIS {
	static int n1[], n2[];
	static int DP[][];
	static int max = -1, s, s1;

	static int LCIS(int c1, int c2, int prev) {
		if (c1 >= n1.length || c2 >= n2.length)
			return 0;
		if (prev < n1[c1] && DP[c1][c2] != -1)
			return DP[c1][c2];
		int call = 0;
		if (n1[c1] > prev && n1[c1] == n2[c2]) {
			call = 1 + LCIS(c1 + 1, c2 + 1, n1[c1]);

		}
		if (n1[c1] > prev) {
			call = Math.max(call, LCIS(c1, c2 + 1, prev));
		}
		if (n2[c2] > prev) {
			call = Math.max(call, LCIS(c1 + 1, c2, prev));
		}
		if (call > max) {
			max = call;
			s = c1;
			s1 = c2;
		}
		return DP[c1][c2] = call;
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
		if (DP[c1][c2] == count && n1[c1] > prev && n1[c1] == n2[c2]) {
			res += n1[c1] + " ";
			print(c1 + 1, c2 + 1, n1[c1], count - 1);
			if (done)
				return;
			res = "";
		}
		if (n1[c1] > prev) {
			print(c1, c2 + 1, prev, count);
			if (done)
				return;
		}
		if (n2[c2] > prev) {
			print(c1 + 1, c2, prev, count);
			if (done)
				return;
		}
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
		DP = new int[n][m];
		for (int i = 0; i < DP.length; i++) {
			Arrays.fill(DP[i], -1);
		}
		int result = LCIS(0, 0, -1);
		System.out.println(result);
		print(s, s1, -1, result);
	}
}