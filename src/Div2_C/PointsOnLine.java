package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PointsOnLine {
	static long nCk(long n, long k) {
		if (n < k)
			return 0;
		long result = n;
		for (int i = 2; i <= k; ++i) {
			result *= (n - i + 1);
			result /= i;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);

		l = bf.readLine().split(" ");
		int nums[] = new int[n];
		int taken[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		long res = 0;
		int minTaken = n;
		for (int i = n - 1; i > 1; i--) {
			int lo = -1;
			int hi = n - 1;
			while (lo + 1 < hi) {
				int mid = (lo + hi) / 2;
				if (nums[i] - nums[mid] <= k) {
					hi = mid;
				} else {
					lo = mid;
				}
			}
			if (hi < minTaken && nums[i] - nums[hi] <= k) {
				res += nCk(i - hi + 1, 3);
				if (minTaken < i)
					res -= nCk(i - minTaken + 1, 3);
				minTaken = hi;
			}
		}
		System.out.println(res);

	}
}
