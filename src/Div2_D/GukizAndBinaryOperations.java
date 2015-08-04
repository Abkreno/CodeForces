package Div2_D;

import java.util.Scanner;

public class GukizAndBinaryOperations {
	static long n, k, m;
	static int l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		k = sc.nextLong();
		l = sc.nextInt();
		m = sc.nextLong();
		if (m == 1 || l < 63 && (1L << l) <= k) {
			System.out.println(0);
			return;
		}
		if (l == 0) {
			if (k == 0)
				System.out.println(1);
			else
				System.out.println(0);
			return;
		}
		long fib = fib(n);
		long pow = fastPower(2, n);
		long res = 1;
		for (int i = 0; i < l; i++) {
			if (((1l << i) & k) == 0) {
				res *= fib;
				res %= m;
			} else {
				res *= (pow - fib);
				res %= m;
			}
		}
		if (res < 0)
			res += m;
		System.out.println(res);
	}

	static long fastPower(long base, long exponent) {
		if (exponent == 0)
			return 1;
		long x = fastPower(base, exponent >> 1);
		x = x * x % m;
		if ((exponent & 1) != 0)
			x = x * base % m;
		return x;
	}

	static long fib(long n) {
		Matrix[] pow = new Matrix[64];
		pow[0] = new Matrix();
		pow[0].M[0][0] = pow[0].M[0][1] = pow[0].M[1][0] = 1;
		for (int i = 1; i < pow.length; i++) {
			pow[i] = multiply(pow[i - 1], pow[i - 1]);
		}
		int i = 0;
		Matrix res = new Matrix();
		res.M[0][0] = res.M[0][1] = 1;
		while (n > 0) {
			if ((n & 1) > 0) {
				Matrix temp = res;
				res = multiply(temp, pow[i]);
			}
			n >>= 1;
			i++;
		}
		return res.M[0][0];
	}

	static class Matrix {
		long M[][] = new long[2][2];

		Matrix() {

		}
	}

	static Matrix multiply(Matrix m1, Matrix m2) {
		Matrix res = new Matrix();
		res.M[0][0] = (m1.M[0][0] * m2.M[0][0] + m1.M[0][1] * m2.M[1][0]) % m;
		res.M[0][1] = (m1.M[0][0] * m2.M[0][1] + m1.M[0][1] * m2.M[1][1]) % m;
		res.M[1][0] = (m1.M[1][0] * m2.M[0][0] + m1.M[1][1] * m2.M[1][0]) % m;
		res.M[1][1] = (m1.M[1][0] * m2.M[0][1] + m1.M[1][1] * m2.M[1][1]) % m;
		return res;
	}
}