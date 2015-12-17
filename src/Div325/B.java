package Div325;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	static int n, crossings[][], sums[][];
	static int cost[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		crossings = new int[2][n - 1];
		sums = new int[2][n];
		cost = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			crossings[0][i] = Integer.parseInt(l[i]);
		}
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			crossings[1][i] = Integer.parseInt(l[i]);
		}
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			cost[i] = Integer.parseInt(l[i]);
		}

		for (int i = 1; i < n; i++) {
			sums[0][i] += crossings[0][i - 1] + sums[0][i - 1];
			sums[1][i] += crossings[1][i - 1] + sums[1][i - 1];
		}
		int sumSoFar = 0, sum2, temp, total, ans = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			// go up then most left
			temp = sumSoFar + cost[i] + sums[0][i];
			sum2 = 0;
			for (int j = 0; j < n; j++) {
				if (j != i) {
					total = temp + cost[j] + sums[1][n - 1] + sum2;
					if (j > 0)
						total -= sums[1][j];
					ans = Math.min(total, ans);
				}
				if (j < n - 1)
					sum2 += crossings[0][j];
			}
			if (i > 0)
				sumSoFar += crossings[1][i-1];
		}
		System.out.println(ans);

	}
}
