package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoadBalancing {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		if (n == 1) {
			System.out.println(0);
			return;
		}
		int nums[] = new int[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
			sum += nums[i];
		}
		int goal = (int) (sum / n);
		int ans = 0;
		int have = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > goal) {
				have += nums[i] - (goal + 1);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < goal) {
				ans += goal - nums[i];
			}
		}

		System.out.println(Math.max(have, ans));

	}
}
