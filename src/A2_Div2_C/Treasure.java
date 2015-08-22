package A2_Div2_C;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Treasure {
	static class C {
		int c, i;
		char type;

		C(char t) {
			type = t;
		}

		C(char h, int count, int ind) {
			type = h;
			c = count;
			i = ind;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] l = sc.nextLine().toCharArray();
		int c = 0;
		StringBuffer sb = new StringBuffer();
		LinkedList<C> st = new LinkedList<>();
		int ind = 0;
		int[] ans = new int[l.length];
		Arrays.fill(ans, -1);
		for (int i = 0; i < l.length; i++) {
			if (l[i] == '(') {
				st.push(new C('('));
			} else if (l[i] == '#') {
				if (st.isEmpty()) {
					System.out.println(-1);
					return;
				}
				if (st.peek().type == '(') {
					c = 0;
					while (!st.isEmpty() && st.peek().type == '(') {
						st.pop();
						c++;
					}
					st.push(new C('#', c, ind++));
				} else {
					while (!st.isEmpty() && st.peek().c == 1) {
						ans[st.pop().i] = 1;
					}
					if (st.isEmpty()) {
						System.out.println(-1);
						return;
					}
					int tmp = st.peek().c;
					st.peek().c = 1;
					st.push(new C('#', tmp - 1, ind++));
				}
			} else {
				if (st.isEmpty()) {
					System.out.println(-1);
					return;
				}
				if (st.peek().type == '(') {
					st.pop();
				} else {
					while (!st.isEmpty() && st.peek().c == 1) {
						ans[st.pop().i] = 1;
					}
					if (st.isEmpty()) {
						System.out.println(-1);
						return;
					}
					st.peek().c--;
				}
			}
		}
		while (!st.isEmpty()) {
			if (st.peek().type == '(') {
				System.out.println(-1);
				return;	
			}
			ans[st.peek().i] = st.pop().c;
		}
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] != -1) {
				sb.append(ans[i] + "\n");
			}
		}
		System.out.print(sb);
	}
}
