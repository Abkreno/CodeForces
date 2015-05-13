package Dev293;

import java.util.Scanner;

public class A {
	static char[] cc;
	static String str, str2;

	static boolean find(int curr) {
		if (curr < 0)
			return false;
		while (cc[curr] < 'z') {
			cc[curr]++;
			for (int i = curr + 1; i < cc.length; i++) {
				cc[i] = 'a';
			}
			if (check())
				return true;
		}
		return find(curr - 1);
	}

	static boolean check() {
		String gg = "";
		for (int i = 0; i < cc.length; i++) {
			gg = gg + cc[i];

		}
		if (gg.compareTo(str) <= 0) // gg<str
			return false;
		if (gg.compareTo(str2) < 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();

		str2 = sc.nextLine();

		cc = str.toCharArray().clone();

		if (find(cc.length - 1)) {
			for (int i = 0; i < cc.length; i++) {
				System.out.print(cc[i]);
			}
			System.out.println();
		} else {
			System.out.println("No such string");
		}
	}
}
