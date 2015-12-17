package Div2_C;

import java.util.Scanner;
import java.util.Stack;

public class LongestRegularBracketSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] l = sc.nextLine().toCharArray();
		Stack<Integer> st = new Stack<>();
		int curr = 0, max = 0, count = 0;
		int counts[] = new int[l.length];
		for (int i = 0; i < l.length; i++) {
			if (l[i] == '(')
				st.push(i);
			else if (!st.isEmpty()) {
				counts[i] = i - st.pop() + 1;
			}
		}
		int prevPos = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] != 0) {
				prevPos = i - counts[i];
				if (prevPos >= 0)
					counts[i] += counts[prevPos];
			}
			max = Math.max(max, counts[i]);
		}

		if (max == 0) {
			System.out.println(0 + " " + 1);
			return;
		}
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == max)
				count++;
		}
		System.out.println(max + " " + count);
	}
}