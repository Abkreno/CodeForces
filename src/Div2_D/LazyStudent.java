package Div2_D;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class LazyStudent {
	static class Edge implements Comparable<Edge> {
		int w, u, v, index;

		Edge(int w, int index) {
			this.w = w;
			this.index = index;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a, b;
		LinkedList<Edge> e_0 = new LinkedList<>();
		LinkedList<Edge> e_1 = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			if (b == 1) {
				e_1.add(new Edge(a, i));
			} else {
				e_0.add(new Edge(a, i));
			}
		}
		Collections.sort(e_0);
		Collections.sort(e_1);
		int index = 1;
		for (Edge e : e_1) {
			e.u = index++;
			e.v = index;
		}
		Edge[] edges = new Edge[e_1.size()];
		int i = 0;
		for (Edge e : e_1) {
			edges[i++] = e;
		}
		int currInd = 1;
		i = 0;

		for (Edge e : e_0) {
			if (e.w < edges[currInd].w || e.w < edges[i].w) {
				System.out.println(-1);
				return;
			}
			e.u = edges[currInd].v;
			e.v = edges[i].u;
			if (i < currInd - 1) {
				i++;
			} else {
				currInd++;
				i = 0;
			}
		}
		int ans[][] = new int[2][m];
		for (Edge e : e_1) {
			ans[0][e.index] = e.u;
			ans[1][e.index] = e.v;
		}
		for (Edge e : e_0) {
			ans[0][e.index] = e.u;
			ans[1][e.index] = e.v;
		}
		StringBuffer sb = new StringBuffer();

		for (i = 0; i < m; i++) {
			sb.append(ans[0][i] + " " + ans[1][i] + "\n");
		}
		System.out.print(sb);
	}
}
