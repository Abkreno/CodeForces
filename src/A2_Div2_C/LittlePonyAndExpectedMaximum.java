package A2_Div2_C;

import java.util.Scanner;

public class LittlePonyAndExpectedMaximum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double m = sc.nextDouble();
		double n = sc.nextDouble();
		double ans = 0;
		for (int i = 1; i <= m; i++) {
			ans += i * (Math.pow((i / m), n) - Math.pow(((i - 1) / m), n));
		}
		System.out.println(ans);
	}
}
