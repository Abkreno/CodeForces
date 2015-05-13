package Dev282;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	static long res = 0;
	static long a, b;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		a = Long.parseLong(l[0]);
		b = Long.parseLong(l[1]);
		if (a < b) {
			System.out.println(0);
		} else if (a == b) {
			System.out.println("infinity");
		} else {
			long n = a - b;
			res++;
			for (long i = 2; i <= n / 2; i++) {
				if (n % i == 0) {
					if ((i + 1) * (n / i) > a)
						res++;
				}
			}
			System.out.println(res);
		}
	}
}
