package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class XorTree {
	static LinkedList<Integer>[] graph;
	static int n, res;
	static boolean[] init, goal, visted, changed;

	static void dfs(int curr, boolean even, boolean e, boolean o) {
		if (visted[curr])
			return;
		visted[curr] = true;
		if ((even && e) || (!even && o)) {
			init[curr] = !init[curr];
		}
		if (init[curr] != goal[curr]) {
			res++;
			changed[curr] = true;
			init[curr] = !init[curr];
			if (even)
				e = !e;
			else
				o = !o;
		}
		for (int i : graph[curr]) {
			dfs(i, !even, e, o);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;
		graph = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			l = bf.readLine().split(" ");
			int x = Integer.parseInt(l[0]) - 1;
			int y = Integer.parseInt(l[1]) - 1;
			graph[x].add(y);
			graph[y].add(x);
		}
		init = new boolean[n];
		goal = new boolean[n];
		visted = new boolean[n];
		changed = new boolean[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			init[i] = Integer.parseInt(l[i]) == 1 ? true : false;
		}
		l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			goal[i] = Integer.parseInt(l[i]) == 1 ? true : false;
		}
		dfs(0, true, false, false);
		System.out.println(res);
		for (int i = 0; i < changed.length; i++) {
			if (changed[i])
				System.out.println(i + 1);
		}
	}
}
