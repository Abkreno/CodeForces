package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ToAddOrNotToAdd {
	static int[] nums;
	static long[] prefixSum;
	static int n, K;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String li[] = bf.readLine().split(" ");
		n = Integer.parseInt(li[0]);
		K = Integer.parseInt(li[1]);
		nums = new int[n];
		prefixSum = new long[n];
		li = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(li[i]);
		}
		Arrays.sort(nums);
		prefixSum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] += nums[i] + prefixSum[i - 1];
		}
		int bestCount = 1;
		int bestNum = nums[0];
		for (int i = 0; i < n; i++) {
			int l = 1, r = i + 2;
			while (r - l > 1) {
				int m = (l + r) / 2;
				if (i - m + 1 >= 0
						&& K >= 1L * m * nums[i] - getSum(i - m + 1, i))
					l = m;
				else
					r = m;
			}
			if (bestCount < l) {
				bestCount = l;
				bestNum = nums[i];
			}
		}
		System.out.println(bestCount + " " + bestNum);

	}

	static long getSum(int l, int r) {
		if (l == 0)
			return prefixSum[r];
		return prefixSum[r] - prefixSum[l - 1];
	}
}
