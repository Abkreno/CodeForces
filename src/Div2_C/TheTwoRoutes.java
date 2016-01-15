package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class TheTwoRoutes {
	static int INF = 100000000;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]), m = Integer.parseInt(l[1]);
		int[][] dist = new int[n][n];
		int[][] dist2 = new int[n][n];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], INF);
			Arrays.fill(dist2[i], 1);
			dist[i][i] = dist2[i][i] = 0;
		}
		int a, b;
		int[][] path = new int[n][n];
		int[][] path2 = new int[n][n];

		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]) - 1;
			b = Integer.parseInt(l[1]) - 1;
			dist[a][b] = dist[b][a] = 1;
			dist2[a][b] = dist2[b][a] = INF;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dist[i][j] >= INF)
					path[i][j] = -1;
				else
					path[i][j] = i;
				if (dist2[i][j] >= INF)
					path2[i][j] = -1;
				else
					path2[i][j] = i;
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = path[k][j];
					}
					if (dist2[i][k] + dist2[k][j] < dist2[i][j]) {
						dist2[i][j] = dist2[i][k] + dist2[k][j];
						path2[i][j] = path2[k][j];
					}
				}
			}
		}
		if (dist[0][n - 1] >= INF || dist2[0][n - 1] >= INF) {
			System.out.println(-1);
			return;
		}
		int start = 0;
		int end = n - 1;
		LinkedList<Integer> railsP = new LinkedList<>();
		while (path[start][end] != start) {
			railsP.addFirst(path[start][end]);
			end = path[start][end];
		}
		railsP.addFirst(1);
		railsP.add(n);
		LinkedList<Integer> carP = new LinkedList<>();
		start = 0;
		end = n - 1;
		while (path2[start][end] != start) {
			carP.addFirst(path2[start][end] + 1);
			end = path2[start][end];
		}
		carP.addFirst(1);
		carP.add(n);
		System.out.println(Math.max(dist2[0][n - 1], dist[0][n - 1]));

	}

}
