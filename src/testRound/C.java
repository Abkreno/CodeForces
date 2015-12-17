package testRound;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		long k = Long.parseLong(l[0]);
		long a = Long.parseLong(l[1]);
		long b = Long.parseLong(l[2]);
		if (k == 1) {
			System.out.println(b - a + 1);
		} else {
			long res = 0;
			if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
				a = a > 0 ? a : -a;
				b = b > 0 ? b : -b;
				if (a > b) {
					long tmp = a;
					a = b;
					b = tmp;
				}
				res = calc(0, b, k) - calc(0, a - 1, k);
			} else if (a == 0) {
				res = calc(0, b, k);
			} else {
				res = calc(0, b, k);
				res += calc(0, -a, k);
				res--;
			}
			System.out.println(res);
		}
	}

	private static long calc(long a, long b, long k) {
		return (b / k) - (a / k) + 1;
	}
}
