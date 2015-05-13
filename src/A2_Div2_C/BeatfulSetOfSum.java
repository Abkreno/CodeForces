package A2_Div2_C;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BeatfulSetOfSum {
	static class P {
		double x, y;

		P(int i) {
			x = i;
			y = -1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		boolean y[] = new boolean[m + 1];
		P points[] = new P[n + 1];
		// Use all x points and try all possible ways to for the y's
		for (int i = 0; i < n + 1; i++) {
			points[i] = new P(i);
		}
		LinkedList<P> used = new LinkedList<P>();
		int res = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = m; j >= 0; j--) {
				// check this pair is valid
				if (y[j] || i + j == 0)
					continue;
				boolean valid = true;
				for (P curr : used) {
					if (!validPair(i, j, curr)) {
						valid = false;
						break;
					}
				}
				if (valid) {
					points[i].y = j;
					y[j] = true;
					res++;
					used.add(points[i]);
					break;
				}
			}
		}
		System.out.println(res);
		for (P i : used) {
			System.out.println(((int) i.x) + " " + ((int) i.y));
		}

	}

	private static boolean validPair(int i, int j, P curr) {
		if (curr.y == -1)
			return true;
		double dist = ((curr.x - i) * (curr.x - i))
				+ ((curr.y - j) * (curr.y - j));
		dist = Math.sqrt(dist);
		return dist != (int) dist;
	}
}
