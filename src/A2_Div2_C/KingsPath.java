package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KingsPath {
	static long INF = 1000000000000L;

	static class segmant implements Comparable<segmant> {
		int c, r;
		long dist;

		segmant(int a, int b, boolean f) {
			r = a;
			c = b;
			dist = f ? 0 : INF;
		}

		@Override
		public int compareTo(segmant o) {
			if (c > o.c)
				return 1;
			if (c < o.c)
				return -1;
			return 0;
		}

		public String toString() {
			return r + " " + c + " " + (dist == INF ? -1 : dist);
		}
	}

	static PriorityQueue<segmant> q;
	static boolean found;
	static int x1, y1;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int x0 = Integer.parseInt(l[0]);
		int y0 = Integer.parseInt(l[1]);
		x1 = Integer.parseInt(l[2]);
		y1 = Integer.parseInt(l[3]);
		int n = Integer.parseInt(bf.readLine());
		HashMap<Integer, HashMap<Integer, segmant>> segmants = new HashMap<>();
		q = new PriorityQueue<segmant>(n, new Comparator<segmant>() {
			public int compare(segmant o1, segmant o2) {
				if (o1.dist < o2.dist) {
					return -1;
				} else if (o1.dist > o2.dist) {
					return 1;
				}
				return 0;
			}

		});
		HashMap<Integer, segmant> temp;
		segmant currSeg;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			int r = Integer.parseInt(l[0]);
			int a = Integer.parseInt(l[1]);
			int b = Integer.parseInt(l[2]);
			if (!segmants.containsKey(r))
				segmants.put(r, new HashMap<Integer, segmant>());
			temp = segmants.get(r);
			for (int j = a; j <= b; j++) {
				if (temp.containsKey(j))
					continue;
				currSeg = new segmant(r, j, r == x0 && j == y0);
				temp.put(j, currSeg);
				q.add(currSeg);
			}
		}
		while (!q.isEmpty()) {
			currSeg = q.poll();
			evalRow(segmants, currSeg, currSeg.r, false);
			if (found) {
				System.out.println(ans);
				break;
			}
			if (segmants.containsKey(currSeg.r + 1)) {
				evalRow(segmants, currSeg, currSeg.r + 1, true);
				if (found) {
					System.out.println(ans);
					break;
				}
			}

			if (segmants.containsKey(currSeg.r - 1)) {
				evalRow(segmants, currSeg, currSeg.r - 1, true);
				if (found) {
					System.out.println(ans);
					break;
				}
			}
		}
		if (!found)
			System.out.println(-1);
	}

	private static void evalRow(
			HashMap<Integer, HashMap<Integer, segmant>> segmants,
			segmant currSeg, int row, boolean f) {
		HashMap<Integer, segmant> temp = segmants.get(row);
		segmant tempSeg;
		if (f && temp.containsKey(currSeg.c)) {
			tempSeg = temp.get(currSeg.c);
			evalCol(tempSeg, currSeg, row, currSeg.c);
		}
		if (found)
			return;
		if (temp.containsKey(currSeg.c + 1)) {
			tempSeg = temp.get(currSeg.c + 1);
			evalCol(tempSeg, currSeg, row, currSeg.c + 1);
		}
		if (found)
			return;
		if (temp.containsKey(currSeg.c - 1)) {
			tempSeg = temp.get(currSeg.c - 1);
			evalCol(tempSeg, currSeg, row, currSeg.c - 1);
		}
	}

	private static void evalCol(segmant tempSeg, segmant currSeg, int row,
			int col) {
		long min = currSeg.dist + 1;
		if (min < tempSeg.dist) {
			tempSeg.dist = min;
			q.add(tempSeg);
			if (row == x1 && col == y1) {
				found = true;
				ans = min;
			}
		}
	}
}
