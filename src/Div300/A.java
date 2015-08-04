package Div300;

import java.util.Scanner;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		char[] pattern = "CODEFORCES".toCharArray();
		if (s.length < pattern.length) {
			System.out.println("NO");
			return;
		}
		for (int i = 0; i < pattern.length; i++) {
			if (s[i] == pattern[i]) {
				if (i + 1 == pattern.length) {
					System.out.println("YES");
					return;
				}
			} else {
				break;
			}
		}
		int c = 0;
		for (int i = s.length - pattern.length; i < s.length; i++) {
			if (s[i] == pattern[c]) {
				c++;
				if (c == pattern.length) {
					System.out.println("YES");
					return;
				}
			} else {
				break;
			}
		}
		lop: for (int i = 0; i < s.length; i++) {
			c = 0;
			for (int k = 0; k <= i; k++) {
				if (s[k] == pattern[c]) {
					c++;
					if (c == pattern.length) {
						System.out.println("YES");
						return;
					}
				} else {
					continue lop;
				}
			}
			for (int k = s.length - (pattern.length - c); k < s.length; k++) {
				if (s[k] == pattern[c]) {
					c++;
					if (c == pattern.length) {
						System.out.println("YES");
						return;
					}
				} else {
					continue lop;
				}
			}

		}
		System.out.println("NO");
	}
}
