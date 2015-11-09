package Div2_C;

import java.util.Scanner;

public class Quiz {
	static long mod = 1000000009;
	static Matrix[] matrices = new Matrix[32];

	static class Matrix {
		long[][] M = new long[2][2];

		void init() {
			M[0][0] = 1;
			M[1][1] = 1;
		}

		public String toString() {
			return M[0][0] + ", " + M[0][1] + "\n" + M[1][0] + ", " + M[1][1];
		}
	}

	static void mult(Matrix res, Matrix m1, Matrix m2) {
		res.M[0][0] = (m1.M[0][0] * m2.M[0][0] + m1.M[0][1] * m2.M[1][0]) % mod;
		res.M[0][1] = (m1.M[0][0] * m2.M[0][1] + m1.M[0][1] * m2.M[1][1]) % mod;
		res.M[1][0] = (m1.M[1][0] * m2.M[0][0] + m1.M[1][1] * m2.M[1][0]) % mod;
		res.M[1][1] = (m1.M[1][0] * m2.M[0][1] + m1.M[1][1] * m2.M[1][1]) % mod;
	}

	static long getMat(long n) {
		for (int i = 0; i < matrices.length; i++) {
			matrices[i] = new Matrix();
		}
		matrices[1].M[0][0] = matrices[1].M[1][0] = 2;
		matrices[1].M[0][1] = 0;
		matrices[1].M[1][1] = 1;
		for (int i = 2; i < 32; i++)
			mult(matrices[i], matrices[i - 1], matrices[i - 1]);
		int e = 1;
		Matrix res = new Matrix();
		res.init();
		Matrix temp = new Matrix();

		while (n > 0) {
			if ((n & 1) > 0) {
				temp = res;
				res = new Matrix();
				mult(res, temp, matrices[e]);
			}
			n >>= 1;
			e++;
		}
		return res.M[1][0] % mod;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		long k = sc.nextLong();
		long have = n % k;
		long numOfGabs = n / k;
		long freeSlots = (n / k) * (k - 1) + n % k;
		if (m <= freeSlots) {
			System.out.println(m);
		} else {
			long matrix = getMat(m - freeSlots) * k % mod;
			long res = matrix + (freeSlots - ((m - freeSlots) * (k - 1)) % mod);
			System.out.println((res % mod));

		}
	}
}
