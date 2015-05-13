package GoodBye2014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class C {
	static class book implements Comparable<book> {
		boolean removed = false;
		int val;
		int index;

		public book(int val, int index) {
			this.val = val;
			this.index = index;
		}

		@Override
		public int compareTo(book o) {
			return this.val - o.val;
		}

		public String toString() {
			return this.val + " " + this.index;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int w = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		LinkedList<book> t = new LinkedList<book>();
		for (int i = 0; i < n; i++) {
			t.add(new book(Integer.parseInt(l[i]), i));
		}
		LinkedList<book> books = new LinkedList<book>();
		l = bf.readLine().split(" ");
		int[] seq = new int[w];
		int index = 0;
		for (int i = 0; i < w; i++) {
			int curr = Integer.parseInt(l[i]) - 1;
			seq[i] = curr;
			if (t.get(curr).removed)
				continue;
			t.get(curr).removed = true;
			books.add(t.get(curr));
		}
		Collections.sort(t);
		for (book b : t) {
			if (!b.removed) {
				books.add(b);
			}
		}

		long res = 0;
		for (int i = 0; i < seq.length; i++) {
			int weight = 0;
			int ind = 0;
			for (int j = 0; j < books.size(); j++) {
				if (books.get(j).index == seq[i]) {
					ind = j;
					break;
				}
			}
			for (int j = 0; j < ind; j++) {
				weight += books.get(j).val;
			}
			res += weight;
			books.addFirst(books.remove(ind));
		}
		System.out.println(res);
	}
}