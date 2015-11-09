package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LuckyTree {
	static LinkedList<Edge> graph[] = new LinkedList[100000];
	static int counts[] = new int[100000];

	static class Edge {
		boolean isLucky;
		int to, closestLucky;

		Edge(int t, boolean i) {
			to = t;
			isLucky = i;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a, b, c, n = Integer.parseInt(bf.readLine());
		boolean lucky;
		String[] l;
		for (int i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			c = Integer.parseInt(l[2]);
			lucky = isLucky(c);
			graph[a].add(new Edge(b, lucky));
			graph[b].add(new Edge(a, lucky));
		}
		countUnLucky(0, 0, 0);
		for (int i = 0; i < 7; i++) {
			System.out.println("count of " + (i + 1) + " " + counts[i]);
		}

	}

	static int countUnLucky(int curr, int dad, int closestLucky) {
		int c = 0;
		for (Edge e : graph[curr]) {
			if (e.to == dad) {
				e.closestLucky = closestLucky;
				continue;
			}
			if (e.isLucky) {
				e.closestLucky = e.to;
				countUnLucky(e.to, curr, e.to);
			} else {
				e.closestLucky = 0;
				countUnLucky(e.to, curr, 0);
			}
		}
		return c;
	}

	static boolean isLucky(int n) {
		int mod;
		while (n > 0) {
			mod = n % 10;
			if (mod != 4 && mod != 7)
				return false;
			n /= 10;
		}
		return true;
	}
}
