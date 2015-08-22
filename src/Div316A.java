import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div316A {
	static boolean flag = false;

	static class Q implements Comparable<Q> {
		int indx, cities;
		long r;

		Q(int i, long X) {
			indx = i;
			r = X;
		}

		@Override
		public int compareTo(Q q) {
			if (flag) {
				if (cities > q.cities)
					return -1;
				if (cities < q.cities)
					return 1;
			} else {
				if (r > q.r)
					return -1;
				if (r < q.r)
					return 1;
			}
			if (indx > q.indx)
				return 1;
			if (indx < q.indx)
				return -1;
			return 0;
		}

		public String toString() {
			return indx + " " + r + " " + cities;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		Q[] cand = new Q[n];
		for (int i = 0; i < cand.length; i++) {
			cand[i] = new Q(i, 0);
		}
		Q[] temp = new Q[n];
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			for (int j = 0; j < temp.length; j++) {
				temp[j] = new Q(j, Integer.parseInt(l[j]));
			}
			Arrays.sort(temp);
			cand[temp[0].indx].r += temp[0].r;
			cand[temp[0].indx].cities++;
		}
		flag = true;
		Arrays.sort(cand);
		System.out.println(cand[0].indx + 1);
	}
}
