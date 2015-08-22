import java.util.Scanner;

public class FriendsAndPresents {
	static long c1, c2, x, y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c1 = sc.nextInt();
		c2 = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		long lo = 0;
		long hi = 1000000000000L;
		long mid;
		while (lo + 1 < hi) {
			mid = (lo + hi) >> 1;
			if (check(mid))
				hi = mid;
			else
				lo = mid;
		}
		System.out.println(hi);
	}

	static boolean check(long m) {
		long left = m - (m / y) - (m / x) + (m / (x * y));
		long cn1 = m / y - (m / (x * y));
		if (cn1 + left < c1)
			return false;
		left -= (c1 - cn1) > 0 ? (c1 - cn1) : 0;
		return left + m / x - (m / (x * y)) >= c2;
	}
}
