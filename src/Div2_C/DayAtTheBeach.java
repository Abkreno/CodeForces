package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DayAtTheBeach {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[] = bf.readLine().split(" ");
		int c = 0;
		int max = -1;
		int size = 0;
		LinkedList<Integer> groups = new LinkedList<>();
		for (int i = 0; i < l.length; i++) {
			int a = Integer.parseInt(l[i]);
			if (a >= max) {
				if (size < groups.size())
					groups.set(size, a);
				else
					groups.add(a);
				max = a;
				size++;
			} else {
				int lo = -1;
				int hi = size;
				while (lo + 1 < hi) {
					int mid = (lo + hi) >> 1;
					if (groups.get(mid) > a) {
						hi = mid;
					} else {
						lo = mid;
					}
				}
				groups.set(hi, max);
				size = hi+1;
			}
		}
		System.out.println(size);

	}
}
