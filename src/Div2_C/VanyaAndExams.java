package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VanyaAndExams {
	static class Exam implements Comparable<Exam> {
		long grade;
		long b;

		Exam(long g, long b) {
			this.grade = g;
			this.b = b;
		}

		@Override
		public int compareTo(Exam e) {
			if (b > e.b)
				return 1;
			if (b < e.b)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int r = Integer.parseInt(l[1]);
		long avg = Integer.parseInt(l[2]);
		long a, b;
		long need = avg * ((long) n);
		long have = 0;
		Exam[] e = new Exam[n];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			b = Integer.parseInt(l[1]);
			have += a;
			e[i] = new Exam(a, b);
		}
		Arrays.sort(e);
		need -= have;
		long can;
		long essays = 0;
		for (int i = 0; need > 0 && i < e.length; i++) {
			can = r - e[i].grade;
			can = Math.min(can, need);
			need -= can;
			essays += can * e[i].b;
		}
		System.out.println(essays);
	}
}
