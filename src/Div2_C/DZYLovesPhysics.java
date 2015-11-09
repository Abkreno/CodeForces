package Div2_C;

import java.util.Scanner;

public class DZYLovesPhysics {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		double max = 0;
		int a, b;
		double c;
		for (int i = 0; i < m; i++) {
			a = sc.nextInt() - 1;
			b = sc.nextInt() - 1;
			c = sc.nextDouble();
			max = Math.max(max, ((double) (nums[a] + nums[b])) / c);
		}
		System.out.println(max);
	}
}
