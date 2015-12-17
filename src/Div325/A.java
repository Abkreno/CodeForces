package Div325;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		int ans = 0;
		int one = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				one = i;
				break;
			}
		}
		if (one != -1) {
			for (int i = one; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] == 1) {
						if (j - i == 2) {
							ans++;
						}
						i = j - 1;
						break;
					} else if (j == n - 1) {
						i = n;
					}
				}
				ans++;
			}
		}
		System.out.println(ans);
	}
}
