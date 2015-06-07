package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Woodcutters {
	static int[] heights, coordinates;
	static int n;
	static int DP[][] = new int[100000][2];

	static int maxC(int i, boolean right) {
		if (i >= n - 1)
			return 1;
		if (DP[i][right ? 1 : 0] != -1)
			return DP[i][right ? 1 : 0];
		int c = maxC(i + 1, false);
		if (right
				&& (coordinates[i] - heights[i] > coordinates[i - 1]
						+ heights[i - 1])) {
			c = Math.max(c, 1 + maxC(i + 1, false));
		} else if (!right && coordinates[i] - heights[i] > coordinates[i - 1]) {
			c = Math.max(c, 1 + maxC(i + 1, false));
		}
		if (coordinates[i] + heights[i] < coordinates[i + 1]) {
			c = Math.max(c, 1 + maxC(i + 1, true));
		}
		return DP[i][right ? 1 : 0] = c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		heights = new int[n];
		coordinates = new int[n];
		for (int D = 0; D < DP.length; D++) {
			Arrays.fill(DP[D], -1);
		}
		for (int i = 0; i < n; i++) {
			String[] l = bf.readLine().split(" ");
			coordinates[i] = Integer.parseInt(l[0]);
			heights[i] = Integer.parseInt(l[1]);
		}
		System.out.println(n==1?1:1 + maxC(1, false));
	}
}
