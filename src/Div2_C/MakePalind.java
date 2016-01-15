package Div2_C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MakePalind {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char s[] = sc.nextLine().toCharArray();
		int counts[] = new int[26];
		for (int i = 0; i < s.length; i++) {
			counts[s[i] - 'a']++;
		}
		Arrays.sort(s);

		char[] r = new char[s.length / 2];
		char[] l = new char[s.length / 2];
		int fst = 0;
		int lst = s.length - 1;
		ArrayList<Character> odds = new ArrayList<>();
		for (int i = 0; i < counts.length; i++) {
			while (counts[i] > 1) {
				s[fst++] = s[lst--] = (char) (i + 'a');
				counts[i] -= 2;
			}
			if (counts[i] == 1) {
				odds.add((char) (i + 'a'));
			}
		}
		int c = 0;
		for (int i = fst; i <= lst; i++) {
			s[i] = odds.get(c++);
		}
		c = s.length - 1;
		for (int i = 0; i < s.length; i++) {
			s[c--] = s[i];
		}
		char[] res = new char[s.length];
		res[s.length / 2] = s[s.length / 2];
		Arrays.sort(s);
		c = res.length - 1;
		int x = 0;
		for (int i = 0; i < s.length - 1;) {
			if (s[i] == s[i + 1]) {
				res[x++] = res[c--] = s[i];
				i += 2;
			} else {
				i++;
			}
		}
		System.out.println(String.valueOf(res));
	}
}
