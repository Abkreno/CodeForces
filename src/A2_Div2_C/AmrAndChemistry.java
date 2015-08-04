package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AmrAndChemistry {
	static int[] count = new int[200001];
	static long[] cost = new long[200001];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(l[i]);
			add(curr, 0);
			int tmp = curr;
			int j = 0;

			while (tmp < 100000) {
				tmp <<= 1;
				j++;
				addWithShiftR(tmp, j);
			}

			j = 0;
			tmp = curr;
			while (tmp > 1) {
				tmp >>= 1;
				j++;
				add(tmp, j);
			}
		}
		long minMoves = Long.MAX_VALUE;
		int best = 0;
		for (int i = 1; i < cost.length; i++) {
			if (count[i] == n) {
				best = minMoves > cost[i] ? i : best;
				minMoves = Math.min(minMoves, cost[i]);

			}
		}
		System.out.println(minMoves);
	}

	public static void add(int n, long moves) {
		int i = 1;
		long lastShift = 0;
		long s = 0;
		while (n > 0) {
			if ((i & n) > 0) {
				count[n]++;
				cost[n] += moves + (lastShift * 2);
				n &= ~(i);
				lastShift = s + 1;
			}
			s++;
			i <<= 1;
		}
	}

	public static void addWithShiftR(int n, long moves) {
		int i = 1;
		long lastShift = 0;
		long s = 0;
		while (n > 0) {
			if ((i & n) > 0) {
				count[n]++;
				if (lastShift == 0)
					cost[n] += moves;
				else
					cost[n] += moves + ((lastShift - moves + 1) * 2);

				n &= ~(i);
				lastShift = s;
			}
			s++;
			i <<= 1;
		}
	}

}