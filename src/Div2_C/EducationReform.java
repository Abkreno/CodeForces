package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EducationReform {
	static class Subject implements Comparable<Subject> {
		long a, b;
		int c, index;

		Subject(long x, long y, int z, int i) {
			a = x;
			b = y;
			c = z;
			index = i;
		}

		@Override
		public int compareTo(Subject o) {
			if (c > o.c)
				return 1;
			if (c < o.c)
				return -1;
			return 0;
		}
	}

	static int n, m, k;
	static Subject[] subjects;
	static long INF = 1000000000000000L;
	static long DP[][][][];

	static long f(int day, int currSub, int lstSub, int diff) {
		if (day >= n)
			return 0;
		if (currSub >= m + 1)
			return -INF;
		if (DP[day][currSub][lstSub][diff] != -1)
			return DP[day][currSub][lstSub][diff];
		long best = f(day, currSub + 1, lstSub, diff);
		long tmp;
		if (lstSub == 0) {
			for (long i = subjects[currSub].a; i <= subjects[currSub].b; i++) {
				tmp = f(day + 1, currSub + 1, currSub,
						(int) (i - subjects[currSub].a));
				if (tmp != -INF)
					tmp += i;
				best = Math.max(best, tmp);
			}
		} else if (subjects[currSub].c > subjects[lstSub].c) {
			long plus = (subjects[lstSub].a + diff + k);

			if (plus >= subjects[currSub].a && plus <= subjects[currSub].b) {

				tmp = f(day + 1, currSub + 1, currSub,
						(int) (plus - subjects[currSub].a));
				if (tmp != -INF)
					tmp += plus;
				best = Math.max(best, tmp);
			}

			long mult = (subjects[lstSub].a + diff) * k;

			if (mult >= subjects[currSub].a && mult <= subjects[currSub].b) {

				tmp = f(day + 1, currSub + 1, currSub,
						(int) (mult - subjects[currSub].a));
				if (tmp != -INF)
					tmp += mult;
				best = Math.max(best, tmp);
			}
		}
		return DP[day][currSub][lstSub][diff] = best;
	}

	static void print(int day, int currSub, int lstSub, int diff) {
		if (day >= n || currSub >= m + 1)
			return;
		long call = f(day, currSub + 1, lstSub, diff);
		if (call == DP[day][currSub][lstSub][diff]) {
			print(day, currSub + 1, lstSub, diff);
		} else {
			long tmp;
			if (lstSub == 0) {
				for (long i = subjects[currSub].a; i <= subjects[currSub].b; i++) {
					tmp = f(day + 1, currSub + 1, currSub,
							(int) (i - subjects[currSub].a));
					if (tmp != -INF)
						tmp += i;
					if (tmp == DP[day][currSub][lstSub][diff]) {
						System.out.println(subjects[currSub].index + " " + i);
						print(day + 1, currSub + 1, currSub,
								(int) (i - subjects[currSub].a));
					}
				}
			} else if (subjects[currSub].c > subjects[lstSub].c) {
				long plus = (subjects[lstSub].a + diff + k);

				if (plus >= subjects[currSub].a && plus <= subjects[currSub].b) {

					tmp = f(day + 1, currSub + 1, currSub,
							(int) (plus - subjects[currSub].a));
					if (tmp != -INF)
						tmp += plus;
					if (tmp == DP[day][currSub][lstSub][diff]) {
						System.out
								.println(subjects[currSub].index + " " + plus);
						print(day + 1, currSub + 1, currSub,
								(int) (plus - subjects[currSub].a));
					}
				}

				long mult = (subjects[lstSub].a + diff) * k;

				if (mult >= subjects[currSub].a && mult <= subjects[currSub].b) {

					tmp = f(day + 1, currSub + 1, currSub,
							(int) (mult - subjects[currSub].a));
					if (tmp != -INF)
						tmp += mult;
					if (tmp == DP[day][currSub][lstSub][diff]) {
						System.out
								.println(subjects[currSub].index + " " + mult);
						print(day + 1, currSub + 1, currSub,
								(int) (mult - subjects[currSub].a));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		k = Integer.parseInt(l[2]);
		DP = new long[n + 1][m + 1][m + 1][101];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				for (int k = 0; k <= m; k++) {
					Arrays.fill(DP[i][j][k], -1);
				}
			}
		}
		subjects = new Subject[m + 1];
		subjects[0] = new Subject(0, 0, 0, 0);
		for (int i = 1; i <= m; i++) {
			l = bf.readLine().split(" ");
			subjects[i] = new Subject(Long.parseLong(l[0]),
					Long.parseLong(l[1]), Integer.parseInt(l[2]), i);
		}
		Arrays.sort(subjects);
		long ans = f(0, 1, 0, 0);
		if (ans == -INF) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			print(0, 1, 0, 0);
		}
	}
}
