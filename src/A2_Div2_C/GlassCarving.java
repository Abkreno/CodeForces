package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class GlassCarving {
	static class Segmant implements Comparable<Segmant> {
		int l, r;

		Segmant(int a, int b) {
			l = a;
			r = b;
		}

		@Override
		public boolean equals(Object o) {
			Segmant x = (Segmant) o;
			System.out.println("here");
			return x.l >= l && x.r <= r;
		}

		@Override
		public int hashCode() {
			return l;
		}

		public String toString() {
			return l + " " + r;
		}

		@Override
		public int compareTo(Segmant o) {
			if (l <= o.l && r >= o.r)
				return 0;
			if (l > o.r)
				return 1;
			if (r < o.l)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int w = Integer.parseInt(l[0]);
		int h = Integer.parseInt(l[1]);
		int n = Integer.parseInt(l[2]);
		StringBuffer sb = new StringBuffer();
		Segmant tmp;
		int[][] toBeRemoved = new int[2][200001];
		TreeSet<Integer> hset = new TreeSet<>();
		hset.add(1);
		hset.add(h);
		PriorityQueue<Integer> hq = new PriorityQueue<>();
		hq.add(-h);

		TreeSet<Integer> wset = new TreeSet<>();
		wset.add(1);
		wset.add(w);
		PriorityQueue<Integer> wq = new PriorityQueue<>();
		wq.add(-w);
		tmp = new Segmant(1, w);

		int pos, val, a, b;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			val = Integer.parseInt(l[1]);
			if (l[0].charAt(0) == 'H') {
				a = hset.floor(val);
				b = hset.higher(val);
				hq.add(-(val - a + 1));
				hq.add(-(b - val));
				toBeRemoved[0][b - a + 1]++;
				hset.add(val);
				hset.add(val + 1);
				while (true) {
					val = -hq.peek();
					if (toBeRemoved[0][val] == 0)
						break;
					hq.poll();
					toBeRemoved[0][val]--;
				}
				h = val;
			} else {
				a = wset.floor(val);
				b = wset.higher(val);
				wq.add(-(val - a + 1));
				wq.add(-(b - val));
				toBeRemoved[1][b - a + 1]++;
				wset.add(val);
				wset.add(val + 1);
				while (true) {
					val = -wq.peek();
					if (toBeRemoved[1][val] == 0)
						break;
					wq.poll();
					toBeRemoved[1][val]--;
				}
				w = val;
			}
			sb.append(((long) h) * ((long) w) + "\n");
		}

		System.out.print(sb);
	}
}
