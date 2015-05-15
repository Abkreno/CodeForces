package Div274;

import java.util.Scanner;

public class B {
	static long cnt1, cnt2, x, y, xy;

	static boolean check2(long mid) {
		long count = mid - (mid / xy);
		count = count - (mid / x);
		if (count >= cnt1) {
			long c2 = mid / x;
			count = count - Math.max(cnt1, (mid / y));
			if (count >= cnt2 - c2)
				return true;
		}
		return false;
	}

	static boolean check(long mid) {

		long ans1 = mid / y - (mid / (y * x));
		long ans2 = mid / x - (mid / (y * x));
		long sup = mid - (ans1 + ans2) - (mid / (x * y));

		if (ans2 > cnt2)
			ans2 = cnt2;
		if (ans1 > cnt1)
			ans1 = cnt1;

		if (cnt1 + cnt2 <= sup + ans1 + ans2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cnt1 = sc.nextLong();
		cnt2 = sc.nextLong();
		x = sc.nextLong();
		y = sc.nextLong();
		xy = x * y;
		// long lo = cnt1 + cnt2;
		// long hi = 1000000000000000000L;
		long lo = 1;
		long hi = 1000000000000000000L;
		while (lo < hi - 1) {
			long mid = (lo + hi) / 2;
			if (check(mid)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		System.out.println(hi);

	}
}
