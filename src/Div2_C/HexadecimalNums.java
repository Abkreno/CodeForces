package Div2_C;

import java.util.Scanner;

public class HexadecimalNums {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		int i = 0;
		while (n != 0) {
			int ld = (n % 10 > 0 || test(n / 10)) ? 1 : 0;
			n /= 10;

			res += (1 << i++) * ld;

		}
		System.out.println(res);
	}

	private static boolean test(int n) {
		while (n != 0) {
			if (n % 10 > 1)
				return true;
			n = n/10;
		}
		return false;
	}
}
