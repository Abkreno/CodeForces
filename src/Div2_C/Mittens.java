package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Mittens {
	static class Mitten {
		int color, count, index;

		Mitten(int c) {
			color = c;
			index = -1;
		}

		Mitten(int c, int i) {
			color = c;
			index = i;
		}

		public String toString() {
			return color + " " + index;
		}
	}

	static class pair {
		boolean visited;
		int left, right;

		pair(int c) {
			left = right = c;
		}

		public String toString() {
			return left + " " + right;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		Mitten[] count = new Mitten[101];
		LinkedList<Mitten>[] mittens = new LinkedList[101];
		pair[] ans = new pair[n];
		for (int i = 0; i < count.length; i++) {
			count[i] = new Mitten(i);
			mittens[i] = new LinkedList<>();
		}
		l = bf.readLine().split(" ");
		int curr;
		for (int i = 0; i < n; i++) {
			curr = Integer.parseInt(l[i]);
			mittens[curr].add(new Mitten(curr, i));
			ans[i] = new pair(curr);
			count[curr].count++;
		}
		PriorityQueue<Mitten> q = new PriorityQueue<>(n,
				new Comparator<Mitten>() {
					@Override
					public int compare(Mitten o1, Mitten o2) {
						if (o1.count > o2.count)
							return -1;
						if (o1.count < o2.count)
							return 1;
						return 0;
					}
				});
		for (int i = 0; i < count.length; i++) {
			if (count[i].count > 0)
				q.add(count[i]);
		}
		Mitten m1, m2;
		int c = 0;
		while (!q.isEmpty()) {
			m1 = q.poll();
			if (q.isEmpty()) {
				pair x = ans[mittens[m1.color].remove().index];
				for (pair y : ans) {
					if (x.right != y.right && x.right != y.left) {
						int temp = x.right;
						x.right = y.right;
						y.right = temp;
						c++;
						break;
					}
				}
				break;
			}
			m2 = q.poll();
			m1.count--;
			m2.count--;
			if (m1.count > 0)
				q.add(m1);
			if (m2.count > 0)
				q.add(m2);
			m1 = mittens[m1.color].remove();
			m2 = mittens[m2.color].remove();
			ans[m1.index].right = m2.color;
			ans[m2.index].right = m1.color;
			c += 2;
		}
		System.out.println(c);
		for (pair s : ans) {
			System.out.println(s);
		}
	}
}
