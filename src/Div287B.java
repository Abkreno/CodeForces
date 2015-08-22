import java.awt.Point;
import java.util.Scanner;

public class Div287B {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextInt() * 2.0;
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		System.out
				.println((int) Math.ceil(Point.distance(x1, y1, x2, y2) / (r)));
	}

	static int distanceCalculate(int x1, int y1, int x2, int y2) {
		int x = x1 - x2;
		int y = y1 - y2;
		int dist;

		dist = (x * x) + (y * y); // calculating distance by euclidean formula
		return dist;
	}
}
