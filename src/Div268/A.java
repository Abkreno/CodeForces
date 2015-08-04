package Div268;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	static boolean moments[] = new boolean[1001];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] l = bf.readLine().split(" ");
		int p = Integer.parseInt(l[0]);
		int q = Integer.parseInt(l[1]);
		int L = Integer.parseInt(l[2]);
		int R = Integer.parseInt(l[3]);
		int[][] ab = new int[2][p];
		int[][] cd = new int[2][q];

		for (int i = 0; i < p; i++) {
			l = bf.readLine().split(" ");
			ab[0][i] = Integer.parseInt(l[0]);
			ab[1][i] = Integer.parseInt(l[1]);
		}

		for (int i = 0; i < q; i++) {
			l = bf.readLine().split(" ");
			cd[0][i] = Integer.parseInt(l[0]);
			cd[1][i] = Integer.parseInt(l[1]);
		}
		long ans = 0;
		for (int i = 0; i < q; i++) {
			for (int k = 0; k < p; k++) {
				for (int j = L; j <= R; j++) {
					if (intersects(cd[0][i] + j, cd[1][i] + j, ab[0][k],
							ab[1][k]))
						moments[j] = true;
				}
			}
		}
		for (int i = 0; i < moments.length; i++) {
			if (moments[i])
				ans++;
		}
		System.out.println(ans);
	}

	private static boolean intersects(int i, int j, int l, int r) {
		int k = Math.max(i, l);
		return k <= Math.min(j, r);
	}
}
