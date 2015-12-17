package Div2_C;

import java.util.Scanner;

public class LuckySum {
	static int currLen = 1, currN = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		long currL = l, nextLucky;
		long res = 0;
		while (currL <= r) {
			nextLucky = generateLucky();
			if (Math.min(nextLucky, r) - currL >= 0) {
				res += (Math.min(nextLucky, r) - currL + 1) * nextLucky;
				currL = nextLucky + 1;
			}
		}
		System.out.println(res);
	}

	static long generateLucky() {
		if (currN == (1 << currLen)) {
			currN = 0;
			currLen++;
		}
		long k = 1;
		long lucky = 0;
		int n = currN;
		for (int i = 0; i < currLen; i++) {
			if (n % 2 == 0) {
				lucky += 4 * k;
			} else {
				lucky += 7 * k;
			}
			n >>= 1;
			k = k * 10;
		}
		currN++;
		return lucky;
	}
}
