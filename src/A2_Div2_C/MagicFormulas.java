package A2_Div2_C;

import java.util.Scanner;

public class MagicFormulas {
	static long xorTill(long n) {
		if (n == 0)
			return 0;
		if (n % 4 == 1)
			return 1;
		if (n % 4 == 2)
			return 3 + (4 * (n / 4));
		if (n % 4 == 3)
			return 0;
		return (4 * (n / 4));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long xor = 0;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			xor ^= sc.nextLong();
		}
		for (int i = 2; i <= n; i++) {
			long xTill = xorTill(i - 1);
			if ((n / i) % 2 == 0)
				xTill ^= xTill;
			xTill ^= xorTill(n % i);
			xor ^= xTill;
		}
		System.out.println(xor);

	}

}
