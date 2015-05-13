import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div266B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line[] = bf.readLine().split(" ");
		long n = Integer.parseInt(line[0]);
		long a = Integer.parseInt(line[1]);
		long b = Integer.parseInt(line[2]);
		long n6 = n * 6;
		long ab = a * b;
		if (n6 <= ab) {
		} else {
			if (ab % 6 != 0) {
				if (a > b) {
					a = a + (6 - (a % 6));
				} else {
					b = b + (6 - (b % 6));
				}
				ab = a * b;
			}
			if (ab < n6) {
				// binary search
				if (a < b) {
					long tmp = a;
					a = b;
					b = tmp;
				}// sabet wa7ed we zawedo keda el a hoa el akbar
				long tmpA = a;
				long lo = 1;
				long hi = 1000;
				long bestA = Integer.MAX_VALUE;
				while (lo < hi-1) {
					long mid = (lo + hi) / 2;
					tmpA = a + mid;
					if ((tmpA * b) >= n6) {
						hi = mid;
						bestA = Math.min(bestA, tmpA);
					} else {
						lo = mid;
					}
				}
				a = bestA;
			}
		}
		System.out.println(a * b);
		System.out.println(a + " " + b);
	}
}
