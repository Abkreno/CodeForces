import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Edu4A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int p = Integer.parseInt(l[1]);
		int q = Integer.parseInt(l[2]);
		String s = bf.readLine();
		int i;
		if (n % p == 0) {
			System.out.println(n / p);
			for (i = 0; i + p <= s.length(); i += p) {
				System.out.println(s.substring(i, i + p));
			}
		} else if (n % q == 0) {
			System.out.println(n / q);
			for (i = 0; i + q <= s.length(); i += q) {
				System.out.println(s.substring(i, i + q));
			}
		} else {
			for (int j = 1; j < s.length(); j++) {
				int left = s.length() - j;
				if (j % p == 0 && left % q == 0) {
					System.out.println(j/p + left/q);
					for (int k = 0; k + p <= j; k += p) {
						System.out.println(s.substring(k, k + p));
					}
					s = s.substring(j);
					for (int k = 0; k < s.length(); k += q) {
						System.out.println(s.substring(k, k + q));
					}
					return;
				}
			}
			System.out.println(-1);
		}
	}
}
