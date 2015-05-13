package Dev277;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(bf.readLine());
		long sumEvens = 0;
		long n1 = 0;
		if (n % 2 == 0) {
			n1 = (2 + n) / 2 - 1;

		} else {
			n1 = (2 + (n - 1)) / 2 - 1;
		}
		sumEvens = n1 * (n1 + 1);
		long n2 = n % 2 == 0 ? n / 2 : n / 2 + 1;
		long sumOdds = n2 * n2 * -1;
		System.out.println(sumOdds + sumEvens);
	}
}
