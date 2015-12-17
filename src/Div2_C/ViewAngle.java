package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ViewAngle {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		double[] angles = new double[n];
		while (n-- > 0) {
			String[] l = bf.readLine().split(" ");
			double x = Integer.parseInt(l[0]);
			double y = Integer.parseInt(l[1]);
			double curr = Math.toDegrees(angle(x, y));
			angles[n] = curr;
		}
		Arrays.sort(angles);
		double ans = angles[angles.length - 1] - angles[0];
		for (int i = 0; i < angles.length - 1; i++) {
			ans = Math.min(360 - (angles[i + 1] - angles[i]), ans);
		}
		System.out.println(String.format("%.10f", ans));
	}

	public static double angle(double x, double y) {
		double res = Math.atan2(y, x);
		if (res >= 0)
			return res;
		return res + Math.toRadians(360);
	}
}
