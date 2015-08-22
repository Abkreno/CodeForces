package A2_Div2_C;

import java.util.Scanner;

public class MUHAndHouseOfCards {
	static long sums[] = new long[816498];

	static void init() {
		for (int i = 1; i < sums.length; i++) {
			sums[i] = (3 * (i)) - 1 + sums[i - 1];
		}
	}

	public static void main(String[] args) {
		init();
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int ans = 0;
		for (int i = 1; i < sums.length; i++) {
			if (n < sums[i])
				break;
			if ((n - sums[i]) % 3 == 0)
				ans++;
		}
		System.out.println(ans);
	}
}
