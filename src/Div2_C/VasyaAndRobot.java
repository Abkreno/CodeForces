package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VasyaAndRobot {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line[] = bf.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int l = Integer.parseInt(line[1]);
		int r = Integer.parseInt(line[2]);
		int Ql = Integer.parseInt(line[3]);
		int Qr = Integer.parseInt(line[4]);
		line = bf.readLine().split(" ");
		int sums[] = new int[n + 1];
		sums[1] = Integer.parseInt(line[0]);
		for (int i = 1; i < line.length; i++) {
			sums[i + 1] = sums[i] + Integer.parseInt(line[i]);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			int curr = sums[i] * l + (sums[n] - sums[i]) * r;
			if (i > n - i)
				curr = curr + (2 * i - n - 1) * Ql;
			if (i < n - i)
				curr = curr + (n - 2 * i - 1) * Qr;
			ans = Math.min(ans, curr);

		}
		System.out.println(ans);

	}
}
