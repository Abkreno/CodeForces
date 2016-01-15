package Div1_C_Div2_E;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MSTForEachEdge {
	public static class DisjointSets {
		static class Set {
			int parent; // index of parent in vector
			int rank;

			// Construct the i'th of an array of disjoint sets
			Set(int i) {
				parent = i;
				rank = 0;
			}
		}

		private Set[] forest;

		/**
		 * Construct a disjoint sets object.
		 *
		 * @param numElements
		 *            the initial number of elements--also the initial number of
		 *            disjoint sets, since every element is initially in its own
		 *            set.
		 **/
		public DisjointSets(int numElements) {
			forest = new Set[numElements];
			for (int i = 0; i < forest.length; i++) {
				forest[i] = new Set(i);
			}
		}

		public boolean merge(int i, int j) {
			int root_i = find(i);
			int root_j = find(j);
			if (root_i != root_j) {
				if (forest[root_i].rank < forest[root_j].rank)
					forest[root_i].parent = root_j;
				else if (forest[root_i].rank > forest[root_j].rank)
					forest[root_j].parent = root_i;
				else {
					forest[root_i].parent = root_j;
					forest[root_j].rank += 1;
				}
				return true;
			}
			return false;
		}

		public int find(int i) {
			if (forest[i].parent == i)
				return i;
			else {
				forest[i].parent = find(forest[i].parent);
				return forest[i].parent;
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int u, v, weight, i;
		boolean valid;

		Edge(int u, int v, int w, int i) {
			this.u = u;
			this.v = v;
			this.weight = w;
			this.i = i;
			this.valid = true;
		}

		public int otherE(int x) {
			return x == u ? v : u;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}

		public String toString() {
			return (u + 1) + " " + (v + 1) + " " + weight;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int u, v, w, n = Integer.parseInt(l[0]), m = Integer.parseInt(l[1]);
		DisjointSets set = new DisjointSets(n);
		Edge edges[] = new Edge[m];
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			u = Integer.parseInt(l[0]) - 1;
			v = Integer.parseInt(l[1]) - 1;
			w = Integer.parseInt(l[2]);
			edges[i] = new Edge(u, v, w, i);
		}
		long ans[] = new long[m];
		Arrays.fill(ans, -1);
		PriorityQueue<Edge> queues[] = new PriorityQueue[n];
		for (int i = 0; i < queues.length; i++) {
			queues[i] = new PriorityQueue<>(new Comparator<Edge>() {
				@Override
				public int compare(Edge e0, Edge e1) {
					return -e0.compareTo(e1);
				}
			});
		}
		Arrays.sort(edges);
		Edge[] mst = new Edge[n - 1];
		int c = 0;
		long mstCost = 0;
		for (Edge e : edges) {
			if (set.find(e.u) != set.find(e.v)) {
				set.merge(e.u, e.v);
				queues[e.u].add(e);
				queues[e.v].add(e);
				mst[c++] = e;
				mstCost += e.weight;
			}
		}
		for (Edge e : mst) {
			ans[e.i] = mstCost;
		}
		long max, w1, w2;
		StringBuffer sb = new StringBuffer();
		for (Edge e : edges) {
			if (ans[e.i] == -1) {
				max = 0; // should be max edge could be removed
				u = e.u;
				v = e.v;
				w1 = 0;
				w2 = 0;
				for (Edge uEdge : queues[u]) {
					if (queues[uEdge.otherE(u)].size() > 1) {
						w1 += uEdge.weight;
					}
				}
				for (Edge vEdge : queues[v]) {
					if (queues[vEdge.otherE(v)].size() > 1) {
						w2 += vEdge.weight;
					}
				}
				
				ans[e.i] = mstCost - Math.max(w1, w2) + ((long) e.weight);
			}
		}
		for (long x : ans)
			sb.append(x + "\n");
		System.out.print(sb);
	}
}
