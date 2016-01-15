import java.math.BigInteger;
import java.util.Scanner;

public class Div333A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b1 = sc.nextInt();
		long num = 0, curr, x = n - 1;
		for (int i = 0; i < n; i++) {
			curr = sc.nextInt();
			long v = curr * pow(b1, x);
			x--;
			num += v;
		}
		int n2 = sc.nextInt();
		int b2 = sc.nextInt();
		long num2 = 0;
		x = n2 - 1;
		for (int i = 0; i < n2; i++) {
			curr = sc.nextInt();
			long v = curr * pow(b2, x);
			x--;
			num2 += v;
		}
		System.out.println(num == num2 ? "=" : num > num2 ? ">" : "<");
	}

	private static long pow(long curr, long x) {
		if (x == 0)
			return 1;
		return curr * pow(curr, x - 1);
	}
}
