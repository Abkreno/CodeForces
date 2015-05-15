package Div288;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] c = bf.readLine().toCharArray();
		boolean ff = false;
		int pos = c.length - 1;
		int first = c[c.length - 1] - '0';
		for (int i = c.length - 2; i >= 0; i--) {
			if ((c[i] - '0') % 2 == 0) {
				ff = true;
				int curr = c[i] - '0';
				if (first < curr) {
					if (pos == c.length - 1)
						pos = i;
				} else {
					pos = i;
				}
			}
		}
		if (ff) {
			char temp = c[pos];
			c[pos] = c[c.length - 1];
			c[c.length - 1] = temp;
			boolean found = false;
			for (int i = 0; i < c.length; i++) {
				if (found || c[i] != '0') {
					found = true;
					System.out.print(c[i]);
				}
			}
		} else {
			System.out.print(-1);
		}
		System.out.println();
	}
}
