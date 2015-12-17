package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WariorAndArcher {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] nums = new int[n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(nums);
		int ans = nums[n - 1] - nums[0];
		for (int i = 0; i < l.length; i++) {
			if (i + n / 2 >= n)
				break;
			ans = Math.min(ans, nums[i + n / 2] - nums[i]);
		}
		System.out.println(ans);
	}
}
