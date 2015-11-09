package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class BearAndPoker {
	static HashSet<Integer> vals = new HashSet<>();
	static HashMap<Integer, Integer> counts = new HashMap<>();
	static int n;

	static boolean go(int c) {
		if (vals.contains(c))
			return false;
		vals.add(c);
		int x = counts.containsKey(c) ? counts.get(c) + 1 : 1;
		if (x == n) {
			return true;
		}
		counts.put(c, x);
		if (c % 2 == 0 && go(c / 2))
			return true;

		if (c % 3 == 0 && go(c / 3))
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");

		for (int i = 0; i < l.length; i++) {
			if (go(Integer.parseInt(l[i]))) {
				System.out.println("Yes");
				return;
			}
			vals.clear();
		}
		System.out.println("No");
	}
}
