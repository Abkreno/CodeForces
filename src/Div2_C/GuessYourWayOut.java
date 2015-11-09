package Div2_C;

import java.util.Scanner;

public class GuessYourWayOut {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long h = sc.nextLong();
		long n = sc.nextLong();
		long leafs;
		long ans = 0;
		boolean left = true;
		while (h > 0) {
			leafs = (1L << h);
			if (n > leafs / 2) {
				// on the right
				if (left) {
					ans += numOfNodes(h - 1) + 1;
					left = true;
				} else {
					ans++;
					left = true;
				}
				n -= (1L << (h - 1));
			} else {
				if (left) {
					ans++;
					left = false;
				} else {
					ans += numOfNodes(h - 1) + 1;
					left = false;
				}
			}
			h--;
		}
		System.out.println(ans);
	}

	private static long numOfNodes(long i) {
		long ans = (1L << (i + 1));
		return ans - 1;
	}
}
