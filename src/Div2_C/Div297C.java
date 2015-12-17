package Div2_C;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Div297C {
	static int counts[] = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int curr, n = Integer.parseInt(bf.readLine());
		String line[] = bf.readLine().split(" ");
		LinkedList<Long> bestNext = new LinkedList<>();
		for (int i = 0; i < line.length; i++) {
			curr = Integer.parseInt(line[i]);
			counts[curr]++;
		}
		for (int i = 1000000; i > 0; i--) {
			if (counts[i] % 2 == 1) {
				counts[i]--;
				if (counts[i - 1] != 0)
					counts[i - 1]++;
			}
			if (counts[i] > 1) {
				bestNext.addFirst((long) i);
			}
		}
		long ans = 0;
		if (bestNext.isEmpty()) {
			System.out.println(ans);
			return;
		}
		long c;
		int i;
		long left = 0;
		long prev = 0;
		while (!bestNext.isEmpty()) {
			c = bestNext.removeLast();
			i = (int) c;
			while (left > 0 && counts[i] > 0) {
				counts[i] -= 2;
				left -= 2;
				ans += (c * prev);
			}
			while (counts[i] > 3) {
				ans += (c * c);
				counts[i] -= 4;
			}
			left = counts[i];
			prev = c;
		}
		System.out.println(ans);

	}
}