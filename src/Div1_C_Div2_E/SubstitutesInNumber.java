package Div1_C_Div2_E;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SubstitutesInNumber {
	static class Digits {
		char[] d;

		Digits(char[] d) {
			this.d = d;
		}
	}

	static class Change {
		int ind;
		char[] d;

		Change(int i, char[] d) {
			ind = i;
			this.d = d;
		}
	}

	static LinkedList<Change> digits[] = new LinkedList[10];
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] s = bf.readLine().toCharArray();
		n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < digits.length; i++) {
			digits[i] = new LinkedList<>();
			digits[i].add(new Change(0, (i + "").toCharArray()));
		}
		String[] l;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split("->");
			digits[Integer.parseInt(l[0])].add(new Change(i + 1, l[1]
					.toCharArray()));
		}
	}
}
