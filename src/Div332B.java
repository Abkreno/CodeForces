import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Div332B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		ArrayList<Integer> map[] = new ArrayList[n + 1];
		for (int i = 0; i < map.length; i++) {
			map[i] = new ArrayList<>();
		}
		l = bf.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			map[Integer.parseInt(l[i - 1])].add(i);
		}
		StringBuffer ans = new StringBuffer();
		l = bf.readLine().split(" ");
		boolean amp = false;
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(l[i]);
			if (a > n || map[a].size() == 0) {
				System.out.println("Impossible");
				return;
			} else if (map[a].size() > 1) {
				amp = true;
			} else if (!amp) {
				ans.append(map[a].get(0) + " ");
			}
		}
		if (amp) {
			System.out.println("Ambiguity");
		} else {
			System.out.println("Possible");
			System.out.println(ans);
		}

	}
}
