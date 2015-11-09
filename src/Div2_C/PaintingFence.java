package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaintingFence {
	static int nums[];

	static int minMoves(int l, int r) {
		if (l == r)
			return 1;
		int min = Integer.MAX_VALUE;
		for (int i = l; i <= r; i++) {
			min = Math.min(min, nums[i]);
		}
		int start = -1;
		int m = min;
		for (int i = l; i <= r; i++) {
			nums[i] -= min;
			if (nums[i] > 0) {
				if (start == -1) {
					start = i;
				}
				if (i == r) {
					m += minMoves(start, i);
				}
			} else {
				if (start != -1) {
					m += minMoves(start, i - 1);
					start = -1;
				}
			}
		}
		return Math.min(m, r - l + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		nums = new int[n];
		String[] l = bf.readLine().split(" ");
		int max = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
			max = Math.max(nums[i], max);
		}

		System.out.println(minMoves(0, n - 1));
	}
}
