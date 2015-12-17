package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SerejaAndSwaps {
	static int k;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		k = Integer.parseInt(l[1]);
		int nums[] = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int bestMax = Integer.MIN_VALUE;
		int sumSoFar = 0;
		for (int start = 0, end; start < nums.length; start++) {
			sumSoFar = 0;
			for (int i = start; i < nums.length; i++) {
				sumSoFar += nums[i];
				end = i;
				bestMax = Math
						.max(bestMax,
								getBest(Arrays
										.copyOfRange(nums, start, end + 1),
										Arrays.copyOfRange(nums, 0, start),
										Arrays.copyOfRange(nums, end + 1, n),
										sumSoFar,k));
			}
		}
		System.out.println(bestMax);
	}

	private static int getBest(int[] orignal, int[] left, int[] right, int sum,int k) {
		Arrays.sort(orignal);
		Arrays.sort(left);
		Arrays.sort(right);
		int p1 = left.length - 1;
		int p2 = right.length - 1;
		for (int i = 0; i < orignal.length; i++) {
			if (k == 0)
				break;
			if (p1 < 0 && p2 < 0)
				break;
			if ((p1 >= 0 && p2 < 0) || (p1 >= 0 && left[p1] > right[p2])) {
				if (left[p1] <= orignal[i])
					break;
				sum -= orignal[i];
				sum += left[p1--];
				k--;
			} else {
				if (right[p2] <= orignal[i])
					break;
				sum -= orignal[i];
				sum += right[p2--];
				k--;
			}
		}
		return sum;
	}
}
