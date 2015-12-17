package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheChildAndToy {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int nums[] = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int res = 0;
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			res += Math.min(nums[Integer.parseInt(l[0])-1], nums[Integer.parseInt(l[1])-1]);
		}
		System.out.println(res);
	}
}
