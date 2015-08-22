package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MrKitayutaTheTreasureHunter {
	static int N = 30001;
	static int[] nums = new int[N + 1];
	static int[][] DP = new int[N + 1][501];
	static int D;

	static int getMax(int curr, int d) {
		if (d <= 0 || curr > N)
			return 0;
		int dd = d - D + 250;
		if (DP[curr][dd] != -1)
			return DP[curr][dd];
		return DP[curr][dd] = nums[curr]
				+ Math.max(
						getMax(curr + d, d),
						Math.max(getMax(curr + d - 1, d - 1),
								getMax(curr + d + 1, d + 1)));
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < DP.length; i++) {
			Arrays.fill(DP[i], -1);
		}
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		D = Integer.parseInt(l[1]);
		for (int i = 0; i < n; i++) {
			nums[Integer.parseInt(bf.readLine())]++;
		}
		if (D == 1) {
			System.out.println(n);
			return;
		}
		System.out.println(getMax(D, D));
	}
}
