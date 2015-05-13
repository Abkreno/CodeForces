package A2_Div2_C;

import java.util.Scanner;

public class Hamburgers {
	static int nb, ns, nc, pb, ps, pc, bC, sC, cC;
	static long r;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] sand = sc.nextLine().toCharArray();
		nb = sc.nextInt();
		ns = sc.nextInt();
		nc = sc.nextInt();
		pb = sc.nextInt();
		ps = sc.nextInt();
		pc = sc.nextInt();
		r = sc.nextLong();
		sc.close();
		bC = 0;
		cC = 0;
		sC = 0;
		for (int i = 0; i < sand.length; i++) {
			if (sand[i] == 'B') {
				bC++;
			} else if (sand[i] == 'C') {
				cC++;
			} else {
				sC++;
			}
		}
		long res = Math.min(cC > 0 ? nc / cC : Long.MAX_VALUE, Math.min(
				bC > 0 ? nb / bC : Long.MAX_VALUE, sC > 0 ? ns / sC
						: Long.MAX_VALUE));
		nb -= (bC * res);
		nc -= (cC * res);
		ns -= (sC * res);

		long lo = 0;
		long hi = (long) Math.pow(10, 12);
		int c = 0;
		while (lo <= hi && c++ < 400) {
			long mid = (lo + hi) / 2;
			if (check(mid)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		if (check(hi))
			lo = hi;
		System.out.println(res + lo);
	}

	static boolean check(long mid) {
		long price = pb * (((mid * bC) - nb) > 0 ? (mid * bC) - nb : 0);
		price += pc * (((mid * cC) - nc) > 0 ? (mid * cC) - nc : 0);
		price += ps * (((mid * sC) - ns) > 0 ? (mid * sC) - ns : 0);
		return price <= r;
	}
}