import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Div254B {
	static LinkedList<Integer> graph[] = new LinkedList[101];
	static boolean visited[] = new boolean[101];
	static int currC = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		for (int i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		int a, b;
		for (int i = 0; i < m; i++) {			
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		long res = 1;
		for (int i = 1; i < n; i++) {
			if (!visited[i]) {
				currC = 0;
				dfs(i);
				res *= (1L << (currC-1));
			}
		}
		System.out.println(res);
	}

	private static void dfs(int i) {
		if (visited[i])
			return;
		visited[i] = true;
		currC++;
		for (int x : graph[i])
			dfs(x);

	}
}
