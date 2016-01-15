import java.awt.geom.Line2D;
import java.util.Scanner;

public class PeterAndSnowBlower {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int xp = scanner.nextInt();
			int yp = scanner.nextInt();

			int[] x = new int[n];
			int[] y = new int[n];

			for (int i = 0; i < n; i++) {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			}

			double maxDist = Double.MIN_VALUE;
			double minDist = Double.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				maxDist = Math.max(maxDist, dist(x[i], y[i], xp, yp));
				minDist = Math.min(minDist, Line2D.ptSegDistSq(x[i], y[i],
						x[(i + 1) % n], y[(i + 1) % n], xp, yp));
			}

			double result = (maxDist - minDist) * Math.PI;
			System.out.println(result);
		}
	}

	private static double dist(double x1, double y1, double x2, double y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}