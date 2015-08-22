import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class HanSoloAndLazerGun {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int x1 = Integer.parseInt(l[1]);
		int y1 = Integer.parseInt(l[2]);
		int x2, y2, gcd;
		HashMap<Integer, HashSet<Integer>> lines = new HashMap<>();
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			x2 = Integer.parseInt(l[0]) - x1;
			y2 = Integer.parseInt(l[1]) - y1;
			if (x2 != 0 && y2 != 0) {
				gcd = gcd(Math.abs(Math.max(x2, y2)),
						Math.abs(Math.min(y2, x2)));
				x2 /= gcd;
				y2 /= gcd;
			} else if (x2 == 0) {
				x2 = 0;
				y2 = 1;
			} else if (y2 == 0) {
				x2 = 0;
			}
			if (x2 * y2 < 0) {
				x2 = -1 * Math.abs(x2);
			} else {
				x2 = Math.abs(x2);
			}
			y2 = Math.abs(y2);
			if (!lines.containsKey(x2))
				lines.put(x2, new HashSet<Integer>());
			lines.get(x2).add(y2);
		}
		int ans = 0;
		Iterator<HashSet<Integer>> it = lines.values().iterator();
		while (it.hasNext())
			ans += it.next().size();
		System.out.println(ans);
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
