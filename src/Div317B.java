import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Div317B {
	static class Num implements Comparable<Num> {
		int p;
		long q;

		Num(int x, long q2) {
			p = x;
			q = q2;
		}

		@Override
		public int compareTo(Num n) {
			if (p > n.p)
				return 1;
			if (p < n.p)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		HashMap<Integer, Num> sell = new HashMap<>();
		HashMap<Integer, Num> buy = new HashMap<>();
		LinkedList<Num> s = new LinkedList<>();
		LinkedList<Num> b = new LinkedList<>();
		int p;
		long q;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			p = Integer.parseInt(l[1]);
			q = Integer.parseInt(l[2]);
			if (l[0].charAt(0) == 'B') {
				if (buy.containsKey(p)) {
					buy.get(p).q += q;
				} else {
					Num temp = new Num(p, q);
					buy.put(p, temp);
					b.add(temp);
				}
			} else {
				if (sell.containsKey(p)) {
					sell.get(p).q += q;
				} else {
					Num temp = new Num(p, q);
					sell.put(p, temp);
					s.add(temp);
				}
			}
		}
		Collections.sort(s);
		Collections.sort(b);
		StringBuffer ans = new StringBuffer();
		int f = 0;
		LinkedList<Num> nn = new LinkedList<>();
		for (Num c : s) {
			nn.addFirst(c);
			f++;
			if (f == m)
				break;
		}
		for (Num c : nn)
			ans.append("S " + c.p + " " + c.q + "\n");

		f = 0;
		while (!b.isEmpty()) {
			Num c = b.removeLast();
			ans.append("B " + c.p + " " + c.q + "\n");
			f++;
			if (f == m)
				break;
		}
		System.out.print(ans);
	}
}
