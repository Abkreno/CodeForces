package Div2_C;
import java.util.Scanner;

public class GivenLenAndSumOfDigits {
	static boolean can(int m, int s) {
		return s >= 0 && s <= 9 * m;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int sum = sc.nextInt();
		int s = sum;
		String min = "";
		for (int i = 0; i < m; i++)
			for (int d = 0; d < 10; d++)
				if ((i > 0 || d > 0 || (m == 1 && d == 0))
						&& can(m - i - 1, sum - d)) {
					min += d;
					sum -= d;
					break;
				}
		String max = "";
		sum = s;
		for (int i = 0; i < m; i++)
			for (int d = 9; d >= 0; d--)
				if ((i > 0 || d > 0 || (m == 1 && d == 0))
						&& can(m - i - 1, sum - d)) {
					max += d;
					sum -= d;
					break;
				}
		if (min.length() > 1 && min.charAt(0) == '0')
			min = "";
		if (min.length() != m)
			min = "";
		if (max.length() > 1 && max.charAt(0) == '0')
			max = "";
		if (max.length() != m)
			max = "";
		System.out.println((min.length() >= 1 ? min : "-1") + " "
				+ (max.length() >= 1 ? max : "-1"));
		sc.close();
	}
}
