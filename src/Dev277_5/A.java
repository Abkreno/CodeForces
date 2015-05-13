package Dev277_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
	static int[] girls, boys;
	static int n, m;
	static int[][] DP;
	static boolean vis[];

	static int Maxmize(int i, int k) {
		if (i >= n || k >= m)
			return 0;
		if (DP[i][k] != -1)
			return DP[i][k];
		int c = 0;
		for (int j = 0; j < m; j++) {
			if (Math.abs(boys[i] - girls[j]) <= 1) {
				if (!vis[j]) {
					vis[j] = true;
					c = Math.max(1 + Maxmize(i + 1, k + 1), c);
					vis[j] = false;
				}
			} else if (girls[j] > boys[i] + 1) {
				break;
			}
		}
		return DP[i][k] = Math.max(c, Maxmize(i + 1, k));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		boys = new int[n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < boys.length; i++) {
			boys[i] = Integer.parseInt(l[i]);
		}
		m = Integer.parseInt(bf.readLine());
		vis = new boolean[m];
		l = bf.readLine().split(" ");
		girls = new int[m];
		DP = new int[n][m];
		for (int i = 0; i < girls.length; i++) {
			girls[i] = Integer.parseInt(l[i]);
		}
		for (int i = 0; i < DP.length; i++) {
			Arrays.fill(DP[i], -1);
		}
		Arrays.sort(boys);
		Arrays.sort(girls);

		System.out.println(Maxmize(0, 0));
	}
}
