package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class KefaAndPark {
	static LinkedList<Integer> graph[] = new LinkedList[100001];
	static int n, m, ans;
	static boolean isCat[] = new boolean[100001];
	static boolean counted[] = new boolean[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			isCat[i] = Integer.parseInt(l[i]) == 1 ? true : false;
			graph[i] = new LinkedList<>();
			counted[i] = false;
		}
		int a, b;
		for (int i = 0; i < n - 1; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		ans = 0;
		dfs(0, 0, 0);
		System.out.println(ans);
	}

	static void dfs(int curr, int parent, int cats) {
		cats = isCat[curr] ? cats + 1 : 0;
		if (cats > m)
			return;
		if (graph[curr].size() == 1 && graph[curr].getFirst() == parent) {
			if (!counted[curr]) {
				counted[curr] = true;
				ans++;
			}
			return;
		}
		for (int i : graph[curr])
			if (i != parent)
				dfs(i, curr, cats);
	}
}
