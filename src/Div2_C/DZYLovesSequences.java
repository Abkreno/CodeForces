package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DZYLovesSequences {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int nums[] = new int[n];
		String l[] = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int prev = -1;
		int start = 0;
		int lis[] = new int[n];
		Arrays.fill(lis, -1);
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] > prev) {
				prev = nums[i];
				if (i + 1 == n) {
					lis[start] = i - start + 1;
					max = Math.max(lis[start], max);
				}
			} else if (nums[i] <= prev) {
				lis[start] = i - start;
				max = Math.max(lis[start], max);
				start = i;
				prev = nums[i];
				if (i + 1 == n) {
					lis[start] = 1;
					max = Math.max(lis[start], max);
				}
			}

		}
		int nextInd;
		for (int i = 0; i < lis.length; i++) {
			if (lis[i] != -1) {
				if (i + lis[i] < n) {
					nextInd = i + lis[i];
					if (lis[nextInd] >= 1) {
						max = Math.max(max, lis[i] + 1);
					}
					max = Math.max(lis[nextInd]+1, max);
					if (lis[nextInd] > 1
							&& nums[nextInd + 1] - nums[nextInd - 1] > 1) {
						max = Math.max(max, lis[i] + lis[nextInd]);
					}

					if (lis[i] == 1 || nums[nextInd] - nums[nextInd - 2] > 1) {
						max = Math.max(max, lis[i] + lis[nextInd]);
					}

				}
			}
		}
		System.out.println(max);
	}
}
