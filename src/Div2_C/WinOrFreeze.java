package Div2_C;

import java.util.LinkedList;
import java.util.Scanner;

public class WinOrFreeze {
	public static LinkedList<Long> primeFactors(long numbers) {
		long n = numbers;
		LinkedList<Long> factors = new LinkedList<Long>();
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		LinkedList<Long> factors = primeFactors(num);
		if (factors.size() <= 1) {
			System.out.println(1 + "\n" + 0);
		} else {
			if (factors.size() == 2) {
				System.out.println(2);
			} else {
				System.out
						.println(1 + "\n" + (factors.get(0) * factors.get(1)));
			}
		}
	}
}
