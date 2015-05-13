import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class A {
	static class Calendar2 implements Comparable<Calendar2> {
		GregorianCalendar start, end;
		int p;

		public Calendar2(int day, int month, int t, int p) {
			end = new GregorianCalendar(2013, month - 1, day - 1);
			start = new GregorianCalendar(2013, month - 1, day - t);
			this.p = p;
		}

		@Override
		public int compareTo(Calendar2 o) {
			return start.compareTo(o.start);
		}

		public int getStartDay() {
			return start.get(Calendar.DAY_OF_MONTH);
		}

		public int getEndDay() {
			return end.get(Calendar.DAY_OF_MONTH);
		}

		public int getStartM() {
			return start.get(Calendar.MONTH);
		}

		public int getEndM() {
			return end.get(Calendar.MONTH);
		}

		public int compare(Calendar2 o) {
			return start.compareTo(o.start);
		}

		public String toString() {
			return start.get(Calendar.DAY_OF_MONTH) + " / "
					+ start.get(Calendar.MONTH) + ">>> "
					+ end.get(Calendar.DAY_OF_MONTH) + " / "
					+ end.get(Calendar.MONTH);
		}

	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Calendar2[] calendar = new Calendar2[n];
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int d = sc.nextInt();
			int people = sc.nextInt();
			int time = sc.nextInt();
			calendar[i] = new Calendar2(d, m, time, people);
		}
		Arrays.sort(calendar);
		int count = 0;
		int max = -1;
		for (int i = 0; i < calendar.length; i++) {
			count += calendar[i].p;
			if (calendar[i].compare(calendar[i - 1]) > 0) {
				count -= calendar[i - 1].p;
			}
		}
		System.out.println(Arrays.toString(calendar));
	}
}
