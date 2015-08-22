import java.util.ArrayList;
import java.util.Scanner;

public class WonderRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		boolean swap = false;
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
			swap = true;
		}
		if (a * b < n * 6) {
			long n6 = n * 6;
			long ob = b;
			long a1 = n6;
			long b1 = b;
			long s = (long) 1e18;
			for (long i = a; i * i <= n6; i++) {
				long nb = n6 / i + ((n6 % i == 0) ? 0 : 1);
				if (nb < ob)
					continue;
				if (i * nb < s) {
					s = i * nb;
					a1 = i;
					b1 = nb;
				}
			}
			a = a1;
			b = b1;
		}
		if (swap) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		System.out.println(a * b);
		System.out.println(a + " " + b);
	}

	static ArrayList<Long> findDivisors(long n) {
		ArrayList<Long> res = new ArrayList<>();
		for (long i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				res.add(i);
			}
			if (n % i == 0 && n / i != i) {
				res.add(n / i);
			}
		}
		// Collections.sort(res);
		return res;
	}
}
