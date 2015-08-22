import java.util.Scanner;

public class DreamonAndWifi {
	static int goal, have, n, count;
	static char[] a, b;

	static void search(int i, int have) {
		if (i >= n) {
			if (have == goal)
				count++;
			return;
		}
		if (b[i] != '?')
			search(i + 1, have);
		else {
			search(i + 1, have + 1);
			search(i + 1, have - 1);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine().toCharArray();
		n = a.length;
		goal = 0;
		for (int i = 0; i < n; i++) {
			goal += a[i] == '+' ? 1 : -1;
		}
		b = sc.nextLine().toCharArray();
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (b[i] == '?')
				total++;
			else
				have += b[i] == '+' ? 1 : -1;
		}
		search(0, have);
		double t = (1 << total);
		double c = count;
		System.out.println(c / t);
	}
}
