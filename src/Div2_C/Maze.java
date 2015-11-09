package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Maze {
	static int I, J, n, m, s, maxToVisit, visted;
	static boolean graph[][];
	static char[][] maze;

	static void dfs(int currI, int currJ) {
		if (!checkInBounds(currI, currJ) || maze[currI][currJ] == '#'
				|| graph[currI][currJ])
			return;
		if (visted == maxToVisit)
			return;
		graph[currI][currJ] = true;
		visted++;
		dfs(currI + 1, currJ);
		dfs(currI - 1, currJ);
		dfs(currI, currJ + 1);
		dfs(currI, currJ - 1);
	}

	static boolean checkInBounds(int currI, int currJ) {
		return currI >= 0 && currI < n && currJ >= 0 && currJ < m;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		s = Integer.parseInt(l[2]);
		maze = new char[n][];
		graph = new boolean[n][m];
		I = 0;
		J = 0;
		for (int i = 0; i < n; i++) {
			maze[i] = bf.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (maze[i][j] == '.') {
					I = i;
					J = j;
					maxToVisit++;
				}
			}
		}
		maxToVisit -= s;
		dfs(I, J);
		StringBuffer ans = new StringBuffer("");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maze[i][j] == '.' && !graph[i][j])
					maze[i][j] = 'X';
				ans.append(maze[i][j]);
			}
			ans.append("\n");
		}
		System.out.println(ans);
	}
}
