package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Barcode {
	static int n, m, x, y;
	static int[] wCost, bCost;
	static int MAX = 10000000;
	static int DP[][][];

	static int getMin(int curr, int k, boolean w) {
		if (curr >= m) {
			if ((k < x || k > y))
				return MAX;
			return 0;
		}
		if (DP[curr][k][w ? 1 : 0] != -1)
			return DP[curr][k][w ? 1 : 0];
		int m = MAX;
		if (k >= y) {
			m = getMin(curr + 1, 1, !w) + (w ? bCost[curr] : wCost[curr]);
		} else {
			m = getMin(curr + 1, k + 1, w) + (w ? wCost[curr] : bCost[curr]);
			if (k==0||k >= x)
				m = Math.min(m, getMin(curr + 1, 1, !w)
						+ (w ? bCost[curr] : wCost[curr]));
		}
		return DP[curr][k][w ? 1 : 0] = m;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		x = Integer.parseInt(l[2]);
		y = Integer.parseInt(l[3]);
		wCost = new int[m];
		bCost = new int[m];
		char[] tmp;
		for (int i = 0; i < n; i++) {
			tmp = bf.readLine().toCharArray();
			for (int j = 0; j < tmp.length; j++) {
				if (tmp[j] == '.')
					wCost[j]++;
				else
					bCost[j]++;
			}
		}
		DP = new int[m][y + 1][2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < y + 1; j++) {
				Arrays.fill(DP[i][j], -1);
			}
		}
		System.out.println(getMin(0, 0, true));
	}
}
