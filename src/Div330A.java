import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div330A {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				int a = Integer.parseInt(l[2 * j]);
				int b = Integer.parseInt(l[2 * j + 1]);
				if (a == 1 || b == 1)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
