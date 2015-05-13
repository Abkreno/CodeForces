package A2_Div2_C;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ValeraAndTubes {
	static class P {
		int x, y;

		public P(int i, int j) {
			x = i;
			y = j;
		}

		public String toString() {
			return x + " " + y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int k = Integer.parseInt(l[2]);

		LinkedList<P> nextPair = new LinkedList<P>();
		boolean alter = false;
		for (int i = 0; i < n; i++) {
			for (int j = alter ? m - 1 : 0; (alter ? j >= 0 : j < m);) {
				nextPair.add(new P(i + 1, j + 1));
				if (alter)
					j--;
				else
					j++;
			}
			alter = !alter;
		}
		int max = (n * m) / k;
		int left = (n * m) % k;
		while (k-- > 0) {
			int i = 0;
			if (k == 0)
				System.out.print((max + left) + " ");
			else
				System.out.print(max + " ");
			while (i++ < max && !nextPair.isEmpty())
				System.out.print(nextPair.remove(0) + " ");
			while (k == 0 && !nextPair.isEmpty())
				System.out.print(nextPair.remove(0) + " ");
			System.out.println();
		}
	}
}
