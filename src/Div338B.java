import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Div338B {

	static LinkedList<Integer> graph[] = new LinkedList[100000];
	static long max;
	static int visited[] = new int[100000];

	static int dfs(int curr) {
		if (visited[curr] != 0)
			return visited[curr];
		int max = 1;
		for (int i : graph[curr]) {
			if (i < curr)
				max = Math.max(1 + dfs(i), max);
		}
		return visited[curr] = max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		max = 0;
		int a, b;
		for (int i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = n - 1; i >= 0; i--) {
			if (visited[i] == 0)
				visited[i] = dfs(i);
		}
		max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(((long) graph[i].size()) * ((long) (visited[i])),
					max);
		}
		System.out.println(max);
	}
}