package Div2_D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class ChoosingCapitalForTreeLand {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static Random rnd;

	class Edge {
		int v, add;

		public Edge(int v, int add) {
			this.v = v;
			this.add = add;
		}
	}

	void solve() throws IOException {
		int n = nextInt();

		ArrayList<Edge>[] g = new ArrayList[n];

		for (int i = 0; i < n; i++)
			g[i] = new ArrayList<Edge>();

		for (int i = 0; i < n - 1; i++) {
			int u = nextInt() - 1, v = nextInt() - 1;
			g[u].add(new Edge(v, 0));
			g[v].add(new Edge(u, 1));
		}

		int[] sums = new int[n];

		dfsCalcSums(0, -1, g, sums);

		int[] d = new int[n];

		dfsCalcD(0, -1, g, sums, d, 0);

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++)
			res = Math.min(res, d[i]);

		out.println(res);

		for (int i = 0; i < n; i++) {
			if (d[i] == res) {
				out.print((i + 1) + " ");
			}
		}

	}

	private void dfsCalcD(int u, int parent, ArrayList<Edge>[] g, int[] sums,
			int[] d, int up) {
		int below = sums[u];

		// System.out.println("Debug: " + u + " " + below + " " + up);

		d[u] = below + up;

		for (Edge e : g[u]) {
			if (e.v != parent) {
				int change = 0;

				if (e.add == 0)
					change = 1;
				else
					change = -1;

				dfsCalcD(e.v, u, g, sums, d, up + below - sums[e.v] + change);
			}
		}
	}

	private void dfsCalcSums(int u, int parent, ArrayList<Edge>[] g, int[] sums) {
		for (Edge e : g[u]) {
			if (e.v != parent) {
				dfsCalcSums(e.v, u, g, sums);
				sums[u] += sums[e.v];
				sums[u] += e.add;
			}
		}
	}

	public static void main(String[] args) {
		new ChoosingCapitalForTreeLand().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			rnd = new Random();

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(42);
		}
	}

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = in.readLine();

			if (line == null)
				return null;

			st = new StringTokenizer(line);
		}

		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}