package Div327;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B {

	static LinkedList<Edge> x[] = new LinkedList[26];
	static boolean visited[] = new boolean[26];

	static class Edge {
		int v, t;

		Edge() {
			v = -1;
			t = -1;
		}

		public String toString() {
			return v + " " + t;
		}
	}

	static int index[] = new int[26];
	static int value[] = new int[26];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int m = Integer.parseInt(l[1]);
		char s[] = bf.readLine().toCharArray();
		for (int i = 0; i < x.length; i++) {
			index[i] = value[i] = i;
		}
		int a, b;
		int tmp;
		while (m-- > 0) {
			l = bf.readLine().split(" ");
			a = l[0].charAt(0) - 'a';
			b = l[1].charAt(0) - 'a';

			value[index[b]] = a;
			value[index[a]] = b;
			tmp = index[a];
			index[a] = index[b];
			index[b] = tmp;
		}
		for (int i = 0; i < s.length; i++) {
			s[i] = (char) (value[s[i] - 'a'] + 'a');
		}
		System.out.println(String.valueOf(s));
	}

	static int dfs(int v) {
		if (v == value[v])
			return v;
		return value[v] = dfs(value[v]);
	}
}
