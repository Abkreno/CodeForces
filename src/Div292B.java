import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div292B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		boolean[] boys = new boolean[n];
		boolean[] girls = new boolean[m];
		int b, g;
		l = bf.readLine().split(" ");
		b = Integer.parseInt(l[0]);
		for (int i = 0; i < b; i++) {
			boys[Integer.parseInt(l[i + 1])] = true;
		}
		l = bf.readLine().split(" ");
		g = Integer.parseInt(l[0]);
		for (int i = 0; i < g; i++) {
			girls[Integer.parseInt(l[i + 1])] = true;
		}
		int[][] cycles = new int[n][m];
		int currDay = 0;
		while (true) {
			b = currDay % n;
			g = currDay % m;
			currDay++;
			if (boys[b] || girls[g]) {
				boys[b] = girls[g] = true;
			}
			cycles[b][g]++;
			if (cycles[b][g] == 3)
				break;
		}
		for (int i = 0; i < n; i++) {
			if (!boys[i]) {
				System.out.println("No");
				return;
			}
		}
		for (int i = 0; i < m; i++) {
			if (!girls[i]) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
}
