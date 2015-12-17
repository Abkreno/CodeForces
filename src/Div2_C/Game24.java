package Div2_C;

import java.util.Scanner;

public class Game24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		if (n < 4) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			if (n == 4) {
				printFour(true);
			} else if (n == 5) {
				printFive();
			} else {
				System.out.println("1 + 5 = 6\n6 - 6 = 0");
				for (int i = 7; i <= n; i++) {
					System.out.println("0 * " + i + " = 0");
				}
				printFour(false);
				System.out.println("24 + 0 = 24");
			}
		}
	}

	private static void printFive() {
		System.out.println("5 * 3 = 15\n15 - 4 = 11\n11 + 1 = 12\n12 * 2 = 24");
	}

	private static void printFour(boolean b) {
		if (b)
			System.out.println("1 * 2 = 2");
		System.out.println("2 * 3 = 6\n6 * 4 = 24");
	}
}
