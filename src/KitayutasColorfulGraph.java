import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KitayutasColorfulGraph {
	static Edge graph[][] = new Edge[100][100];
	static boolean visited[] = new boolean[100];
	static int n, m, currDest;
	static boolean found;

	static class Edge {
		boolean colors[];

		Edge(int m) {
			colors = new boolean[m];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		int a, b, c;
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			c = Integer.parseInt(l[2]) - 1;
			if (graph[a][b] == null)
				graph[a][b] = new Edge(m);
			if (graph[b][a] == null)
				graph[b][a] = new Edge(m);
			graph[a][b].colors[c] = true;
			graph[b][a].colors[c] = true;
		}
		int q = Integer.parseInt(bf.readLine());
		int ans;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < q; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			currDest = Integer.parseInt(l[1]) - 1;
			ans = 0;
			for (int color = 0; color < m; color++) {
				Arrays.fill(visited, false);
				if (dfs(a, color))
					ans++;
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb);
	}

	static boolean dfs(int u, int c) {
		visited[u] = true;
		if (u == currDest) {
			return true;
		}
		for (int v = 0; v < n; v++) {
			if (!visited[v] && graph[u][v] != null && graph[u][v].colors[c])
				if (dfs(v, c))
					return true;
		}
		return false;
	}
}
