package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SortinRailWaysCars {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int longest_incresing[] = new int[n + 1];
		int ans = n;
		for (int i = 0; i < n; i++) {
			longest_incresing[nums[i]] = 1 + longest_incresing[nums[i] - 1];
			ans = Math.min(ans, n - longest_incresing[nums[i]]);
		}
		System.out.println(ans);
	}
}
