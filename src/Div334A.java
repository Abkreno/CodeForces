import java.util.Scanner;

public class Div334A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] a = new double[5];
		double[] b = new double[5];
		for (int i = 0; i < b.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		int h = sc.nextInt();
		int f = sc.nextInt();
		double score = h * 100 - f * 50;
		int total = 0;
		double scores[] = new double[] { 500, 1000, 1500, 2000, 2500 };
		for (int i = 0; i < b.length; i++) {
			double curr = Math.max((0.3 * scores[i]), ((1 - (a[i] / 250.0))
					* scores[i] - 50.0 * b[i]));
			score += curr;
		}
		System.out.println((int) score);
	}
}
