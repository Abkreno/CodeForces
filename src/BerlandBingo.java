import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BerlandBingo {

	void solve() throws Exception {
		int n = nextInt();
		boolean[][] a = new boolean[n][101];
		for (int i = 0; i < n; i++) {
			int m = nextInt();
			for (int j = 0; j < m; j++)
				a[i][nextInt()] = true;
		}
		for (int i = 0; i < n; i++) {
			int can = 0;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				for (int k = 1; k <= 100; k++) {
					if (!a[i][k] && a[j][k]) {
						can++;
						break;
					}
				}
			}
			out.println(can == n - 1 ? "YES" : "NO");
		}
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public static void main(String[] args) {
		new BerlandBingo().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.close();
		}
	}

}