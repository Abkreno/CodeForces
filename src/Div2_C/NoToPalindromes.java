package Div2_C;

import java.util.Scanner;

public class NoToPalindromes {
	static int[] changes;
	static char[] c;
	static int n, p, currI;

	static boolean search(int i) {
		if (i >= n)
			return true;
		int z = currI == i ? 1 : 0;
		for (int j = c[i] - 'a' + z; j < p; j++) {
			changes[i] = j - c[i] + 'a';
			if (checkBefore(i)) {
				if (search(i + 1))
					return true;
			}
		}
		c[i] = 'a';
		changes[i] = 0;
		return false;
	}

	public static void main(String[] args) {
		char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = sc.nextInt();
		sc.nextLine();
		c = sc.nextLine().toCharArray();
		changes = new int[n];
		boolean valid = false;
		for (int i = n - 1; i >= 0; i--) {
			currI = i;
			valid |= search(i);
			if (valid) {
				for (int j = 0; j < c.length; j++) {
					int pos = changes[j] + c[j] - 'a';
					System.out.print(abc[pos]);
				}
				System.out.println();
				break;
			}
		}
		if (!valid)
			System.out.println("NO");
		sc.close();
	}

	static boolean checkBefore(int i) {
		boolean valid = true;
		if (i - 1 >= 0)
			valid &= (c[i - 1] - 'a' + changes[i - 1]) != (c[i] - 'a' + changes[i]);
		if (i - 2 >= 0)
			valid &= (c[i - 2] - 'a' + changes[i - 2]) != (c[i] - 'a' + changes[i]);
		return valid;
	}
}
