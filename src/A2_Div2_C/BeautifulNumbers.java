package A2_Div2_C;

	import java.util.Scanner;
	
	public class BeautifulNumbers {
		public static void main(String[] args) {
			long fac[] = new long[1000001];
			int mod = 1000000007;
			fac[0] = 1;
			for (int i = 1; i <= 1000000; i++) {
				fac[i] = fac[i - 1] * i;
				fac[i] %= mod;
			}
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			long res = 0;
			long div = 0;
			for (int i = 0; i <= n; i++) {
				if (check(a * i + b * (n - i), a, b)) {
					long r = fac[n];
					div = fac[n - i] * fac[i];
					div %= mod;
					div = binpow(div, mod - 2, mod);
					r = (r * div) % mod;
					res += r;
					res %= mod;
				}
			}
			System.out.println(res);
		}
	
		private static boolean check(int i, int a, int b) {
			while (i != 0) {
				if (i % 10 != a && i % 10 != b)
					return false;
				i = i / 10;
			}
			return true;
		}
	
		static long binpow(long val, long deg, long mod) {
			if (deg == 0)
				return 1 % mod;
			if (deg % 2 == 1)
				return binpow(val, deg - 1, mod) * val % mod;
			long res = binpow(val, deg >> 1, mod);
			return (res * res) % mod;
		}
	
	}
