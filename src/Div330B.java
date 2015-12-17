import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div330B {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		long[] a = new long[n];
		int[] b = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			a[i] = Integer.parseInt(l[i]);
		}
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			b[i] = Integer.parseInt(l[i]);
		}
		long ans = 1;
		long mod = 1000000007;
		long kNines = generate(9, k); // 99
		for (int i = 0; i < l.length; i++) {
			long ways = (kNines / a[i]) + 1;
			long num = generate(b[i], k); // 79
			ways -= ((num / a[i] + 1));
			if (b[i] != 0) {
				long num2 = generate(b[i] - 1, k); // 69
				ways += (num2 / a[i] + 1);
			}
			ways %= mod;
			ans = (ans * ways) % mod;
			ans %= mod;
		}
		System.out.println(ans);
	}

	private static long generate(int b2, int k) {
		String ans = b2 + "";
		for (int j = 1; j < k; j++) {
			ans += 9;
		}
		return Long.parseLong(ans);
	}
}