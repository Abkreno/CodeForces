package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeatifulFunc {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		int sumX = 0;
		int sumY = 0;
		int minAbs[] = new int[n];
		int maxAbs[] = new int[n];
		int minX[] = new int[n];
		int maxX[] = new int[n];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			int x = Integer.parseInt(l[0]);
			int y = Integer.parseInt(l[1]);
			int r = Integer.parseInt(l[2]);
			minX[i] = x - r;
			maxX[i] = x + r;
			minAbs[i] = y - r;
			maxAbs[i] = y + r;

		}
		boolean all[] = new boolean[n];
		int abs;
		int a = 0;
		for (int c = 0; c <= 50; c++) {
			Arrays.fill(all, false);
			for (int t = 0; t <= 50; t++) {
				abs = Math.abs(t - c);
				for (int i = 0; i < n; i++) {
					if (t >= minX[i] && t <= maxX[i] && abs >= minAbs[i]
							&& abs <= maxAbs[i]) {
						all[i] = true;
					}
				}
			}
			if (checkAll(all)) {
				a = c;
				break;
			}
		}

		System.out.println("t");
		if (a < 0) {
			System.out.println("abs((t+" + (-1 * a) + "))");
		} else {
			System.out.println("abs((t-" + a + "))");
		}
	}

	private static boolean checkAll(boolean[] all) {
		for (int i = 0; i < all.length; i++) {
			if (!all[i])
				return false;
		}
		return true;
	}
}
