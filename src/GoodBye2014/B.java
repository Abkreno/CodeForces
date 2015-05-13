package GoodBye2014;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[] = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		boolean[][] A = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			char[] x = bf.readLine().toCharArray();
			for (int j = 0; j < x.length; j++) {
				if (x[j] == '1')
					A[i][j] = true;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (i == j)
					continue;
				if (nums[i] > nums[j] && A[i][j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					i = -1;
					break;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
