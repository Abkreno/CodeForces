import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MemSqlRound1B {
	static LinkedList<Point> points = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		if (n == 0) {
			System.out.println(0 + " " + 1);
			System.out.println(0 + " " + m);
			System.out.println(0 + " " + 0);
			System.out.println(0 + " " + (m - 1));
		} else if (m == 0) {
			System.out.println(1 + " " + 0);
			System.out.println(n + " " + 0);
			System.out.println(0 + " " + 0);
			System.out.println((n - 1) + " " + 0);
		} else {
			int numOfPoints = 0;
			// from (0,0) to (0,4)
			for (int i = 0; i <= Math.min(m, 4); i++) {
				points.add(new Point(0, i));
			}

			// from (0,0) to (4,0)
			for (int i = 1; i <= Math.min(n, 4); i++) {
				points.add(new Point(i, 0));
			}

			// from (0,m-4) to (0,m)
			for (int i = Math.max(m - 4, 0); i <= m; i++) {
				points.add(new Point(0, i));
			}

			// from (0,m) to (4,m)
			for (int i = 1; i <= Math.min(n, 4); i++) {
				points.add(new Point(i, m));
			}

			// from (n-4,0) to (n,0)
			for (int i = Math.max(n - 4, 0); i <= n; i++) {
				points.add(new Point(i, 0));
			}

			// from (n,0) to (n,4)
			for (int i = 0; i <= Math.min(m, 4); i++) {
				points.add(new Point(n, i));
			}

			// from (n,m-4) to (n,m)
			for (int i = Math.max(0, m - 4); i <= m; i++) {
				points.add(new Point(n, i));
			}

			// from (n-4,m) to (n,m)
			for (int i = Math.max(0, n - 4); i <= n; i++) {
				points.add(new Point(i, m));
			}
			double bestDist = 0;
			double dist;
			LinkedList<Point> ans = new LinkedList<>();
			for (Point topL : points) {
				for (Point bottR : points) {
					if (!bottR.equals(topL))
						for (Point bottL : points) {
							if (!bottL.equals(bottR) && !bottL.equals(topL))
								for (Point topR : points) {
									if (!topR.equals(bottR)
											&& !topR.equals(topL)
											&& !topR.equals(bottL)) {
										dist = distance(topL, bottR)
												+ distance(bottR, bottL)
												+ distance(bottL, topR);
										if (dist > bestDist) {
											bestDist = dist;
											ans.clear();
											ans.add(topL);
											ans.add(bottR);
											ans.add(bottL);
											ans.add(topR);
										}
										dist = distance(topL, bottR)
												+ distance(bottR, topR)
												+ distance(topR, bottL);
										if (dist > bestDist) {
											bestDist = dist;
											ans.clear();
											ans.add(topL);
											ans.add(bottR);
											ans.add(topR);
											ans.add(bottL);
										}
									}
								}
						}
				}
			}
			for (Point res : ans) {
				System.out.println(res.x + " " + res.y);
			}
		}
	}

	private static double distance(Point p1, Point p2) {
		return Point.distance(p1.x, p1.y, p2.x, p2.y);
	}
}
