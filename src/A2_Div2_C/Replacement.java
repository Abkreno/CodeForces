package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Replacement {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[] = bf.readLine().split(" ");
		int nums[] = new int[n];
		boolean allOnes = true;
		int max = 0;
		int pos = 0;
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
			if (nums[i] > 1)
				allOnes = false;
			if (nums[i] > max) {
				pos = i;
				max = nums[i];
			}
		}
		if (allOnes) {
			nums[pos] = 2;
		} else {
			nums[pos] = 1;
		}
		Arrays.sort(nums);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i] + " ");
		}
		System.out.println(sb);
	}
}
