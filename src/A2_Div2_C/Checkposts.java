package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Checkposts {
	static int[] costs;

	List<Integer>[] graph;
	boolean[] visited;
	Stack<Integer> stack;
	int time;
	int[] lowlink;
	List<List<Integer>> components;

	public List<List<Integer>> scc(List<Integer>[] graph) {
		int n = graph.length;
		this.graph = graph;
		visited = new boolean[n];
		stack = new Stack<>();
		time = 0;
		lowlink = new int[n];
		components = new ArrayList<>();

		for (int u = 0; u < n; u++)
			if (!visited[u])
				dfs(u);

		return components;
	}

	void dfs(int u) {
		lowlink[u] = time++;
		visited[u] = true;
		stack.add(u);
		boolean isComponentRoot = true;

		for (int v : graph[u]) {
			if (!visited[v])
				dfs(v);
			if (lowlink[u] > lowlink[v]) {
				lowlink[u] = lowlink[v];
				isComponentRoot = false;
			}
		}

		if (isComponentRoot) {
			List<Integer> component = new ArrayList<>();
			while (true) {
				int x = stack.pop();
				component.add(x);
				lowlink[x] = Integer.MAX_VALUE;
				if (x == u)
					break;
			}
			components.add(component);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		costs = new int[n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			costs[i] = Integer.parseInt(l[i]);
		}
		List<Integer>[] g = new List[n];
		for (int i = 0; i < g.length; i++)
			g[i] = new ArrayList<>();
		int m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			g[Integer.parseInt(l[0]) - 1].add(Integer.parseInt(l[1]) - 1);
		}
		List<List<Integer>> components = new Checkposts().scc(g);
		long numOfWays = 1;
		long cost = 0;
		long mod = 1000000007;
		for (List<Integer> comp : components) {
			long min = Integer.MAX_VALUE;
			long numOfMins = 1;
			for (int i : comp) {
				if (costs[i] < min) {
					min = costs[i];
					numOfMins = 1;
				} else if (costs[i] == min) {
					numOfMins++;
				}
			}
			cost += min;
			numOfWays *= numOfMins;
			numOfWays %= mod;
		}
		System.out.println(cost + " " + numOfWays);
	}
}
