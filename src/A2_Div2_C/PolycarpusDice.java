package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PolycarpusDice {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		long A = Long.parseLong(l[1]);
		long sums[] = new long[n];
		long vals[] = new long[n];
		l = bf.readLine().split(" ");
		vals[0] = sums[0] = Integer.parseInt(l[0]);
		if (n == 1) {
			System.out.println(vals[0] - 1);
			return;
		}
		for (int i = 1; i < vals.length; i++) {
			vals[i] = Integer.parseInt(l[i]);
			sums[i] = sums[i - 1] + vals[i];
		}
		StringBuffer ans = new StringBuffer();
		long maxSum, minSum = n - 1;
		long minLeft = A - minSum;
		long minFromOthers, maxFromOthers, currMin, currMax;
		for (int i = 0; i < n; i++) {
			maxSum = sums[n - 1] - vals[i];
			minFromOthers = Math.max(A - vals[i], n - 1);
			maxFromOthers = Math.min(A - 1, maxSum);
			currMin = A - maxFromOthers;
			currMax = A - minFromOthers;
			ans.append((vals[i] - (currMax - currMin + 1)) + " ");
		}
		System.out.println(ans);
	}
}
