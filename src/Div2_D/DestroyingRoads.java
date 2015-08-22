package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DestroyingRoads {

	static int INF = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");

		int n = Integer.parseInt(l[0]);

		int m = Integer.parseInt(l[1]);

		LinkedList<Edge>[] graph = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++)
			graph[i] = new LinkedList<Edge>();

		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			int v1 = Integer.parseInt(l[0]);
			int v2 = Integer.parseInt(l[1]);
			graph[v1].add(new Edge(v2));
			graph[v2].add(new Edge(v1));
		}

		Node[] min = new Node[n + 1];
		for (int i = 1; i < min.length; i++) {
			min[i] = new Node(i);
		}
		Node[] min2 = new Node[n + 1];
		for (int i = 1; i < min.length; i++) {
			min2[i] = new Node(i);
		}
		PriorityQueue<Node> q = new PriorityQueue<Node>(n,
				new Comparator<Node>() {
					public int compare(Node o1, Node o2) {
						if (o1.min < o2.min) {
							return -1;
						} else if (o1.min > o2.min) {
							return 1;
						}
						return 0;
					}

				});

		l = bf.readLine().split(" ");
		int u1 = Integer.parseInt(l[0]);
		int end = Integer.parseInt(l[1]);
		int l1 = Integer.parseInt(l[2]);
		min[u1].min = 0;
		q.add(min[u1]);

		while (!q.isEmpty()) {
			Node v = q.poll();
			for (Edge edge : graph[v.v]) {
				int v1 = edge.v;
				int min1 = v.min + 1;

				if (min1 < min[v1].min) {
					min[v1].min = min1;
					min[v1].roadEdges.clear();
					min[v1].roadEdges.addAll(v.roadEdges);
					min[v1].roadEdges.add(edge);
					q.add(min[v1]);
				}
			}
		}
		if (min[end].min > l1) {
			System.out.println(-1);
			return;
		}
		l = bf.readLine().split(" ");
		int u2 = Integer.parseInt(l[0]);
		int end2 = Integer.parseInt(l[1]);
		int l2 = Integer.parseInt(l[2]);
		min2[u2].min = 0;
		q.add(min2[u2]);
		while (!q.isEmpty()) {
			Node v = q.poll();
			for (Edge edge : graph[v.v]) {
				int v1 = edge.v;
				int min1 = v.min + 1;

				if (min1 < min2[v1].min) {
					min2[v1].min = min1;
					min2[v1].roadEdges.clear();
					min2[v1].roadEdges.addAll(v.roadEdges);
					min2[v1].roadEdges.add(edge);
					q.add(min2[v1]);
				}
			}
		}
		if (min2[end2].min > l2) {
			System.out.println(-1);
			return;
		}
		int ans = m;
		for (Edge e : min[end].roadEdges) {
			e.taken = true;
			ans--;
		}
		for (Edge e : min2[end2].roadEdges) {
			if (e.taken)
				continue;
			e.taken = true;
			ans--;
		}
		System.out.println(ans);
	}

	static class Node {
		LinkedList<Edge> roadEdges;
		int v;
		int min;

		Node(int v) {
			this.v = v;
			this.min = INF;
			roadEdges = new LinkedList<>();
		}
	}

	static class Edge {
		int v;
		boolean taken;

		Edge(int v) {
			this.v = v;
		}

		public String toString() {
			return " --" + 1 + "--> " + v;
		}
	}
}
