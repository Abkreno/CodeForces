package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div319C {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		boolean nums[] = new boolean[n + 1];
		Arrays.fill(nums, true);
		for (int i = 2; i < nums.length; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0 && i / j != j) {
					if((i/j)%j!=0&&j%(i/j)!=0)
					nums[i] = false;
				}
			}
		}
		StringBuilder ans = new StringBuilder();
		int res = 0;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i]) {
				res++;
				ans.append(i + " ");
			}
		}
		System.out.println(res + "\n" + ans);
	}

}