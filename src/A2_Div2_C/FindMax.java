package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindMax {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		long sums[] = new long[n];
		sums[0] = nums[0] = Integer.parseInt(l[0]);
		for (int i = 1; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
			sums[i] += sums[i - 1] + nums[i];
		}
		char[] m = bf.readLine().toCharArray();
		long sum = 0;
		for (int i = 0; i < m.length; i++) {
			if (m[i] == '1') {
				sum += nums[i];
			}
		}
		long prevSum = 0;
		for (int i = n - 1; i > 0; i--) {
			if (m[i] == '1') {
				sum = Math.max(sum, prevSum + sums[i - 1]);
				prevSum += nums[i];
			}
		}
		System.out.println(sum);
	}
}
