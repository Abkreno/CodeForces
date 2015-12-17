import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Div318B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int a, b;
		LinkedList<Integer> adj[] = new LinkedList[n];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			adj[a].add(b);
			adj[b].add(a);
		}
		for (int i = 0; i < adj.length; i++) {
			Collections.sort(adj[i]);
		}
		int ans = Integer.MAX_VALUE, curr;
		for (int i = 0; i < n; i++) {
			for (int j : adj[i]) {
				for (int k : adj[i]) {
					if (k == j)
						continue;
					if (Collections.binarySearch(adj[j], k) < 0)
						continue;
					curr = adj[k].size() - 2;
					curr += adj[i].size() - 2;
					curr += adj[j].size() - 2;
					ans = Math.min(ans, curr);
				}

			}
		}
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

}
