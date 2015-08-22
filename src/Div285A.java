import java.util.Scanner;

public class Div285A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double d = sc.nextDouble();
		double v = 3.0 * a / 10.0;
		v = Math.max(v, a - ((a / 250.0) * c));
		double x = 3.0 * b / 10.0;
		x = Math.max(x, b - ((b / 250.0) * d));
		if (compare(v, x) == 0) {
			System.out.println("Tie");
		} else if (compare(v, x) == 1) {
			System.out.println("Misha");
		} else {
			System.out.println("Vasya");
		}
	}

	static double eps = 1e-10;

	static int compare(double a, double b) {
		if (Math.abs(a - b) < eps)
			return 0;
		if (a - b < 0.0)
			return -1;
		return 1;
	}
}
