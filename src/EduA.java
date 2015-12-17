import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EduA {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		long res;
		while (t-- > 0) {
			long n = Integer.parseInt(bf.readLine());
			res = n * (n + 1) / 2;
			res -= 2*pow2(n);
			System.out.println(res);
		}
	}

	private static long pow2(long n) {
		long res = 0;
		for (long i = 1; i <= n; i *= 2) {
			res += i;
		}
		return res;
	}
}
