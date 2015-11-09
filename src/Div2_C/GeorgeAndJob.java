package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GeorgeAndJob {
	static long DP[][] = new long[5002][2501];
	static int n, m, k;
	static long INF = -1000;
	static long p[] = new long[5002];

	static long find(int i, int numOfPairs) {
		if (numOfPairs == 0)
			return 0;
		if (i > n || numOfPairs * m > n - i + 1)
			return INF;
		if (DP[i][numOfPairs] != -1)
			return DP[i][numOfPairs];
		long max = find(i + 1, numOfPairs);
		long c = find(i + m, numOfPairs - 1);
		if (c != INF)
			c += (p[i + m - 1] - p[i - 1]);
		max = Math.max(max, c);
		return DP[i][numOfPairs] = max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		k = Integer.parseInt(l[2]);
		if (m == 1) {
			one(bf.readLine().split(" "));
			return;
		}
		for (int i = 0; i < n + 2; i++) {
			Arrays.fill(DP[i], -1);
		}
		l = bf.readLine().split(" ");
		p[1] = Integer.parseInt(l[0]);
		for (int i = 2; i <= n; i++) {
			p[i] = Integer.parseInt(l[i - 1]);
			p[i] += p[i - 1];
		}
		long call = Math.max(find(1, k), 0);
		System.out.println(call);
	}

	private static void one(String[] l) {
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(p);
		long ans = 0;
		for (int i = p.length - k; i < p.length; i++) {
			ans += ((long) p[i]);
		}
		System.out.println(ans);
	}
}
