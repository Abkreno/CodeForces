package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SoldierAndCards {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int k1 = Integer.parseInt(l[0]);
		LinkedList<Integer> p1 = new LinkedList<>();
		for (int i = 1; i < l.length; i++) {
			p1.add(Integer.parseInt(l[i]));
		}
		l = bf.readLine().split(" ");
		int k2 = Integer.parseInt(l[0]);
		LinkedList<Integer> p2 = new LinkedList<>();
		for (int i = 1; i < l.length; i++) {
			p2.add(Integer.parseInt(l[i]));
		}
		int t = 0;
		int fights = 0;
		while (t++ <= 1000000) {
			int n1 = p1.removeFirst();
			int n2 = p2.removeFirst();
			fights++;
			if (n1 > n2) {
				p1.addLast(n2);
				p1.addLast(n1);
				if (p2.isEmpty()) {
					System.out.println(fights + " " + 1);
					return;
				}
			} else {
				p2.addLast(n1);
				p2.addLast(n2);
				if (p1.isEmpty()) {
					System.out.println(fights + " " + 2);
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
