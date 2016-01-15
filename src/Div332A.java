import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div332A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int d1 = Integer.parseInt(l[0]);
		int d2 = Integer.parseInt(l[1]);
		int d3 = Integer.parseInt(l[2]);
		int ans = 2 * d1 + 2 * d2;
		ans = Math.min(ans, d1 + d2 + d3);
		ans = Math.min(ans, 2 * d1 + 2 * d3);
		ans = Math.min(ans, 2 * d2 + 2 * d3);
		System.out.println(ans);
	}
}
