package Div2_C;

import java.util.Scanner;

public class DreamonAndSums {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long mod = 1000000007;
		long c = ((b * (b - 1) / 2) % mod);
		long res = 0;
		for (long i = 1; i <= a; i++) {
			res += (((((b * i + 1) % mod)) % mod) * c) % mod;
			res %= mod;
		}
		System.out.println(res);
	}
}
