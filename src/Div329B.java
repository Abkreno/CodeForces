import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div329B {
	static class Y implements Comparable<Y> {
		long y, y2;
		int i;

		Y(int ind, long yy, long yyy) {
			y = yy;
			y2 = yyy;
			i = ind;
		}

		@Override
		public int compareTo(Y o) {
			return Long.compare(y, o.y) == 0 ? (Long.compare(y2, o.y2) == 0 ? Integer
					.compare(i, o.i) : Long.compare(y2, o.y2))
					: Long.compare(y, o.y);
		}

		public String toString() {
			return y + " " + i;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		long x1 = Integer.parseInt(l[0]);
		long x2 = Integer.parseInt(l[1]);
		Y y1[] = new Y[n];
		Y y2[] = new Y[n];
		long k, d;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			k = Integer.parseInt(l[0]);
			d = Integer.parseInt(l[1]);
			y1[i] = new Y(i, k * x1 + d, k * x2 + d);
			y2[i] = new Y(i, k * x2 + d, k * x1 + d);
		}
		Arrays.sort(y1);
		Arrays.sort(y2);
		int i = 0;
		while (i < n && y1[i].i == y2[i].i)
			i++;
		if (i < n)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
