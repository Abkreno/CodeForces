package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class WilburAndPoints {
	static class P implements Comparable<P> {
		int x, y;

		P(int xx, int yy) {
			x = xx;
			y = yy;
		}

		@Override
		public int compareTo(P o) {
			if (x > o.x && y > o.y)
				return 1;
			if (x < o.x && y < o.y)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l;

		HashMap<Integer, PriorityQueue<P>> map = new HashMap<>();
		int x, y, diff;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			x = Integer.parseInt(l[0]);
			y = Integer.parseInt(l[1]);
			diff = y - x;
			if (!map.containsKey(diff))
				map.put(diff, new PriorityQueue<>());
			map.get(diff).add(new P(x, y));
		}
		P[] ans = new P[n];
		l = bf.readLine().split(" ");
		PriorityQueue<P> tmp;
		P maxXP = new P(-1, -1);
		P maxYP = new P(-1, -1);
		P tmpp;
		for (int i = 0; i < l.length; i++) {
			diff = Integer.parseInt(l[i]);
			if (!map.containsKey(diff)) {
				System.out.println("NO");
				return;
			}
			tmp = map.get(diff);
			tmpp = tmp.poll();
			if (tmp.isEmpty())
				map.remove(diff);
			if (!(tmpp.x >= maxXP.x || tmpp.y >= maxYP.y)) {
				System.out.println("NO");
				return;
			}
			if (tmpp.x == maxXP.x && tmpp.y < maxXP.y) {
				System.out.println("NO");
				return;
			} else {
				maxXP = tmpp;
			}
			if (tmpp.y == maxYP.y && tmpp.x < maxYP.x) {
				System.out.println("NO");
				return;
			} else {
				maxYP = tmpp;
			}
			ans[i] = tmpp;
		}
		System.out.println("YES");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ans.length; i++) {
			sb.append(ans[i].x + " " + ans[i].y + "\n");
		}
		System.out.print(sb);
	}
}
