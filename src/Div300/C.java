package Div300;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		long n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		long nums[][] = new long[2][m];
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			nums[0][i] = Integer.parseInt(l[0]);
			nums[1][i] = Integer.parseInt(l[1]);

		}

		long max = nums[1][0] + nums[0][0] - 1, d1, d2, h1, h2, need, have, left;

		for (int i = 0; i < m - 1; i++) {
			d1 = nums[0][i];
			d2 = nums[0][i + 1];
			h1 = nums[1][i];
			h2 = nums[1][i + 1];
			need = Math.abs(h2 - h1);
			have = d2 - d1;
			if (need > have) {
				System.out.println("IMPOSSIBLE");
				return;
			} else {
				left = have - need;
				max = Math.max(max, Math.max(h1, h2) + left / 2);
			}
		}
		max = Math.max(max, n - nums[0][m - 1] + nums[1][m - 1]);
		System.out.println(max);
	}
}
