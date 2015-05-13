package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ladder {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int q = Integer.parseInt(l[1]);
		int nums[] = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = i;
			dp[i] = i;
		}
		boolean asc = true;
		int start = 0;
		int temp = nums[0];
		int magic = 0;
		for (int i = 1; i < n; i++) {
			if (asc && nums[i] >= temp) {
				temp = nums[i];
				if (nums[magic] < nums[i])
					magic = i;
			} else if (!asc && nums[i] <= temp) {
				temp = nums[i];
				if (nums[magic] > nums[i])
					magic = i;
			} else if (asc && nums[i] < temp) {
				temp = nums[i];
				magic = i;
				asc = false;
			} else {
				temp = nums[i];
				for (int j = start; j < i; j++) {
					dp[j] = i - 1;
				}
				start = magic;
				asc = true;
			}
		}
		for (int j = start; j < n; j++) {
			dp[j] = n - 1;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < q; i++) {
			l = bf.readLine().split(" ");
			sb.append(((dp[Integer.parseInt(l[0]) - 1] >= Integer
					.parseInt(l[1]) - 1) ? "Yes" : "No") + "\n");
		}
		System.out.print(sb);
	}
}
