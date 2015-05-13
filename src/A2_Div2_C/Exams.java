package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exams {
	static class Exam implements Comparable<Exam> {
		int a, b;

		public Exam(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Exam o) {
			if (a == o.a)
				return b - o.b;
			return a - o.a;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Exam[] exams = new Exam[n];
		String[] l;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			exams[i] = new Exam(Integer.parseInt(l[0]), Integer.parseInt(l[1]));
		}
		Arrays.sort(exams);
		int maxDay = Math.min(exams[0].a, exams[0].b);
		for (int i = 1; i < exams.length; i++) {
			int min = Math.min(exams[i].a, exams[i].b);
			int max = Math.max(exams[i].a, exams[i].b);
			if (min >= maxDay) {
				maxDay = min;
			} else {
				maxDay = max;
			}
		}
		System.out.println(maxDay);
	}
}
