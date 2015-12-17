package Div327;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		int res[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = res[i] = Integer.parseInt(l[i]);
		}
		int steps = 0;
		int last = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == n - 1 || nums[i] == nums[i + 1]) {
				steps = Math.max(modify(last, i, nums,res), steps);
				last = i + 1;
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append(steps + "\n");
		for (int i = 0; i < nums.length; i++) {
			sb.append(res[i] + " ");
		}
		System.out.println(sb);
	}

	private static int modify(int last, int i, int nums[], int res[]) {
		if (last == i)
			return 0;
		if (nums[last] == nums[i]) {
			for (int j = last; j <= i; j++) {
				res[j] = nums[i];
			}
			return (i - last) / 2;
		} else {
			int m = last + ((i - last) / 2);
			for (int j = last; j <= m; j++) {
				res[j] = nums[last];
			}
			for (int j = m + 1; j < i; j++) {
				res[j] = nums[i];
			}
			return (i - last) / 2;
		}
	}

}