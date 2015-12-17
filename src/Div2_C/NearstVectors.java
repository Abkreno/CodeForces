package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NearstVectors {
	static double PI = Math.acos(-1.0);

	static class Ang implements Comparable<Ang> {
		int index;
		double angle;

		Ang(int i, double a, boolean s) {
			index = i;
			angle = a;
			if (s && angle < 0)
				angle += 2 * PI;
		}

		@Override
		public int compareTo(Ang o) {
			return Double.compare(angle, o.angle);
		}

		public String toString() {
			return angle + " " + index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[];
		double x1, y1;
		Ang[] angles = new Ang[n];
		Ang[] angles2 = new Ang[n];
		double angle, dot, det;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			x1 = Integer.parseInt(l[0]);
			y1 = Integer.parseInt(l[1]);
			dot = x1; // # dot product
			det = y1 * 1; // # determinant
			angle = Math.atan2(det, dot);// # ata
			angles[i] = new Ang(i, angle, true);
			angles2[i] = new Ang(i, angle, false);
		}
		Arrays.sort(angles2);
		Arrays.sort(angles);
		int best1 = 1;
		int best2 = 2;
		double t, bestDiff = Integer.MAX_VALUE;
		for (int i = 0; i < angles.length - 1; i++) {
			t = angles[i + 1].angle - angles[i].angle;
			if (t > PI)
				t = 2 * PI - t;
			if (t < bestDiff) {
				bestDiff = t;
				best1 = angles[i].index + 1;
				best2 = angles[i + 1].index + 1;
			}
			t = angles2[i + 1].angle - angles2[i].angle;
			if (t > PI)
				t = 2 * PI - t;
			if (t < bestDiff) {
				bestDiff = t;
				best1 = angles2[i].index + 1;
				best2 = angles2[i + 1].index + 1;
			}
		}
		// System.out.println(Arrays.toString(angles));
		System.out.println(best1 + " " + best2);
		// System.out.println((Math.acos(0) / Math.PI));
	}

}