package Div324;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int t = Integer.parseInt(l[1]);
		char[] s1 = bf.readLine().toCharArray();
		char[] s2 = bf.readLine().toCharArray();
		char[] s3 = new char[n];
		int diff = 0;
		boolean f = false;
		int last = -1;
		for (int i = 0; i < n; i++) {
			if (s1[i] != s2[i]) {
				s3[i] = f ? s1[i] : s2[i];
				diff++;
				last = i;
				f = !f;
			}
		}
		if (diff % 2 != 0) {
			s3[last] = somethingDiff(s1[last], s2[last]);
			diff++;
		}
		diff /= 2;
		if (diff > t) {
			System.out.println(-1);
			return;
		}
		int prev = -1;
		for (int i = 0; i < s3.length; i++) {
			if (diff == t)
				break;
			if (s1[i] != s2[i]) {
				if (prev != -1) {
					s3[i] = somethingDiff(s1[i], s2[i]);
					s3[prev] = somethingDiff(s1[prev], s2[prev]);
					diff++;
					prev = -1;
				} else {
					prev = i;
				}

			}
		}
		boolean changed[] = new boolean[n];
		for (int i = 0; i < s3.length; i++) {
			if (diff == t)
				break;
			if (s1[i] == s2[i]) {
				s3[i] = somethingDiff(s1[i], s2[i]);
				changed[i] = true;
				diff++;
			}
		}
		if (diff < t) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < s3.length; i++) {
			if (s1[i] == s2[i] && !changed[i]) {
				s3[i] = s1[i];
			}
		}
		System.out.println(String.valueOf(s3));
	}

	static char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	static char somethingDiff(char c, char d) {
		for (int i = 0; i < abc.length; i++) {
			if (abc[i] != c && abc[i] != d) {
				return abc[i];
			}
		}
		return (char) (((c + d) % 26 + 1) + 'a');
	}
}
